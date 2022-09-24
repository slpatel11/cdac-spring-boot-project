package com.app.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CampusDrive")
public class CampusDrive implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer driveId;
	
	@Column(name="driveDate")
	private String driveDate;
	
	@Column(name="interviewTime")
	private String time;
	
	@Column(name="venue")
	private String venue;
	
	@Column(name="status")
	private String status;
	@JsonIgnore
	@OneToMany(mappedBy="drive" ,cascade = CascadeType.ALL)
	private List<JobDetail>job=new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="companyId")
	private Company company;
	
	@ManyToMany(mappedBy = "drive", fetch = FetchType.LAZY)
	private Set<Student>students = new HashSet<>();
	public CampusDrive() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CampusDrive(Integer driveId, String driveDate, String time, String venue, List<JobDetail> job,
			Company company) {
		super();
		this.driveId = driveId;
		this.driveDate = driveDate;
		this.time = time;
		this.venue = venue;
		this.job = job;
		this.company = company;
	}



	public Integer getDriveId() {
		return driveId;
	}

	public void setDriveId(Integer driveId) {
		this.driveId = driveId;
	}

	public String getDriveDate() {
		return driveDate;
	}

	public void setDriveDate(String driveDate) {
		this.driveDate = driveDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Set<Student> getStudents() {
		return students;
	}



	public void setStudents(Set<Student> students) {
		this.students = students;
	}



	public List<JobDetail> getJob() {
		return job;
	}



	public void setJob(List<JobDetail> job) {
		this.job = job;
	}



	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "CampusDrive [driveId=" + driveId + ", driveDate=" + driveDate + ", time=" + time + ", venue=" + venue
				+ ", job=" + job + ", company=" + company + "]";
	}
	
	

	
	
	
	


}
