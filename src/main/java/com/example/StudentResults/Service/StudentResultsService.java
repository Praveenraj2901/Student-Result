package com.example.StudentResults.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.StudentResults.Dao.StudentResultsDao;
import com.example.StudentResults.Entity.Results;

@Service
public class StudentResultsService {
	@Autowired
	StudentResultsDao srd;
	public String insertResult(Results r) {
		return srd.insertResult(r);
	}
	public Results getTopper(@RequestBody Results r) {
		return srd.getTopper(r);
	}
	public List<Results> getTopthree(@RequestBody Results r) {
		return srd.getTopthree(r);
	}
	public List<Results> getRange(@RequestBody Results r) {
		return srd.getRange(r);
	}

}
