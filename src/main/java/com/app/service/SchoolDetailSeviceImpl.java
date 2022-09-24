package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ISchoolDetailDao;
import com.app.pojos.SchoolDetail;

@Service
@Transactional
public class SchoolDetailSeviceImpl implements ISchoolDetailService {
	
	@Autowired
	ISchoolDetailDao dao;

	@Override
	public SchoolDetail addSchoolDetail(SchoolDetail s) {
		return dao.save(s);
	}

}
