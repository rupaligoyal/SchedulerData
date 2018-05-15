package com.scheduler.bo.service;

public interface SchedulerBO {
	public boolean createInterviewer();
	public boolean createCandidate();
	public boolean scheduleInterview();
	public boolean cancelInterviewer();
	public boolean sendNotifications();
	public boolean createEscalation();
}
