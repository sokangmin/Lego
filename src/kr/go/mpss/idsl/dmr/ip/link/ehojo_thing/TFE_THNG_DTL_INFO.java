package kr.go.mpss.idsl.dmr.ip.link.ehojo_thing;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;


@Data
@Entity
@IdClass(TFE_THNG_DTL_INFO_ID.class)
public class TFE_THNG_DTL_INFO {
	@Id
	private String CNTRCT_PBLNC_OFFIC_CL_CD;
	@Id
	private String CNTRCT_MNG_SN;
	@Id
	private String THNG_SN;
	private String THNG_NM;
	private String THNG_CL_NO;
	private String THNG_STNDD_NO;
	private String THNG_STNDD;
	private String THNG_UNIT;
	private String THNG_QY;
	private String THNG_UNTPC;
	private String THNG_AMT;

}
