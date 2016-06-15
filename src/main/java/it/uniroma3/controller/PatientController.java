package it.uniroma3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import it.uniroma3.model.Patient;
import it.uniroma3.service.PatientService;

@Controller
@RequestMapping("/admin")
public class PatientController extends WebMvcConfigurerAdapter {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	@Qualifier("patientValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@ModelAttribute("patient")
	public Patient createPatientModel() {
		return new Patient();
	}
	
	@RequestMapping(value = "/listpatient", method =  RequestMethod.GET)
	public String listPatients(Model model) {
		model.addAttribute("patientsList",	patientService.listPatient());
		return "patient";
	}
	
	@RequestMapping(value = "/addpatient", method = RequestMethod.GET)
	public String addPatient(Model model) {
		return "/addpatient";
	}
	
	@RequestMapping(value = "/updatepatient", method = RequestMethod.POST)
	public String updatePatient(@ModelAttribute("patient") @Validated Patient patient,	BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) 
			return "addpatient";
		this.patientService.insertPatient(patient);
		model.addAttribute("patientsList",	patientService.listPatient());
		return "patient";
	}
	
	@RequestMapping(value = "/deleteP/{patId}", method =	RequestMethod.GET)
	public String deletePatient(@PathVariable("patId") Integer	patId,	Model model) {
		this.patientService.deletePatient(patId);
		model.addAttribute("patientsList",	patientService.listPatient());
		return "patient";
	}

}
