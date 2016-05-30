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
			dtl.setCNTRCT_PBLNC_OFFIC_CL_CD("00");	// ������ó�з��ڵ�
			dtl.setCNTRCT_MNG_SN(dto.getLOCALGOVCD()+"-"+dto.getCTRTACCTBOOKMNGNO());	// �������Ϸù�ȣ
			dtl.setTHNG_SN(dto.getGOODSDESCSEQ());	// ��ǰ������
			dtl.setTHNG_NM(dto.getGOODSNM());	// ��ǰ��
			dtl.setTHNG_CL_NO(dto.getGOODSCLNO());	// ��ǰ�з���ȣ
			dtl.setTHNG_STNDD_NO(dto.getGOODSPECNO());	// ��ǰ�԰ݹ�ȣ
			dtl.setTHNG_STNDD(dto.getGOODSSPEC());	// ��ǰ�԰�
			dtl.setTHNG_UNIT(dto.getGOODSUNIT()); 	// ��ǰ����
			dtl.setTHNG_QY(dto.getGOODSQTY()); 	// ��ǰ����
			dtl.setTHNG_UNTPC(dto.getGOODSUPRC());	// ��ǰ�ܰ�
			dtl.setTHNG_AMT(dto.getGOODSAMT()); // ��ǰ
			
			list.add(dtl);
		}
		
		log.info("Convert List<THNG_Dto> to List<TFE_THNG_DTL_INFO> Object.");
		
		return list;
	}

}
