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
			dtl.setCNTRCT_PBLNC_OFFIC_CL_CD("00");	// 계약공고처분류코드
			dtl.setCNTRCT_MNG_SN(dto.getLOCALGOVCD()+"-"+dto.getCTRTACCTBOOKMNGNO());	// 계약관리일련번호
			dtl.setSFRND_CD(dto.getLOCALGOVCD());	// 자치단체코드
			dtl.setCNTRCT_MNG_NO(dto.getCTRTACCTBOOKMNGNO());	// 계약관리번호
			dtl.setFSCLYR(dto.getFISYEAR());	// 회계연도
			dtl.setCNTRCT_NM(dto.getCTRTNM());	// 계약명
			dtl.setCNTRCT_SE_NM(dto.getCTRTFGNM());	// 계약구분명
			dtl.setCNTRCT_SE_KND_NM(dto.getCTRTKINDNM());	// 계약종류명
			dtl.setCNTRCT_DE(dto.getFIRSTCTRTYMD());	// 계약일자
			dtl.setCNTRCT_AMT(dto.getSUMMARYCTRTTOTAMT());	// 계약금액
			dtl.setPROGRS_STTUS("계약체결");	// 진행상태
			
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMddHHmmss");
			dtl.setCNTC_DT(now.toString(fmt));	// 연계일시
			
			dtl.setCNTRCT_SE(dto.getCTRTFG());	// 계약구분
			dtl.setCNTRCT_OBJ(dto.getCTRTOBJECTS());	// 계약목적물
			dtl.setCNTRCT_SE_KND(dto.getCTRTKIND());	// 계약종류
			dtl.setCNTRCT_TY(dto.getCTRTTYPE());	// 계약유형
			dtl.setCNTRCT_TY_NM(dto.getCTRTTYPENM());	// 계약유형명
			dtl.setSTRWRK_DE(dto.getSTARTWORKYMD());	// 착공일자
			dtl.setFRST_SMRIZE_CNTRCTAMOUNT(dto.getFIRSTSUMMARYCTRTAMT());	// 최초총괄계약금액
			dtl.setCOMPET_PRRNG_DE(dto.getCOMPLTSCHDYMD());	// 준공예정일자
			dtl.setEXPENS_SE(dto.getEXPFG());	// 경비구분
			dtl.setEXPENS_SE_NM(dto.getEXPFGNM());	// 경비구분명
			dtl.setCOMPET_DE(dto.getCOMPLTYMD());	// 준공일자
			dtl.setDEBIT_AT(dto.getDIRECTPAYYN());	// 직불여부
			dtl.setNEW_LNGTR_SE(dto.getNEWLONGPRDFG());	// 신규/장기구분
			dtl.setNEW_LNGTR_SE_NM(dto.getNEWLONGPRDFGNM());	// 신규/장기구분명
			dtl.setCNTRCT_MTH(dto.getCTRTMETH());	// 계약방법
			dtl.setCNTRCT_MTH_NM(dto.getCTRTMETHNM());	// 계약방법명
			dtl.setCNTRCT_SUMRY(dto.getCTRTOUTLINE());	// 계약적요
			dtl.setLC_NM(dto.getLOCATNM());	// 위치명
			dtl.setPRCURE_SE(dto.getSPLYFG());	// 조달구분
			dtl.setPRCURE_SE_NM(dto.getSPLYFGNM());	// 조달구분명
			dtl.setCNTRCT_DEPT_CD(dto.getDEPTCD());	// 계약부서코드
			dtl.setCNTRCT_CHPSN_ID(dto.getCTRTUSERID());	// 계약담당자ID
			dtl.setCNTRCT_CHPSN_NM(dto.getCTRTUSERNM());	// 계약담당자명
			dtl.setLAST_UPDUSR_DE(dto.getMODIYMD());	// 최종수정일
			
			list.add(dtl);
		}
		
		log.info("Convert List<CNTRCT_INFO_Dto> to List<TFE_CNTRCT_INFO_DTL> Object.");
		
		return list;
	}

}
