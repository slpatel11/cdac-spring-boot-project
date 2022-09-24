package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITraningPlacementOfficer;
import com.app.pojos.Student;
import com.app.pojos.TraningPlacementOfficer;

@Service
@Transactional
public class TraningPlacementOfficerServiceImpl implements ITraningPlacementOfficerService {
	@Autowired
	private ITraningPlacementOfficer dao;
	
	@Override
	public TraningPlacementOfficer getTraningPlacementOfficerDetails(String EmailId) {
		// TODO Auto-generated method stub
		TraningPlacementOfficer ss=dao.getTraningPlacementOfficerByEmailId(EmailId);
		return ss;
		}

	@Override
	public TraningPlacementOfficer addTraningPlacementOfficer(TraningPlacementOfficer p) {
		
		return dao.save(p);
	}
}
