package com.app.service;

import com.app.pojos.Company;

public interface ICompanyService {
	public Company getCompanyDetails(String EmailId);
	public Company addCompanyDetail(Company c);
}
