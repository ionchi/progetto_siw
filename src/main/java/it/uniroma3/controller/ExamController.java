package it.uniroma3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

import it.uniroma3.model.Exam;
import it.uniroma3.service.ExamService;

@Controller
@RequestMapping("/user")
public class ExamController extends WebMvcConfigurerAdapter{
	
	@Autowired
	private ExamService examService;

	@Autowired
	@Qualifier("examValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@ModelAttribute("exam")
	public Exam createExamModel() {
		return new Exam();
	}

	@RequestMapping(value = "/addexam", method = RequestMethod.GET)
	public String addExam(Model model) {
		return "/addexam";
	}

	/*@RequestMapping(value = "/exam", method =  RequestMethod.GET)
	public String listExam(Model model) {
		model.addAttribute("examsList",	examService.listExam());
		return "exam";
	}*/
	
	@RequestMapping(value = "/exam", method =  RequestMethod.GET)
	public String listExamPatient(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		model.addAttribute("examsList",	examService.listExamPatient(username));
		return "exam";
	}

	@RequestMapping(value = "/updateexam", method = RequestMethod.POST)
	public String updateExam(@ModelAttribute("exam") @Validated Exam exam, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) 
			return "addexam";
		this.examService.insertExam(exam);
		model.addAttribute("examsList",	examService.listExam());
		return "exam";
	}

	@RequestMapping(value = "/deleteT/{examId}", method = RequestMethod.GET)
	public String deleteExam(@PathVariable("examId") Integer examId, Model model) {
		this.examService.deleteExam(examId);
		model.addAttribute("examsList",	examService.listExam());
		return "exam";
	}

}
