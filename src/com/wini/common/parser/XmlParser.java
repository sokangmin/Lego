package com.wini.common.parser;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlParser {

	private Logger logger = LogManager.getLogger(getClass());

	XPath xpath = XPathFactory.newInstance().newXPath();
	Document doc = null;
	
	public XmlParser(){}
	 
	public XmlParser(String api_data){
		try {
			if(api_data.startsWith("<?xml")) {	//응답값은 받았지만 페이지에러가 나서 error.jps로 변환해주는 값으로 날아오는 경우가 있기 때문에 그런 경우를 제외하기 위해 해당 태그로 날라올때만 변환.
				InputSource is = new InputSource(new StringReader(api_data));
				this.doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
			} else {
				logger.info("conn data error.");
			}
		} catch (SAXException e) {
			logger.error("[ XmlParsing | SAXException ] : "+e+"\n error data : "+api_data);
		} catch (IOException e) {
			logger.error("[ XmlParsing | IOException ] : "+e);
		} catch (ParserConfigurationException e) {
			logger.error("[ XmlParsing | ParserConfigurationException ] : "+e);
		}

	}
	
	public NodeList getNodeList(String list_expression){
		NodeList data_list = null;
		
		try {
			if(doc!=null){
				//list_expression 위치에 있는 모든 태그 값을 선택.
				data_list 	= (NodeList) xpath.evaluate(list_expression, this.doc, XPathConstants.NODESET);
			} else {
				logger.info("xml data document parsing fail. doc : "+doc);
			}
		} catch (XPathExpressionException e) {
			logger.error("[ XmlParser | XPathExpressionException ] : " +e);
		}
		return data_list;
	}
	
	

}
