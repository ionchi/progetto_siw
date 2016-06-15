package it.uniroma3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.service.ExamTypeService;

@Controller
public class PublicController {
	
	@Autowired
	private ExamTypeService examTypeService;
	
	@RequestMapping(value = "/examtype", method =  RequestMethod.GET)
	public String listExamType(Model model) {
		model.addAttribute("examsTypeList",	examTypeService.listExamType());
		return "examtypepublic";
	}
	
	@RequestMapping(value = "/examtypedetail/{examTypeId}", method =  RequestMethod.GET)
	public String examTypeDetail(@PathVariable("examTypeId") Integer examTypeId, Model model) {
		model.addAttribute("examtype", examTypeService.findExamTypeById(examTypeId));
		model.addAttribute("prerequisteList", examTypeService.findExamTypeById(examTypeId).getPrerequisites());
		return "examtypedetail";
	}
	
	@RequestMapping(value = "/workinprogress", method =  RequestMethod.GET)
	public String workInProgress(Model model) {
		return "workinprogress";
	}
	
	@RequestMapping(value = "/about", method =  RequestMethod.GET)
	public String aboutPage(Model model) {
		return "about";
	}
}
