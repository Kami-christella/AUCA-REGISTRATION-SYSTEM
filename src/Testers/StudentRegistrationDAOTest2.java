package Testers;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull; // Add this import
import DAO.StudentRegistrationDAO;
import Beans.StudentRegistration;
import java.util.List;



class StudentRegistrationDAOTest2 {

	@Test
	public void testGetStudentsBySemester() {
	    String semesterId = "JAN2024"; 
	    StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
	    List<StudentRegistration> students = studentRegistrationDAO.getStudentsBySemesterId(semesterId);
	    assertNotNull(students);
	    for (StudentRegistration student : students) {
	        assertNotNull(student);
	        assertEquals(semesterId, student.getSemesterId().getSemesterId()); 
	        System.out.println("Student ID: " + student.getStudent().getStudentId());
	        System.out.println("Student Name: " + student.getStudent().getFirstName() + " " + student.getStudent().getLastname());
	        
	    }
	}

}
