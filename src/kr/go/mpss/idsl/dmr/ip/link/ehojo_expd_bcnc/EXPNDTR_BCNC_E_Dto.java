package kr.go.mpss.idsl.dmr.ip.link.ehojo_expd_bcnc;

import lombok.Data;


@Data
public class EXPNDTR_BCNC_E_Dto {
	private String LOCALGOVCD;	// 자치단체코드
	private String LOCALGOVNM;	// 자치단체명
	private String FISYEAR;		// 회계연도
	private String FISFGCD;		// 회계구분코드
	private String FISFGNM;		// 회계구분명
	private String GCCDEPTCD;	// GCC부서코드
	private String GCCDEPTNM;	// GCC부서명
	private String DEPTCD;		// 부서코드
	private String DEPTNM;		// 부서명
	private String EXPFG;		// 경비구분
	private String EXPFGNM;		// 경비구분명
	private String EXPDCAUSEACTSNO;	// 지출원인행위일련번호
	private String PAYCMDREGINO;	// 지급명령번호
	private String EXPDRESOLCRDITORSEQ;	// 순번
	private String CUSTNM;		// 거래처명
	private String BIZREGINO;	// 사업자등록번호
}
