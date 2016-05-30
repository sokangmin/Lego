package kr.go.mpss.idsl.dmr.ip.link.ehojo_contract_partn;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.blocks.PipeBlock;

@Log4j2
public class CNTRCT_PARTN_Dto2TFE_CNTRCT_PARTN_INFOBlock extends PipeBlock<List<CNTRCT_PARTN_Dto>, List<TFE_CNTRCT_PARTN_INFO>> {

	@Override
	protected List<TFE_CNTRCT_PARTN_INFO> doing(List<CNTRCT_PARTN_Dto> data) {
		List<TFE_CNTRCT_PARTN_INFO> list = new ArrayList<>();
		
		for(CNTRCT_PARTN_Dto dto : data) {
			TFE_CNTRCT_PARTN_INFO dtl = new TFE_CNTRCT_PARTN_INFO();
			dtl.setCNTRCT_PBLNC_OFFIC_CL_CD("00");	// 계약공고처분류코드
			dtl.setCNTRCT_MNG_SN(dto.getLOCALGOVCD()+"-"+dto.getCTRTACCTBOOKMNGNO());	// 계약관리일련번호
			dtl.setENTRPS_TY(dto.getCMPYTYPE());	// 업체유형
			dtl.setBCNC_SN(dto.getCTRTCMPYSNO()); 	// 계약업체순번
			dtl.setBCNC_NM(dto.getCUSTNM()); 	// 거래처명
			dtl.setBSNM_REGIST_NO(dto.getBIZREGINO()); 	// 사업자등록번호
			dtl.setRPRSNTV_NM(dto.getREPREVEHGNM()); 	// 대표자명
			dtl.setZIP(dto.getZIPNO()); 	// 우편번호
			dtl.setBASS_ADRES(dto.getBASICADDR()); 	// 기본주소
			dtl.setDTL_ADRES(dto.getDETLADDR()); 	// 상세주소
			dtl.setTELNO(dto.getTELNO()); 	// 전화번호
			
			list.add(dtl);
		}
		
		log.info("Convert List<CNTRCT_PARTN_Dto> to List<TFE_CNTRCT_PARTN_INFO> Object.");
		
		return list;
	}

}
