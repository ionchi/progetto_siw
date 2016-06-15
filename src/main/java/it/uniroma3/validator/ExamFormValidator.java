package it.uniroma3.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.model.Exam;

public class ExamFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Exam.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {		
		// TODO Auto-generated method stub
	}

}
