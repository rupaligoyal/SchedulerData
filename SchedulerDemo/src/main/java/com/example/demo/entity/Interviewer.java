package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Table(name = "interviewer")
@Builder
public class Interviewer {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long empId;
	private String firstname;
	private String lastname;
	private String priority;
	
	@OneToMany(cascade=CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_id", referencedColumnName = "empId", nullable=false)
	private Set<InterviewerAvailableTimeSlot> availableTimeSlot=new HashSet<>(0);
	
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
	
	public Set<InterviewerAvailableTimeSlot> getAvailableTimeSlot() {
		return availableTimeSlot;
	}
	public void setAvailableTimeSlot(Set<InterviewerAvailableTimeSlot> availableTimeSlot) {
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
	
	@Override
	public boolean equals(Object obj) {
		Interviewer interviewer;
		try {
			interviewer = (Interviewer) obj;
		} catch (Exception e) {
			return false;
		}
		return this.getEmailId().equals(interviewer != null ? interviewer.getEmailId() : null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		return result;
	}
}
