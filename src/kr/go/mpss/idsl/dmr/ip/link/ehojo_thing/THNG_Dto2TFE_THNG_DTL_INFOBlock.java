package kr.go.mpss.idsl.dmr.ip.link.ehojo_thing;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.blocks.PipeBlock;

@Log4j2
public class THNG_Dto2TFE_THNG_DTL_INFOBlock extends PipeBlock<List<THNG_Dto>, List<TFE_THNG_DTL_INFO>> {

	@Override
	protected List<TFE_THNG_DTL_INFO> doing(List<THNG_Dto> data) {
		List<TFE_THNG_DTL_INFO> list = new ArrayList<>();
		
		for(THNG_Dto dto : data) {
			TFE_THNG_DTL_INFO dtl = new TFE_THNG_DTL_INFO();
			dtl.setCNTRCT_PBLNC_OFFIC_CL_CD("00");	// 계약공고처분류코드
			dtl.setCNTRCT_MNG_SN(dto.getLOCALGOVCD()+"-"+dto.getCTRTACCTBOOKMNGNO());	// 계약관리일련번호
			dtl.setTHNG_SN(dto.getGOODSDESCSEQ());	// 물품명세순번
			dtl.setTHNG_NM(dto.getGOODSNM());	// 물품명
			dtl.setTHNG_CL_NO(dto.getGOODSCLNO());	// 물품분류번호
			dtl.setTHNG_STNDD_NO(dto.getGOODSPECNO());	// 물품규격번호
			dtl.setTHNG_STNDD(dto.getGOODSSPEC());	// 물품규격
			dtl.setTHNG_UNIT(dto.getGOODSUNIT()); 	// 물품단위
			dtl.setTHNG_QY(dto.getGOODSQTY()); 	// 물품수량
			dtl.setTHNG_UNTPC(dto.getGOODSUPRC());	// 물품단가
			dtl.setTHNG_AMT(dto.getGOODSAMT()); // 물품
			
			list.add(dtl);
		}
		
		log.info("Convert List<THNG_Dto> to List<TFE_THNG_DTL_INFO> Object.");
		
		return list;
	}

}
