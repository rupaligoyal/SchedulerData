package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.candidate.CandidateRepository;
import com.example.demo.candidate.CandidateService;
import com.example.demo.entity.Candidate;
import com.example.demo.interviewer.InterviewerService;
import com.example.demo.model.CandidateModel;
import com.example.demo.model.InterviewerModel;

@RestController
@RequestMapping("/interviewer")
public class InterviewerRestController {
	
	@Autowired
	InterviewerService interviewerService;
	
	public InterviewerRestController() {
	}
	
	@RequestMapping (value = "/create", method = RequestMethod.POST, consumes="application/json")	
	public HttpStatus createCandidate ( @RequestBody InterviewerModel interviewerModel) {
		try {
			boolean isCreated = interviewerService.createInterviewer(interviewerModel);
			
			if(isCreated) {
				return HttpStatus.OK;
			}else {
				return HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.BAD_REQUEST;
		}
	}
	
	@RequestMapping (value = "/update", method = RequestMethod.POST, consumes="application/json")	
	public String updateCandidate ( @RequestBody InterviewerModel model) {
		try {
			return interviewerService.updateInterviewer(model);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Oops. Failed to update candidate..!!";
		}
	}
	
	@RequestMapping (value = "/delete/{id}", method = RequestMethod.POST, consumes="application/json")	
	public String deleteCandidate ( @PathVariable Long id) {
		try {
			return interviewerService.deleteInterviewerById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Oops. Failed to update candidate..!!";
		}
	}
	
	@RequestMapping (value = "/search/{id}", method = RequestMethod.POST, consumes="application/json")	
	public @ResponseBody InterviewerModel searchCandidate ( @PathVariable Long id) {
		try {
			return interviewerService.searchInterviewerById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
