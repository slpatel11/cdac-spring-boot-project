package com.app.controller;

import java.util.List;
import java.util.Optional;

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

import com.app.dao.IDriveDetailDao;
import com.app.pojos.CampusDrive;
import com.app.pojos.Student;
import com.app.service.IDriveDetailService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/drive")
public class DriveController {
	
	@Autowired
	private IDriveDetailService service;
	@Autowired
	private IDriveDetailDao dao;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listAllDrive( @PathVariable Integer id){
	  List<CampusDrive>drive=service.getAllDrive(id);
	  if(drive.isEmpty())
		  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  return new ResponseEntity<>(drive,HttpStatus.OK);
	}
	@GetMapping("/getall")
	public ResponseEntity<?> listAllDrive(){
	  List<CampusDrive>drive=service.getAllDrive();
	  if(drive.isEmpty())
		  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  return new ResponseEntity<>(drive,HttpStatus.OK);
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<?> listAllDriveByStudebtId( @PathVariable Integer id){
	  List<CampusDrive>drive=dao.getAllByStudentId(id);
	  if(drive.isEmpty())
		  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  return new ResponseEntity<>(drive,HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getDrive(@PathVariable Integer id){
		
		Optional<CampusDrive>drive=service.getDrive(id);
	  if(drive.isPresent())
		  return new ResponseEntity<>(drive.get(),HttpStatus.OK);	
   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?>updateDriveDetails( @RequestBody CampusDrive d )
	{
		try {
			CampusDrive updatedDetails=service.updateDriveDetail(d);
			return new ResponseEntity<>(updatedDetails,HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/update/status/")
	public ResponseEntity<?>updateDriveStatus( @RequestBody CampusDrive d)
	{
		try {
			CampusDrive c=service.updateDriveStatus(d);
			c.setStatus("Verified");
			return new ResponseEntity<>(c,HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteDriveDetails( @PathVariable Integer id )
	{
		try {
			
			boolean deleteDetails=service.deleteDriveDetail(id);
			return new ResponseEntity<>(deleteDetails,HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?>insertDriveDetails( @RequestBody CampusDrive d )
	{
		try {
			CampusDrive insertDetails=service.insertDriveDetail(d);
			return new ResponseEntity<>(insertDetails,HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
