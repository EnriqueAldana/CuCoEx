package com.cucoex.service;

import com.cucoex.entity.User;
import com.cucoex.entity.Company;
import com.cucoex.exception.*;

public interface CompanyService {
	
	public Iterable<Company> getAllComanies();

	public Company createCompany(Company company) throws CompanyException;

	public Company getCompanyById(Long id) throws CompanyException;
	
	public Company updateCompany(Company user) throws CompanyException;
	
	public void deleteCompany(Long id) throws CompanyException;
	

}
