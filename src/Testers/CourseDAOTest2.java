package Testers;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import DAO.CourseDAO;
import DAO.StudentRegistrationDAO;
import Beans.Course;
import Beans.StudentRegistration;

import java.util.List;



class CourseDAOTest2 {

	@Test
	public void testGetCoursesByStudent() {
	    String studentId = "1"; 

	    CourseDAO courseDAO = new CourseDAO();
	    List<Course> courses = courseDAO.getCoursesByStudent(studentId);

	    assertNotNull(courses);
	    for (Course course : courses) {
	        assertNotNull(course);

	        
	        System.out.println("Course ID: " + course.getCourseId());
	        System.out.println("Course Code: " + course.getCourseCode());
	        System.out.println("Course Name: " + course.getCourseName());
	        System.out.println("Semester ID: " + course.getSemester());
	        System.out.println("Department ID: " + course.getDepartment());

	        
	    }
	}



}
