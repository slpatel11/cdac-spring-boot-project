package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICompanyDao;
import com.app.dao.IDriveDetailDao;
import com.app.dao.IStudentDao;
import com.app.pojos.CampusDrive;
import com.app.pojos.Company;
import com.app.pojos.Student;
@Service
@Transactional
public class IDriveDetailImpl implements IDriveDetailService {

	
	@Autowired
	private IDriveDetailDao dao;
	@Autowired
	private ICompanyDao cdao;
	@Autowired
	private IStudentDao sdao;
	@Override
	public List<CampusDrive> getAllDrive(Integer id) {
		// TODO Auto-generated method stub
		return dao.findAllById(id);
	}
	@Override
	public List<CampusDrive> getAllDrive() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}


	@Override
	public Optional<CampusDrive> getDrive(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}


	@Override
	public CampusDrive updateDriveDetail(CampusDrive c) {
		Optional<CampusDrive> drive= dao.findById(c.getDriveId());
		if(drive.isPresent()) {
			CampusDrive cd=drive.get();
			cd.setDriveDate(c.getDriveDate());
			cd.setTime(cd.getTime());
			cd.setVenue(cd.getVenue());
			cd.setStatus("Not Verified");
			return cd;
		}
		return null;
	}


	@Override
	public boolean deleteDriveDetail(Integer id) {
		dao.deleteById(id);
		return true;
	}


	@Override
	public CampusDrive insertDriveDetail(CampusDrive c) {
		Optional<Company> company=this.cdao.findById(c.getCompany().getCompanyId());
		CampusDrive cd=new CampusDrive();
		cd.setCompany(company.get());
        cd.setDriveDate(c.getDriveDate());
        cd.setTime(c.getTime());
        cd.setVenue(c.getVenue());
        cd.setStatus("Not Verified");
		return dao.save(cd);
	}


	@Override
	public CampusDrive updateDriveStatus(CampusDrive c) {
	
        c.setStatus("Verified");
        List<Student>ss=sdao.getAllStudents();
        for(Student s:ss) {
        	dao.insertIntoStudent_Drive(s.getStudentId(),c.getDriveId());
        }
		return dao.save(c);
	}
	@Override
	public boolean deleteDriveDetail(CampusDrive d) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
