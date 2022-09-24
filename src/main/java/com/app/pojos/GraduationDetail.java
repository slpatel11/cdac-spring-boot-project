package com.app.pojos;

import java.io.Serializable;
import java.time.Year;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="graduationDetail")
public class GraduationDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer collegedId;
	@Column(length = 30,name="collegeName")
	private String collegeName;
	@Column(length = 30,name="university")
	private String university;
	@Enumerated(EnumType.STRING)
	private Degree degree;
	@Enumerated(EnumType.STRING)
	private Stream stream;
	@Column(length = 30,name="percentage")
	private double percentage;
	@Column(length = 30,name="passingYear")
	private int passingYear;
	@ManyToOne
	@JoinColumn(name="studentId", nullable=false)
    private Student student;
	public GraduationDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	


	public GraduationDetail(Integer collegedId, String collegeName, String university, Degree degree, Stream stream,
			double percentage, int passingYear) {
		super();
		this.collegedId = collegedId;
		this.collegeName = collegeName;
		this.university = university;
		this.degree = degree;
		this.stream = stream;
		this.percentage = percentage;
		this.passingYear = passingYear;
	}






	public Integer getCollegedId() {
		return collegedId;
	}
	public void setCollegedId(Integer collegedId) {
		this.collegedId = collegedId;
	}
	
	



	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public Degree getDegree() {
		return degree;
	}
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	public Stream getStream() {
		return stream;
	}
	public void setStream(Stream stream) {
		this.stream = stream;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}




	public int getPassingYear() {
		return passingYear;
	}






	public void setPassingYear(int passingYear) {
		this.passingYear = passingYear;
	}






	public Student getStudent() {
		return student;
	}






	public void setStudent(Student student) {
		this.student = student;
	}






	@Override
	public String toString() {
		return "GraduationDetail [collegedId=" + collegedId + ", collegeName=" + collegeName + ", university="
				+ university + ", degree=" + degree + ", stream=" + stream + ", percentage=" + percentage
				+ ", passingYear=" + passingYear + "]";
	}

	

}
