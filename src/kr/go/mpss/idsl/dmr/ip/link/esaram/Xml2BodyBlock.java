package kr.go.mpss.idsl.dmr.ip.link.esaram;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.blocks.PipeBlock;

@Log4j2
public class Xml2BodyBlock extends PipeBlock<String, Body> {

	@Override
	protected Body doing(String data) {
		Body body = null;
		
		try(Reader reader = new StringReader(data);) {
			JAXBContext jaxbContext = JAXBContext.newInstance(Body.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			body = (Body) jaxbUnmarshaller.unmarshal(reader);
		} catch (JAXBException | IOException e) {
			log.error(e);
		} 
		
		log.info("Convert Xml to Body Object");
		
		return body;
	}

}
