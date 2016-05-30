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
		
			dtl.setSFRND_CD(dto.getLOCALGOVCD()); 	// ��ġ��ü�ڵ�
			dtl.setFSCLYR(dto.getFISYEAR()); 	// ȸ�迬��
			dtl.setFSSE(dto.getFISFGCD()); 	// ȸ�豸���ڵ�
			dtl.setGCC_DEPT_CD(dto.getGCCDEPTCD()); 	// GCC�μ��ڵ�
			dtl.setEXPENS_SE(dto.getEXPFG()); 	// ��񱸺�
			dtl.setEPNS_SN(dto.getEXPDCAUSEACTSNO()); 	// ������������Ϸù�ȣ
			dtl.setPYMNT_CM_NO(dto.getPAYCMDREGINO()); 	// ���޸�ɹ�ȣ
			dtl.setSN(dto.getEXPDRESOLCRDITORSEQ()); 	// ����
			dtl.setBCNC_NM(dto.getCUSTNM()); 	// �ŷ�ó��
			dtl.setBSNM_REGIST_NO(dto.getBIZREGINO()); 	// ����ڵ�Ϲ�ȣ
			
			list.add(dtl);
		}
		
		log.info("Convert List<EXPNDTR_BCNC_E_Dto> to List<TFE_EXPNDTR_BCNC_E> Object.");
		
		return list;
	}

}
