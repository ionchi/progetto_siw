package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Result;

public interface ResultDao {
	
	public List<Result> listResult();

	public void insertResult(Result result);

	public void deleteResult(Integer resId);

}
