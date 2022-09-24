package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.SchoolDetail;
import com.app.pojos.Student;
import com.app.service.ISchoolDetailService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/school")
public class SchoolDetailController {
	
	@Autowired
	ISchoolDetailService service;

	public SchoolDetailController() {
		System.out.println("in ctor of"+getClass().getName());

	}
	
	@PostMapping("/register")
	public ResponseEntity<?>addSchool(@RequestBody SchoolDetail s)
	{
	
		try {
			SchoolDetail savedSchool=service.addSchoolDetail(s);
			return new ResponseEntity<>(savedSchool,HttpStatus.OK);
			
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
