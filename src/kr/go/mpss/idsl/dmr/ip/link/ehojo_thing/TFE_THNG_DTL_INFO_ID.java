package kr.go.mpss.idsl.dmr.ip.link.ehojo_thing;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TFE_THNG_DTL_INFO_ID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CNTRCT_PBLNC_OFFIC_CL_CD;
	private String CNTRCT_MNG_SN;
	private String THNG_SN;
}
