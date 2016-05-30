package kr.go.mpss.idsl.dmr.ip.link.ehojo_contract_partn;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TFE_CNTRCT_PARTN_INFO_ID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CNTRCT_PBLNC_OFFIC_CL_CD;
	private String CNTRCT_MNG_SN;
	private String ENTRPS_TY;
	private String BCNC_SN;
}
