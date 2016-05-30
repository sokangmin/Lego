package kr.go.mpss.idsl.dmr.ip.link.ehojo_expd;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;


@Data
@Entity
@IdClass(TFE_EXPNDTR_INFO_E_ID.class)
public class TFE_EXPNDTR_INFO_E {
	@Id
	private String SFRND_CD;
	@Id
	private String FSCLYR;
	@Id
	private String FSSE;
	private String FSSE_NM;
	@Id
	private String GCC_DEPT_CD;
	private String GCC_DEPT_CD_NM;
	@Id
	private String EPNS_SN;
	@Id
	private String PYMNT_CM_NO;
	private String CAUSE_NO;
	@Id
	private String EXPENS_SE;
	private String EXPENS_SE_NM;
	private String CNSUL_KND_SE;
	private String CNSUL_KND_SE_NM;
	private String BSNS_CD;
	private String BSNS_NM;
	private String TE_MNG_MOK_CD;
	private String TE_MNG_MOK_NM;
	private String REGIST_DE;
	private String CAUSE_ACTION_AM;
	private String PYMNT_CM_AMT;
	private String PYMNT_CM_DE;
	private String LAST_MODF_DT;
	private String CNTRCT_PBLNC_OFFIC_CL_CD;
	private String CNTRCT_MNG_SN;

}
