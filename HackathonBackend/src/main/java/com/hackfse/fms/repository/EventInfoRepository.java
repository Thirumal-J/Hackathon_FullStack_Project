package com.hackfse.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hackfse.fms.model.DistinctEvent;
import com.hackfse.fms.model.EventInfo;

public interface EventInfoRepository extends CrudRepository<EventInfo, Long>  {

	@Query("SELECT DISTINCT e.eventId FROM event_info e")
	List<String> findDistinctEvent();
	
	@Query("SELECT DISTINCT e.eventName FROM event_info e where e.eventId = :eventId")
	String findDistinctEventName(@Param("eventId") String eventId);
}
