package kr.go.mpss.idsl.dmr.ip.link.esaram;

import java.util.List;

import lombok.extern.log4j.Log4j2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wini.common.database.SessionFactoryHome;
import com.wini.lego.blocks.EndBlock;

@Log4j2
public class ToDBBlock extends EndBlock<List<TFE_TN_HCA_MASTER>>{

	@Override
	protected Void doing(List<TFE_TN_HCA_MASTER> data) {
		
		SessionFactory sf = SessionFactoryHome.getSessionFactory("db/tibero");
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = sf.getCurrentSession();
			transaction = session.getTransaction();
			transaction.begin();
			
			int count = 0;
			for(TFE_TN_HCA_MASTER info:data) {
				session.saveOrUpdate(info);
				
				log.info("SaveOrUpdate to DB : " + info.toString());
				
				if(++count % 20 == 0) {
					session.flush();
					session.clear();
				}
			}
			
			transaction.commit();
		} catch (HibernateException e) {
			if(transaction != null)
				transaction.rollback();
			
			throw e;
		}
		
		return null;
	}

}
