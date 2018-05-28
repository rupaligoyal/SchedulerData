package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
	@EmbeddedId
	private ScheduleId id; 
	
	private String timeOfInterview;
	private String interviewStatus;
	
	
	public ScheduleId getId() {
		return id;
	}
	public void setId(ScheduleId id) {
		this.id = id;
	}
	public String getTimeOfInterview() {
		return timeOfInterview;
	}
	public void setTimeOfInterview(String timeOfInterview) {
		this.timeOfInterview = timeOfInterview;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	
	
}
