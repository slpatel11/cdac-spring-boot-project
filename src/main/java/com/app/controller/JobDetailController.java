package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.JobDetail;
import com.app.service.IJobDetailService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/job")
public class JobDetailController {
	
	@Autowired
	private IJobDetailService service;
	@GetMapping("/getall/{id}")
	public ResponseEntity<?> listAllJobByCompany( @PathVariable Integer id){
	  List<JobDetail>job=service.getallJobDetailByCompanyId(id);
	  if(job.isEmpty())
		  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  return new ResponseEntity<>(job,HttpStatus.OK);
	}
	@GetMapping("/getallbydrive/{id}")
	public ResponseEntity<?> listAllJobByDrive( @PathVariable Integer id){
	  List<JobDetail>job=service.getJobDetailByDriveId(id);
	  if(job.isEmpty())
		  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  return new ResponseEntity<>(job,HttpStatus.OK);
	}
	@PostMapping("/register")
	public ResponseEntity<?>addJobDetails( @RequestBody JobDetail d )
	{
		try {
			JobDetail addDetails=service.addJobDetail(d);
			return new ResponseEntity<>(addDetails,HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<?>updateJobDetails( @RequestBody JobDetail d )
	{
		try {
			JobDetail updatedDetails=service.updateJobDetail(d);
			return new ResponseEntity<>(updatedDetails,HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/drive/{id}")
	public ResponseEntity<?>deleteDriveDetails( @PathVariable Integer id  )
	{
		try {
			List<JobDetail> deleteDetails=service.getJobDetailByDriveId(id);
			boolean status=service.deleteJobDetail(deleteDetails);
			return new ResponseEntity<>(status,HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteJobDetails( @PathVariable Integer id  )
	{
		try {
			
			boolean status=service.deleteJobDetail(id);
			return new ResponseEntity<>(status,HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

}
