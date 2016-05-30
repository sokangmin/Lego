package kr.go.mpss.idsl.dmr.ip.link.ehojo_contract;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;


@Data
@Entity
@IdClass(TFE_CNTRCT_INFO_CMMN_ID.class)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TFE_CNTRCT_INFO_CMMN {
	@Id
	private String CNTRCT_PBLNC_OFFIC_CL_CD;
	
	@Id
	private String CNTRCT_MNG_SN;
	private String SFRND_CD;
	private String CNTRCT_MNG_NO;
	private String FSCLYR;
	private String CNTRCT_NM;
	private String CNTRCT_SE_NM;
	private String CNTRCT_SE_KND_NM;
	private String CNTRCT_DE;
	private String CNTRCT_AMT;
	private String PROGRS_STTUS;
	private String CNTC_DT;
}
