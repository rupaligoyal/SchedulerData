package com.example.demo.interviewer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.candidate.CandidateServiceHelper;
import com.example.demo.entity.Candidate;
import com.example.demo.entity.Interviewer;
import com.example.demo.model.CandidateModel;
import com.example.demo.model.InterviewerModel;
import com.example.demo.util.ValidationException;

@Service
public class InterviewerServiceImpl implements InterviewerService {
	@Autowired
	InterviewerRepository interviewerRepository;
		
	@Override
	public boolean createInterviewer(InterviewerModel interviewerModel) throws ValidationException {

		// extract candidate object from model class
		Interviewer interviewer = InterviewerServiceHelper.extractInterviewerObjectFromModel(interviewerModel);

		// store candidate in DB
		interviewerRepository.save(interviewer);
		return true;

	}
	
	@Override
	public String updateInterviewer(InterviewerModel interviewerModel) throws ValidationException {

		//candidateValidator.validateCandidate(interviewerModel);

		Optional<Interviewer> interviewer = interviewerRepository.findById(interviewerModel.getEmpId());
		if (interviewer.isPresent()) {
			
			InterviewerServiceHelper.buildInterviewerDetails(interviewerModel, interviewer);			
			interviewerRepository.save(interviewer.get());

			return "Interveiwer Updated Successfully..!!";
		}	
		return "Failed to update interviewer..";
	}

	

	@Override
	public List<Interviewer> searchCandidate(InterviewerModel interviewerModel) {
		return null;
	}

	@Override
	public String deleteInterviewerById(Long id) {
		Optional<Interviewer> interviewer = interviewerRepository.findById(id);
		if (interviewer.isPresent()) {
			interviewerRepository.deleteById(id);
			return "Interviewer Successfully deleted..!!";
		}
		return "Failed to delete candidate..!!";
	}

	@Override
	public InterviewerModel searchInterviewerById(Long id) {
		Optional<Interviewer> interviewer = interviewerRepository.findById(id);
		InterviewerModel model;
		if (interviewer.isPresent()) {
			return InterviewerServiceHelper.buildInterviewerModel(interviewer.get());
		}else {
			return null;
		}
		
	}
}
