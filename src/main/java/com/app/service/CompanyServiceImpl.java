package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICompanyDao;
import com.app.pojos.Company;
@Service
@Transactional
public class CompanyServiceImpl implements ICompanyService {
	@Autowired
	private ICompanyDao dao;
	@Override
	public Company getCompanyDetails(String EmailId) {
		Company c=dao.getCompanyByEmailId(EmailId);
		return c;
	}
	@Override
	public Company addCompanyDetail(Company c) {
		// TODO Auto-generated method stub
		return dao.save(c);
	}
	
	

}
