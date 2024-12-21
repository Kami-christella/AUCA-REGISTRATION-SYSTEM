package Beans;

import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", updatable = false, nullable = false)
    private Integer studentId;
    
    @Column(name = "first_name")
	private String firstName;
    
    @Column(name = "last_name")
   	private String lastname;
    
    @Column(name = "date_of_birth")
	private String dateOfBirth;

	public Student() {
		
	}

	public Student(Integer studentId, String firstName, String lastname, String dateOfBirth) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
    
    
}
