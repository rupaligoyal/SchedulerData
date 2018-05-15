package com.scheduler.bean;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_interviewer")
public class Interviewer {
	@Id
	private String empId;
	private String firstname;
	private String lastname;
	private String priority;
	
	@OneToMany(mappedBy = "id")
	private Set<AvailableTimeSlots> availableTimeSlot;
	
	private String avilabilityStatus;
	private String emailId;
	private String managerEmailId;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
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
	
	public Set<AvailableTimeSlots> getAvailableTimeSlot() {
		return availableTimeSlot;
	}
	public void setAvailableTimeSlot(Set<AvailableTimeSlots> availableTimeSlot) {
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
