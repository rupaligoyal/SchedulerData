package com.scheduler.bean;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_candidate")
public class Candidate {

	@Id
	private String candId;
	
	private String firstname;
	private String lastname;
	private String priority;
	
	@OneToMany(mappedBy = "id")
	private Set<AvailableTimeSlots> availableTimeSlot;
	
	private String status;
	private String feedback;
	private String emailId;
	
	public String getCandId() {
		return candId;
	}
	public void setCandId(String candId) {
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
	
	public Set<AvailableTimeSlots> getAvailableTimeSlot() {
		return availableTimeSlot;
	}
	public void setAvailableTimeSlot(Set<AvailableTimeSlots> availableTimeSlot) {
		this.availableTimeSlot = availableTimeSlot;
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
}
