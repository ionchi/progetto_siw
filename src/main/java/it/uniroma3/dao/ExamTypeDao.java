package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.ExamType;

public interface ExamTypeDao {
	
	public List<ExamType> listExamType();
	
	public ExamType findExamTypeById(Integer examTypeId);

	public void insertExamType(ExamType examType);

	public void deleteExamType(Integer examTypeId);

}
