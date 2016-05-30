package kr.go.mpss.idsl.dmr.ip.link.esaram;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TFE_TN_HCA_MASTER_ID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String dptcd;	//부처코드
	
	private String pid;	//개인id
}
