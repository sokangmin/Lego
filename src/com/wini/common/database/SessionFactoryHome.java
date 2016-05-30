package com.wini.common.database;

import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.naming.Binding;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import lombok.extern.log4j.Log4j2;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@Log4j2
public class SessionFactoryHome {

	static{ 

			ClassLoader cl;
	
			cl = Thread.currentThread().getContextClassLoader();
			if( cl == null ) 
				cl = ClassLoader.getSystemClassLoader();	
			
			URL url = cl.getResource( "hibernate" );		
			
			String path = null;
			try {			
				path = java.net.URLDecoder.decode(url.getPath(), "utf-8");
			} catch (UnsupportedEncodingException e1) {
				log.error("[ SessionFactoryHome | static ] UnsupportedEncodingException"+e1);
			}		
			
			File[] flist = getHiberFiles(new File(path));
			
			log.debug("flist : "+flist.length);
	
			//filepath 얻어와서 해당 파일에 있는 db를 building한다.
			for(File f: flist) {
				try {
					log.debug("=======================f : "+f);
					Configuration configuration = new Configuration();
					configuration.configure(f);
					StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
					configuration.buildSessionFactory(ssrb.build());
				} catch (HibernateException e) {
					e.printStackTrace();
					log.error("[SessionFactoryHome | static ] HibernateException : "+e);
				}
			}
	
			try {
				//        	sf = InitialContext.doLookup("db/oracle");
				InitialContext Context = new InitialContext();
	
				NamingEnumeration<Binding> b = Context.listBindings("db");
				NamingEnumeration<NameClassPair> c = Context.list("db");
	
	
				//db binding된 list목록을 얻어와 바인딩 된 db를 확인한다.
				while(b.hasMore()) {
					Binding obj = b.next();
					String jndiname = obj.getName();
					if(obj.getObject() instanceof SessionFactory) {
						obj.getObject();
					}
					log.debug(obj+"->"+jndiname);
					log.info("db connection : "+jndiname+"("+obj+")");
				}
	
				//
				while(c.hasMore()) {
					NameClassPair obj = c.next();
					String jndiname = obj.getName();
					obj.getClassName();
					log.debug(obj+"->"+jndiname+"->"+obj.getClassName());
				}
				
				/*logger.debug("InitialContext.doLookup(tibero) : "+InitialContext.doLookup("db/tibero"));
				logger.debug("InitialContext.doLookup(oracle) : "+InitialContext.doLookup("db/oracle"));*/
	
			} catch (NamingException e) {
				log.error("[SessionFactoryHome | static ] NamingException : "+e);
			} 
	
	//		Context.close();	
	
			/*File[] fileList = new FileSearch().searchFile();
			for(int i = 0; i<fileList.length; i++){
	
				Configuration configuration = new Configuration();
				StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
	
				configuration.configure(fileList[i].toString());
				ssrb = ssrb.applySettings(configuration.getProperties());
				configuration.buildSessionFactory(ssrb.build());
	
				System.out.println(configuration.getProperty("hibernate.jdbc.batch_size"));
			}*/
	}

	/**
	 * 폴더 안의 cfg.xml 학장자 파일의 path를 가져간다.
	 * @param subFile 파일 path
	 * @return cfg.xml 파일path list
	 */
	private static File[] getHiberFiles(File subFile) {

		File[] subList = subFile.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				boolean bool = name.toLowerCase().endsWith("cfg.xml");
				return bool;
			}
		});

		return subList;
	}

	public static SessionFactory getSessionFactory(String jndiName) {
		SessionFactory sf = null;
		try {
			sf = InitialContext.doLookup(jndiName);
		} catch (NamingException e) {
			log.error("[ SessionFactoryHome | SessionFactory ] NamingException : "+e);
		}
		return sf;
	}

}

