package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.JobDetail;

public interface IJobDetail extends JpaRepository<JobDetail,Integer> {
	@Query("select s from JobDetail s where s.drive.driveId=:id")
    public List<JobDetail> getJobDetailByDriveId(@Param("id")int id);
	
	@Query(nativeQuery = true, value ="select * from job_detail where drive_id in (select drive_id from campus_drive where status='Verified' and company_id=:id) ")
    public List<JobDetail> getJobDetailByCompanyId(@Param("id")int id);
}
