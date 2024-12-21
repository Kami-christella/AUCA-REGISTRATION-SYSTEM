package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import Beans.StudentRegistration;

public class StudentRegistrationDAO {

	public StudentRegistration saveStudentRegistration(StudentRegistration str) {
		Transaction transaction = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(str);

            transaction.commit();
            
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return null;
	}
	
	public List<StudentRegistration> getStudentsBySemesterId(String semesterId) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        String queryString = "SELECT sr.*, s.first_name, s.last_name " +
	        		             "FROM student_registration sr " + 
	        		             "JOIN student s ON sr.student_id = s.student_id " +
	        		             "WHERE sr.semester_id = :semesterId";
	        NativeQuery<StudentRegistration> query = session.createNativeQuery(queryString, StudentRegistration.class);
	        query.setParameter("semesterId", semesterId);
	        return query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	public List<StudentRegistration> getStudentsByCourseAndSemester(String courseCode, String semesterId) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        String sql = "SELECT sr.*, s.first_name, s.last_name " +
	                     "FROM student_registration sr " +
	                     "JOIN student s ON sr.student_id = s.student_id " +
	                     "JOIN student_registration_courses src ON sr.registration_id = src.registration_id " +
	                     "WHERE sr.semester_id = :semesterId AND src.course_code = :courseCode";
	        NativeQuery<StudentRegistration> query = session.createNativeQuery(sql, StudentRegistration.class);
	        query.setParameter("semesterId", semesterId);
	        query.setParameter("courseCode", courseCode);
	        return query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}



	
	public List<StudentRegistration> getStudentsByDepartmentAndSemester(String departmentId, String semesterId) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        String sql = "SELECT sr.*, s.first_name, s.last_name " +
	                     "FROM student_registration sr " +
	                     "JOIN student s ON sr.student_id = s.student_id " +
	                     "WHERE sr.academic_id = :departmentId AND sr.semester_id = :semesterId";
	        NativeQuery<StudentRegistration> query = session.createNativeQuery(sql, StudentRegistration.class);
	        query.setParameter("departmentId", departmentId);
	        query.setParameter("semesterId", semesterId);
	        return query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	 public List<StudentRegistration> getCoursesByStudentId(String studentId) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            String sql = "SELECT c.* " +
	                         "FROM course c " +
	                         "JOIN student_registration_courses src ON c.course_id = src.course_id " +
	                         "JOIN student_registration sr ON src.registration_id = sr.registration_id " +
	                         "WHERE sr.student_id = :studentId";
	            NativeQuery<StudentRegistration> query = session.createNativeQuery(sql, StudentRegistration.class);
	            query.setParameter("studentId", studentId);
	            return query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

}
