package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.uniroma3.model.Result;

@Repository
public class ResultDaoImpl implements ResultDao {

	private static final Logger logger = LoggerFactory.getLogger(ResultDaoImpl.class);

	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Override
	public List<Result> listResult() {
		Query query = em.createQuery("SELECT r FROM result r");
		@SuppressWarnings("unchecked")
		List<Result> resList = query.getResultList();
		logger.info("Result List::" + resList);
		return resList;
	}

	@Override
	public void insertResult(Result result) {
		em.persist(result);
	}

	@Override
	public void deleteResult(Integer resId) {
		Result r = em.find(Result.class, resId);
		em.remove(r);
	}

}
