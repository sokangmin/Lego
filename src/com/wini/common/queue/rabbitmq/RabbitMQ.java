package com.wini.common.queue.rabbitmq;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import lombok.extern.log4j.Log4j2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.wini.common.parser.PropertiesFile;

@Log4j2
public class RabbitMQ extends AbstractQueue<String> {
	protected final ConnectionFactory factory;
	protected volatile Connection connection;
	protected final String queue;
	static final String MESSAGE_ENCODING = "UTF-8";
	
	private RabbitMQ(final ConnectionFactory factory, Connection connection, String queue) {
		this.factory = factory;
		this.connection = connection;
		this.queue = queue;
	}
	
	private Channel createChannel() {
		try {
			return connection == null ? null : connection.createChannel();
		} catch (IOException e) {
			log.error("Failed to create channel", e);
			return null;
		}
	}
	
	private void closeChannel(final Channel channel) {
		if ((channel ==null) || (!channel.isOpen())) { return; }
		try { channel.close(); } catch(Exception e) { log.error("Failed to close channel:" + channel, e); }
	}
	
	public void stop() {
		if (connection == null) {
			return;
		}
		
		try {
			connection.close();
		} catch (IOException e) {
			log.error("Failed to close connection", e);
		} finally {
			connection = null;
		}
	}
	
	private <T> T call(final ChannelCallable<T> callable) {
		final Channel channel = createChannel();
		
		if(channel != null) {
			try {
				return callable.call(channel);
			} catch (final Exception e) {
				log.error("Failed on channel:" + channel, e);
			} finally {
				closeChannel(channel);
			}
		}
		
		return null;
		
	}
	
	@Override
	public boolean offer(final String e) {
		return call(new ChannelCallable<Boolean>() {

			@Override
			public Boolean call(Channel channel) {
				try {
					channel.basicPublish("", queue, null, e.getBytes(MESSAGE_ENCODING));
				} catch (UnsupportedEncodingException e) {
					return false;
				} catch (IOException e) {
					return false;
				}
						
				return true;
			}
		});
	}



	@Override
	public String poll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String peek() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	final public static class Builder {
		private String username;
		private String password;
		private String virtualHost;
		private String host;
		private int port;
		private String queue;
		
		Builder() {
			username = PropertiesFile.getProperties().getProperty("rabbitmq.username");
			password = PropertiesFile.getProperties().getProperty("rabbitmq.password");
			virtualHost = PropertiesFile.getProperties().getProperty("rabbitmq.virtualhost", "/");
			host = PropertiesFile.getProperties().getProperty("rabbitmq.host");
			port = Integer.parseInt(PropertiesFile.getProperties().getProperty("rabbitmq.port", "5672"));
		}
		
		public Builder setUsername(String username) {
			this.username = username;
			
			return this;
		}
		
		public Builder setPassword(String password) {
			this.password = password;
			
			return this;
		}
		
		public Builder setVirtualHost(String virtualHost) {
			this.virtualHost = virtualHost;
			
			return this;
		}
		
		public Builder setHost(String host) {
			this.host = host;
			
			return this;
		}
		
		public Builder setPort(int port) {
			this.port = port;
			
			return this;
		}
		
		public Builder setQueueName(String queue) {
			this.queue = queue;
			
			return this;
		}
		
		@Override
		public String toString() {
			return "rabbitmq info {username:" + username + ", password:" + password + ", virtualHost:" + virtualHost + ", host:" + host + ", port:" + port + ", queue:" + queue + "}";
		}
		
		public RabbitMQ build() {
			if(queue == null) {
				log.error("Queue Name is null. please input Queue Name.(setQueueName(String queue))");
				System.exit(-1);;
			}
			
			ConnectionFactory factory = new ConnectionFactory();
			Connection connection = null;	
			Channel channel = null;
			
			factory.setUsername(username);
			factory.setPassword(password);
			factory.setVirtualHost(virtualHost);
			factory.setHost(host);
			factory.setPort(port);
			factory.setAutomaticRecoveryEnabled(true);
			
			log.debug(this.toString());
			
			try {
				connection = factory.newConnection();
				channel = connection.createChannel();
				
				boolean durable = true;
				boolean autoDelete = false;
				boolean exclusive = false;
				Map<String, Object> args = null;
				
				channel.queueDeclare(queue, durable, autoDelete, exclusive, args);
			} catch (IOException e) {
				log.error(e);
			} catch (TimeoutException e) {
				log.error(e);
			} finally {
				if ((channel ==null) || (!channel.isOpen())) {}
				try { channel.close(); } catch(Exception e) { log.error("Failed to close channel:" + channel, e);}
			}
			
			
			return new RabbitMQ(factory, connection, queue);
		}
	}
}
