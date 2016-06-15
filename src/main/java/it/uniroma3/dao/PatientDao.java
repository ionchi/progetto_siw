package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Patient;

public interface PatientDao {

	public List<Patient> listPatient();

	public void insertPatient(Patient patient);

	public void deletePatient(Integer patientId);

}
