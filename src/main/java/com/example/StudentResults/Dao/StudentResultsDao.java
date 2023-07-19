package com.example.StudentResults.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.StudentResults.Entity.Results;
import com.example.StudentResults.Repository.StudentResultsRepository;

@Repository
public class StudentResultsDao {
	@Autowired
	StudentResultsRepository srr;
	public String insertResult(Results r) {
		srr.save(r);
		return "SUCCESS";
	}
	public Results getTopper(@RequestBody Results r) {
		return srr.getTopper(r);
	}
	public List<Results> getTopthree(@RequestBody Results r) {
		return srr.getTopthree(r);
	}
	public List<Results> getRange(@RequestBody Results r) {
		return srr.getRange(r);
	}

}
