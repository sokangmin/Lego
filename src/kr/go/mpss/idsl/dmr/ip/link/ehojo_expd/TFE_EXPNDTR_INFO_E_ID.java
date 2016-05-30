package kr.go.mpss.idsl.dmr.ip.link.ehojo_expd;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TFE_EXPNDTR_INFO_E_ID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String SFRND_CD;
	private String FSCLYR;
	private String FSSE;
	private String GCC_DEPT_CD;
	private String EPNS_SN;
	private String PYMNT_CM_NO;
	private String EXPENS_SE;
}
