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
	private String dptcd;	//��ó�ڵ�
	
	@Id
	@Column(name="INDVDL_ID")
	private String pid;	//����id
	
	@Column(name="INDVDL_P_ID")
	private String uniquepid;	//����pid
	
	@Column(name="INDVDL_NM")
	private String pname;	//���μ���
	
	@Column(name="EPLY_ID")
	private String eplyid;	//���id
	
	@Column(name="PSITN_MIRYFC_CD")
	private String onpstdptcd;	//�ҼӺ�ó�ڵ�
	
	@Column(name="HR_OPERT_ORG_CD")
	private String pesnwkogzcd;	//�λ��۾�����ڵ�
	
	@Column(name="SALARY_OPERT_ORG_CD")
	private String sarywkogzcd;	//�޿��۾�����ڵ�
	
	@Column(name="DEPT_CD")
	private String dprcd;	//�μ��ڵ�
	
	@Column(name="DISTAL_DEPT_NM")
	private String tenddeptnm;	//���ܺμ���
	
	@Column(name="DEPT_GNTRM_NM")
	private String deptgntrmnm;	//�μ���Ī��
	
	@Column(name="DEPT_ABRV_NM")
	private String deptabbrnm;	//�μ�����
	
	@Column(name="DEPT_RNUMNS_NO")
	private String deptbldmtno ;	//�μ������ȣ
	
	@Column(name="PBSVT_SE_CD")
	private String pblaosccd;	//�����������ڵ�
	
	@Column(name="JSSFC_CD")
	private String jsrscd;	//�����ڵ�
	
	@Column(name="JSSFC_NM")
	private String jsrsnm;	//������
	
	@Column(name="DETAIL_JSSFC_CD")
	private String detaijsrscd;	//���������ڵ�
	
	@Column(name="JBLN_CD")
	private String jblncd;	//�����ڵ�
	
	@Column(name="JBLN_NM")
	private String jblnnm;	//���ĸ�
	
	@Column(name="OCPTY_CD")
	private String dctrcd;	//�����ڵ�
	
	@Column(name="CLSS_CD")
	private String clscd;	//����ڵ�
	
	@Column(name="CLSS_ORDR")
	private String clsseq;	//��޼���
	
	@Column(name="CLSF_CD")
	private String copcd;	//�����ڵ�
	
	@Column(name="CLSF_NM")
	private String copnm;	//���޸�
	
	@Column(name="CLSF_ORDR")
	private String copseq;	//���޼���
	
	@Column(name="OFCPS_CD")
	private String jobpscd;	//�����ڵ�
	
	@Column(name="OFCPS_NM")
	private String jobpsnm;	//������
	
	@Column(name="OFCPS_LEVEL_CD")
	private String jobpslvlcd;	//���������ڵ�
	
	@Column(name="PAYSTEP_CD")
	private String srclscd;	//ȣ���ڵ�
	
	@Column(name="CITY_BRRER_AT")
	private String prbtnyn;	//�ú�����
	
	@Column(name="CITY_BRRER_RELIS_PRRNG_DE")
	private String prbtnremvparngymd;	//�ú�������������
	
	@Column(name="PBSVT_FRST_APITMT_DE")
	private String pblaofstemplmymd;	//�����������ӿ�����
	
	@Column(name="FRST_APITMT_DE")
	private String fstemplmymd;	//�����ӿ�����
	
	@Column(name="NOW_MIRYFC_APITMT_DE")
	private String psminstemplmymd;	//����ó�ӿ�����
	
	@Column(name="NOW_ORG_APITMT_DE")
	private String psinstemplmymd;	//������ӿ�����
	
	@Column(name="NOW_CLSF_APITMT_DE")
	private String pscopemplmymd;	//�������ӿ�����
	
	@Column(name="NOW_CLSS_APITMT_DE")
	private String psclsemplmymd;	//������ӿ�����
	
	@Column(name="NOW_DEPT_APITMT_DE")
	private String psdeptemplmymd;	//���μ��ӿ�����
	
	@Column(name="NOW_OFCPS_APITMT_DE")
	private String psjobpsemplmymd;	//�������ӿ�����
	
	@Column(name="OFCPS_PROMOTION_DE")
	private String jobpsprmotymd;	//������������
	
	@Column(name="RESIOFFER_APITMT_AT")
	private String rsdofemplmyn;	//������ӿ뿩��
	
	@Column(name="CNTSSERV_PROMOTION_AT")
	private String ctsvprmotyn;	//�ټӽ�������
	
	@Column(name="TTMNT_PBLAO_YN")
	private String ttmntpblaoyn;	//������������
	
	@Column(name="ESSNTL_PRCAFS_STAFF_AT")
	private String mndtprcafstaffyn;	//�ʼ��ǹ��������
	
	@Column(name="RETIREMENT_DE")
	private String rtmymd;	//��������
	
	@Column(name="HFFC_STTUS_CD")
	private String hldofstatcd;	//���������ڵ�
	
	@Column(name="HFFC_STTUS_NM")
	private String hldofstatnm;	//�������¸�
	
	@Column(name="ELAPSE_CD")
	private String psgcd;	//����ڵ�
	
	@Column(name="URNTH_CLS_EMPLM_YMD")
	private String urnthclsemplmymd;	//���ϰ���ӿ�����
	
	@Column(name="CNTSSERV_CLSF_CD")
	private String ctsvcopcd;	//�ټ������ڵ�
	
	@Column(name="CNTSSERV_CLSF_MODF_AT")
	private String ctsvcopmdfcyn;	//�ټ����޼�������
	
	@Column(name="CNTSSERV_CNT")
	private String ctsvntst;	//�ټ�Ƚ��
	
	@Column(name="CLSS_LEVEL_CD")
	private String clslvlcd;	//��޷����ڵ�
	
	@Column(name="SPUSE_PSNCPA_SE_CD")
	private String spwytoforsccd;	//�������������ڵ�
	
	@Column(name="SORT_VALUE")
	private String stdilval;	//���İ�
	
	@Column(name="PSTINST_CD")
	private String onpstogzcd;	//�Ҽӱ���ڵ�
	
	@Column(name="SRVIC_DEPT_CD")
	private String srvicdprcd;	//�����μ��ڵ�
	
	@Column(name="NOW_GRFC_TRNSFRN_DE")
	private String psgrfcmvinymd;	//��������������
	
	@Column(name="CHRG_JOB_CD")
	private String chrgebusncd;	//�������ڵ�
	
	@Column(name="LAST_PSTINST_APITMT_DE")
	private String lastonpstinstemplmymd;	//�����Ҽӱ���ӿ�����
	
	@Column(name="EMPMN_SE_NM")
	private String empmnscnm;	//ä�뱸�и�
	
	@Column(name="TTMNT_COP_CD")
	private String ttmntcopcd;	//��������ڵ�
	
	@Column(name="RETIREMENT_SE_CD")
	private String rtmsccd;	//���������ڵ�
	
	@Column(name="JBGP_CD")
	private String fldwkcd;	//�����ڵ�
	
	@Column(name="ARCD")
	private String dstctcd;	//�����ڵ�
	
	@Column(name="MODF_TIME")
	private String mdfcdtm;	//�����ð�
	
	@Column(name="BFE_DEPT_APITMT_DE")
	private String jsbfrdeptemplmymd;	//�����μ��ӿ�����

}
