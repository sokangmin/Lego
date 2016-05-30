package kr.go.mpss.idsl.dmr.ip.link;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.flow.Lego;
import com.wini.lego.flow.MultiThreadLego;


@Log4j2
public class Saeol_Link_Main {

	public static void main(String[] args) {
		log.debug("��������_���� program is starting.");
		
		Lego ����_�ڻ�_flow = new MultiThreadLego(4, 0, 0, 1, 60*60*24, true, "����_�ڻ�_flow");
		����_�ڻ�_flow.input("select from directory", kr.go.mpss.idsl.dmr.ip.link.saeol_asset.FromFileBlock.class);
		����_�ڻ�_flow.filter("Xml File to DRML object",  kr.go.mpss.idsl.dmr.ip.link.saeol_asset.Xml2DRMLBlock.class);	
		����_�ڻ�_flow.filter("DRML to List<TFE_EQPMN_DAO> object", kr.go.mpss.idsl.dmr.ip.link.saeol_asset.DRML2TFE_ASSETS_INFO_CMMNBlock.class);
		����_�ڻ�_flow.output("insert or update to tibero", kr.go.mpss.idsl.dmr.ip.link.saeol_asset.ToDBBlock.class);		
		����_�ڻ�_flow.successListener(kr.go.mpss.idsl.dmr.ip.link.saeol_asset.SuccessBlock.class);
		����_�ڻ�_flow.failListener(kr.go.mpss.idsl.dmr.ip.link.saeol_asset.FailBlock.class);
		����_�ڻ�_flow.start();
	}

}
