
package pjwstk.mpr.projekt.core;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pjwstk.mpr.projekt.beans.Disciple;


public class SearchDisciple {
    
    
    public List<Disciple> searchByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Disciple.class);
        criteria.add(Restrictions.eq("name", name));
        List<Disciple> transports = criteria.list();
        
        transaction.commit();

        return transports;
    }
    
    public List<Disciple> searchByWeight(Long min, Long max) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Disciple.class);
        criteria.add(Restrictions.between("weight", min, max));
        List<Disciple> transports = criteria.list();
        
        transaction.commit();

        return transports;
    }
    
    public List<Disciple> searchByAge(Long min, Long max) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Disciple.class);
        criteria.add(Restrictions.between("age", min, max));
        List<Disciple> transports = criteria.list();
        
        transaction.commit();

        return transports;
    }
}
