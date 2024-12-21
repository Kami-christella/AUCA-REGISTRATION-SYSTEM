package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import Beans.Course;

public class CourseDAO {

	public Course saveCourse(Course crs) {
		Transaction transaction = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(crs);

            transaction.commit();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return null;
	}
	
	
	public List<Course> getCoursesByStudent(String studentId) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        String sql = "SELECT c.* " +
	                     "FROM course c " +
	                     "JOIN student_registration_courses src ON c.course_code = src.course_code " +
	                     "JOIN student_registration sr ON src.registration_id = sr.registration_id " +
	                     "WHERE sr.student_id = :studentId";
	                     
	        NativeQuery<Course> query = session.createNativeQuery(sql, Course.class);
	        query.setParameter("studentId", studentId);
	        return query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	
	public List<Course> getCoursesByDepartmentAndSemester(String departmentId, String semesterId) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        String sql = "SELECT * FROM course WHERE academic_id = :departmentId AND semester_id = :semesterId";
	        NativeQuery<Course> query = session.createNativeQuery(sql, Course.class);
	        query.setParameter("departmentId", departmentId);
	        query.setParameter("semesterId", semesterId);
	        return query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}


}
