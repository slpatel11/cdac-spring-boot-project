package com.app.service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.config.CustomUserDetails;
import com.app.custom.excs.StudentNotException;
import com.app.dao.IDriveDetailDao;
import com.app.dao.IStudentDao;
import com.app.pojos.SchoolDetail;
import com.app.pojos.Student;
@Service
@Transactional
public class StudentServiceImpl implements IStudentService,UserDetailsService {
	
	@Autowired
	private IStudentDao student;
	@Autowired
	private IDriveDetailDao ddao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student s=student.findByName(username);
		if(s==null)
		{
			throw new UsernameNotFoundException("Could not found Student");
		}
		CustomUserDetails user=new CustomUserDetails(s);
		return user;
	}
	@Override
	public Student addStudentDetails(Student p) {
		 Student s=new Student();
		 s=p;
		 s.setPassword(passwordEncoder.encode(p.getPassword()));
		 s.setStatus("not Placed");
		return dao.save(s);
	}

	@Override
	public Student updateStudentDetails(int studentId, Student p) {
		// chk if student exists
		 Optional<Student> student=dao.findById(studentId);
		 if(student.isPresent())
		 {
			 Student s=student.get();
			 s.setAddress(p.getAddress());
			 s.setName(p.getName());
			 s.setDateOfBirth(p.getDateOfBirth());
			 s.setEmailId(p.getEmailId());
			 s.setHobbies(p.getHobbies());
			 s.setKnownLanguages(p.getKnownLanguages());
			 s.setMobileNo(p.getMobileNo());
			 s.setPassword(passwordEncoder.encode(p.getPassword()));
		   return s;
		 }
		 throw new StudentNotException("Invalid Student Id");
			 
	}

	@Autowired
	private IStudentDao dao;

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		System.out.println("Dao impl class"+dao.getClass().getName());
		return dao.findAll();
	}

	@Override
	public Student getStudentDetails(String EmailId) {
		// TODO Auto-generated method stub
		Student ss=dao.getStudentByEmailId(EmailId);
	    ss.getDrive().addAll(ddao.getAllByStudentId(ss.getStudentId()));
		return ss;
	//	return dao.getStudentByStudentEmail(EmailId);
	}
	@Override
	public List<Student> getAllStudentsbyDriveId(int id) {
		List<Student>students=dao.getAllStudentsbyDriveId(id);
		return students;
	}
	@Override
	public boolean updateStudentStatus(ArrayList<Student> s) {
		for(Student ss:s) {
			Optional<Student> student=dao.findById(ss.getStudentId());
			 if(student.isPresent())
			 {
				 Student stud=student.get();
				 stud.setStatus(ss.getStatus());
			 }
		}
		return true;
	}
	

}
