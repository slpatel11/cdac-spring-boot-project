package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Company;
import com.app.pojos.HeadOfDepartment;
import com.app.service.ICompanyService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private ICompanyService service;

	public CompanyController() {
		System.out.println("in ctor of"+getClass().getName());
	}
	@PostMapping("/login")
	public Company loginCompany(@RequestBody Company s) throws Exception{
		String emailId=s.getEmailId();
		String password=s.getPassword();
		Company company=null;
		if(emailId!=null && password!=null) {
			company=service.getCompanyDetails(emailId);
		}
		if(company==null)
		{
			throw new Exception("Bad request");
		}
		return company;
	}
	
	
	@PostMapping("register")
	public ResponseEntity<?>addCompany(@RequestBody Company s)
	{
		try {
			Company savedCompany=service.addCompanyDetail(s);
			return new ResponseEntity<>(savedCompany,HttpStatus.OK);
			
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
