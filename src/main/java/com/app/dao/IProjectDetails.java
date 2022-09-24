package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.ProjectDetail;


public interface IProjectDetails extends JpaRepository<ProjectDetail,Integer>  {
     
}
