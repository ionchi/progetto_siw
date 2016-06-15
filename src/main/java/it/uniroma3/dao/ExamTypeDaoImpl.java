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

import it.uniroma3.model.ExamType;
import it.uniroma3.model.Prerequisite;

@Repository
public class ExamTypeDaoImpl implements ExamTypeDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ExamTypeDaoImpl.class);
	
	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Override
	public List<ExamType> listExamType() {
		Query query = em.createQuery("SELECT et FROM ExamType et");
		@SuppressWarnings("unchecked")
		List<ExamType> exTypeList = query.getResultList();
		logger.info("ExamType List::" + exTypeList);
		return exTypeList;
	}

	@Override
	@Transactional
	public void insertExamType(ExamType examType) {
		em.persist(examType);
	}

	@Override
	@Transactional
	public void deleteExamType(Integer examTypeId) {
		ExamType et = em.find(ExamType.class, examTypeId);
		em.remove(et);
	}

	@Override
	@Transactional
	public ExamType findExamTypeById(Integer examTypeId) {
		ExamType et = em.find(ExamType.class, examTypeId);
		Prerequisite pre = em.find(Prerequisite.class, examTypeId);
		et.getPrerequisites().add(pre);
		return et;
	}
}
