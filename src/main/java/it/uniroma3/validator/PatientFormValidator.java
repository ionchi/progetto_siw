package it.uniroma3.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.model.Patient;

public class PatientFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Patient.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");

	}

}
