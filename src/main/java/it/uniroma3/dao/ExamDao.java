package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Exam;

public interface ExamDao {
	
	public List<Exam> listExam();

	public void insertExam(Exam exam);

	public void deleteExam(Integer examId);
	
	public List<Exam> listExamPatient(String username);

}
