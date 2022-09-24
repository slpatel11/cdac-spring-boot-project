package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDriveDetailDao;
import com.app.dao.IJobDetail;
import com.app.pojos.CampusDrive;
import com.app.pojos.JobDetail;
@Service
@Transactional
public class JobDetailServiceImpl implements IJobDetailService {
  
	@Autowired
	private IJobDetail dao;
	@Autowired
	private IDriveDetailDao ddao;
	@Override
	public JobDetail updateJobDetail(JobDetail d) {
		Optional<JobDetail>job= dao.findById(d.getJobId());
		if(job.isPresent()) {
			JobDetail cd=job.get();
			cd.setDesignation(d.getDesignation());
			cd.setExperience(d.getExperience());
			cd.setLocation(d.getLocation());
			cd.setResponsibility(d.getResponsibility());
			cd.setSalary(d.getSalary());
			cd.setSkill(d.getSkill());
			cd.setTechnology(d.getTechnology());
			return cd;
		}
		return null;
	}
	@Override
	public boolean deleteJobDetail(int id) {
		Optional<JobDetail> j=dao.findById(id);
		JobDetail d=j.get();
		dao.delete(d);
		return true;
	}
	@Override
	public Optional<JobDetail> JobDetailById(int id) {
		
		return dao.findById(id);
	}
	@Override
	public Optional<JobDetail> getJobDetail(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	@Override
	public List<JobDetail> getJobDetailByDriveId(int id) {
		// TODO Auto-generated method stub
		return dao.getJobDetailByDriveId(id);
	}
	@Override
	public boolean deleteJobDetail(List<JobDetail> d) {
		// TODO Auto-generated method stub
		dao.deleteInBatch(d);
		return true;
	}
	@Override
	public JobDetail updateJobDetail(int id) {
		
		return null;
	}
	@Override
	public boolean deleteJobDetail(JobDetail d) {
		
		return false;
	}
	@Override
	public JobDetail addJobDetail(JobDetail d) {
		Optional<CampusDrive> cd=this.ddao.findById(d.getDrive().getDriveId());
		JobDetail j=new JobDetail();
		j.setDrive(cd.get());
		j.setDesignation(d.getDesignation());
		j.setExperience(d.getExperience());
		j.setLocation(d.getLocation());
		j.setResponsibility(d.getResponsibility());
		j.setSalary(d.getSalary());
		j.setSkill(d.getSkill());
		j.setTechnology(d.getTechnology());
		return dao.save(j);
	}
	@Override
	public List<JobDetail> getallJobDetailByCompanyId(int id) {
		// TODO Auto-generated method stub
		return dao.getJobDetailByCompanyId(id);
	}
	
	
	

}
