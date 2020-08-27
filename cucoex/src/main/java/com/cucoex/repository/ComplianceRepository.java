/**
 * 
 */
package com.cucoex.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cucoex.entity.Compliance;





/**
 * @author enrique
 *
 */
public interface ComplianceRepository extends CrudRepository<Compliance, Long> {
	
	public Optional<Compliance> findById(Long id);
	public Iterable<Compliance> findByCompany(Long companyId);
	public Iterable<Compliance> findByCompanyAndImpexptype(Long companyId, Long impExpTypeId);
	public Optional<Compliance> findByCompanyAndImpexptypeAndCausal(Long companyId, Long impExpTypeId, Long causalId);
	public Optional<Compliance> findByCompanyAndImpexptypeAndCausalAndStatus(Long companyId, Long impExpTypeId, Long causalId, Long status);
	

}
