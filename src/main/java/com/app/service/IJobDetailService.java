package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.JobDetail;

public interface IJobDetailService {
	
	JobDetail updateJobDetail(int id);
	Optional<JobDetail> getJobDetail(int id);
	boolean deleteJobDetail(JobDetail d);
	Optional<JobDetail> JobDetailById(int id);
	boolean deleteJobDetail(List<JobDetail> d);
	List<JobDetail>getJobDetailByDriveId(int id);
	boolean deleteJobDetail(int id);
	JobDetail updateJobDetail(JobDetail d);
	JobDetail addJobDetail(JobDetail d);
	List<JobDetail>getallJobDetailByCompanyId(int id);
}
