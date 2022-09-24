package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.HeadOfDepartment;
import com.app.pojos.TraningPlacementOfficer;
import com.app.service.IHeadOfDepartmentService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/hod")
public class HeadOfDepartmentController {
	
	@Autowired
	private IHeadOfDepartmentService service;

	public HeadOfDepartmentController() {
		System.out.println("in ctor of"+getClass().getName());
	}
	@PostMapping("/login")
	public HeadOfDepartment loginHod(@RequestBody HeadOfDepartment s) throws Exception{
		String emailId=s.getEmailId();
		String password=s.getPassword();
		HeadOfDepartment hod=null;
		if(emailId!=null && password!=null) {
			hod=service.getHeadOfDepartmentDetails(emailId);
		}
		if(hod==null)
		{
			throw new Exception("Bad request");
		}
		return hod;
	}
	
	
	@PostMapping("register")
	public ResponseEntity<?>addHeadOfDepartment(@RequestBody HeadOfDepartment s)
	{
		try {
			HeadOfDepartment savedHeadOfDepartment=service.addHeadOfDepartmentDetail(s);
			return new ResponseEntity<>(savedHeadOfDepartment,HttpStatus.OK);
			
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
