package kr.go.mpss.idsl.dmr.ip.link.ehojo_expd;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.blocks.PipeBlock;

@Log4j2
public class EXPNDTR_E_Dto2TFE_EXPNDTR_INFO_EBlock extends PipeBlock<List<EXPNDTR_E_Dto>, List<TFE_EXPNDTR_INFO_E>> {

	@Override
	protected List<TFE_EXPNDTR_INFO_E> doing(List<EXPNDTR_E_Dto> data) {
		List<TFE_EXPNDTR_INFO_E> list = new ArrayList<>();
		
		for(EXPNDTR_E_Dto dto : data) {
			TFE_EXPNDTR_INFO_E dtl = new TFE_EXPNDTR_INFO_E();
			dtl.setCNTRCT_PBLNC_OFFIC_CL_CD("00");	// 계약공고처분류코드
			dtl.setCNTRCT_MNG_SN(dto.getLOCALGOVCD()+"-"+dto.getCTRTACCTBOOKMNGNO());	// 계약관리일련번호
			dtl.setSFRND_CD(dto.getLOCALGOVCD()); 	// 자치단체코드
			dtl.setFSCLYR(dto.getFISYEAR()); 	// 회계연도
			dtl.setFSSE(dto.getFISFGCD()); 	// 회계구분코드
			dtl.setFSSE_NM(dto.getFISFGNM()); 	// 회계구분명
			dtl.setGCC_DEPT_CD(dto.getGCCDEPTCD()); 	// GCC부서코드
			dtl.setGCC_DEPT_CD_NM(dto.getGCCDEPTNM()); 	// GCC부서코드명
			dtl.setEPNS_SN(dto.getEXPDCAUSEACTSNO()); 	// 지출원인행위일련번호
			dtl.setPYMNT_CM_NO(dto.getPAYCMDREGINO()); 	// 지급명령번호
			dtl.setCAUSE_NO(dto.getCAUSENO()); 	// 원인번호
			dtl.setEXPENS_SE(dto.getEXPFG()); 	// 경비구분
			dtl.setEXPENS_SE_NM(dto.getEXPFGNM()); 	// 경비구분명
			dtl.setCNSUL_KND_SE(dto.getCONSULTKINDFG()); 	// 품의종류구분
			dtl.setCNSUL_KND_SE_NM(dto.getCONSULTKINDFGNM()); 	// 품의종류구분명
			dtl.setBSNS_CD(dto.getBIZCD()); 	// 사업코드
			dtl.setBSNS_NM(dto.getBIZNM()); 	// 사업명
			dtl.setTE_MNG_MOK_CD(dto.getTEMNGMOKCD()); 	// 세출관리목코드
			dtl.setTE_MNG_MOK_NM(dto.getTEMNGMOKNM()); 	// 세출관리목명
			dtl.setREGIST_DE(dto.getREGIYMD()); 	// 등록일자
			dtl.setCAUSE_ACTION_AM(dto.getCAUSEACTAMT()); 	// 원인행위액
			dtl.setPYMNT_CM_AMT(dto.getTOTPAYCMDAMT()); 	// 지급명령금액
			dtl.setPYMNT_CM_DE(dto.getPAYCMDYMD()); 	// 지급명령일자
			dtl.setLAST_MODF_DT(dto.getFINALREGIDATE()); 	// 최종수정일시
			
			list.add(dtl);
		}
		
		log.info("Convert List<EXPNDTR_E_Dto> to List<TFE_EXPNDTR_INFO_E> Object.");
		
		return list;
	}

}
