package it.uniroma3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.Exam;

public interface ExamService {
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<Exam> listExam();
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<Exam> listExamPatient(String nomePaziente);

	@Secured({"ROLE_ADMIN"})
	public void insertExam(Exam exam);
	
	@Secured({"ROLE_ADMIN"})
	public void deleteExam(Integer examId);

}
