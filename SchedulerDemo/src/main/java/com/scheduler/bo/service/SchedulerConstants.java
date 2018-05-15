package com.scheduler.bo.service;


public interface SchedulerConstants {
	public static String CANDIDATE_STATUS_NEW="N";
	public static String CANDIDATE_STATUS_SCHEDULED="S";
	public static String INTERVIEW_COMPLETED="C";
	public static String CANDIDATE_STATUS_ACCEPTED="A";
	public static String CANDIDATE_STATUS_REJECTED="R";
	public static String CANDIDATE_STATUS_CANCELLED="CAN";
	
	public static String INTERVIEWER_STATUS_AVAILABLE="A";
	public static String INTERVIEWER_STATUS_NOT_AVAILABLE="NA";
	
	public static String[] TIME_SLOTS = {"Slot-1","Slot-2", "Slot-12"};
	public static String  SLOT_1_TIME= "4-5";
	public static String  SLOT_2_TIME= "5-6";
	public static String  SLOT_12_TIME= "4-6";

}
