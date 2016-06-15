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

import it.uniroma3.model.Exam;

@Repository
public class ExamDaoImpl implements ExamDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ExamDaoImpl.class);
	
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;


	@Override
	public List<Exam> listExam() {
		Query query = em.createQuery("SELECT e FROM Exam e");
		@SuppressWarnings("unchecked")
		List<Exam> exList = query.getResultList();
		logger.info("Exam List::" + exList);
		return exList;
	}

	@Override
	@Transactional
	public void insertExam(Exam exam) {
		em.persist(exam);
	}

	@Override
	@Transactional
	public void deleteExam(Integer examId) {
		Exam e=em.find(Exam.class , examId);
		em.remove(e);
	}
	
	@Override
	@Transactional
	public List<Exam> listExamPatient(String username) {
		Query query = em.createQuery("SELECT e FROM Exam e WHERE e.patient.username = :username",Exam.class);
		@SuppressWarnings("unchecked")
		List<Exam> exList = query.setParameter("username", username).getResultList();
		logger.info("Exam List::" + exList);
		return exList;
	}
}
