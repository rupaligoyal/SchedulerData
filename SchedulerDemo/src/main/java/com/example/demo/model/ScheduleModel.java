package com.example.demo.model;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class ScheduleModel {
	private String candId;
	private String interviewerId;
	private String timeOfInterview;
	private String interviewStatus;
	
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
