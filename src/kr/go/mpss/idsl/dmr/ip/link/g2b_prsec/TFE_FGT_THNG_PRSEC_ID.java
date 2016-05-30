package kr.go.mpss.idsl.dmr.ip.link.g2b_prsec;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TFE_FGT_THNG_PRSEC_ID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String psexam_no;
	private String prsec_org;
}
