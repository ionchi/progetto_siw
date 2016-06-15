package it.uniroma3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.Patient;

public interface PatientService {
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<Patient> listPatient();

	@Secured({"ROLE_ADMIN"})
	public void insertPatient(Patient patient);
	
	@Secured({"ROLE_ADMIN"})
	public void deletePatient(Integer patID);

}
