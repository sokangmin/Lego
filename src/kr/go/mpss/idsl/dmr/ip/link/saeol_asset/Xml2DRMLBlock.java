package kr.go.mpss.idsl.dmr.ip.link.saeol_asset;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.annotations.ForEach;
import com.wini.lego.blocks.PipeBlock;
import com.wini.lego.context.Context;

@ForEach
@Log4j2
public class Xml2DRMLBlock extends PipeBlock<File, DRML> {

	@Override
	protected DRML doing(File data) {		
		DRML drml = null;
				
		try( FileInputStream fis = new FileInputStream(data);
				 InputStreamReader isr = new InputStreamReader(fis, "euc-kr");) {
			 JAXBContext jaxbContext = JAXBContext.newInstance(DRML.class);
			 Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			 
			 drml = (DRML) jaxbUnmarshaller.unmarshal(isr);
			 
			 log.info("Convert XML to DRML Object.");
		} catch (JAXBException | IOException e) {
			log.error(e);
		}
		
		Context.set(data);
		
		
		return drml;
	}

}
