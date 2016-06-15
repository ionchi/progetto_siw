package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Doctor;
import it.uniroma3.model.Exam;

public interface DoctorDao {
	
	public List<Doctor> listDoctor();

	public void insertDoctor(Doctor doctor);

	public void deleteDoctor(Integer docId);
	
	public List<Exam> findExamsByDoctor(String firstName, String lastName);
	
	public Doctor findDoctorById(Integer docId);
}
