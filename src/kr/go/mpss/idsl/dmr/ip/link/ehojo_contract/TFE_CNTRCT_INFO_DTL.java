package kr.go.mpss.idsl.dmr.ip.link.ehojo_contract;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class TFE_CNTRCT_INFO_DTL extends TFE_CNTRCT_INFO_CMMN {
	private String CNTRCT_SE;
	private String CNTRCT_OBJ;
	private String CNTRCT_SE_KND;
	private String CNTRCT_TY;
	private String CNTRCT_TY_NM;
	private String STRWRK_DE;
	private String FRST_SMRIZE_CNTRCTAMOUNT;
	private String COMPET_PRRNG_DE;
	private String EXPENS_SE;
	private String EXPENS_SE_NM;
	private String COMPET_DE;
	private String DEBIT_AT;
	private String NEW_LNGTR_SE;
	private String NEW_LNGTR_SE_NM;
	private String CNTRCT_MTH;
	private String CNTRCT_MTH_NM;
	private String CNTRCT_SUMRY;
	private String LC_NM;
	private String PRCURE_SE;
	private String PRCURE_SE_NM;
	private String CNTRCT_DEPT_CD;
	private String CNTRCT_CHPSN_ID;
	private String CNTRCT_CHPSN_NM;
	private String LAST_UPDUSR_DE;

}
