package kr.go.mpss.idsl.dmr.ip.link.g2b_prsec;


import java.io.File;

import lombok.extern.log4j.Log4j2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wini.common.database.SessionFactoryHome;
import com.wini.lego.blocks.EndBlock;
import com.wini.lego.context.Context;

@Log4j2
public class ToDBBlock extends EndBlock<TFE_FGT_THNG_PRSEC> {

	@Override
	protected Void doing(TFE_FGT_THNG_PRSEC data) {
		TFE_FGT_THNG_PRSEC info = data;
		
		
		SessionFactory sf = SessionFactoryHome.getSessionFactory("db/tibero");			
		Session session = null;
		Transaction transaction = null;
		
		try{
		session = sf.getCurrentSession();
		transaction = session.getTransaction();
		transaction.begin();		
		session.saveOrUpdate(info);		
		transaction.commit();
		} catch(HibernateException e) {
			if(transaction != null)
				transaction.rollback();
			log.error("Error File - " + ((File) Context.get()).getAbsolutePath() + ": content - " + data );
			throw e;
		}
		
		log.info("SaveOrUpdate to DB : " + info.toString());
		
		return null;
	}

}
