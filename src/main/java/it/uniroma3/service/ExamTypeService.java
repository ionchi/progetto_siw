package it.uniroma3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.ExamType;

public interface ExamTypeService {

	public List<ExamType> listExamType();
	
	public ExamType findExamTypeById(Integer examTypeId);

	@Secured({"ROLE_ADMIN"})
	public void insertExamType(ExamType examType);
	
	@Secured({"ROLE_ADMIN"})
	public void deleteExamType(Integer examTypeId);
	
}
