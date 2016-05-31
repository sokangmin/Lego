package kr.go.mpss.idsl.dmr.ip.link;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.flow.Lego;
import com.wini.lego.flow.MultiThreadLego;

import kr.go.mpss.idsl.dmr.ip.link.saeol_asset.*;



@Log4j2
public class Saeol_Link_Main {

	public static void main(String[] args) {
		log.debug("ㅌㅎㅈㄴ_ㅇㄱ program is starting.");
		
		Lego 새올_자산_flow = new MultiThreadLego(4, 0, 0, 1, 60*60*24, true, "새올_자산_flow");
		새올_자산_flow.input("select from directory", FromFileBlock.class);
		새올_자산_flow.filter("Xml File to DRML object",  Xml2DRMLBlock.class);	
		새올_자산_flow.filter("DRML to List<TFE_EQPMN_DAO> object", DRML2TFE_ASSETS_INFO_CMMNBlock.class);
		새올_자산_flow.output("insert or update to tibero", ToDBBlock.class);		
		새올_자산_flow.successListener(SuccessBlock.class);
		새올_자산_flow.failListener(FailBlock.class);
		새올_자산_flow.start();
	}

}
