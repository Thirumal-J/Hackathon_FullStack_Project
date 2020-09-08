package com.hackfse.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hackfse.fms.model.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
	@Query("SELECT DISTINCT f.eventId FROM feedback f")
	List<String> findDistinctEvent();
	
	@Query("select count(*) from feedback f where eventId = :event and rating = 5")
	int countFive(@Param("event") String event);
	
	@Query("select count(*) from feedback f where eventId = :event and rating = 4")
	int countFour(@Param("event") String event);
	
	@Query("select count(*) from feedback f where eventId = :event and rating = 3")
	int countThree(@Param("event") String event);
	
	@Query("select count(*) from feedback f where eventId = :event and rating = 2")
	int countTwo(@Param("event") String event);
	
	@Query("select count(*) from feedback f where eventId = :event and rating = 1")
	int countOne(@Param("event") String event);
}
