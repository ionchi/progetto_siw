package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.PatientDao;
import it.uniroma3.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientDao patientDao; 

	@Override
	public List<Patient> listPatient() {
		return this.patientDao.listPatient();
	}

	@Override
	public void insertPatient(Patient patient) {
		this.patientDao.insertPatient(patient);
	}

	@Override
	public void deletePatient(Integer patID) {
		this.patientDao.deletePatient(patID);
	}
}
