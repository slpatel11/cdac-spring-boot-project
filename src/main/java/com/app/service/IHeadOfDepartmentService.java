package com.app.service;

import com.app.pojos.HeadOfDepartment;


public interface IHeadOfDepartmentService {
	public HeadOfDepartment getHeadOfDepartmentDetails(String EmailId);
	public HeadOfDepartment addHeadOfDepartmentDetail(HeadOfDepartment h);
}
