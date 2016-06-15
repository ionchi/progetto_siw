package it.uniroma3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.Indicator;

public interface IndicatorService {
	
	public List<Indicator> listIndicator();

	@Secured({"ROLE_ADMIN"})
	public void insertIndicator(Indicator indicator);
	
	@Secured({"ROLE_ADMIN"})
	public void deleteIndicator(Integer indId);


}
