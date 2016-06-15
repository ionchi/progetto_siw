package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.IndicatorDao;
import it.uniroma3.model.Indicator;

@Service
public class IndicatorServiceImpl implements IndicatorService{
	
	@Autowired
	private IndicatorDao indicatorDao;

	@Override
	public List<Indicator> listIndicator() {
		return this.indicatorDao.listIndicator();
	}

	@Override
	public void insertIndicator(Indicator indicator) {
		this.indicatorDao.insertIndicator(indicator);
	}

	@Override
	public void deleteIndicator(Integer indId) {
		this.indicatorDao.deleteIndicator(indId);
	} 

}
