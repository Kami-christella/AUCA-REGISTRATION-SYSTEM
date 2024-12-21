package Beans;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student_registration")
public class StudentRegistration {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "registration_id", updatable = false, nullable = false)
    private UUID registrationId;

    @Column(name = "registration_code", length = 50)
    private String registrationCode;

    @Column(name = "registration_date")
    private Date registrationDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semesterId;

    @ManyToOne
    @JoinColumn(name = "academic_id")
    private AcademicUnit department;
    
    @ElementCollection
    @CollectionTable(name = "student_registration_courses", joinColumns = @JoinColumn(name = "registration_id"))
    @Column(name = "course_code")
    private List<String> courseCodes;


	public StudentRegistration() {
		
	}


	


	public StudentRegistration(UUID registrationId, String registrationCode, Date registrationDate, Student student,
			Semester semesterId, AcademicUnit department, List<String> courseCodes) {
		super();
		this.registrationId = registrationId;
		this.registrationCode = registrationCode;
		this.registrationDate = registrationDate;
		this.student = student;
		this.semesterId = semesterId;
		this.department = department;
		this.courseCodes = courseCodes;
	}





	public UUID getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(UUID registrationId) {
		this.registrationId = registrationId;
	}

	public String getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	

	public Semester getSemesterId() {
		return semesterId;
	}





	public void setSemesterId(Semester semesterId) {
		this.semesterId = semesterId;
	}





	public AcademicUnit getDepartment() {
		return department;
	}

	public void setDepartment(AcademicUnit department) {
		this.department = department;
	}

	public List<String> getCourseCodes() {
		return courseCodes;
	}

	public void setCourseCodes(List<String> courseCodes) {
		this.courseCodes = courseCodes;
	}


	

	
    
}