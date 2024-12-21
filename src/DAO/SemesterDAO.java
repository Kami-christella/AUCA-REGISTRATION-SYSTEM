package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Beans.Semester;

public class SemesterDAO {

	public Semester saveSemester(Semester sem) {
		Transaction transaction = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(sem);

            transaction.commit();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return null;
	}
}
