package com.hackfse.fms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "event_info")
public class EventInfo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	String eventId;
	String location;
	String benefeciary;
	String eventName;
	String eventDate;
	int empId;
	String empName;
	String bu;
	public int getId() {
		return id;
	}
	public void setId(int id2) {
		this.id = id2;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBenefeciary() {
		return benefeciary;
	}
	public void setBenefeciary(String benefeciary) {
		this.benefeciary = benefeciary;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getBu() {
		return bu;
	}
	public void setBu(String bu) {
		this.bu = bu;
	}
	
	
}
