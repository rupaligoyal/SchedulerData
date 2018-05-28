package com.example.demo.interviewer;

import java.util.List;

import com.example.demo.entity.Candidate;
import com.example.demo.entity.Interviewer;
import com.example.demo.model.CandidateModel;
import com.example.demo.model.InterviewerModel;
import com.example.demo.util.ValidationException;

public interface InterviewerService {
	boolean createInterviewer(InterviewerModel interviewerModel) throws ValidationException;
	String updateInterviewer(InterviewerModel interviewerModel) throws ValidationException;
	List<Interviewer> searchCandidate(InterviewerModel interviewerModel) ;
	InterviewerModel searchInterviewerById(Long id) ;
	String deleteInterviewerById(Long id) ;
}
