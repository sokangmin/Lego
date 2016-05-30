package kr.go.mpss.idsl.dmr.ip.link.g2b_prsec;

import java.io.File;

import com.wini.lego.context.Context;
import com.wini.lego.listener.Success;

public class SuccessBlock extends Success {

	@Override
	public void dooo() {
		File file = (File) Context.get();
		file.delete();			
		Context.remove();
	}
}
