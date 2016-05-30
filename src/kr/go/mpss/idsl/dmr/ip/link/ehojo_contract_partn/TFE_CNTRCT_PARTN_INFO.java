package kr.go.mpss.idsl.dmr.ip.link.ehojo_contract_partn;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;


@Data
@Entity
@IdClass(TFE_CNTRCT_PARTN_INFO_ID.class)
public class TFE_CNTRCT_PARTN_INFO {
	@Id
	private String CNTRCT_PBLNC_OFFIC_CL_CD;
	@Id
	private String CNTRCT_MNG_SN;
	@Id
	private String ENTRPS_TY;
	@Id
	private String BCNC_SN;
	private String BCNC_NM;
	private String BSNM_REGIST_NO;
	private String RPRSNTV_NM;
	private String ZIP;
	private String BASS_ADRES;
	private String DTL_ADRES;
	private String TELNO;

}
