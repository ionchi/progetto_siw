package it.uniroma3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.uniroma3.model.Indicator;

@Repository
public class IndicatorDaoImpl implements IndicatorDao {

	private static final Logger logger = LoggerFactory.getLogger(IndicatorDaoImpl.class);

	@Autowired
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

	@Override
	public List<Indicator> listIndicator() {
		Query query = em.createQuery("SELECT i FROM indicator i");
		@SuppressWarnings("unchecked")
		List<Indicator> indList = query.getResultList();
		logger.info("Indicator List::" + indList);
		return indList;
	}

	@Override
	public void insertIndicator(Indicator indicator) {
		em.persist(indicator);
	}

	@Override
	public void deleteIndicator(Integer indId) {
		Indicator i = em.find(Indicator.class, indId);
		em.remove(i);
	}

}
