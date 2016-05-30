/**
 * 
 */
package com.wini.common.queue.rabbitmq;

import java.io.IOException;

import com.rabbitmq.client.Channel;

/**
 * @author Administrator
 *
 */
public interface ChannelCallable<T> {
	T call(Channel channel) throws IOException;
}
