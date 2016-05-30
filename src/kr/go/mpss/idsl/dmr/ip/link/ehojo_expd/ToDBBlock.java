package kr.go.mpss.idsl.dmr.ip.link.ehojo_expd;


import java.io.File;
import java.util.List;

import lombok.extern.log4j.Log4j2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wini.common.database.SessionFactoryHome;
import com.wini.lego.annotations.ForEach;
import com.wini.lego.blocks.EndBlock;
import com.wini.lego.context.Context;

@Log4j2
@ForEach
public class ToDBBlock extends EndBlock<List<TFE_EXPNDTR_INFO_E>> {

	@Override
	protected Void doing(List<TFE_EXPNDTR_INFO_E> data) {
		SessionFactory sf = SessionFactoryHome.getSessionFactory("db/tibero");			
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = sf.getCurrentSession();
			transaction = session.getTransaction();
			transaction.begin();		
			
			int count = 0;
			for(TFE_EXPNDTR_INFO_E dtl:data) {
				session.saveOrUpdate(dtl);
				
				log.info("SaveOrUpdate to DB : " + dtl.toString());
				
				if(++count % 20 ==0) {
					session.flush();
					session.clear();
				}
			}
			
			transaction.commit();
		} catch (HibernateException e) {
			if(transaction != null)
				transaction.rollback();
			log.error("Error File - " + ((File) Context.get()).getAbsolutePath() + ": content - " + data );
			throw e;
		}
		
		return null;
	}

}
