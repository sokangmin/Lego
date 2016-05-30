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
 * Ŭ���� �δ��� �̿��Ͽ� properties ������ ��ġ�� ã�´�.
 * �Ʒ� URL�� �����ϴ� �κп� ������Ƽ�� �̸��� �����ּ���.
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
		cl = Thread.currentThread().getContextClassLoader();//Ŭ���� �δ����� properties ������ ��ġ�� ã����. ��ġ�� �ٲ� �������� ã��.
		
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
			System.exit(0);	//������ ������ ������ ����Ű�� �޾ư� �� ���� ������ ������������ �ý����� ���°��� �����ϰ����� �ý����� �����Ų��.
		} catch (IOException e) {
			logger.error("getProperties IOException", e);
			System.exit(0);	//������ ������ ������ ����Ű�� �޾ư� �� ���� ������ ������������ �ý����� ���°��� �����ϰ����� �ý����� �����Ų��.
		}
	}

	private PropertiesFile(){}
 
	public static synchronized Properties getProperties(){
		
		return prop;
	}

}
