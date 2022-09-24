package com.app.pojos;

import javax.persistence.*;
@Entity
@Table(name="headOfDepartment")
public class HeadOfDepartment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30,name="name")
	private String name;
	@Column(length = 30,unique = true,name="emailId")
	private String emailId;
	@Column(length = 30,name="collegeName")
	private String collegeName;
	@Column(length =150,name="password")
	private String password;
	@Column(length = 30,unique = true,name="mobileNo")
	private String mobileNo;
	public HeadOfDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HeadOfDepartment(Integer id, String name, String emailId, String collegeName, String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.collegeName = collegeName;
		this.mobileNo = mobileNo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "HeadOfDepartment [id=" + id + ", name=" + name + ", emailId=" + emailId + ", collegeName=" + collegeName
				+ ", mobileNo=" + mobileNo + "]";
	}
	
	

}
