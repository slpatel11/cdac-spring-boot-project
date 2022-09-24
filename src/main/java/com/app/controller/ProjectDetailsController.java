package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import com.app.dao.IProjectDetails;
import com.app.pojos.ProjectDetail;
import com.app.pojos.Student;
import com.app.service.IStudentService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/project/")
public class ProjectDetailsController {
	@Autowired
	private IProjectDetails dao;
	
	@GetMapping
	public ResponseEntity<?>getAllProjectDetails(){
		List<ProjectDetail>project=dao.findAll();
		return ResponseEntity.ok(project);
	}
	
	@GetMapping("/{projectId}")
	public ResponseEntity<?>getProjectDetails(@PathVariable int id)
	{
		System.out.println("in get project"+id);
		Optional<ProjectDetail> optional = dao.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok(optional.get());
		return new ResponseEntity<>( HttpStatus.NOT_FOUND);
	}

	@PostMapping("register")
	public ResponseEntity<?> addProjectDetails(@RequestBody ProjectDetail s) {
		try {
			ProjectDetail projectSave=dao.save(s);
		return new ResponseEntity<>(projectSave, HttpStatus.CREATED);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	

}
