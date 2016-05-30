package kr.go.mpss.idsl.dmr.ip.link.ehojo_contract;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TFE_CNTRCT_INFO_CMMN_ID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CNTRCT_PBLNC_OFFIC_CL_CD;
	private String CNTRCT_MNG_SN;
}
