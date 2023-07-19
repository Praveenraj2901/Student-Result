package com.example.StudentResults.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.StudentResults.Entity.Results;
import com.example.StudentResults.Service.StudentResultsService;

@RestController
public class StudentResultsController {
	@Autowired
	StudentResultsService srs;
	@Autowired
	RestTemplate rt;

	@PostMapping(value = "/insertResult")
	public String insertResult(@RequestBody Results r) {
		String url1 = "http://localhost:8080/getAttendence/";
		String url2 = "http://localhost:8081/getSem1Total/";
		String url3 = "http://localhost:8081/getSem2Total/";
		ResponseEntity<Integer> res1 = rt.exchange(url1 + r.getRollNumber(), HttpMethod.GET, null, Integer.class);
		int att = res1.getBody();
		ResponseEntity<Integer> res2 = rt.exchange(url2 + r.getRollNumber(), HttpMethod.GET, null, Integer.class);
		int sem1 = res2.getBody();
		ResponseEntity<Integer> res3 = rt.exchange(url3 + r.getRollNumber(), HttpMethod.GET, null, Integer.class);
		int sem2 = res3.getBody();
		if (att > 90) {
			r.setTotalMarks(((sem1 + sem2) / 2) + 5);
			r.setPercentage(r.getTotalMarks());
			return srs.insertResult(r);
		} else {
			r.setTotalMarks((sem1 + sem2) / 2);
			r.setPercentage(r.getTotalMarks());
			return srs.insertResult(r);
		}
	}

	@GetMapping(value = "/getTopper")
	public Results getTopper(@RequestBody Results r) {
		return srs.getTopper(r);
	}

	@GetMapping(value = "/getTopthree")
	public List<Results> getTopthree(@RequestBody Results r) {
		return srs.getTopthree(r);
	}
	@GetMapping(value = "/getRange")
	public List<Results> getRange(@RequestBody Results r) {
		return srs.getRange(r);
	}

}
