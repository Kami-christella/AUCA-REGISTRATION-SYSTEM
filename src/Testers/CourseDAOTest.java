package Testers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import DAO.CourseDAO;
import Beans.Course;
import java.util.List;

class CourseDAOTest {

	@Test
	public void testGetCoursesByDepartmentAndSemester() {
	    String departmentId = "DEP1"; 
	    String semesterId = "JAN2024"; 

	    CourseDAO courseDAO = new CourseDAO();
	    List<Course> courses = courseDAO.getCoursesByDepartmentAndSemester(departmentId, semesterId);

	    assertNotNull(courses);
	    for (Course course : courses) {
	        assertNotNull(course);

	        
	        System.out.println("Course ID: " + course.getCourseId());
	        System.out.println("Course Code: " + course.getCourseCode());
	        System.out.println("Course Name: " + course.getCourseName());
	        System.out.println("Department ID: " + course.getDepartment());
	        System.out.println("Semester ID: " + course.getSemester());

	        
	    }
	}


}
