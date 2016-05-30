package kr.go.mpss.idsl.dmr.ip.link.esaram.util;



public class ShareGpki {
	
	public ShareGpki(){
		
	}
	public static NewGpkiUtil getGpkiUtil(String targetServerId)throws Exception{
		NewGpkiUtil g = new NewGpkiUtil();
		// 이용기관 서버CN
		String myServerId = "SVR1750087002";
		
		// 이용기관 서버인증서 경로
		g.setCertFilePath("/DATA01/mogaha/gpki2/gpkisecureweb/certs");
		String envCertFilePathName = "/DATA01/mogaha/gpki2/gpkisecureweb/certs/SVR1750087002_env.cer";
		String envPrivateKeyFilePathName = "/DATA01/mogaha/gpki2/gpkisecureweb/certs/SVR1750087002_env.key";
		
		// 이용기관 서버인증서 비밀번호
//		String envPrivateKeyPasswd = "########";
		String envPrivateKeyPasswd = "thqkd0933!";

		// 이용기관 서버전자서명 경로
		String sigCertFilePathName = "/DATA01/mogaha/gpki2/gpkisecureweb/certs/SVR1750087002_sig.cer";
		String sigPrivateKeyFilePathName = "/DATA01/mogaha/gpki2/gpkisecureweb/certs/SVR1750087002_sig.key";
		
		// 이용기관 서버전자서명 비밀번호
//		String sigPrivateKeyPasswd = "########";
		String sigPrivateKeyPasswd = "thqkd0933!";
		
		
		// 이용기관 GPKI API 라이선스파일 경로
		g.setGpkiLicPath("/DATA01/mogaha/gpki2/gpkisecureweb/conf/1");
		g.setEnvCertFilePathName(envCertFilePathName);
		g.setEnvPrivateKeyFilePathName(envPrivateKeyFilePathName);
		g.setEnvPrivateKeyPasswd(envPrivateKeyPasswd);
		// LDAP 의 사용유무
		// 미사용일 경우 암호화할 타겟의 인증서를 파일로 저장해놓고 사용하여야함.
		g.setIsLDAP(true);
		g.setMyServerId(myServerId);
		g.setSigCertFilePathName(sigCertFilePathName);
		g.setSigPrivateKeyFilePathName(sigPrivateKeyFilePathName);
		g.setSigPrivateKeyPasswd(sigPrivateKeyPasswd);
		
		g.setTargetServerIdList(targetServerId);

		g.init();
		return g;
	}
}
