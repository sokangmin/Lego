package kr.go.mpss.idsl.dmr.ip.link.ehojo_expd_bcnc;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.blocks.PipeBlock;

@Log4j2
public class EXPNDTR_BCNC_E_Dto2TFE_EXPNDTR_BCNC_EBlock extends PipeBlock<List<EXPNDTR_BCNC_E_Dto>, List<TFE_EXPNDTR_BCNC_E>> {

	@Override
	protected List<TFE_EXPNDTR_BCNC_E> doing(List<EXPNDTR_BCNC_E_Dto> data) {
		List<TFE_EXPNDTR_BCNC_E> list = new ArrayList<>();
		
		for(EXPNDTR_BCNC_E_Dto dto : data) {
			TFE_EXPNDTR_BCNC_E dtl = new TFE_EXPNDTR_BCNC_E();
		
			dtl.setSFRND_CD(dto.getLOCALGOVCD()); 	// 자치단체코드
			dtl.setFSCLYR(dto.getFISYEAR()); 	// 회계연도
			dtl.setFSSE(dto.getFISFGCD()); 	// 회계구분코드
			dtl.setGCC_DEPT_CD(dto.getGCCDEPTCD()); 	// GCC부서코드
			dtl.setEXPENS_SE(dto.getEXPFG()); 	// 경비구분
			dtl.setEPNS_SN(dto.getEXPDCAUSEACTSNO()); 	// 지출원인행위일련번호
			dtl.setPYMNT_CM_NO(dto.getPAYCMDREGINO()); 	// 지급명령번호
			dtl.setSN(dto.getEXPDRESOLCRDITORSEQ()); 	// 순번
			dtl.setBCNC_NM(dto.getCUSTNM()); 	// 거래처명
			dtl.setBSNM_REGIST_NO(dto.getBIZREGINO()); 	// 사업자등록번호
			
			list.add(dtl);
		}
		
		log.info("Convert List<EXPNDTR_BCNC_E_Dto> to List<TFE_EXPNDTR_BCNC_E> Object.");
		
		return list;
	}

}
