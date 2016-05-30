package com.wini.common.url;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wini.lego.annotations.ForEach;
import com.wini.lego.blocks.PipeBlock;

/**
 * �մܿ��� string���·� ���� url�� ������ �õ��Ѵ�.
 * openAPI�� ������ �õ��� �� ������ url�ε� 404������ ���� ��찡 �־� 200�����ڵ带 ���� ���� ��, �ش� url������ ��õ��Ѵ�.
 * ������ ����Ű�� �Ϸ� ��û���� Ƚ���� ������ �ֱ⶧����(�ش� ���񽺹ٴ� ���� ��û Ƚ���� �� �ٸ� �� �ִ�.) 5�� �̻� �õ����� ���踦 ���� �ʰ� �Ѿ��.
 * 
 * 
 * @author ������ 2015.10.21
 *
 */
@ForEach
public class ConnectUrl extends PipeBlock<String, HashMap<String, String>>{

	private Logger logger = LogManager.getLogger(getClass());
	private int res = 0;
	@Override
	protected HashMap<String, String> doing(String url) {
		String damcode=null;
		//String cctv_sn=null;
		HashMap<String, String> map_url_data = new HashMap<String, String>();
		
		if(url.indexOf("&damcode=") != -1){	//damcode�� ������ ���� �� �� �� ���� damcode�� ���� ���� parsing�ϴ� ���� �Ѱ��ش�.
			damcode = url.substring(url.indexOf("&damcode=")+"&damcode=".length(), url.length());
			map_url_data.put("damcode", damcode);
		}/* else if(url.indexOf("&cctv_sn=") != -1){//cctv_sn�� �� �� ���� ������ cctv_sn�� ���� parsing�ϴ� ���� �Ѱ��ش�.
			cctv_sn = url.substring(url.indexOf("&cctv_sn=")+"&cctv_sn=".length(), url.length());
			map_url_data.put("cctv_sn", cctv_sn);	//���߿� db�� insert/update �� �ʿ��ؼ� �˻��� ������ ������
			//���� cctv_sn�� url�� ���Ե��� �ʴ� �κ��̱� ������, ���� �� url���� �����ش�.
			url=url.substring(0, url.indexOf("&cctv_sn="));
		}*/
		
		//������ ����url���� �����͸� �޾ƿ��� �κ�
		StringBuffer api_data = getApiData(url);
		
		//map�� api_data�� �޾ƿ� ���� �ִ´�.
		map_url_data.put("api_data", api_data.toString());

		/*logger.debug("���� url : "+url);
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = null;
		//		request = new HttpGet(url.trim());
		HttpResponse response = null;

		 *//**��Ȳ������ ������ �� multi thread�� �� �ش� url�� �����Ͽ� �����͸� �����ؿ����� �ϴµ�, ���������� ����(��ȿ�� url�� 404 ������ ���� ��) ������ �־ �ش�url�� 200 code�� ���������� ��õ��Ѵ�.
		 * ���� ù��° �õ��� �� 20�� �� 15��~18�� ������ �����ǰ� �������� �ùٸ��� ����ɶ����� �õ��� �Ѵ�.
		 * �׽�Ʈ��� ��������� 2������ ��õ� �� 200�� code�� ���Ϲ޾Ҵ�.
		 * �� ��ȿ�� url�� 404 ������ �������� �ľ����� ����.
		 * �׽�Ʈ���� �� single thread�� �ش� url�� �����ϴ� ��쿡�� �̷� ���������� ����� ���� ���� ����.
		 * (�ش� ������� ����Ű�� ��Ȳ ������ ��û�� �Ϸ翡 1000�Ǳ��� �õ��� �� �ִ�.)
		 *//*
		int cnt=0;
		while (true) {
			try {
				request = new HttpGet(url.trim());
				response = client.execute(request);
				res = response.getStatusLine().getStatusCode();

				if(res == 200){
					api_data = getApiData(response);
					break;
				}else {
					logger.info("data required's response is not OK. �����ڵ�(result code) : "+res+", ���� ����(reason) : "+response.getStatusLine().getReasonPhrase());
					cnt++;
					logger.info(cnt+"��° ��õ�. url : "+url);
				}
			} catch (ClientProtocolException e) {
				logger.error("[ ConnectUrl | doing ] ClientProtocolException : "+e);
			} catch (IOException e) {
				logger.error("[ ConnectUrl | doing ] IOException : "+e);
			} finally {
				request.releaseConnection();	// connection�� �����ش�. ���������� close_wait �߻�
			}
		}*/
		return map_url_data;
	}
	
	/**��Ȳ������ ������ �� multi thread�� �� �ش� url�� �����Ͽ� �����͸� �����ؿ����� �ϴµ�, ���������� ����(��ȿ�� url�� 404 ������ ���� ��) ������ �־ �ش�url�� 200 code�� ���������� ��õ��Ѵ�.
	 * ���� ù��° �õ��� �� 20�� �� 15��~18�� ������ �ѹ��� �����ǰ� �������� �ùٸ��� ����ɶ����� �õ��� �Ѵ�.
	 * �׽�Ʈ��� ��������� 2������ ��õ� �� 200�� code�� ���Ϲ޾Ҵ�.
	 * �� ��ȿ�� url�� 404 ������ �������� �ľ����� ����.
	 * �׽�Ʈ���� �� single thread�� �ش� url�� �����ϴ� ��쿡�� �̷� ���������� ����� ���� ���� ����.
	 * (�ش� ������� ����Ű�� ��Ȳ ������ ��û�� �Ϸ翡 1000�Ǳ��� �õ��� �� �ִ�.)
	 */
	public StringBuffer getApiData(String url){
		logger.debug("���� url : "+url);
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = null;
		//		request = new HttpGet(url.trim());
		HttpResponse response = null;
		StringBuffer api_data = new StringBuffer();

		int cnt=0;
		int tryCnt=5;
		while (true) {
			try {
				request = new HttpGet(url.trim());
				cnt++;
				response = client.execute(request);	//timed out �߻�����
				res = response.getStatusLine().getStatusCode();

				if(res == 200){	//�����ڵ尪�� 200�϶��� ��������
					api_data = getApiData(response);
					break;
				} else if(cnt>=tryCnt) {	//���� �õ��� �ʹ� ���� �� ��� ����Ű�� �õ�Ƚ���� full�� �� �ֱ� ������ 5�� �̻� �̵����� ���ϰ��Ѵ�. ���� ���������� 404������ ��� 2��°�� �����ϴ� ���� Ȯ��.
					logger.info("Trying count is more than 5. It doesn't try url : "+url);
					break;
				} else {
					logger.info("Try cnt : "+cnt+"\n url : "+url+"\n data required's response is not OK. result code : "+res+"\n fail reason : "+response.getStatusLine().getReasonPhrase());
				}

			} catch (ClientProtocolException e) {
				logger.error("[ ConnectUrl | getApiData ] ClientProtocolException : "+e+"\n ClientProtocolException URL : "+url);
				if(cnt>=tryCnt) {	//���� �õ��� �ʹ� ���� �� ��� ����Ű�� �õ�Ƚ���� full�� �� �ֱ� ������ 5�� �̻� �̵����� ���ϰ��Ѵ�. ���� ���������� 404������ ��� 2��°�� �����ϴ� ���� Ȯ��.
					logger.info("Trying count is more than "+cnt);
					break;
				}
			} catch (IOException e) {
				logger.error("[ ConnectUrl | getApiData ] IOException : "+e+"\n IOException URL : "+url);
				if(cnt>=tryCnt) {	//���� �õ��� �ʹ� ���� �� ��� ����Ű�� �õ�Ƚ���� full�� �� �ֱ� ������ 5�� �̻� �̵����� ���ϰ��Ѵ�. ���� ���������� 404������ ��� 2��°�� �����ϴ� ���� Ȯ��.
					logger.info("Trying count is more than "+cnt);
					break;
				}
			} catch (Exception e) {
				logger.error("[ ConnectUrl | getApiData ] Exception : "+e+"\n Exception URL : "+url);
				if(cnt>=tryCnt) {	//���� �õ��� �ʹ� ���� �� ��� ����Ű�� �õ�Ƚ���� full�� �� �ֱ� ������ 5�� �̻� �̵����� ���ϰ��Ѵ�. ���� ���������� 404������ ��� 2��°�� �����ϴ� ���� Ȯ��.
					logger.info("Trying count is more than "+cnt);
					break;
				}
			}finally {
				request.releaseConnection();	// connection�� �����ش�. ���������� close_wait �߻�
			}
		}
		return api_data;
	}

	/**
	 * response���� 200�� ��쿡�� �����Ͱ��� ��������, api_data�� �о� return�Ѵ�.
	 * @param response
	 * @return api data
	 */
	private StringBuffer getApiData(HttpResponse response){

		logger.debug("URL ����");
		StringBuffer api_data = new StringBuffer();
 
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(new DataInputStream(response.getEntity().getContent()), "utf-8"));

			String line = "";
			while( (line = rd.readLine()) != null ){
				api_data.append(line);
			}
			logger.debug("������ ����");
		} catch (IOException e) {
			logger.error("[ ConnectUrl | getApiData ] IOException : "+e);
		} 
		return api_data;
	}

	


	/*	public StringBuffer getApiData(String url){

		logger.debug("URL ����");
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url.trim());
		HttpResponse response = null;
		StringBuffer api_data = new StringBuffer();

		try {

			response = client.execute(request);
			res = response.getStatusLine().getStatusCode();
			logger.debug("response code : "+res);

			if (res == 200){	//���������� ������ ����
				BufferedReader rd = new BufferedReader(new InputStreamReader(new DataInputStream(response.getEntity().getContent()), "utf-8"));

				String line = "";
				while( (line = rd.readLine()) != null ){
					api_data.append(line);
				}

			} else {
				logger.info("data required's response is not OK.");
				logger.debug("res code : "+res+", res Reason Phrase : "+response.getStatusLine().getReasonPhrase());
				logger.debug("����url : "+url);
			}
			logger.debug("������ ����");
		} catch (IOException e) {
			logger.error("[ GetAPIData class | IOException ]: "+e);
		} finally {
			request.releaseConnection();	// connection�� �����ش�. ���������� close_wait �߻�
		}
		return api_data;
	}*/

}
