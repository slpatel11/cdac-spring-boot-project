package com.app.pojos;

import java.io.Serializable;

import javax.persistence.*;




@Entity
@Table(name="projectDetail")
public class ProjectDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	@Enumerated(EnumType.STRING)
	private ProjectType type;
	@Column(length = 30,name="projectTitle")
	private String title;
	@Column(length = 30,name="projectDescription")
	private String description;
	@ManyToOne
	@JoinColumn(name="studentId", nullable=false)
    private Student student;
	public ProjectDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	







	public ProjectDetail(Integer projectId, ProjectType type, String title, String description, Student student) {
		super();
		this.projectId = projectId;
		this.type = type;
		this.title = title;
		this.description = description;
		this.student = student;
	}








	public Student getStudent() {
		return student;
	}









	public void setStudent(Student student) {
		this.student = student;
	}









	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public ProjectType getType() {
		return type;
	}
	public void setType(ProjectType type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	







	@Override
	public String toString() {
		return "ProjectDetail [projectId=" + projectId + ", type=" + type + ", title=" + title + ", description="
				+ description +  "]";
	}

	

}
