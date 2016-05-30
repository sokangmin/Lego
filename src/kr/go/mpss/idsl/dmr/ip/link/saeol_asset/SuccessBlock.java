package kr.go.mpss.idsl.dmr.ip.link.saeol_asset;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.wini.common.parser.PropertiesFile;
import com.wini.lego.context.Context;
import com.wini.lego.listener.Success;

public class SuccessBlock extends Success {

	@Override
	public void dooo() {
		File file = (File) Context.get();
		
		try {
			File success_dir = new File(PropertiesFile.getProperties().getProperty("success_saeol_asset_dir"));
			FileUtils.moveFileToDirectory(file, success_dir, true);
		} catch (IOException e) {
		}
		
		//file.delete();			
		Context.remove();
	}
}
