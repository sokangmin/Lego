package kr.go.mpss.idsl.dmr.ip.link.g2b_prsec;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import lombok.extern.log4j.Log4j2;

import com.wini.common.parser.PropertiesFile;
import com.wini.lego.context.Context;
import com.wini.lego.listener.Fail;

@Log4j2
public class FailBlock extends Fail {

	@Override
	public void dooo() {
		if(exception instanceof Exception) {
			log.error(exception);
		} else {
			log.error("delivery message is null");
		}
		
		File file = (File) Context.get();
		
		try {
			File fail_dir = new File(PropertiesFile.getProperties().getProperty("fail_g2b_prsec_dir"));
			FileUtils.moveFileToDirectory(file, fail_dir, true);
			log.info(file.getAbsolutePath() + ">>>>>>>>" + fail_dir.getAbsolutePath());
		} catch (IOException e) {
		}
		
		Context.remove();
	}

}
