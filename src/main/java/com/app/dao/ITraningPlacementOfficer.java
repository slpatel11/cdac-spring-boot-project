package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.app.pojos.TraningPlacementOfficer;

public interface ITraningPlacementOfficer extends JpaRepository<TraningPlacementOfficer,Integer>{
	 @Query("select s from TraningPlacementOfficer s where s.emailId=:email")
	    public TraningPlacementOfficer getTraningPlacementOfficerByEmailId(@Param("email")String email);

}
