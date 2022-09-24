package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.HeadOfDepartment;


public interface IHeadOfDepartmentDao extends JpaRepository<HeadOfDepartment,Integer>{
	
	 @Query("select s from HeadOfDepartment s where s.emailId=:email")
	    public HeadOfDepartment getHeadOfDepartmentByEmailId(@Param("email")String email);


}
