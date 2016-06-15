package it.uniroma3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.Prerequisite;

public interface PrerequisiteService {
	
	public List<Prerequisite> listPrerequisite();

	@Secured({"ROLE_ADMIN"})
	public void insertPrerequisite(Prerequisite prerequisite);
	
	@Secured({"ROLE_ADMIN"})
	public void insertPreToType(Integer examTypeId, Prerequisite prerequisite);
	
	@Secured({"ROLE_ADMIN"})
	public void deletePrerequisite(Integer preId);

}
