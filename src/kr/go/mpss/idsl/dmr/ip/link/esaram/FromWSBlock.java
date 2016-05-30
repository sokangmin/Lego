package kr.go.mpss.idsl.dmr.ip.link.esaram;

import com.wini.lego.blocks.StartBlock;

public class FromWSBlock extends StartBlock<String> {

	@Override
	protected String doing(Void data) {
		String result;
		
		IndiDutyMatterInfoService ws = new IndiDutyMatterInfoService();
		result = ws.service();
		
		if (result != null) {
			result = result.replaceAll("typ:", "");
			result = "<body>" + result + "</body>";
		}
		
		return result;
	}

}
