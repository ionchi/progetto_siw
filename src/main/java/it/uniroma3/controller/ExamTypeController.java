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

import it.uniroma3.model.ExamType;
import it.uniroma3.service.ExamTypeService;

@Controller
@RequestMapping("/admin")
public class ExamTypeController extends WebMvcConfigurerAdapter {

	@Autowired
	private ExamTypeService examTypeService;

	@Autowired
	@Qualifier("examTypeValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@ModelAttribute("examtype")
	public ExamType createExamTypeModel() {
		return new ExamType();
	}

	@RequestMapping(value = "/addexamtype", method = RequestMethod.GET)
	public String addExamType(Model model) {
		return "/addexamtype";
	}

	@RequestMapping(value = "/listexamtype", method =  RequestMethod.GET)
	public String listExamType(Model model) {
		model.addAttribute("examsTypeList",	examTypeService.listExamType());
		return "examtype";
	}

	@RequestMapping(value = "/updateexamtype", method = RequestMethod.POST)
	public String updateExamType(@ModelAttribute("examtype") @Validated ExamType examType, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) 
			return "addexamtype";
		this.examTypeService.insertExamType(examType);
		model.addAttribute("examsTypeList",	examTypeService.listExamType());
		return "examtype";
	}

	@RequestMapping(value = "/deleteT/{examTypeId}", method = RequestMethod.GET)
	public String deleteExamType(@PathVariable("examTypeId") Integer examTypeId, Model model) {
		this.examTypeService.deleteExamType(examTypeId);
		model.addAttribute("examsTypeList",	examTypeService.listExamType());
		return "examtype";
	}
}
