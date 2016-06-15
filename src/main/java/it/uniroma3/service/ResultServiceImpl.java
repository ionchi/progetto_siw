package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.ResultDao;
import it.uniroma3.model.Result;

@Service
public class ResultServiceImpl implements ResultService {
	
	@Autowired
	private ResultDao resultDao;

	@Override
	public List<Result> listResult() {
		return this.resultDao.listResult();
	}

	@Override
	public void insertPrerequisite(Result result) {
		this.resultDao.insertResult(result);
	}

	@Override
	public void deleteResult(Integer resId) {
		this.resultDao.deleteResult(resId);
	} 

}
