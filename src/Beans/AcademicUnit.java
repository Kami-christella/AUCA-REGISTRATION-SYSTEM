package Beans;


import java.util.*;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "academic_unit")
public class AcademicUnit {
	
	@Id
	@Column(name = "academic_id",length = 50, nullable = false)
	private String academicId;

    @Column(name = "academic_code", length = 50)
    private String academicCode;

    @Column(name = "academic_name", length = 50)
    private String academicName;

    @Column(name = "unit_type")
    private AcademicUnitType type;


    @ManyToOne
    @JoinColumn(name = "parent_id")
    private AcademicUnit parent;

	public AcademicUnit() {
		
	}

	public AcademicUnit(String academicId, String academicCode, String academicName, AcademicUnitType type,
			AcademicUnit parent) {
		super();
		this.academicId = academicId;
		this.academicCode = academicCode;
		this.academicName = academicName;
		this.type = type;
		this.parent = parent;
	}

	public String getAcademicId() {
		return academicId;
	}

	public void setAcademicId(String academicId) {
		this.academicId = academicId;
	}

	public String getAcademicCode() {
		return academicCode;
	}

	public void setAcademicCode(String academicCode) {
		this.academicCode = academicCode;
	}

	public String getAcademicName() {
		return academicName;
	}

	public void setAcademicName(String academicName) {
		this.academicName = academicName;
	}

	public AcademicUnitType getType() {
		return type;
	}

	public void setType(AcademicUnitType type) {
		this.type = type;
	}

	public AcademicUnit getParent() {
		return parent;
	}

	public void setParent(AcademicUnit parent) {
		this.parent = parent;
	}

   
}

