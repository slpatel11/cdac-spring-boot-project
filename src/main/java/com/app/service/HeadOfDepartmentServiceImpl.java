package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IHeadOfDepartmentDao;
import com.app.pojos.HeadOfDepartment;
@Service
@Transactional
public class HeadOfDepartmentServiceImpl implements IHeadOfDepartmentService {
	
	@Autowired
	private IHeadOfDepartmentDao dao;

	@Override
	public HeadOfDepartment getHeadOfDepartmentDetails(String EmailId) {
		HeadOfDepartment s=dao.getHeadOfDepartmentByEmailId(EmailId);
		return s;
	}

	@Override
	public HeadOfDepartment addHeadOfDepartmentDetail(HeadOfDepartment h) {
		// TODO Auto-generated method stub
		return dao.save(h);
	}

}
