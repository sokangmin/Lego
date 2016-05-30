package kr.go.mpss.idsl.dmr.ip.link.esaram;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Data
@Entity
@IdClass(TFE_TN_HCA_MASTER_ID.class)
public class TFE_TN_HCA_MASTER {
	@Id
	@Column(name="MIRYFC_CD")
	private String dptcd;	//부처코드
	
	@Id
	@Column(name="INDVDL_ID")
	private String pid;	//개인id
	
	@Column(name="INDVDL_P_ID")
	private String uniquepid;	//개인pid
	
	@Column(name="INDVDL_NM")
	private String pname;	//개인성명
	
	@Column(name="EPLY_ID")
	private String eplyid;	//사원id
	
	@Column(name="PSITN_MIRYFC_CD")
	private String onpstdptcd;	//소속부처코드
	
	@Column(name="HR_OPERT_ORG_CD")
	private String pesnwkogzcd;	//인사작업기관코드
	
	@Column(name="SALARY_OPERT_ORG_CD")
	private String sarywkogzcd;	//급여작업기관코드
	
	@Column(name="DEPT_CD")
	private String dprcd;	//부서코드
	
	@Column(name="DISTAL_DEPT_NM")
	private String tenddeptnm;	//말단부서명
	
	@Column(name="DEPT_GNTRM_NM")
	private String deptgntrmnm;	//부서총칭명
	
	@Column(name="DEPT_ABRV_NM")
	private String deptabbrnm;	//부서약어명
	
	@Column(name="DEPT_RNUMNS_NO")
	private String deptbldmtno ;	//부서건재번호
	
	@Column(name="PBSVT_SE_CD")
	private String pblaosccd;	//공무원구분코드
	
	@Column(name="JSSFC_CD")
	private String jsrscd;	//직종코드
	
	@Column(name="JSSFC_NM")
	private String jsrsnm;	//직종명
	
	@Column(name="DETAIL_JSSFC_CD")
	private String detaijsrscd;	//세부직종코드
	
	@Column(name="JBLN_CD")
	private String jblncd;	//직렬코드
	
	@Column(name="JBLN_NM")
	private String jblnnm;	//직렬명
	
	@Column(name="OCPTY_CD")
	private String dctrcd;	//직류코드
	
	@Column(name="CLSS_CD")
	private String clscd;	//계급코드
	
	@Column(name="CLSS_ORDR")
	private String clsseq;	//계급순서
	
	@Column(name="CLSF_CD")
	private String copcd;	//직급코드
	
	@Column(name="CLSF_NM")
	private String copnm;	//직급명
	
	@Column(name="CLSF_ORDR")
	private String copseq;	//직급순서
	
	@Column(name="OFCPS_CD")
	private String jobpscd;	//직위코드
	
	@Column(name="OFCPS_NM")
	private String jobpsnm;	//직위명
	
	@Column(name="OFCPS_LEVEL_CD")
	private String jobpslvlcd;	//직위레벨코드
	
	@Column(name="PAYSTEP_CD")
	private String srclscd;	//호봉코드
	
	@Column(name="CITY_BRRER_AT")
	private String prbtnyn;	//시보여부
	
	@Column(name="CITY_BRRER_RELIS_PRRNG_DE")
	private String prbtnremvparngymd;	//시보해제예정일자
	
	@Column(name="PBSVT_FRST_APITMT_DE")
	private String pblaofstemplmymd;	//공무원최초임용일자
	
	@Column(name="FRST_APITMT_DE")
	private String fstemplmymd;	//최초임용일자
	
	@Column(name="NOW_MIRYFC_APITMT_DE")
	private String psminstemplmymd;	//현부처임용일자
	
	@Column(name="NOW_ORG_APITMT_DE")
	private String psinstemplmymd;	//현기관임용일자
	
	@Column(name="NOW_CLSF_APITMT_DE")
	private String pscopemplmymd;	//현직급임용일자
	
	@Column(name="NOW_CLSS_APITMT_DE")
	private String psclsemplmymd;	//현계급임용일자
	
	@Column(name="NOW_DEPT_APITMT_DE")
	private String psdeptemplmymd;	//현부서임용일자
	
	@Column(name="NOW_OFCPS_APITMT_DE")
	private String psjobpsemplmymd;	//현직위임용일자
	
	@Column(name="OFCPS_PROMOTION_DE")
	private String jobpsprmotymd;	//직위승진일자
	
	@Column(name="RESIOFFER_APITMT_AT")
	private String rsdofemplmyn;	//주재관임용여부
	
	@Column(name="CNTSSERV_PROMOTION_AT")
	private String ctsvprmotyn;	//근속승진여부
	
	@Column(name="TTMNT_PBLAO_YN")
	private String ttmntpblaoyn;	//대우공무원여부
	
	@Column(name="ESSNTL_PRCAFS_STAFF_AT")
	private String mndtprcafstaffyn;	//필수실무요원여부
	
	@Column(name="RETIREMENT_DE")
	private String rtmymd;	//퇴직일자
	
	@Column(name="HFFC_STTUS_CD")
	private String hldofstatcd;	//재직상태코드
	
	@Column(name="HFFC_STTUS_NM")
	private String hldofstatnm;	//재직상태명
	
	@Column(name="ELAPSE_CD")
	private String psgcd;	//경과코드
	
	@Column(name="URNTH_CLS_EMPLM_YMD")
	private String urnthclsemplmymd;	//차하계급임용일자
	
	@Column(name="CNTSSERV_CLSF_CD")
	private String ctsvcopcd;	//근속직급코드
	
	@Column(name="CNTSSERV_CLSF_MODF_AT")
	private String ctsvcopmdfcyn;	//근속직급수정여부
	
	@Column(name="CNTSSERV_CNT")
	private String ctsvntst;	//근속횟수
	
	@Column(name="CLSS_LEVEL_CD")
	private String clslvlcd;	//계급레벨코드
	
	@Column(name="SPUSE_PSNCPA_SE_CD")
	private String spwytoforsccd;	//별도정원구분코드
	
	@Column(name="SORT_VALUE")
	private String stdilval;	//정렬값
	
	@Column(name="PSTINST_CD")
	private String onpstogzcd;	//소속기관코드
	
	@Column(name="SRVIC_DEPT_CD")
	private String srvicdprcd;	//복무부서코드
	
	@Column(name="NOW_GRFC_TRNSFRN_DE")
	private String psgrfcmvinymd;	//현관서전입일자
	
	@Column(name="CHRG_JOB_CD")
	private String chrgebusncd;	//담당업무코드
	
	@Column(name="LAST_PSTINST_APITMT_DE")
	private String lastonpstinstemplmymd;	//최종소속기관임용일자
	
	@Column(name="EMPMN_SE_NM")
	private String empmnscnm;	//채용구분명
	
	@Column(name="TTMNT_COP_CD")
	private String ttmntcopcd;	//대우직급코드
	
	@Column(name="RETIREMENT_SE_CD")
	private String rtmsccd;	//퇴직구분코드
	
	@Column(name="JBGP_CD")
	private String fldwkcd;	//직군코드
	
	@Column(name="ARCD")
	private String dstctcd;	//지역코드
	
	@Column(name="MODF_TIME")
	private String mdfcdtm;	//수정시간
	
	@Column(name="BFE_DEPT_APITMT_DE")
	private String jsbfrdeptemplmymd;	//직전부서임용일자

}
