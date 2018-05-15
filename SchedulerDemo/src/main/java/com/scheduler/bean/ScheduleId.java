package com.scheduler.bean;

import javax.persistence.Embeddable;

@Embeddable
public class ScheduleId {
	private String candId;
	private String interviewerId;
	public String getCandId() {
		return candId;
	}
	public void setCandId(String candId) {
		this.candId = candId;
	}
	public String getInterviewerId() {
		return interviewerId;
	}
	public void setInterviewerId(String interviewerId) {
		this.interviewerId = interviewerId;
	}
	
}
