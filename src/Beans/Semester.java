package Beans;


import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "semester")
public class Semester {
	@Id
	@Column(name = "semester_id",length = 50, updatable = false, nullable = false)
    private String semesterId;

    @Column(name = "semester_name", length = 50)
    private String semesterName;

    @Column(name = "starting_date")
    private Date startingDate;

    @Column(name = "end_date")
    private Date endDate;

	public Semester() {
	
	}

	public Semester(String semesterId, String semesterName, Date startingDate, Date endDate) {
		super();
		this.semesterId = semesterId;
		this.semesterName = semesterName;
		this.startingDate = startingDate;
		this.endDate = endDate;
	}

	public String getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(String semesterId) {
		this.semesterId = semesterId;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

    
}

