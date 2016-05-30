package kr.go.mpss.idsl.dmr.ip.link.ehojo_expd_bcnc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;


@Data
@Entity
@IdClass(TFE_EXPNDTR_BCNC_E_ID.class)
public class TFE_EXPNDTR_BCNC_E {
	@Id
	private String SFRND_CD;
	@Id
	private String FSCLYR;
	@Id
	private String FSSE;
	@Id
	private String GCC_DEPT_CD;
	@Id
	private String EXPENS_SE;
	@Id
	private String EPNS_SN;
	@Id
	private String PYMNT_CM_NO;
	@Id
	private String SN;
	private String BCNC_NM;
	private String BSNM_REGIST_NO;
}
