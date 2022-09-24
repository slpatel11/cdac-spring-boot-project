package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IGraduationDetail;
import com.app.dao.IStudentDao;
import com.app.pojos.GraduationDetail;
import com.app.pojos.Student;

@Service
@Transactional
public class GraduationDetailServiceImpl implements IGraduationDetailService {
	
	@Autowired
	IGraduationDetail dao;
	@Autowired
	IStudentDao sdao;
	

	@Override
	public GraduationDetail addGraduationDetail(GraduationDetail d) {
		Optional<Student> s=sdao.findById(d.getStudent().getStudentId());
		GraduationDetail gd=new GraduationDetail();
		gd.setStudent(s.get());
		gd.setCollegeName(d.getCollegeName());
		gd.setDegree(d.getDegree());
		gd.setPassingYear(d.getPassingYear());
		gd.setPercentage(d.getPercentage());
		gd.setStream(d.getStream());
		gd.setUniversity(d.getUniversity());
		return dao.save(gd);
	}

}
