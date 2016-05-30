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
	private String CNTRCT_PBLNC_OFFIC_CL_CD;		// ������ó�з��ڵ�
	
	@Id
	@Column(name="ASSETS_SN")
	private String purcSNO;		// �����Ϸù�ȣ
	
	@Column(name="SFRND_CD")
	private String sfTeamCode;		// ��ġ��ü�ڵ�
	
	@Column(name="ASSETS_NO")
	private String astNo;			// �ڻ��ȣ
	
	@Column(name="THNG_CL_NO")
	private String govAtclCatNo;	// ��ǰ�з���ȣ
	
	@Column(name="THNG_STNDD_NO")
	private String atclSizNo;		// ��ǰ�԰ݹ�ȣ
	
	@Column(name="THNG_STNDD_NM")
	private String sizNm;		// ��ǰ�԰ݸ�
	
	@Column(name="ASSETS_NM")
	private String korAtclNm;	// �ѱ�ǰ���
	
	@Column(name=" FRST_PURCHS_DE")
	private String purcYmd;		// ���ʱ�������
	
	@Column(name="THNG_UNIT")
	private String atclUnt;		// ��ǰ����
	
	@Column(name="PRSISTN_PRID")
	private String useTerm;		// ��������
	
	@Column(name="QY")
	private String qt;			// ����	
	
	@Column(name="UNTPC")
	private String ucst;		// �ܰ�
	
	@Column(name="CSTDY_PLC")
	private String depoPlc;		// �������
	
	@Column(name="OPER_DEPT_CD")
    private String depCode;		// �μ��ڵ�
	
	@Column(name="OPER_DEPT_NM")
	private String deptNm;		// �μ���
	
	@Column(name="LAST_THNG_CHANGE_MATTER")
	private String chgCode;		// �����ڵ�
}
