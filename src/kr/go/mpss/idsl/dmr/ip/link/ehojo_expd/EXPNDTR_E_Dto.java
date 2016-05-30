package kr.go.mpss.idsl.dmr.ip.link.ehojo_expd;

import lombok.Data;


@Data
public class EXPNDTR_E_Dto {
	private String LOCALGOVCD;	// 자치단체코드
	private String LOCALGOVNM;	// 자치단체명
	private String FISYEAR;		// 회계연도
	private String FISFGCD;		// 회계구분코드
	private String FISFGNM;		// 회계구분명
	private String GCCDEPTCD;	// GCC부서코드
	private String GCCDEPTNM;	// GCC부서명
	private String DEPTCD;		// 부서코드
	private String DEPTNM;		// 부서명
	private String EXPDCAUSEACTSNO;	// 지출원인행위일련번호
	private String PAYCMDREGINO;	// 지급명령번호
	private String CTRTACCTBOOKMNGNO;	// 계약대장관리번호
	private String CAUSENO;		// 원인번호
	private String EXPFG;		// 경비구분
	private String EXPFGNM;		// 경비구분명
	private String CONSULTKINDFG;	//품의종류구분
	private String CONSULTKINDFGNM;	// 품의종류구분명
	private String BIZCD;		// 사업코드
	private String BIZNM;		// 사업명
	private String TEMNGMOKCD;	// 세출관리목코드
	private String TEMNGMOKNM;	// 세출관리목명
	private String REGIYMD;		// 등록일자
	private String CAUSEACTAMT;	// 원인행위액
	private String TOTPAYCMDAMT;	// 지급명령금액
	private String PAYCMDYMD;		// 지급명령일자
	private String FINALREGIDATE;	// 최종수정일자

}
