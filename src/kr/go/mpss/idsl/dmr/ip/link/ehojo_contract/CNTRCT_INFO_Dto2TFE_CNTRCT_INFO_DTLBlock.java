package kr.go.mpss.idsl.dmr.ip.link.ehojo_contract;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.blocks.PipeBlock;

@Log4j2
public class CNTRCT_INFO_Dto2TFE_CNTRCT_INFO_DTLBlock extends PipeBlock<List<CNTRCT_INFO_Dto>, List<TFE_CNTRCT_INFO_DTL>> {

	@Override
	protected List<TFE_CNTRCT_INFO_DTL> doing(List<CNTRCT_INFO_Dto> data) {
		List<TFE_CNTRCT_INFO_DTL> list = new ArrayList<>();
		
		for(CNTRCT_INFO_Dto dto : data) {
			TFE_CNTRCT_INFO_DTL dtl = new TFE_CNTRCT_INFO_DTL();
			dtl.setCNTRCT_PBLNC_OFFIC_CL_CD("00");	// ������ó�з��ڵ�
			dtl.setCNTRCT_MNG_SN(dto.getLOCALGOVCD()+"-"+dto.getCTRTACCTBOOKMNGNO());	// �������Ϸù�ȣ
			dtl.setSFRND_CD(dto.getLOCALGOVCD());	// ��ġ��ü�ڵ�
			dtl.setCNTRCT_MNG_NO(dto.getCTRTACCTBOOKMNGNO());	// ��������ȣ
			dtl.setFSCLYR(dto.getFISYEAR());	// ȸ�迬��
			dtl.setCNTRCT_NM(dto.getCTRTNM());	// ����
			dtl.setCNTRCT_SE_NM(dto.getCTRTFGNM());	// ��౸�и�
			dtl.setCNTRCT_SE_KND_NM(dto.getCTRTKINDNM());	// ���������
			dtl.setCNTRCT_DE(dto.getFIRSTCTRTYMD());	// �������
			dtl.setCNTRCT_AMT(dto.getSUMMARYCTRTTOTAMT());	// ���ݾ�
			dtl.setPROGRS_STTUS("���ü��");	// �������
			
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMddHHmmss");
			dtl.setCNTC_DT(now.toString(fmt));	// �����Ͻ�
			
			dtl.setCNTRCT_SE(dto.getCTRTFG());	// ��౸��
			dtl.setCNTRCT_OBJ(dto.getCTRTOBJECTS());	// ��������
			dtl.setCNTRCT_SE_KND(dto.getCTRTKIND());	// �������
			dtl.setCNTRCT_TY(dto.getCTRTTYPE());	// �������
			dtl.setCNTRCT_TY_NM(dto.getCTRTTYPENM());	// ���������
			dtl.setSTRWRK_DE(dto.getSTARTWORKYMD());	// ��������
			dtl.setFRST_SMRIZE_CNTRCTAMOUNT(dto.getFIRSTSUMMARYCTRTAMT());	// �����Ѱ����ݾ�
			dtl.setCOMPET_PRRNG_DE(dto.getCOMPLTSCHDYMD());	// �ذ���������
			dtl.setEXPENS_SE(dto.getEXPFG());	// ��񱸺�
			dtl.setEXPENS_SE_NM(dto.getEXPFGNM());	// ��񱸺и�
			dtl.setCOMPET_DE(dto.getCOMPLTYMD());	// �ذ�����
			dtl.setDEBIT_AT(dto.getDIRECTPAYYN());	// ���ҿ���
			dtl.setNEW_LNGTR_SE(dto.getNEWLONGPRDFG());	// �ű�/��ⱸ��
			dtl.setNEW_LNGTR_SE_NM(dto.getNEWLONGPRDFGNM());	// �ű�/��ⱸ�и�
			dtl.setCNTRCT_MTH(dto.getCTRTMETH());	// �����
			dtl.setCNTRCT_MTH_NM(dto.getCTRTMETHNM());	// �������
			dtl.setCNTRCT_SUMRY(dto.getCTRTOUTLINE());	// �������
			dtl.setLC_NM(dto.getLOCATNM());	// ��ġ��
			dtl.setPRCURE_SE(dto.getSPLYFG());	// ���ޱ���
			dtl.setPRCURE_SE_NM(dto.getSPLYFGNM());	// ���ޱ��и�
			dtl.setCNTRCT_DEPT_CD(dto.getDEPTCD());	// ���μ��ڵ�
			dtl.setCNTRCT_CHPSN_ID(dto.getCTRTUSERID());	// �������ID
			dtl.setCNTRCT_CHPSN_NM(dto.getCTRTUSERNM());	// ������ڸ�
			dtl.setLAST_UPDUSR_DE(dto.getMODIYMD());	// ����������
			
			list.add(dtl);
		}
		
		log.info("Convert List<CNTRCT_INFO_Dto> to List<TFE_CNTRCT_INFO_DTL> Object.");
		
		return list;
	}

}
