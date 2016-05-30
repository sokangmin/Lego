package kr.go.mpss.idsl.dmr.ip.link.saeol_asset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Data
@Entity
@IdClass(TFE_ASSETS_INFO_CMMN_ID.class)
public class TFE_ASSETS_INFO_CMMN {
	@Id
	private String CNTRCT_PBLNC_OFFIC_CL_CD;		// 계약공고처분류코드
	
	@Id
	@Column(name="ASSETS_SN")
	private String purcSNO;		// 구입일련번호
	
	@Column(name="SFRND_CD")
	private String sfTeamCode;		// 자치단체코드
	
	@Column(name="ASSETS_NO")
	private String astNo;			// 자산번호
	
	@Column(name="THNG_CL_NO")
	private String govAtclCatNo;	// 물품분류번호
	
	@Column(name="THNG_STNDD_NO")
	private String atclSizNo;		// 물품규격번호
	
	@Column(name="THNG_STNDD_NM")
	private String sizNm;		// 물품규격명
	
	@Column(name="ASSETS_NM")
	private String korAtclNm;	// 한글품목명
	
	@Column(name=" FRST_PURCHS_DE")
	private String purcYmd;		// 최초구입일자
	
	@Column(name="THNG_UNIT")
	private String atclUnt;		// 물품단위
	
	@Column(name="PRSISTN_PRID")
	private String useTerm;		// 내구연한
	
	@Column(name="QY")
	private String qt;			// 수량	
	
	@Column(name="UNTPC")
	private String ucst;		// 단가
	
	@Column(name="CSTDY_PLC")
	private String depoPlc;		// 보관장소
	
	@Column(name="OPER_DEPT_CD")
    private String depCode;		// 부서코드
	
	@Column(name="OPER_DEPT_NM")
	private String deptNm;		// 부서명
	
	@Column(name="LAST_THNG_CHANGE_MATTER")
	private String chgCode;		// 변동코드
}
