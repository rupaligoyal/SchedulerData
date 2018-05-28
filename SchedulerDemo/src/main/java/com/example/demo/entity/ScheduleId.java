package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ScheduleId implements Serializable{
	private String candidateEmailId;
	private String interviewerEmailId;
	public String getCandidateEmailId() {
		return candidateEmailId;
	}
	public void setCandidateEmailId(String candidateEmailId) {
		this.candidateEmailId = candidateEmailId;
	}
	public String getInterviewerEmailId() {
		return interviewerEmailId;
	}
	public void setInterviewerEmailId(String interviewerEmailId) {
		this.interviewerEmailId = interviewerEmailId;
	}
}
