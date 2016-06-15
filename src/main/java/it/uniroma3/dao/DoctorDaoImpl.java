package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.model.Doctor;
import it.uniroma3.model.Exam;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	private static final Logger logger = LoggerFactory.getLogger(DoctorDaoImpl.class);

	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Override
	public List<Doctor> listDoctor() {
		Query query = em.createQuery("SELECT d FROM Doctor d");
		@SuppressWarnings("unchecked")
		List<Doctor> docList = query.getResultList();
		logger.info("Doctor List::" + docList);
		return docList;
	}

	@Override
	@Transactional
	public void insertDoctor(Doctor doctor) {
		em.persist(doctor);
	}

	@Override
	@Transactional
	public void deleteDoctor(Integer docId) {
		Doctor d = em.find(Doctor.class, docId);
		em.remove(d);
	}

	@Override
	@Transactional
	public Doctor findDoctorById(Integer docId) {
		return em.find(Doctor.class, docId);
	}

	@Override
	@Transactional
	public List<Exam> findExamsByDoctor(String firstName, String lastName) {
		try{
			Doctor doc = em.createQuery(
					"SELECT d FROM Doctor d WHERE d.firstName=:firstName AND d.lastName=:lastName", Doctor.class)
					.setParameter("firstName", firstName)
					.setParameter("lastName", lastName)
					.getSingleResult();
			List<Exam> exams = em.createQuery(
					"SELECT e FROM Exam e WHERE e.doctor=:doctor", Exam.class)
					.setParameter("doctor", doc)
					.getResultList();
			return exams;
		} catch(NoResultException e) {
			return null;
		}
	}

}
