package com.example.demo.schedule;

import java.util.List;

import com.example.demo.entity.Schedule;
import com.example.demo.model.InterviewResult;
import com.example.demo.model.InterviewerModel;
import com.example.demo.model.ScheduleModel;

public interface SchedulerService {
	public List<InterviewerModel> serachAvailableInterviewerForCandidate(Long id) throws Exception;
	//public ScheduleModel scheduleInterviewByCandidate(Long id) throws Exception;
	public String updateInterviewResult(InterviewResult result) throws Exception;
	ScheduleModel scheduleInterviewByCandidateEmail(String emailId) throws Exception;
	String cancelInterviewForCandidate(String candidateEmailId) throws Exception;
	List<ScheduleModel> scheduleInterviewForAll() throws Exception;
}
