package kr.go.mpss.idsl.dmr.ip.link.ehojo_contract;

import lombok.Data;


@Data
public class CNTRCT_INFO_Dto {
	private String LOCALGOVCD;	// 자치단체코드
	private String LOCALGOVNM;	// 자치단체명
	private String FISYEAR;		// 회계연도
	private String CTRTACCTBOOKMNGNO;	// 계약대장관리번호
	private String CTRTNM;		// 계약명
	private String CTRTFG;		// 계약구분
	private String CTRTFGNM;	// 계약구분명
	private String CTRTOBJECTS;	// 계약목적
	private String CTRTOBJECTSNM;	// 계약목적명
	private String CTRTKIND;	// 계약종류
	private String CTRTKINDNM;	// 계약종류명
	private String CTRTTYPE;	// 계약유형
	private String CTRTTYPENM;	// 계약유형명
	private String FIRSTCTRTYMD;	// 총괄계약일자
	private String SUMMARYCTRTTOTAMT;	// 총괄계약합계금액
	private String STARTWORKYMD;	// 착공일자
	private String FIRSTSUMMARYCTRTAMT;	// 최초총괄계약금액
	private String COMPLTSCHDYMD;	// 준공예정일자
	private String EXPFG;		// 경비구분
	private String EXPFGNM;		// 경비구분명
	private String COMPLTYMD;	// 준공일자
	private String DIRECTPAYYN;	// 직불여부
	private String NEWLONGPRDFG;	// 신규/장기구분
	private String NEWLONGPRDFGNM;	// 신규/장기구분명
	private String CTRTMETH;	// 계약방법
	private String CTRTMETHNM;	// 계약방법명
	private String CTRTOUTLINE;	// 계약적요
	private String LOCATNM;		// 위치명
	private String SPLYFG;		// 조달구분
	private String SPLYFGNM;	// 조달구분명
	private String DEPTCD;		// 계약부서코드
	private String CTRTUSERID;	// 계약담당자ID
	private String CTRTUSERNM;	// 계약담당자명
	private String MODIYMD;		// 최종수정일

}
