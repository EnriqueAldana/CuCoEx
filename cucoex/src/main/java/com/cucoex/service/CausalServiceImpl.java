/**
 * 
 */
package com.cucoex.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cucoex.entity.Causal;
import com.cucoex.entity.Cumplimiento;
import com.cucoex.entity.Instruction;
import com.cucoex.exception.CausalException;
import com.cucoex.repository.CausalRepository;


/**
 * @author enrique
 *
 */
@Service
public class CausalServiceImpl implements CausalService {
	
	@Autowired
	CausalRepository repository;
	/**
	 * 
	 */
	public CausalServiceImpl() {
		
	}

	@Override
	public Iterable<Causal> getAllCausals() {
		
		return  repository.findAll();
	}

	@Override
	public Iterable<Instruction> getAllInstructionsByCausalId(Long id) throws CausalException {
		
		Causal causalFound = new Causal();
		causalFound= getCausalById(id);
		
		return causalFound.getInstructionList();

	}

	@Override
	public Causal createCausal(Causal causal) throws CausalException {
		 causal = repository.save(causal);
		return causal;
	}

	@Override
	public Causal getCausalById(Long id) throws CausalException {
		
		return repository.findById(id).orElseThrow(() -> new CausalException("El Id de la empresa no existe."));
	}

	@Override
	public Causal updateCausal(Causal causal) throws  CausalException {
		Calendar today = Calendar.getInstance(); 
		
		  Causal causeUpdated = getCausalById(causal.getId());
		  
		  
		 if(causeUpdated != null )
		  { 
			 System.out.println("Causal por actualizar "  + causeUpdated.toString());
			 mapCausal(causal,causeUpdated);
			 causeUpdated.setUpdated(today);
		     
			 causeUpdated = repository.save(causeUpdated);
		     
		     System.out.println("Empresa actualizada " + causeUpdated.toString());
		  
		  }else { 
			  throw new CausalException("La causal " + causal.getId() + "  no está disponible para actualizar"); }
		  
		  return causeUpdated;
	}

	@Override
	public void deleteCausal(Long id) throws CausalException {
		 Causal causeUpdated = getCausalById(id);
		if (causeUpdated != null) {
			repository.deleteById(id);
			
			
		}else {
			throw new CausalException("La causal " + id + "  no está disponible para eliminar");
		}
		
	}

	
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapCausal(Causal from,Causal to) {
		
		to.setCausalClasification(from.getCausalClasification());
		to.setCausalCumplimiento(from.getCausalCumplimiento());
		to.setCausalDescription(from.getCausalDescription());
		to.setCausalExclusiva(from.getCausalExclusiva());
		to.setCausalFraction(from.getCausalFraction());
		to.setCausalOsCe(from.getCausalOsCe());
		to.setCausalType(from.getCausalType());
		to.setCreated(from.getCreated());
		to.setCumplimientoList(from.getCumplimientoList());
		to.setInstructionList(from.getInstructionList());
		to.setUpdated(from.getUpdated());
		

	}

	@Override
	public Set<Cumplimiento> getCumplimiento(Long id) throws CausalException {
		Causal causeUpdated = getCausalById(id);
		Set<Cumplimiento> cumplimiento;  
		  
		 if(causeUpdated != null )
		  { 
			 cumplimiento = causeUpdated.getCumplimientoList();
		  
		  }else { 
			  throw new CausalException("La causal " + id + "  no está disponible para obtener su cumplimientor"); }
		  
		  return cumplimiento;
	}
	
	
}
