package kr.go.mpss.idsl.dmr.ip.link.esaram;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import kr.go.mpss.idsl.dmr.ip.link.esaram.util.Client;
import kr.go.mpss.idsl.dmr.ip.link.esaram.util.NewGpkiUtil;
import kr.go.mpss.idsl.dmr.ip.link.esaram.util.ShareGpki;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class IndiDutyMatterInfoService {

	public String service() {
		long startTime = System.currentTimeMillis();
		String rnd1 = Double.toString(java.lang.Math.random()).substring(2, 6);
		String rnd2 = Double.toString(java.lang.Math.random()).substring(2, 6);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS",Locale.KOREA);
		String cur = sdf.format(new Date());
		String transactionUniqueId = cur + rnd1 + rnd2;
		
		LocalDate now = LocalDate.now();
		LocalDate yesterday = now.minusDays(1);
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd");
		String str_now = now.toString(fmt);	// 연계일시
		String str_yesterday = yesterday.toString(fmt);
		
		NewGpkiUtil g = null;
		String xml = null;
		StringBuffer sb = new StringBuffer();
		sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://ccais.mopas.go.kr/dh/osc/services/esaram/indidutymatterinfo/types\">\n");
		sb.append("   <soapenv:Header>																\n");
		sb.append("      <typ:commonHeader>															\n");
		sb.append("         <typ:serviceName>IndiDutyMatterInfoService</typ:serviceName>				\n");
		sb.append("         <typ:useSystemCode>ESBTEST</typ:useSystemCode>						\n");
		sb.append("         <typ:certServerId>SVR1750087002</typ:certServerId>				\n");	
		sb.append("         <typ:transactionUniqueId>" + transactionUniqueId+ "</typ:transactionUniqueId>										\n");
		sb.append("         <typ:userDeptCode>1750000</typ:userDeptCode>				\n");
		sb.append("         <typ:userName>차경천</typ:userName>					\n");
		sb.append("      </typ:commonHeader>										\n");
		sb.append("   </soapenv:Header>												\n");
		sb.append("   <soapenv:Body>												\n");
		sb.append("      <typ:getIndiDutyMatterInfoService>								\n");
		sb.append("         <typ:reqStartDate>" + str_yesterday + "</typ:reqStartDate>			\n");
		sb.append("         <typ:reqEndDate>" + str_now + "</typ:reqEndDate>				\n");
		/*sb.append("         <typ:reqStartDate>20160513</typ:reqStartDate>			\n");
		sb.append("         <typ:reqEndDate>20160514</typ:reqEndDate>				\n");*/
		sb.append("       </typ:getIndiDutyMatterInfoService>								\n");
		sb.append("   </soapenv:Body>												\n");
		sb.append("</soapenv:Envelope>												\n");

		xml = sb.toString();
//		String serviceUrl = "http://10.50.3.172:24100/smx/infoservice/esaram/IndiDutyMatterInfoService";
		String serviceUrl = "http://hub.share.go.kr:80/smx/infoservice/esaram/IndiDutyMatterInfoService";

		String encoded = null;
		String requestXml = null;
		try {
			
			String targetServerId = "SVR1311447001";	
			g = ShareGpki.getGpkiUtil(targetServerId);	
			
			String charset = "UTF-8";

			int sIndex = xml.indexOf("<typ:getIndiDutyMatterInfoService");
			sIndex = xml.indexOf(">", sIndex)+1;
			
			int eIndex = xml.indexOf("</typ:getIndiDutyMatterInfoService");
			String original = xml.substring(sIndex, eIndex);

			// String encoded;
			byte[] encrypted = g.encrypt(original.getBytes(charset),
					targetServerId);
			byte[] signed = g.sign(encrypted);
			encoded = g.encode(signed);
			System.out.println("original=" + original);
			System.out.println("encoded=" + encoded);

			requestXml = xml;
			{
				requestXml = requestXml.replace(original, encoded);
			}
			System.out.println(requestXml);
		} catch (Throwable e) {
			log.error(e);
		}

		String aa = Client.doService(serviceUrl, requestXml);
		
		int sIndex = aa.indexOf("getIndiDutyMatterInfoResponse");
		sIndex = aa.indexOf(">", sIndex)+1;
		
		int eIndex = aa.lastIndexOf("getIndiDutyMatterInfoResponse");
		eIndex = aa.lastIndexOf("</", eIndex);
		String qq = aa.substring(sIndex, eIndex);
		
		String decrypted = null;
		{
			byte[] decoded;
			try {
				decoded = g.decode(qq);
				byte[] validated = g.validate(decoded);
				decrypted = new String(g.decrypt(validated), "UTF-8");
				//System.out.println("aaaaaaa->" + decrypted);
				log.info("aaaaaaa->" + decrypted);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
		}
		log.info("응답시간 : " + (System.currentTimeMillis() - startTime) + " ms");
		
		return decrypted;
	}
	
	public static void main(String[] args) {
		IndiDutyMatterInfoService ws = new IndiDutyMatterInfoService();
		String result = ws.service();
		result = result.replaceAll("typ:", "");
		
		result = "<body>" + result + "</body>";
		
		System.out.println(result);
	}
}