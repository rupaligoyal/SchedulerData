package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CandidateModel;
import com.example.demo.model.InterviewResult;
import com.example.demo.model.InterviewerModel;
import com.example.demo.model.ScheduleModel;
import com.example.demo.schedule.SchedulerRepository;
import com.example.demo.schedule.SchedulerService;

@RestController
@RequestMapping("/schedule")
public class SchedulerRestController {
	@Autowired
	SchedulerService schedulerService;
	
	@RequestMapping(value = "/searchInterviewersByCandidate/{id}", method = RequestMethod.GET, consumes="application/json")
	public List<InterviewerModel> serachAvailableInterviewerForCandidate(@PathVariable Long id) {
		try {
			return schedulerService.serachAvailableInterviewerForCandidate(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/schedule/{emailId}", method = RequestMethod.GET, consumes="application/json")
	public ScheduleModel scheduleInterviewByCandidate(@PathVariable String emailId) {
		try {
			return schedulerService.scheduleInterviewByCandidateEmail(emailId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*@RequestMapping(value = "/update", method = RequestMethod.GET, consumes="application/json")
	public ScheduleModel updateInterviewResult(InterviewResult result) {
		try {
			return schedulerService.updateInterviewResult(result);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}*/
	
	@RequestMapping(value = "/scheduleAll", method = RequestMethod.GET, consumes="application/json")
	public void scheduleInterviewAll() {
		try {
			schedulerService.scheduleInterviewForAll();
		} catch (Exception e) {
			e.printStackTrace();
			//return null;
		}
	}
}
