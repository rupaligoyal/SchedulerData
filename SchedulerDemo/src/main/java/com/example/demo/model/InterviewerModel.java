package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

public class InterviewerModel {
	private Long empId;
	private String firstname;
	private String lastname;
	private String priority;
	private Set<AvailableTimeSlotsModel> availableTimeSlot = new HashSet<>(0);	
	private String avilabilityStatus;
	private String emailId;
	private String managerEmailId;
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
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
	
	public Set<AvailableTimeSlotsModel> getAvailableTimeSlot() {
		return availableTimeSlot;
	}
	public void setAvailableTimeSlot(Set<AvailableTimeSlotsModel> availableTimeSlot) {
		this.availableTimeSlot = availableTimeSlot;
	}
	public String getAvilabilityStatus() {
		return avilabilityStatus;
	}
	public void setAvilabilityStatus(String avilabilityStatus) {
		this.avilabilityStatus = avilabilityStatus;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getManagerEmailId() {
		return managerEmailId;
	}
	public void setManagerEmailId(String managerEmailId) {
		this.managerEmailId = managerEmailId;
	}
}
