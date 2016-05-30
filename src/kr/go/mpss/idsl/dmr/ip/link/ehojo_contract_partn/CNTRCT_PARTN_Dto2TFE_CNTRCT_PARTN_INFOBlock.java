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
			dtl.setCNTRCT_PBLNC_OFFIC_CL_CD("00");	// ������ó�з��ڵ�
			dtl.setCNTRCT_MNG_SN(dto.getLOCALGOVCD()+"-"+dto.getCTRTACCTBOOKMNGNO());	// �������Ϸù�ȣ
			dtl.setENTRPS_TY(dto.getCMPYTYPE());	// ��ü����
			dtl.setBCNC_SN(dto.getCTRTCMPYSNO()); 	// ����ü����
			dtl.setBCNC_NM(dto.getCUSTNM()); 	// �ŷ�ó��
			dtl.setBSNM_REGIST_NO(dto.getBIZREGINO()); 	// ����ڵ�Ϲ�ȣ
			dtl.setRPRSNTV_NM(dto.getREPREVEHGNM()); 	// ��ǥ�ڸ�
			dtl.setZIP(dto.getZIPNO()); 	// �����ȣ
			dtl.setBASS_ADRES(dto.getBASICADDR()); 	// �⺻�ּ�
			dtl.setDTL_ADRES(dto.getDETLADDR()); 	// ���ּ�
			dtl.setTELNO(dto.getTELNO()); 	// ��ȭ��ȣ
			
			list.add(dtl);
		}
		
		log.info("Convert List<CNTRCT_PARTN_Dto> to List<TFE_CNTRCT_PARTN_INFO> Object.");
		
		return list;
	}

}
