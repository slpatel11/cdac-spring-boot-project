package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.GraduationDetail;

public interface IGraduationDetail extends JpaRepository<GraduationDetail, Integer> {

}
