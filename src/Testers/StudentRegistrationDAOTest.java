package Testers;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull; // Add this import
import DAO.StudentRegistrationDAO;
import Beans.StudentRegistration;


class StudentRegistrationDAOTest {

	@Test
	public void testGetStudentsByDepartmentAndSemester() {
	    String departmentId = "DEP1"; 
	    String semesterId = "JAN2024"; 
	    StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
	    List<StudentRegistration> students = studentRegistrationDAO.getStudentsByDepartmentAndSemester(departmentId, semesterId);
	    assertNotNull(students);
	    for (StudentRegistration student : students) {
	        assertNotNull(student);
	        assertEquals(departmentId, student.getDepartment().getAcademicId()); 
	        assertEquals(semesterId, student.getSemesterId().getSemesterId()); // Ass
	        System.out.println("Student ID: " + student.getStudent().getStudentId());
	        System.out.println("Student Name: " + student.getStudent().getFirstName() + " " + student.getStudent().getLastname());
	      
	    }
	}


}
