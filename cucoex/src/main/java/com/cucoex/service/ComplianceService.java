/**
 * 
 */
package com.cucoex.service;

import java.util.Optional;

import com.cucoex.entity.Compliance;
import com.cucoex.exception.ComplianceException;

/**
 * @author enrique
 *
 */
public interface ComplianceService {
	
	
	public Compliance createCompliance(Compliance compliance) throws ComplianceException;

	public Compliance getComplianceById(Long id) throws ComplianceException;
	
	public Optional<Compliance> getComplianceByCompanyIdAndImpExtTypeIdAndCausalId(Long idCompany,Long idImpExpType,Long idCausal) throws ComplianceException;
	
	public Iterable<Compliance> getComplianceByCompanyIdAndImpExtTypeId(Long idCompany,Long idImpExpType) throws ComplianceException;
	
	public Iterable<Compliance> getComplianceByCompanyId(Long id) throws ComplianceException;
	
	public Compliance updateCompliance(Compliance compliance) throws ComplianceException;
	
	public void deleteCompliance(Long id) throws ComplianceException;

}
