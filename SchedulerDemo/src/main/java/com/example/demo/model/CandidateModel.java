package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

public class CandidateModel {
	private Long candId;	
	private String firstname;
	private String lastname;
	private String priority;
	private Set<AvailableTimeSlotsModel> availableTimeSlot= new HashSet<>(0);
	private String status;
	private String feedback;
	private String emailId;
	
	public Long getCandId() {
		return candId;
	}
	public void setCandId(Long candId) {
		this.candId = candId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Set<AvailableTimeSlotsModel> getAvailableTimeSlot() {
		return availableTimeSlot;
	}
	public void setAvailableTimeSlot(Set<AvailableTimeSlotsModel> availableTimeSlot) {
		this.availableTimeSlot = availableTimeSlot;
	}
}
