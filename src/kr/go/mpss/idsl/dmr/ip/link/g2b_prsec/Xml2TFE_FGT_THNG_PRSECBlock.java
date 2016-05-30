package kr.go.mpss.idsl.dmr.ip.link.g2b_prsec;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.annotations.ForEach;
import com.wini.lego.blocks.PipeBlock;
import com.wini.lego.context.Context;

@ForEach
@Log4j2
public class Xml2TFE_FGT_THNG_PRSECBlock extends PipeBlock<File, TFE_FGT_THNG_PRSEC> {

	@Override
	protected TFE_FGT_THNG_PRSEC doing(File data) {
		TFE_FGT_THNG_PRSEC eqp = null;
		
		try {
			 JAXBContext jaxbContext = JAXBContext.newInstance(TFE_FGT_THNG_PRSEC.class);
			 Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			 eqp = (TFE_FGT_THNG_PRSEC) jaxbUnmarshaller.unmarshal(data);
			 
			 log.info("Convert XML to TFE_FGT_THNG_PRSEC Object.");
		} catch (JAXBException e) {
			log.error(e);
		}
		
		Context.set(data);
		
		return eqp;
	}

}
