package com.hackfse.fms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "feedback")
public class Feedback {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	int empId;
	
	String eventId;
	String rating;
	String likeAbout;
	String improvement;
	
	public String getLikeAbout() {
		return likeAbout;
	}
	public void setLikeAbout(String likeAbout) {
		this.likeAbout = likeAbout;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getImprovement() {
		return improvement;
	}
	public void setImprovement(String improvement) {
		this.improvement = improvement;
	}
	
	
	
}
