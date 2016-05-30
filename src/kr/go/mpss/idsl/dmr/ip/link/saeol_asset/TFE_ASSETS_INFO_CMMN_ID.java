package kr.go.mpss.idsl.dmr.ip.link.saeol_asset;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TFE_ASSETS_INFO_CMMN_ID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CNTRCT_PBLNC_OFFIC_CL_CD;
	private String purcSNO;		// 구입일련번호
}
