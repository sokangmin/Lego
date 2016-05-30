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
			dtl.setCNTRCT_PBLNC_OFFIC_CL_CD("00");	// ������ó�з��ڵ�
			dtl.setCNTRCT_MNG_SN(dto.getLOCALGOVCD()+"-"+dto.getCTRTACCTBOOKMNGNO());	// �������Ϸù�ȣ
			dtl.setSFRND_CD(dto.getLOCALGOVCD()); 	// ��ġ��ü�ڵ�
			dtl.setFSCLYR(dto.getFISYEAR()); 	// ȸ�迬��
			dtl.setFSSE(dto.getFISFGCD()); 	// ȸ�豸���ڵ�
			dtl.setFSSE_NM(dto.getFISFGNM()); 	// ȸ�豸�и�
			dtl.setGCC_DEPT_CD(dto.getGCCDEPTCD()); 	// GCC�μ��ڵ�
			dtl.setGCC_DEPT_CD_NM(dto.getGCCDEPTNM()); 	// GCC�μ��ڵ��
			dtl.setEPNS_SN(dto.getEXPDCAUSEACTSNO()); 	// ������������Ϸù�ȣ
			dtl.setPYMNT_CM_NO(dto.getPAYCMDREGINO()); 	// ���޸�ɹ�ȣ
			dtl.setCAUSE_NO(dto.getCAUSENO()); 	// ���ι�ȣ
			dtl.setEXPENS_SE(dto.getEXPFG()); 	// ��񱸺�
			dtl.setEXPENS_SE_NM(dto.getEXPFGNM()); 	// ��񱸺и�
			dtl.setCNSUL_KND_SE(dto.getCONSULTKINDFG()); 	// ǰ����������
			dtl.setCNSUL_KND_SE_NM(dto.getCONSULTKINDFGNM()); 	// ǰ���������и�
			dtl.setBSNS_CD(dto.getBIZCD()); 	// ����ڵ�
			dtl.setBSNS_NM(dto.getBIZNM()); 	// �����
			dtl.setTE_MNG_MOK_CD(dto.getTEMNGMOKCD()); 	// ����������ڵ�
			dtl.setTE_MNG_MOK_NM(dto.getTEMNGMOKNM()); 	// ����������
			dtl.setREGIST_DE(dto.getREGIYMD()); 	// �������
			dtl.setCAUSE_ACTION_AM(dto.getCAUSEACTAMT()); 	// ����������
			dtl.setPYMNT_CM_AMT(dto.getTOTPAYCMDAMT()); 	// ���޸�ɱݾ�
			dtl.setPYMNT_CM_DE(dto.getPAYCMDYMD()); 	// ���޸������
			dtl.setLAST_MODF_DT(dto.getFINALREGIDATE()); 	// ���������Ͻ�
			
			list.add(dtl);
		}
		
		log.info("Convert List<EXPNDTR_E_Dto> to List<TFE_EXPNDTR_INFO_E> Object.");
		
		return list;
	}

}
