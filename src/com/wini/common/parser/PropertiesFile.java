package com.wini.common.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 클래스 로더를 이용하여 properties 파일의 위치를 찾는다.
 * 아래 URL을 생성하는 부분에 프로퍼티의 이름을 적어주세요.
 * @author Administrator
 *
 */
public class PropertiesFile {

	private static Logger logger = LogManager.getLogger(PropertiesFile.class);

	static final long serialVersionUID = 42L;
	static  Properties prop = null;
	static ClassLoader cl=null;
	//	static String prop_file_name = ".\\conf\\prop.properties";
	static String prop_file_name = null;
	
	
	static {
		cl = Thread.currentThread().getContextClassLoader();//클래스 로더에서 properties 파일의 위치를 찾게함. 위치가 바뀌어도 ㄹ더에서 찾음.
		
		if(cl==null){
			cl = ClassLoader.getSystemClassLoader();	
		}
		
		URL url = cl.getResource("prop.properties");
		try {
			prop_file_name = java.net.URLDecoder.decode(url.getPath(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("[PropertiesFile | getProperties ] UnsupportedEncodingException : "+e);
		}

		prop = new Properties();
		try {
			if(prop_file_name != null) {
				prop.load(new FileInputStream(prop_file_name));
			}
		} catch (FileNotFoundException e) {
			logger.error("getProperties FileNotFoundException", e);
			System.exit(0);	//파일이 없으면 설정된 인증키를 받아갈 수 없기 때문에 비정상적으로 시스템이 도는것을 방지하게위해 시스템을 종료시킨다.
		} catch (IOException e) {
			logger.error("getProperties IOException", e);
			System.exit(0);	//파일이 없으면 설정된 인증키를 받아갈 수 없기 때문에 비정상적으로 시스템이 도는것을 방지하게위해 시스템을 종료시킨다.
		}
	}

	private PropertiesFile(){}
 
	public static synchronized Properties getProperties(){
		
		return prop;
	}

}
