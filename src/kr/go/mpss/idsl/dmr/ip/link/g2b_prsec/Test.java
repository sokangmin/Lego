package kr.go.mpss.idsl.dmr.ip.link.g2b_prsec;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wini.common.database.SessionFactoryHome;
import com.wini.common.parser.PropertiesFile;

public class Test {

	public static void main(String[] args) throws JAXBException {

		SessionFactory sf = SessionFactoryHome.getSessionFactory("db/tibero");
		
		
		
		Session session = sf.getCurrentSession();
		
		session.getTransaction().begin();
	
		
		TFE_FGT_THNG_PRSEC info = (TFE_FGT_THNG_PRSEC) session.get(TFE_FGT_THNG_PRSEC.class, new TFE_FGT_THNG_PRSEC_ID("NEAC95972","01"));
		
		
		session.getTransaction().commit();
		
		System.out.println(info);
		
		//info.setCntrct_regstr_mng_no("EHO"+info.getCntrct_regstr_mng_no());
		//info.setInpt_se_cd("I");

		
		JAXBContext jaxbContext = JAXBContext.newInstance(TFE_FGT_THNG_PRSEC.class);
		
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		//final StringWriter w = new StringWriter();
		File dir = new File(PropertiesFile.getProperties().getProperty("g2b_prsec_dir"));
		if(!dir.isDirectory()) {
			dir.mkdirs();
		}
		
		jaxbMarshaller.marshal(info, new File(PropertiesFile.getProperties().getProperty("g2b_prsec_dir")+"/Noname.xml"));
		//String s = w.toString();
		
		//System.out.println(s);
		
		
		//StringReader r = new StringReader(s);
//		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//		TFE_EQPMN eqp1 = (TFE_EQPMN) jaxbUnmarshaller.unmarshal(new File("C:/tfe_eqpmn/Noname6.xml"));
//		
//		System.out.println(eqp1);
//			
//		System.out.println(eqp1);
	}

}
