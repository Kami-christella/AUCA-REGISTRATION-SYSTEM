package View;

import java.text.SimpleDateFormat;
import java.util.*;

import Beans.AcademicUnit;
import Beans.AcademicUnitType;
import Beans.Course;
import Beans.Semester;
import Beans.Student;
import Beans.StudentRegistration;
import DAO.CourseDAO;
import DAO.DepartmentDAO;
import DAO.SemesterDAO;
import DAO.StudentDAO;
import DAO.StudentRegistrationDAO;

public class UniversitySystem {

	public static void main(String[] args) {
		
		   
	        boolean condition =true;
	        while(condition){
	            System.out.println("=======================");
	            System.out.println("University MGT SYS");
	            System.out.println("1.Record Academic Unit");
	            System.out.println("2.Record Student");
	            System.out.println("3.Record Semester");
	            System.out.println("4.Record Course");
	            System.out.println("5.Record Student Registration");
	            System.out.println("0.exit");
	            System.out.println("--------------");
	            System.out.println("Choice:");
	            Scanner sc = new Scanner(System.in);
	            int choice = sc.nextInt();
	            switch(choice){
	                case 1:
	                    try{
	                    	
	                            DepartmentDAO academicUnitDAO = new DepartmentDAO();
	                            
	                            System.out.println("Enter academic Id: ");
	                            String academicId = sc.next();

	                            System.out.println("Enter academic code: ");
	                            String academicCode = sc.next();

	                            System.out.println("Enter academic name:");
	                            String academicName = sc.next();

	                            System.out.println("Enter academic type (PROGRAMME, FACULTY, DEPARTMENT):");
	                            String typeString = sc.next();
	                            AcademicUnitType type = AcademicUnitType.valueOf(typeString);

	                            
	                            System.out.println("Do you want to specify a parent academic unit? (yes/no)");
	                            String specifyParent = sc.next();
	                            AcademicUnit parent = null;
	                            if (specifyParent.equalsIgnoreCase("yes")) {
	                                System.out.println("Enter parent academic unit ID:");
	                                String parentId = sc.next();
	                               // parent = academicUnitDAO.getAcademicUnitById(parentId);
	                            }
	                            

	                            AcademicUnit academicUnit = new AcademicUnit();
	                            academicUnit.setAcademicId(academicId);
	                            academicUnit.setAcademicCode(academicCode);
	                            academicUnit.setAcademicName(academicName);
	                            academicUnit.setType(type);
	                            academicUnit.setParent(parent);

	                            academicUnitDAO.saveAcademicUnit(academicUnit);
	                            System.out.println("Academic Unit recorded successfully.");
	                    
	                            
	                       
	                    } 
	                    
	                    catch(Exception ex){
	                            ex.printStackTrace();
	                        
	                    }
	                    
	                    break;
	                case 2:
	                    try{
	                    	StudentDAO studentDAO = new StudentDAO();

	                        System.out.println("Enter student first name:");
	                        String firstName = sc.next();

	                        System.out.println("Enter student last name:");
	                        String lastName = sc.next();

	                        System.out.println("Enter student date of birth (YYYY-MM-DD):");
	                        String dateOfBirth = sc.next();                

	                        Student student = new Student();
	                        student.setFirstName(firstName);
	                        student.setLastname(lastName);
	                        student.setDateOfBirth(dateOfBirth);
	                        

	                        studentDAO.saveStudent(student);
	                        System.out.println("Student recorded successfully.");
	                    }
	                    catch(Exception ex){
	                        ex.printStackTrace();
	                    }
	                    
	                   
	                     
	                     
	                    break;
	                case 3:
	                    try{
	                    	SemesterDAO semesterDAO = new SemesterDAO();
	                    	
	                    	System.out.println("Enter semester ID:");
	                        String semesterId = sc.next();

	                        System.out.println("Enter semester name:");
	                        String semesterName = sc.next();

	                        System.out.println("Enter starting date (YYYY-MM-DD):");
	                        String startingDateStr = sc.next();
	                        Date startingDate = new SimpleDateFormat("yyyy-MM-dd").parse(startingDateStr);

	                        System.out.println("Enter end date (YYYY-MM-DD):");
	                        String endDateStr = sc.next();
	                        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);

	                        

	                        Semester semester = new Semester();
	                        semester.setSemesterId(semesterId);
	                        semester.setSemesterName(semesterName);
	                        semester.setStartingDate(startingDate);
	                        semester.setEndDate(endDate);

	                        semesterDAO.saveSemester(semester);
	                        System.out.println("Semester recorded successfully.");
	                       
	                    }                     
	                    catch(Exception ex){
	                            ex.printStackTrace();
	                                           }
	                    System.out.println("Third option");
	                    break;
	                    case 4:
	                        try{
	                        	CourseDAO courseDAO = new CourseDAO();

	                            System.out.println("Enter course code:");
	                            String courseCode = sc.next();

	                            System.out.println("Enter course name:");
	                            String courseName = sc.next();

	                            System.out.println("Enter semester ID:");
	                            String semesterId = sc.next(); 

	                            System.out.println("Enter department ID:");
	                            String departmentId = sc.next(); 

	                            Semester semester = new Semester();
		                        semester.setSemesterId(semesterId); // Set semester ID

		                        AcademicUnit department = new AcademicUnit();
		                        department.setAcademicId(departmentId);

	                           

	                            Course course = new Course();
	                            course.setCourseCode(courseCode);
	                            course.setCourseName(courseName);
	                            course.setSemester(semester);
	                            course.setDepartment(department);

	                            courseDAO.saveCourse(course);
	                            System.out.println("Course recorded successfully.");
	                    }
	                    catch(Exception ex){
	                        ex.printStackTrace();
	                    }
	                       
	                    break;
	                    case 5:
	                       try{
	                    	   StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();

	                           System.out.println("Enter student ID:");
	                           String studentId = sc.next();

	                           System.out.println("Enter registration code:");
	                           String registrationCode = sc.next();

	                           System.out.println("Enter registration date (YYYY-MM-DD):");
	                           String registrationDateStr = sc.next();
	                           Date registrationDate = new SimpleDateFormat("yyyy-MM-dd").parse(registrationDateStr);

	                           System.out.println("Enter semester ID:");
	                           String semesterId = sc.next();

	                           System.out.println("Enter department ID:");
	                           String departmentId = sc.next();

	                           
	                           System.out.println("Enter course codes (separated by commas):");
	                           String courseCodesStr = sc.next();
	                           String[] courseCodess = courseCodesStr.split(",");

	                          

	                           // Create StudentRegistration instance
	                           Student student = new Student();
	                           student.setStudentId(Integer.valueOf(studentId)); // Set student ID

	                           Semester semester = new Semester();
	                           semester.setSemesterId(semesterId); // Set semester ID

	                           AcademicUnit department = new AcademicUnit();
	                           department.setAcademicId(departmentId);

	                           List<String> coursesCodes = Arrays.asList(courseCodess);

	                           StudentRegistration studentRegistration = new StudentRegistration();
	                           studentRegistration.setStudent(student);
	                           studentRegistration.setRegistrationCode(registrationCode);
	                           studentRegistration.setRegistrationDate(registrationDate);
	                           studentRegistration.setSemesterId(semester);
	                           studentRegistration.setDepartment(department);
	                           studentRegistration.setCourseCodes(coursesCodes);
	                           

	                           // Save student registration
	                           studentRegistrationDAO.saveStudentRegistration(studentRegistration);
	                           System.out.println("Student registration recorded successfully.");
	                       
	                    }                     
	                    catch(Exception ex){
	                            ex.printStackTrace();
	                                           }
	                    System.out.println("Fifth option");
	                    break;
	                   
	                case 0:
	                    System.out.println("Thank you for usin g system");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Wrong choice");
	                    System.out.println("Enter Yes or No to quit the system");
	                    String answer = sc.next();
	                   
	                    if(answer.equalsIgnoreCase("yes")){
	                        condition = true;
	                    }else if (answer.equalsIgnoreCase("no")){
	                         System.out.println("Thank you for using the syetem");
	                        condition = false;
	                    }
	                    else{
	                        System.out.println("Wrong option");
	                        condition = false;
	                        
	                    }
	            }
	            
	            
	        }
	    
	}

}
