package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.CampusDrive;

public interface IDriveDetailService {
	
	List<CampusDrive> getAllDrive(Integer Id);
	Optional<CampusDrive> getDrive(Integer id);
	CampusDrive updateDriveDetail(CampusDrive c);
	boolean deleteDriveDetail(CampusDrive d);
	CampusDrive insertDriveDetail(CampusDrive c);
	boolean deleteDriveDetail(Integer id);
	List<CampusDrive> getAllDrive();
	CampusDrive updateDriveStatus(CampusDrive c);
	

}
