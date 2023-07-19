package com.example.StudentResults.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.StudentResults.Entity.Results;

public interface StudentResultsRepository extends JpaRepository<Results, Integer> {
	@Query(value="select * from results where total_marks=(select max(total_marks) from results)",nativeQuery = true)
	public Results getTopper(@RequestBody Results r);
	@Query(value="select * from results order by total_marks desc limit 3",nativeQuery = true)
	public List<Results> getTopthree(@RequestBody Results r);
	@Query(value="select * from results where total_marks BETWEEN 70 and 90",nativeQuery = true)
	public List<Results> getRange(@RequestBody Results r);


}
