package kr.go.mpss.idsl.dmr.ip.link.esaram.util;



public class ShareGpki {
	
	public ShareGpki(){
		
	}
	public static NewGpkiUtil getGpkiUtil(String targetServerId)throws Exception{
		NewGpkiUtil g = new NewGpkiUtil();
		// �̿��� ����CN
		String myServerId = "SVR1750087002";
		
		// �̿��� ���������� ���
		g.setCertFilePath("/DATA01/mogaha/gpki2/gpkisecureweb/certs");
		String envCertFilePathName = "/DATA01/mogaha/gpki2/gpkisecureweb/certs/SVR1750087002_env.cer";
		String envPrivateKeyFilePathName = "/DATA01/mogaha/gpki2/gpkisecureweb/certs/SVR1750087002_env.key";
		
		// �̿��� ���������� ��й�ȣ
//		String envPrivateKeyPasswd = "########";
		String envPrivateKeyPasswd = "thqkd0933!";

		// �̿��� �������ڼ��� ���
		String sigCertFilePathName = "/DATA01/mogaha/gpki2/gpkisecureweb/certs/SVR1750087002_sig.cer";
		String sigPrivateKeyFilePathName = "/DATA01/mogaha/gpki2/gpkisecureweb/certs/SVR1750087002_sig.key";
		
		// �̿��� �������ڼ��� ��й�ȣ
//		String sigPrivateKeyPasswd = "########";
		String sigPrivateKeyPasswd = "thqkd0933!";
		
		
		// �̿��� GPKI API ���̼������� ���
		g.setGpkiLicPath("/DATA01/mogaha/gpki2/gpkisecureweb/conf/1");
		g.setEnvCertFilePathName(envCertFilePathName);
		g.setEnvPrivateKeyFilePathName(envPrivateKeyFilePathName);
		g.setEnvPrivateKeyPasswd(envPrivateKeyPasswd);
		// LDAP �� �������
		// �̻���� ��� ��ȣȭ�� Ÿ���� �������� ���Ϸ� �����س��� ����Ͽ�����.
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
