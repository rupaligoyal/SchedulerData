package com.example.demo.model;

public class InterviewResult {
	private String candidateEmailId;
	private String interviewedByEmailId;
	private String feedback;
	private String status;
	
	
	public String getCandidateEmailId() {
		return candidateEmailId;
	}
	public void setCandidateEmailId(String candidateEmailId) {
		this.candidateEmailId = candidateEmailId;
	}
	public String getInterviewedByEmailId() {
		return interviewedByEmailId;
	}
	public void setInterviewedByEmailId(String interviewedByEmailId) {
		this.interviewedByEmailId = interviewedByEmailId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
