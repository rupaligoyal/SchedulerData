package com.example.demo.schedule;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;

import com.example.demo.candidate.CandidateRepository;
import com.example.demo.entity.Candidate;
import com.example.demo.entity.Interviewer;
import com.example.demo.entity.Schedule;
import com.example.demo.entity.ScheduleId;
import com.example.demo.interviewer.InterviewerRepository;
import com.example.demo.model.ScheduleModel;

public class SchedulerServiceHelper {
	public static ScheduleModel buildModelFromEntity(Schedule schedule) {
		if(schedule != null) {
			//ScheduleModel.builder();
		}
		ScheduleModel scheduleModel = new ScheduleModel();
		scheduleModel.setCandId(schedule.getId().getCandidateEmailId());
		scheduleModel.setInterviewerId(schedule.getId().getInterviewerEmailId());
		scheduleModel.setInterviewStatus(schedule.getInterviewStatus());
		scheduleModel.setTimeOfInterview(schedule.getTimeOfInterview());
		return scheduleModel;
	}
	
	public static Candidate findCandidateByEmail(String emailId, CandidateRepository candidateRepository) {
		Candidate candidate = new Candidate();
		candidate.setEmailId(emailId);
		
		Example<Candidate> candidateExample = Example.of(candidate);
		
		return candidateRepository.findOne(candidateExample).get();
	}
	
	public static Interviewer findInterviewerByEmail(String emailId, InterviewerRepository repository) {
		Interviewer interviewer = new Interviewer();
		interviewer.setEmailId(emailId);
		
		Example<Interviewer> interviewExample = Example.of(interviewer);
		
		return repository.findOne(interviewExample).get();
	}
	
	public static boolean isAlreadyScheduled(String emailId, SchedulerRepository repository) {
		Schedule schedule = new Schedule();
		ScheduleId scheduleId = new ScheduleId();
		scheduleId.setCandidateEmailId(emailId);
		schedule.setId(scheduleId);
		schedule.setInterviewStatus(SchedulerConstants.SCHEDULED);
		
		Example<Schedule> scheduleExample = Example.of(schedule);
		
		List<Schedule> result = repository.findAll(scheduleExample);
		
		return result.size() > 0;
	}
}
