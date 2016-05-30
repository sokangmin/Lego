package kr.go.mpss.idsl.dmr.ip.link.saeol_asset;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.blocks.PipeBlock;

import kr.go.mpss.idsl.dmr.ip.link.saeol_asset.DRML.Resources.EquipmentInfos;

@Log4j2
public class DRML2TFE_ASSETS_INFO_CMMNBlock extends PipeBlock<DRML, List<TFE_ASSETS_INFO_CMMN>> {

	@Override
	protected List<TFE_ASSETS_INFO_CMMN> doing(DRML data) {		
		List<TFE_ASSETS_INFO_CMMN> list = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
			 
		for(EquipmentInfos equip:data.getResources().getEquipmentInfos()) {
			TFE_ASSETS_INFO_CMMN dao = mapper.map(equip, TFE_ASSETS_INFO_CMMN.class);
			
			dao.setCNTRCT_PBLNC_OFFIC_CL_CD("00");
			if(dao.getChgCode() != null)
				dao.setChgCode(getChgCodeNM(dao.getChgCode()));
			
			list.add(dao);
		}
	 
		log.info("Convert DRML to List<TFE_EQPMN_DAO> Object.");
		
		
		return list;
	}
	
	private String getChgCodeNM(String chgCode) {
		switch(chgCode) {
		case "01":	return "취득";
		case "02":	return "이동";
		case "03":	return "불용";
		case "04":	return "처분";
		case "05":	return "삭제";
		default:	return "";
		}
	}

}
