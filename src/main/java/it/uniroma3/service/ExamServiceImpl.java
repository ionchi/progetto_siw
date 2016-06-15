package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.ExamDao;
import it.uniroma3.model.Exam;

@Service
public class ExamServiceImpl implements ExamService {
	
	@Autowired
	private ExamDao examDao;

	@Override
	public List<Exam> listExam() {
		return this.examDao.listExam();
	}

	@Override
	public void insertExam(Exam exam) {
		this.examDao.insertExam(exam);
	}

	@Override
	public void deleteExam(Integer examId) {
		this.examDao.deleteExam(examId);
	} 
	
	@Override
	public List<Exam> listExamPatient(String username) {
		return this.examDao.listExamPatient(username);
	} 

}
