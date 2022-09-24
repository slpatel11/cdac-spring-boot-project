package com.app.pojos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="student")
public class Student implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	@Column(length = 30,name="studentName")
	private String name;
	@Column(length = 30,unique = true,name="studentEmailId")
	private String emailId;
	@Column(length =150,name="studentPassword")
	private String password;
	@Column(name="studentDOB")
	private String dateOfBirth;
	@Column(length = 30,unique = true,name="studentMobileNo")
	private String mobileNo;
	@Column(length = 150,name="studentAddress")
	private String address;
	@Column(length = 30,name="studentHobbie")
	private String hobbies;
	@Column(length = 30,name="studentLanguage")
	private String knownLanguages;
	@Column(length = 30,name="status")
	private String status;
	@JsonIgnore
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<SchoolDetail>schoolDetails=new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<ProjectDetail>projectDetails=new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<GraduationDetail>graduationDetail=new ArrayList<>();
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "students_drive",
            joinColumns = {
                    @JoinColumn(name = "studentId", referencedColumnName = "studentId",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "driveId", referencedColumnName = "driveId",
                            nullable = false, updatable = false)})
    private Set<CampusDrive>drive = new HashSet<>();
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Student(Integer studentId, String name, String emailId, String password, String dateOfBirth, String mobileNo,
			String address, String hobbies, String knownLanguages, String status, List<SchoolDetail> schoolDetails,
			List<ProjectDetail> projectDetails, List<GraduationDetail> graduationDetail) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.mobileNo = mobileNo;
		this.address = address;
		this.hobbies = hobbies;
		this.knownLanguages = knownLanguages;
		this.status = status;
		this.schoolDetails = schoolDetails;
		this.projectDetails = projectDetails;
		this.graduationDetail = graduationDetail;
	}


	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getKnownLanguages() {
		return knownLanguages;
	}
	public void setKnownLanguages(String knownLanguages) {
		this.knownLanguages = knownLanguages;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<SchoolDetail> getSchoolDetails() {
		return schoolDetails;
	}


	public void setSchoolDetails(List<SchoolDetail> schoolDetails) {
		this.schoolDetails = schoolDetails;
	}
	


	public List<ProjectDetail> getProjectDetails() {
		return projectDetails;
	}





	public void setProjectDetails(List<ProjectDetail> projectDetails) {
		this.projectDetails = projectDetails;
	}










	public Set<CampusDrive> getDrive() {
		return drive;
	}


	public void setDrive(Set<CampusDrive> drive) {
		this.drive = drive;
	}


	public List<GraduationDetail> getGraduationDetail() {
		return graduationDetail;
	}





	public void setGraduationDetail(List<GraduationDetail> graduationDetail) {
		this.graduationDetail = graduationDetail;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", emailId=" + emailId + ", password=" + password
				+ ", dateOfBirth=" + dateOfBirth + ", mobileNo=" + mobileNo + ", address=" + address + ", hobbies="
				+ hobbies + ", knownLanguages=" + knownLanguages + ", status=" + status + ", schoolDetails="
				+ schoolDetails + ", projectDetails=" + projectDetails + ", graduationDetail=" + graduationDetail + "]";
	}












	


	





	

}
