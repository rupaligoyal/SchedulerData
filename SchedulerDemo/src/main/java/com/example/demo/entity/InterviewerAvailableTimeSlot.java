package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "interviewer_availabletimeslot")
public class InterviewerAvailableTimeSlot implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long seq_nbr;
	
	//@ManyToOne (targetEntity = Candidate.class)
	//@JoinColumn(name = "cand_id", referencedColumnName = "candId", nullable=false)
	//private Candidate candidate;
	
	//private String id;
	
	private String slotNum;
	private String slotDate;
	private String slotRange;
	
	
	/*public Long getSeq_nbr() {
		return seq_nbr;
	}
	public void setSeq_nbr(Long seq_nbr) {
		this.seq_nbr = seq_nbr;
	}*/
	//@Id
	//@ManyToOne (targetEntity = Candidate.class)
	//@JoinColumn(name= "cand_id")
	/*public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}*/
	
	public String getSlotNum() {
		return slotNum;
	}
	
	public void setSlotNum(String slotNum) {
		this.slotNum = slotNum;
	}
	public String getSlotDate() {
		return slotDate;
	}
	public void setSlotDate(String slotDate) {
		this.slotDate = slotDate;
	}
	public String getSlotRange() {
		return slotRange;
	}
	public void setSlotRange(String slotRange) {
		this.slotRange = slotRange;
	}
}
