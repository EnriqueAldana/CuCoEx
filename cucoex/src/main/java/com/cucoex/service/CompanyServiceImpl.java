/**
 * 
 */
package com.cucoex.service;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cucoex.entity.Company;
import com.cucoex.entity.User;
import com.cucoex.exception.CompanyException;
import com.cucoex.exception.UsernameOrIdNotFound;
import com.cucoex.repository.*;

/**
 * @author enrique
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CompanyRepository repository;

	/**
	 * 
	 */
	public CompanyServiceImpl() {
		
	}



	@Override
	public Iterable<Company> getAllComanies() {
		
		return repository.findAll();
	}


	@Override
	public Company createCompany(Company company) throws CompanyException {
		company = repository.save(company);
		return company;
	}

	@Override
	public Company getCompanyById(Long id) throws CompanyException {
		
		return repository.findById(id).orElseThrow(() -> new CompanyException("El Id de la empresa no existe."));

	}

	@Override
	public Company updateCompany(Company company) throws CompanyException {
		
	  
		  Company companyUpdated = getCompanyById(company.getId());
		  
		  
		 if(companyUpdated != null )
		  { 
			 System.out.println("Empresa por actualizar "  + companyUpdated.toString());
			 mapCompany(company,companyUpdated);
		     
             companyUpdated = repository.save(companyUpdated);
		     
		     System.out.println("Empresa actualizada " + companyUpdated.toString());
		  
		  }else { 
			  throw new CompanyException("La empresa " + company.getId() + "  no está disponible para actualizar"); }
		  
		  return companyUpdated;
		  
	}

	@Override
	public void deleteCompany(Long id) throws CompanyException {
		Optional<Company> companyFound = repository.findById(id);
		if (companyFound.isPresent()) {
			repository.deleteById(id);
			
			
		}else {
			throw new CompanyException("La empresa " + id + "  no está disponible para eliminar");
		}
		

		
	}



	@Override
	public String toString() {
		return "CompanyServiceImpl [getAllComanies()=" + getAllComanies() + "]";
	}


	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapCompany(Company from,Company to) {
		
		Calendar today = Calendar.getInstance(); 
		
		to.setAlertMessage(from.getAlertMessage());
		to.setAreAlertsEnabled(from.getAreAlertsEnabled());
		to.setAreAlertsEnabledToAdministrators(from.getAreAlertsEnabledToAdministrators());
		to.setAreAlertsEnabledToSupervisors(from.getAreAlertsEnabledToSupervisors());
		to.setAreAlertsEnabledToUsers(from.getAreAlertsEnabledToUsers());
		to.setCompanyAddress(from.getCompanyAddress());
		to.setCompanyEmail(from.getCompanyEmail());
		to.setCompanyId(from.getCompanyId());
		to.setCompanyName(from.getCompanyName());
		to.setCompanyPhone(from.getCompanyPhone());
		to.setCompanyWeb(from.getCompanyWeb());
		to.setUpdated(today);
		

	}
}
