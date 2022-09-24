package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Company;

public interface ICompanyDao extends JpaRepository<Company,Integer> {
	 @Query("select s from Company s where s.emailId=:email")
	    public Company getCompanyByEmailId(@Param("email")String email);

}
