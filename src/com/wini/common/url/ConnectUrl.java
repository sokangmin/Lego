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
 * 앞단에서 string형태로 받은 url에 접속을 시도한다.
 * openAPI에 접속을 시도할 때 유료한 url인데 404에러가 나는 경우가 있어 200응답코드를 받지 못할 시, 해당 url접속을 재시도한다.
 * 하지만 인증키에 하루 요청가능 횟수가 정해져 있기때문에(해당 서비스바다 접속 요청 횟수는 다 다를 수 있다.) 5번 이상 시도할지 연계를 하지 않고 넘어간다.
 * 
 * 
 * @author 박진영 2015.10.21
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
		
		if(url.indexOf("&damcode=") != -1){	//damcode를 정보를 받은 후 알 수 없어 damcode를 따로 빼서 parsing하는 곳에 넘겨준다.
			damcode = url.substring(url.indexOf("&damcode=")+"&damcode=".length(), url.length());
			map_url_data.put("damcode", damcode);
		}/* else if(url.indexOf("&cctv_sn=") != -1){//cctv_sn을 알 수 없기 때문에 cctv_sn을 따로 parsing하는 곳에 넘겨준다.
			cctv_sn = url.substring(url.indexOf("&cctv_sn=")+"&cctv_sn=".length(), url.length());
			map_url_data.put("cctv_sn", cctv_sn);	//나중에 db에 insert/update 시 필요해서 검색해 가져온 데이터
			//원래 cctv_sn은 url에 포함되지 않는 부분이기 때문에, 추출 후 url에서 지워준다.
			url=url.substring(0, url.indexOf("&cctv_sn="));
		}*/
		
		//실제로 받은url에서 데이터를 받아오는 부분
		StringBuffer api_data = getApiData(url);
		
		//map에 api_data로 받아온 값을 넣는다.
		map_url_data.put("api_data", api_data.toString());

		/*logger.debug("실행 url : "+url);
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = null;
		//		request = new HttpGet(url.trim());
		HttpResponse response = null;

		 *//**실황정보를 연계할 때 multi thread로 각 해당 url에 접속하여 데이터를 연계해오도록 하는데, 비정상적인 접속(유효한 url이 404 에러로 리턴 됨) 문제가 있어서 해당url이 200 code를 받을때까지 재시도한다.
		 * 보통 첫번째 시도에 총 20개 중 15개~18개 정도가 성공되고 나머지는 올바르게 연계될때까지 시도를 한다.
		 * 테스트결과 통상적으로 2번까지 재시도 시 200번 code를 리턴받았다.
		 * 왜 유효한 url이 404 에러가 나는지는 파악하지 못함.
		 * 테스트했을 때 single thread로 해당 url에 접속하는 경우에는 이런 비정상적인 결과를 받은 적이 없다.
		 * (해당 운영서버용 인증키는 실황 정보에 요청을 하루에 1000건까지 시도할 수 있다.)
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
					logger.info("data required's response is not OK. 응답코드(result code) : "+res+", 실패 이유(reason) : "+response.getStatusLine().getReasonPhrase());
					cnt++;
					logger.info(cnt+"번째 재시도. url : "+url);
				}
			} catch (ClientProtocolException e) {
				logger.error("[ ConnectUrl | doing ] ClientProtocolException : "+e);
			} catch (IOException e) {
				logger.error("[ ConnectUrl | doing ] IOException : "+e);
			} finally {
				request.releaseConnection();	// connection을 끊어준다. 하지않으면 close_wait 발생
			}
		}*/
		return map_url_data;
	}
	
	/**실황정보를 연계할 때 multi thread로 각 해당 url에 접속하여 데이터를 연계해오도록 하는데, 비정상적인 접속(유효한 url이 404 에러로 리턴 됨) 문제가 있어서 해당url이 200 code를 받을때까지 재시도한다.
	 * 보통 첫번째 시도에 총 20개 중 15개~18개 정도가 한번에 성공되고 나머지는 올바르게 연계될때까지 시도를 한다.
	 * 테스트결과 통상적으로 2번까지 재시도 시 200번 code를 리턴받았다.
	 * 왜 유효한 url이 404 에러가 나는지는 파악하지 못함.
	 * 테스트했을 때 single thread로 해당 url에 접속하는 경우에는 이런 비정상적인 결과를 받은 적이 없다.
	 * (해당 운영서버용 인증키는 실황 정보에 요청을 하루에 1000건까지 시도할 수 있다.)
	 */
	public StringBuffer getApiData(String url){
		logger.debug("실행 url : "+url);
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
				response = client.execute(request);	//timed out 발생지점
				res = response.getStatusLine().getStatusCode();

				if(res == 200){	//응답코드값이 200일때만 정상응답
					api_data = getApiData(response);
					break;
				} else if(cnt>=tryCnt) {	//접속 시도를 너무 많이 할 경우 인증키의 시도횟수가 full될 수 있기 때문에 5번 이상 이도하지 못하게한다. 보통 비정상적인 404에러의 경우 2번째에 성공하는 것을 확인.
					logger.info("Trying count is more than 5. It doesn't try url : "+url);
					break;
				} else {
					logger.info("Try cnt : "+cnt+"\n url : "+url+"\n data required's response is not OK. result code : "+res+"\n fail reason : "+response.getStatusLine().getReasonPhrase());
				}

			} catch (ClientProtocolException e) {
				logger.error("[ ConnectUrl | getApiData ] ClientProtocolException : "+e+"\n ClientProtocolException URL : "+url);
				if(cnt>=tryCnt) {	//접속 시도를 너무 많이 할 경우 인증키의 시도횟수가 full될 수 있기 때문에 5번 이상 이도하지 못하게한다. 보통 비정상적인 404에러의 경우 2번째에 성공하는 것을 확인.
					logger.info("Trying count is more than "+cnt);
					break;
				}
			} catch (IOException e) {
				logger.error("[ ConnectUrl | getApiData ] IOException : "+e+"\n IOException URL : "+url);
				if(cnt>=tryCnt) {	//접속 시도를 너무 많이 할 경우 인증키의 시도횟수가 full될 수 있기 때문에 5번 이상 이도하지 못하게한다. 보통 비정상적인 404에러의 경우 2번째에 성공하는 것을 확인.
					logger.info("Trying count is more than "+cnt);
					break;
				}
			} catch (Exception e) {
				logger.error("[ ConnectUrl | getApiData ] Exception : "+e+"\n Exception URL : "+url);
				if(cnt>=tryCnt) {	//접속 시도를 너무 많이 할 경우 인증키의 시도횟수가 full될 수 있기 때문에 5번 이상 이도하지 못하게한다. 보통 비정상적인 404에러의 경우 2번째에 성공하는 것을 확인.
					logger.info("Trying count is more than "+cnt);
					break;
				}
			}finally {
				request.releaseConnection();	// connection을 끊어준다. 하지않으면 close_wait 발생
			}
		}
		return api_data;
	}

	/**
	 * response값이 200일 경우에만 데이터값이 정상응답, api_data를 읽어 return한다.
	 * @param response
	 * @return api data
	 */
	private StringBuffer getApiData(HttpResponse response){

		logger.debug("URL 접속");
		StringBuffer api_data = new StringBuffer();
 
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(new DataInputStream(response.getEntity().getContent()), "utf-8"));

			String line = "";
			while( (line = rd.readLine()) != null ){
				api_data.append(line);
			}
			logger.debug("데이터 받음");
		} catch (IOException e) {
			logger.error("[ ConnectUrl | getApiData ] IOException : "+e);
		} 
		return api_data;
	}

	


	/*	public StringBuffer getApiData(String url){

		logger.debug("URL 접속");
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url.trim());
		HttpResponse response = null;
		StringBuffer api_data = new StringBuffer();

		try {

			response = client.execute(request);
			res = response.getStatusLine().getStatusCode();
			logger.debug("response code : "+res);

			if (res == 200){	//정상적으로 응답을 받음
				BufferedReader rd = new BufferedReader(new InputStreamReader(new DataInputStream(response.getEntity().getContent()), "utf-8"));

				String line = "";
				while( (line = rd.readLine()) != null ){
					api_data.append(line);
				}

			} else {
				logger.info("data required's response is not OK.");
				logger.debug("res code : "+res+", res Reason Phrase : "+response.getStatusLine().getReasonPhrase());
				logger.debug("실패url : "+url);
			}
			logger.debug("데이터 받음");
		} catch (IOException e) {
			logger.error("[ GetAPIData class | IOException ]: "+e);
		} finally {
			request.releaseConnection();	// connection을 끊어준다. 하지않으면 close_wait 발생
		}
		return api_data;
	}*/

}
