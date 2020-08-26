/**
 * 
 */
package com.cucoex.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import com.cucoex.exception.CustomeFieldValidationException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cucoex.dto.ChangePasswordForm;
import com.cucoex.entity.Company;
import com.cucoex.entity.User;
import com.cucoex.exception.CompanyException;
import com.cucoex.exception.CustomeFieldValidationException;
import com.cucoex.exception.UsernameOrIdNotFound;
import com.cucoex.service.CompanyService;
import com.cucoex.service.ImpExpTypeService;


/**
 * @author enrique
 *
 */
@Controller
public class CompanyController {
	
	
	private final String TAB_FORM = "formTab";
	private final String TAB_LIST = "listTab";
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	ImpExpTypeService impExpTypeService;
	
	
	/**
	 * 
	 */
	public CompanyController() {
		
	}
	
	// Cata,ogo de usuarios
		@GetMapping({"/companies"})
		public String getCompanyList(Model model) {
			baseAttributerForCompanyForm(model, new Company(), TAB_LIST );	
			return "company";
		}
		
		// Crear nueva empresa
		@PostMapping("/companyForm")
		public String createCompany(@Valid @ModelAttribute("companyForm")Company company, BindingResult result, Model model) {
			if(result.hasErrors()) {
				baseAttributerForCompanyForm(model, company, TAB_FORM);
			}else {
				try {
					/*
					 * Date date = new Date(); Timestamp ts=new Timestamp(date.getTime());
					 */
					Calendar hoy = Calendar.getInstance();
					company.setCreated(hoy);
					company.setUpdated(hoy);
					companyService.createCompany(company);
					
					baseAttributerForCompanyForm(model, new Company(), TAB_LIST );
					
					/* } catch (CustomeFieldValidationException cfve) {
					result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
					baseAttributerForCompanyForm(model, company, TAB_FORM );*/
				}catch (Exception e) {
					// Esta excepcion es la que viene de la BD y no es amigable
					model.addAttribute("formErrorMessage",e.getMessage());
					baseAttributerForCompanyForm(model, company, TAB_FORM );
				}
			}
			return "company";
		}
		
		
		@PostMapping("/editCompany")
		public String postEditCompanyForm(@Valid @ModelAttribute("companyForm")Company company, BindingResult result, Model model) {
			
			  if(result.hasErrors()) { 
				  		baseAttributerForCompanyForm(model, company, TAB_FORM );
			  			model.addAttribute("editMode","true");
						/*
						 * model.addAttribute("passwordForm",new ChangePasswordForm(user.getId()));
						 */
			  }else { 
				  /*
				   * try {
			  
			 Date date = new Date(); Timestamp ts=new Timestamp(date.getTime()); Calendar
			  hoy = Calendar.getInstance(); user.setCreated(hoy); user.setLastUpdated(hoy);
			  
			  userService.updateUser(user); baseAttributerForUserForm(model, new User(),
			  TAB_LIST ); } catch (Exception e) {
			  model.addAttribute("formErrorMessage",e.getMessage());
			  
			  baseAttributerForUserForm(model, user, TAB_FORM );
			  model.addAttribute("editMode","true"); model.addAttribute("passwordForm",new
			  ChangePasswordForm(user.getId())); }*/ 
				  
			  }
			 
			return "company";
			
		}
		
		@GetMapping("/editCompany/{id}")
		public String getEditCompanyForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
		
			System.out.println("Entrando a getEditCompanyForm con Id " + id);
			Company companyToEdit;
				companyToEdit = companyService.getCompanyById(id);
				baseAttributerForCompanyForm(model, companyToEdit, TAB_FORM );
			
			model.addAttribute("editMode","true");
			/* model.addAttribute("passwordForm",new ChangePasswordForm(id)); */

			//return "company";
			return "catCompany/CompanyViewEditMode";
			
	 		
		}
		
		
		@GetMapping("/companyForm/cancel")
		public String cancelEditCompany(ModelMap model) {
			System.out.println("Entrando a companyFormCancel");
			return "redirect:/companies";
			//return "user";
		}
		
		
		@GetMapping("/deleteCompany/{id}")
		public String deleteUser(Model model, @PathVariable(name="id")Long id) {
			try {
				System.out.println("Borrando empresa " +id);
				companyService.deleteCompany(id);
			
			} 
			catch (CompanyException uoin) {
				System.out.println("Excepcion al borrar empresa " +id);
				model.addAttribute("listErrorMessage",uoin.getMessage());
			} catch (SQLIntegrityConstraintViolationException e) {
				model.addAttribute("listErrorMessage","La empresa no puede eliminarse mientras contenga asignados Tipo de Imp/Ext, Causales, etc");
				System.out.println(e.getStackTrace());
			} catch (Exception ex) {
				model.addAttribute("listErrorMessage","La empresa no puede eliminarse mientras contenga asignados Tipo de Imp/Ext, Causales, etc");
				System.out.println(ex.getStackTrace());
			}finally {

				baseAttributerForCompanyForm(model, new Company(), TAB_LIST );
			}
			
			return "redirect:/companies";

		}
		
		private void baseAttributerForCompanyForm(Model model, Company company,String activeTab) {
			model.addAttribute("companyForm", company);
			model.addAttribute("companyList",companyService.getAllCompanies());
			model.addAttribute("impExpTypes", impExpTypeService.getAllImpExpType());
			model.addAttribute(activeTab,"active");
		}
		
		
	
		
}
