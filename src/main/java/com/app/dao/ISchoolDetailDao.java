package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.SchoolDetail;

public interface ISchoolDetailDao extends JpaRepository<SchoolDetail, Integer> {

}
