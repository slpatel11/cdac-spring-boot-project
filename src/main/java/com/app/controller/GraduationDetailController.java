package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IGraduationDetail;
import com.app.pojos.GraduationDetail;
import com.app.service.IGraduationDetailService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/graduation")
public class GraduationDetailController {
	
	@Autowired
	IGraduationDetailService service;
	
	@Autowired
	IGraduationDetail dao;
	
	@PostMapping("/register")
	public ResponseEntity<?>addSchool(@RequestBody GraduationDetail s)
	{
	
		try {
			GraduationDetail savedSchool=service.addGraduationDetail(s);
			return new ResponseEntity<>(savedSchool,HttpStatus.OK);
			
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<?>getAllGraduationDetails(){
		List<GraduationDetail>project=dao.findAll();
		return ResponseEntity.ok(project);
	}
}
