package kr.go.mpss.idsl.dmr.ip.link.esaram.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.log4j.Log4j2;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

@Log4j2
public abstract class Client {

	public static String doService(String serviceUrl, String requestXml) {

		String contentType, endoding, transactionUniqueId;
		int connectTimeout, soTimeout;
		{
			contentType = "text/xml; charset=utf-8"; 
			endoding = "UTF-8";

			connectTimeout = 5 * 60 * 1000; 
			soTimeout = 900 * 1000; 

			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyyMMddHHmmssSSS");
			transactionUniqueId = formatter.format(new Date())
					+ String.valueOf(Math.random()).substring(2, 10);
		}

		{
			requestXml = requestXml.replace("#USE_SYSTEM_CODE#", "TEST_SYSTEM"); 
			requestXml = requestXml
					.replace("#CERT_SERVER_ID#", "SVR1750087002"); 
			requestXml = requestXml.replace("#TRANSACTION_UNIQUE_ID#",
					transactionUniqueId);
			requestXml = requestXml.replace("#USER_DEPT_CODE#", "1750087");
			requestXml = requestXml.replace("#USER_NAME#", "Â÷°æÃµ"); 
		}

		PostMethod method = null; 


		String responseXml = null; 
		try {

			HttpClient client; 
			{
				HttpConnectionManagerParams params = new HttpConnectionManagerParams();

				params.setConnectionTimeout(connectTimeout);
				params.setSoTimeout(soTimeout);
				params.setTcpNoDelay(true);

				HttpConnectionManager conn = new SimpleHttpConnectionManager();
				conn.setParams(params);
				client = new HttpClient(conn);

				method = new PostMethod(serviceUrl);
				method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
						new DefaultHttpMethodRetryHandler(0, false));

				method.setRequestHeader("Content-Type", contentType);
				method.setRequestHeader("Connection", "close");

				RequestEntity requestEntity = new StringRequestEntity(
						requestXml, contentType, endoding);
				method.setRequestEntity(requestEntity);
			}


			int responseCode = client.executeMethod(method); 


			{
				InputStream is = method.getResponseBodyAsStream();
				try {
					int readLen;
					byte[] buffer = new byte[1024];
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					while ((readLen = is.read(buffer)) >= 0) {
						baos.write(buffer, 0, readLen);
					}
					byte[] data = baos.toByteArray();
					responseXml = new String(data, endoding);
				} finally {
					is.close();
				}
			}


			if (responseCode == HttpStatus.SC_OK) {
			} else if (responseXml.indexOf("Fault>") > 0) {
			} else {
			}

		} catch (Throwable e) {
			log.error(e);
		} finally {
			if (method != null) {
				method.releaseConnection(); 
			}
		}

		return responseXml;
	}
}
