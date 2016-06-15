package it.uniroma3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.Doctor;
import it.uniroma3.model.Exam;

public interface DoctorService {
	
	public List<Doctor> listDoctor();
	
	public Doctor findDoctorById(Integer docId);

	@Secured({"ROLE_ADMIN"})
	public void insertDoctor(Doctor doctor);
	
	@Secured({"ROLE_ADMIN"})
	public void deleteDoctor(Integer docId);
	
	@Secured({"ROLE_ADMIN"})
	public List<Exam> findExamsByDoctor(String firstName, String lastName);

	
}
