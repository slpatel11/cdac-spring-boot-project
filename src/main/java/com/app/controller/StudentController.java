package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Student;
import com.app.service.IStudentService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	public StudentController() {
		System.out.println("in ctor of"+getClass().getName());
	}
	@PostMapping("/login")
	public Student loginStudent(@RequestBody Student s) throws Exception{
		String emailId=s.getEmailId();
		String password=s.getPassword();
		Student student=null;
		if(emailId!=null && password!=null) {
			student=service.getStudentDetails(emailId);
		}
		if(student==null)
		{
			throw new Exception("Bad request");
		}
		  return student;
	}
	@PostMapping("/update/status")
	public boolean updateStudentStatus(@RequestBody  ArrayList<Student> student) throws Exception{
	      boolean s=this.service.updateStudentStatus(student);	
		  return s;
	}
	@PostMapping("register")
	public ResponseEntity<?>addStudent(@RequestBody Student s)
	{
		System.out.println("in add student"+s);
		try {
			Student savedStudent=service.addStudentDetails(s);
			return new ResponseEntity<>(savedStudent,HttpStatus.OK);
			
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	@GetMapping("/getstudentlist/{id}")
	public ResponseEntity<?> listAllStudents(@PathVariable Integer id){
	  System.out.println("in list all Students");
	  List<Student>students=service.getAllStudentsbyDriveId(id);
	  if(students.isEmpty())
		  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  return new ResponseEntity<>(students,HttpStatus.OK);
	}
	@GetMapping("/student/{studentEmailId}")
	public ResponseEntity<?>getStudentDetails(@PathVariable String studentEmailId)
	{
	     System.out.println("in get student Details"+studentEmailId);
	     Student studentDetails=service.getStudentDetails(studentEmailId);
	     if(studentDetails.getStudentId()!=0)
	    	 return new ResponseEntity<>(studentDetails,HttpStatus.OK);
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	     
	}
	
	//req handling method to create a new Student :post
	
	//req handling method to update existing student
	@PutMapping("{studentId}")
	public ResponseEntity<?>updateStudentDetails(@PathVariable int studentId,@RequestBody Student s )
	{
		System.out.println("in update"+studentId+""+s);
		try {
			Student updatedDetails=service.updateStudentDetails(studentId,s);
			return new ResponseEntity<>(updatedDetails,HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
