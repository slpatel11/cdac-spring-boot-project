package com.app.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Company")
public class Company implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyId;
	@Column(length = 30,unique = true,name="companyName")
	private String name;
	@Column(length = 30,unique = true,name="emailId")
	private String emailId;
	@Column(length =150,name="password")
	private String password;
	@Column(length = 30,unique = true,name="mobileNo")
	private String mobileNo;
	@Column(length = 120,name="address")
	private String address;
	
	@JsonIgnore
	@OneToMany(mappedBy="company" ,cascade = CascadeType.ALL)
	private List<CampusDrive>drive=new ArrayList<>();
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Company(Integer companyId, String name, String emailId, String password, String mobileNo, String address,
			List<CampusDrive> drive) {
		super();
		this.companyId = companyId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.mobileNo = mobileNo;
		this.address = address;
		this.drive = drive;
	}



	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public List<CampusDrive> getDrive() {
		return drive;
	}



	public void setDrive(List<CampusDrive> drive) {
		this.drive = drive;
	}



	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", name=" + name + ", emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", address=" + address + "]";
	}
	

}
