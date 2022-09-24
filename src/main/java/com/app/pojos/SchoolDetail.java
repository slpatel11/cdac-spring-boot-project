package com.app.pojos;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="schoolDetail")
public class SchoolDetail implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer schoolId;
	@Column(length = 30,name="schoolName")
	private String schoolName;
	@Column(length = 30,name="board")
	private String board;
	@Column(length = 30,name="percentage")
	private double percentage;
	@Column(length = 30,name="passingYear")
	private int passingYear;
	@ManyToOne
	@JoinColumn(name="studentId", nullable=false)
    private Student student;
	public SchoolDetail() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

	public SchoolDetail(Integer schoolId, String schoolName, String board, double percentage, int passingYear,
			Student student) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.board = board;
		this.percentage = percentage;
		this.passingYear = passingYear;
		this.student = student;
	}





	public Student getStudent() {
		return student;
	}





	public void setStudent(Student student) {
		this.student = student;
	}





	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
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


	@Override
	public String toString() {
		return "SchoolDetail [schoolId=" + schoolId + ", schoolName=" + schoolName + ", board=" + board
				+ ", percentage=" + percentage + ", passingYear=" + passingYear + "]";
	}
	
	

}
