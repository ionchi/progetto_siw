package it.uniroma3.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DoctorFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return true;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "specialization", "specialization.required");

	}

}