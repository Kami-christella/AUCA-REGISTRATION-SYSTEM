package Beans;

import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "course_definition")
public class CourseDefinition {
    @Id  
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "course_definition_id", updatable = false, nullable = false)
    private UUID courseDefinitionId;

    @Column(name = "course_definition_code", length = 50)
    private String courseDefinitionCode;

    @Column(name = "course_definition_description", length = 50)
    private String courseDefinitionDescription;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

	public CourseDefinition() {
		
	}

	public CourseDefinition(UUID courseDefinitionId, String courseDefinitionCode, String courseDefinitionDescription,
			Course course) {
		super();
		this.courseDefinitionId = courseDefinitionId;
		this.courseDefinitionCode = courseDefinitionCode;
		this.courseDefinitionDescription = courseDefinitionDescription;
		this.course = course;
	}

	public UUID getCourseDefinitionId() {
		return courseDefinitionId;
	}

	public void setCourseDefinitionId(UUID courseDefinitionId) {
		this.courseDefinitionId = courseDefinitionId;
	}

	public String getCourseDefinitionCode() {
		return courseDefinitionCode;
	}

	public void setCourseDefinitionCode(String courseDefinitionCode) {
		this.courseDefinitionCode = courseDefinitionCode;
	}

	public String getCourseDefinitionDescription() {
		return courseDefinitionDescription;
	}

	public void setCourseDefinitionDescription(String courseDefinitionDescription) {
		this.courseDefinitionDescription = courseDefinitionDescription;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

    
}
