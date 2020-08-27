/**
 * 
 */
package com.cucoex.service;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cucoex.entity.Compliance;
import com.cucoex.exception.ComplianceException;
import com.cucoex.repository.ComplianceRepository;

/**
 * @author enrique
 *
 */
@Service
public class ComplianceServiceImp implements ComplianceService {
	
	@Autowired
	ComplianceRepository complianceRepository;

	
	@Autowired
	ComplianceService complianceService;
	

	/**
	 * 
	 */
	public ComplianceServiceImp() {
		
	}

	@Override
	public Compliance createCompliance(Compliance compliance) throws ComplianceException {
		
		compliance = complianceRepository.save(compliance);
		return compliance;
	}

	@Override
	public Compliance getComplianceById(Long id) throws ComplianceException {
		
		return complianceRepository.findById(id).orElseThrow(() -> new ComplianceException("El Id del cumplimiento no existe."));
		 
	}

	 							
	@Override
	public Optional<Compliance> getComplianceByCompanyIdAndImpExtTypeIdAndCausalId(Long idCompany,Long idImpExpType,Long idCausal) throws ComplianceException {
		
		return Optional.ofNullable(complianceRepository.findByCompanyAndImpexptypeAndCausal(idCompany, idImpExpType, idCausal).orElseThrow(() -> new ComplianceException("El Id del cumplimiento no existe.")));
	}

	@Override 					
	public Iterable<Compliance> getComplianceByCompanyIdAndImpExtTypeId(Long idCompany,Long idImpExpType) throws ComplianceException {
		
		return complianceRepository.findByCompanyAndImpexptype(idCompany, idImpExpType);
	}

	@Override
	public Iterable<Compliance> getComplianceByCompanyId(Long id) throws ComplianceException {
		
		return complianceRepository.findByCompany(id);
	}

	@Override
	public Compliance updateCompliance(Compliance compliance) throws ComplianceException {
		
		  Calendar hoy = Calendar.getInstance(); 
		  
		  Compliance complianceUpdated = getComplianceById(compliance.getId());

		 if(complianceUpdated != null )
		  { 
			 System.out.println("Cumplimiento por actualizar "  + complianceUpdated.toString());
			 mapCompliance(compliance,complianceUpdated);
			 complianceUpdated.setUpdated(hoy);   
			 complianceUpdated = complianceRepository.save(complianceUpdated);
		     
		     System.out.println("Cumplimiento actualizada " + complianceUpdated.toString());
		  
		  }else { 
			  throw new ComplianceException("Id de cumplimiento no disponible para actualizar"); }
		  
		  return complianceUpdated;

	}

	@Override
	public void deleteCompliance(Long id) throws ComplianceException {
					
						Compliance complianceFound = getComplianceById(id);
		
						if (complianceFound  != null) {
							complianceRepository.deleteById(id);
							
							
						}else {
							 throw new ComplianceException("Id de cumplimiento no disponible para eliminar"); 
						}

	}
	
	protected void mapCompliance(Compliance from,Compliance to) {
		to.setId(from.getId());
		to.setCausal(from.getCausal());
		to.setCompany(from.getCompany());
		to.setComplianceEvaluationDate(from.getComplianceEvaluationDate());
		to.setCreated(from.getCreated());
		to.setEffectiveDateForCompliance(from.getEffectiveDateForCompliance());
		to.setImpexptype(from.getImpexptype());
		to.setStatus(from.getStatus());
		to.setUpdated(from.getUpdated());
	}

	

}
