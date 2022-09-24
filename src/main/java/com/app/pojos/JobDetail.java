package com.app.pojos;
import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="jobDetail")
public class JobDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobId;
	@Column(length = 30,name="designation")
	private String designation;
	@Column(length = 30,name="responsibility")
	private String responsibility;
	@Column(length = 30,name="skill")
	private String skill;
	@Column(length = 30,name="Experience")
	private Integer Experience;
	@Column(length = 30,name="technology")
	private String technology;
	@Column(length = 30,name="salary")
	private double salary;
	@Column(length = 30,name="location")
	private String location;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="driveId")
	private CampusDrive drive;
	
	public JobDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public JobDetail(Integer jobId, String designation, String responsibility, String skill, Integer experience,
			String technology, double salary, String location, CampusDrive drive) {
		super();
		this.jobId = jobId;
		this.designation = designation;
		this.responsibility = responsibility;
		this.skill = skill;
		Experience = experience;
		this.technology = technology;
		this.salary = salary;
		this.location = location;
		this.drive = drive;
	}



	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Integer getExperience() {
		return Experience;
	}
	public void setExperience(Integer experience) {
		Experience = experience;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public CampusDrive getDrive() {
		return drive;
	}

	public void setDrive(CampusDrive drive) {
		this.drive = drive;
	}



	@Override
	public String toString() {
		return "JobDetail [jobId=" + jobId + ", designation=" + designation + ", responsibility=" + responsibility
				+ ", skill=" + skill + ", Experience=" + Experience + ", technology=" + technology + ", salary="
				+ salary + ", location=" + location + ", drive=" + drive + "]";
	}

	
	

}
