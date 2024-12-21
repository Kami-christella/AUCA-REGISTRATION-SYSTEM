package DAO;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import DAO.HibernateUtil;

import Beans.Student;

public class StudentDAO {

	
	
	public Student saveStudent(Student stu) {
		Transaction transaction = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(stu);

            transaction.commit();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return null;
	}
	
	
	 public List<Student> getStudentsBySemester(String semesterId) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            Query<Student> query = session.createQuery("SELECT s FROM Student s " +
	                                                        "JOIN s.semester sem " +
	                                                        "WHERE sem.semesterId = :semesterId", Student.class);
	            query.setParameter("semesterId", semesterId);
	            return query.getResultList();
	        } finally {
	            session.close();
	        }
	    }
	 
	 public List<Student> getStudentsByCourseAndSemester(String courseId, String semesterId) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            Query<Student> query = session.createQuery("SELECT s FROM Student s " +
	                                                        "JOIN s.studentCourses sc " +
	                                                        "JOIN sc.course c " +
	                                                        "JOIN c.semester sem " +
	                                                        "WHERE c.courseId = :courseId " +
	                                                        "AND sem.semesterId = :semesterId", Student.class);
	            query.setParameter("courseId", courseId);
	            query.setParameter("semesterId", semesterId);
	            return query.getResultList();
	        } finally {
	            session.close();
	        }
	    }
	
	public List<Student> getStudentsByAcademicUnitAndSemester(String academicUnitId, String semesterId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Student> query = session.createQuery("SELECT s FROM Student s " +
                                                        "JOIN s.academicUnit au " +
                                                        "JOIN s.semester sem " +
                                                        "WHERE au.academicId = :academicUnitId " +
                                                        "AND sem.semesterId = :semesterId", Student.class);
            query.setParameter("academicUnitId", academicUnitId);
            query.setParameter("semesterId", semesterId);
            return query.getResultList();
        } finally {
            session.close();
        }
    }
}
