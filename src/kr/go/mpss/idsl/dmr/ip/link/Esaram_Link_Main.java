package kr.go.mpss.idsl.dmr.ip.link;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.flow.Lego;
import com.wini.lego.flow.MultiThreadLego;

import kr.go.mpss.idsl.dmr.ip.link.esaram.*;


@Log4j2
public class Esaram_Link_Main {

	public static void main(String[] args) {
		log.debug("��������_���� program is starting.");
		
		Lego e���_flow = new MultiThreadLego(1, 30, 0, 1, 60*60*24, true, "e���_flow");
		e���_flow.input("select from webService", FromWSBlock.class);
		e���_flow.filter("Xml String to Body Object", Xml2BodyBlock.class);
		e���_flow.filter("Body to List<TFE_TN_HCA_MASTER> Object", Body2TFE_TN_HCA_MASTERBlock.class);
		e���_flow.output("insert or update to tibero", ToDBBlock.class);
		e���_flow.start();
	}

}
