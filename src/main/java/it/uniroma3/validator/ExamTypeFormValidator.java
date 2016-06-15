package it.uniroma3.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.model.ExamType;

public class ExamTypeFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return ExamType.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		ExamType exty = (ExamType) obj;
		
		if(exty.getCost() <=0){
			errors.rejectValue("cost", "negativeValue", new Object[]{"'Il costo'"}, "il costo non puo' essere negativo");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cost", "cost.required");		
	}

}
