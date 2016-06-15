package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {
	
	private static final Logger logger = LoggerFactory.getLogger(PatientDaoImpl.class);
	
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Override
	public List<Patient> listPatient() {
		Query query = em.createQuery("SELECT p FROM Patient p");
		@SuppressWarnings("unchecked")
		List<Patient> patList = query.getResultList();
		logger.info("Person List::" + patList);
		return patList;
	}

	@Override
	@Transactional
	public void insertPatient(Patient patient) {
		em.persist(patient);
	}

	@Override
	@Transactional
	public void deletePatient(Integer patientId) {
		Patient p = em.find(Patient.class, patientId);
        em.remove(p);
	}

}