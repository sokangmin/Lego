package kr.go.mpss.idsl.dmr.ip.link.g2b_prsec;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.extern.log4j.Log4j2;

import org.apache.commons.io.FilenameUtils;

import com.wini.common.parser.PropertiesFile;
import com.wini.lego.blocks.StartBlock;

@Log4j2
public class FromFileBlock extends StartBlock<List<File>> {

	@Override
	protected List<File> doing(Void data) {
		ArrayList<File> list = new ArrayList<File>();
		
		File dir = new File(PropertiesFile.getProperties().getProperty("g2b_prsec_dir"));
		if(!dir.isDirectory()) {
			log.info("There is not directory. It create directory. Check the path on the 'prop.properties' file.");
			dir.mkdirs();
		}
		
		Collections.addAll(list, fileList(dir));
		
		log.info("FromFile count - " + list.size());

		return list;
	}
	
	private File[] fileList(File dir){
		File[] fileArray = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("xml");
			}
		});
		return fileArray;
	}

}
