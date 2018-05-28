package com.example.demo.model;

import java.util.Date;

public class AvailableTimeSlotsModel {	
	private Long id;
	
	private String slotNum;
	private String slotDate;
	private String slotRange;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
