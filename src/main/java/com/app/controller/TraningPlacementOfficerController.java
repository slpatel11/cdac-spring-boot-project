package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Student;
import com.app.pojos.TraningPlacementOfficer;
import com.app.service.ITraningPlacementOfficerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/tpo")
public class TraningPlacementOfficerController {
	@Autowired
	private ITraningPlacementOfficerService service;

	public TraningPlacementOfficerController() {
		System.out.println("in ctor of"+getClass().getName());
	}
	@PostMapping("/login")
	public TraningPlacementOfficer loginTpo(@RequestBody TraningPlacementOfficer s) throws Exception{
		String emailId=s.getEmailId();
		String password=s.getPassword();
		TraningPlacementOfficer tpo=null;
		if(emailId!=null && password!=null) {
			tpo=service.getTraningPlacementOfficerDetails(emailId);
		}
		if(tpo==null)
		{
			throw new Exception("Bad request");
		}
		return tpo;
	}
	@PostMapping("register")
	public ResponseEntity<?>addTraningPlacementOfficer(@RequestBody TraningPlacementOfficer s)
	{
		try {
			TraningPlacementOfficer savedTraningPlacementOfficer=service.addTraningPlacementOfficer(s);
			return new ResponseEntity<>(savedTraningPlacementOfficer,HttpStatus.OK);
			
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
