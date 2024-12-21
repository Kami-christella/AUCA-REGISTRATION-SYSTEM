package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Beans.AcademicUnit;

public class DepartmentDAO {

	
	public AcademicUnit saveAcademicUnit(AcademicUnit au) {
		Transaction transaction = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(au);

            transaction.commit();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return null;
	}
}
