package com.example.demo.entity;

import java.io.Serializable;
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

@Entity
@Table(name = "candidate")
public class Candidate implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long candId;
	
	private String firstname;
	private String lastname;
	private String priority;
	
	//@OneToMany(mappedBy="candidate", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cand_id", referencedColumnName = "candId", nullable=false)
	private Set<CandidateAvailableTimeSlot> availableTimeSlot = new HashSet<>(0);
	
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
	
	public Set<CandidateAvailableTimeSlot> getAvailableTimeSlot() {
		return availableTimeSlot;
	}
	public void setAvailableTimeSlot(Set<CandidateAvailableTimeSlot> availableTimeSlot) {
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
