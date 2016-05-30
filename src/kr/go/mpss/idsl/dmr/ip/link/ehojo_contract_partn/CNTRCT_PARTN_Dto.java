package kr.go.mpss.idsl.dmr.ip.link.ehojo_contract_partn;

import lombok.Data;


@Data
public class CNTRCT_PARTN_Dto {
	private String LOCALGOVCD;	// 자치단체코드
	private String LOCALGOVNM;	// 자치단체명
	private String CTRTACCTBOOKMNGNO;	// 계약대장관리번호
	private String CMPYTYPE;	// 업체유형
	private String CMPYTYPENM;	// 업체유형명
	private String CTRTCMPYSNO;	// 계약업체순번
	private String CUSTNM;	// 거래처명
	private String BIZREGINO;	// 사업자등록번호
	private String REPREVEHGNM;	// 대표자명
	private String ZIPNO;	// 우편번호
	private String BASICADDR;	// 기본주소
	private String DETLADDR;	// 상세주소
	private String TELNO;	// 전화번호
}
