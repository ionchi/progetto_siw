package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.DoctorDao;
import it.uniroma3.model.Doctor;
import it.uniroma3.model.Exam;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorDao doctorDao;

	@Override
	public List<Doctor> listDoctor() {
		return this.doctorDao.listDoctor();
	}

	@Override
	public void insertDoctor(Doctor doctor) {
		this.doctorDao.insertDoctor(doctor);
	}

	@Override
	public void deleteDoctor(Integer docId) {
		this.doctorDao.deleteDoctor(docId);
	}

	@Override
	public List<Exam> findExamsByDoctor(String firstName, String lastName) {
		return this.doctorDao.findExamsByDoctor(firstName, lastName);
	}

	@Override
	public Doctor findDoctorById(Integer docId) {
		return this.doctorDao.findDoctorById(docId);
	}


}
