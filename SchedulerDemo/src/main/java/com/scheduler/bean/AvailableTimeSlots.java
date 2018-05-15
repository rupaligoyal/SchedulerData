package com.scheduler.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_availabletimeslots")
public class AvailableTimeSlots {
	//@ManyToOne
    //@JoinColumn(name= "candId", nullable=false)
	private String id;
	
	//private String id;
	
	private String slotNum;
	private Date slotDate;
	private String slotRange;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSlotNum() {
		return slotNum;
	}
	public void setSlotNum(String slotNum) {
		this.slotNum = slotNum;
	}
	public Date getSlotDate() {
		return slotDate;
	}
	public void setSlotDate(Date slotDate) {
		this.slotDate = slotDate;
	}
	public String getSlotRange() {
		return slotRange;
	}
	public void setSlotRange(String slotRange) {
		this.slotRange = slotRange;
	}
}
