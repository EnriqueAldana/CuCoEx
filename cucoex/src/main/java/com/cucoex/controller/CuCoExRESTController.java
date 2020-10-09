/**
 * 
 */
package com.cucoex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cucoex.entity.Causal;
import com.cucoex.entity.Company;
import com.cucoex.entity.ImpExpType;
import com.cucoex.entity.Status;
import com.cucoex.exception.CausalException;
import com.cucoex.exception.CompanyException;
import com.cucoex.service.CausalServiceImpl;
import com.cucoex.service.CompanyService;

/**
 * @author enrique
 *
 */
@RestController
public class CuCoExRESTController {
	
	@Autowired
	CausalServiceImpl causalService;
	
	@Autowired
	CompanyService companyService;

	
	
	@GetMapping(value = "impExpTypes/{companyId}")
    public Company impExpTypes(@PathVariable Long companyId) {
		Company ret = null;
		
		Company companyFounded = new Company();
		try {
			companyFounded = companyService.getCompanyById(companyId);
		
			if (!companyFounded.equals(null)) {
				ret= companyFounded;
			}
			
			
		} catch (CompanyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ret;

      
    }
	
	@GetMapping(value = "status/{companyId}")
    public List<Status> getAllStatus(@PathVariable String companyId) {
		
		List<Status> lista = new ArrayList<Status>();
		lista.add(new Status("TEST" , "TESTNAME","Test description"));
		lista.add(new Status("Prueba" , "PruebaNAME","Descripcion de prueba"));
		return lista;

      
    }
	

	/**
	 * 
	 */
	public CuCoExRESTController() {
		
	}

}
