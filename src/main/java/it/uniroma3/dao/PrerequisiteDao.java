package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Prerequisite;

public interface PrerequisiteDao {
	
	public List<Prerequisite> listPrerequisite();

	public void insertPrerequisite(Prerequisite prerequisite);
	
	public void insertPreToType(Integer examTypeId, Prerequisite prerequisite);

	public void deletePrerequisite(Integer preId);

}
