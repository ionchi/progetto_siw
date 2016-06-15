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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import it.uniroma3.model.Doctor;
import it.uniroma3.service.DoctorService;

@Controller
@RequestMapping("/admin")
public class DoctorController extends WebMvcConfigurerAdapter {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	@Qualifier("doctorValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@ModelAttribute("doctor")
	public Doctor createDoctorModel() {
		return new Doctor();
	}
	
	@RequestMapping(value = "/listdoctor", method =  RequestMethod.GET)
	public String listDoctors(Model model) {
		model.addAttribute("doctorsList", doctorService.listDoctor());
		return "doctor";
	}
	
	@RequestMapping(value = "/adddoctor", method = RequestMethod.GET)
	public String addDoctor(Model model) {
		return "/adddoctor";
	}
	
	@RequestMapping(value = "/updatedoctor", method = RequestMethod.POST)
	public String updateDoctor(@ModelAttribute("doctor") @Validated Doctor doctor, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) 
			return "adddoctor";
		doctorService.insertDoctor(doctor);
		model.addAttribute("doctorsList", doctorService.listDoctor());
		return "doctor";
	}
	
	@RequestMapping(value = "/deleteD/{docId}", method =	RequestMethod.GET)
	public String deleteDoctor(@PathVariable("docId") Integer docId, Model model) {
		this.doctorService.deleteDoctor(docId);
		model.addAttribute("doctorsList", doctorService.listDoctor());
		return "doctor";
	}
	
	@RequestMapping(value = "/searchdoctor", method = RequestMethod.GET)
	public String searchDoctor(Model model) {
		return "/searchdoctor";
	}
	
	@RequestMapping(value = "/doctorexams", method = RequestMethod.POST)
	public String findExamsByDoctor(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, Model model) {
		model.addAttribute("doctorExamList", this.doctorService.findExamsByDoctor(firstName, lastName));
		return "/doctorexams";
	}
	

}
