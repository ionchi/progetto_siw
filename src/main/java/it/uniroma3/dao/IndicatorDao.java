package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Indicator;

public interface IndicatorDao {
	
	public List<Indicator> listIndicator();

	public void insertIndicator(Indicator indicator);

	public void deleteIndicator(Integer indId);

}
