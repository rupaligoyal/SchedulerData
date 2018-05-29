package com.example.demo.interviewer;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.cache.InterviewerCache;
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
		Interviewer interviewer = new Interviewer(); 
		InterviewerServiceHelper.extractInterviewerObjectFromModel(interviewerModel, interviewer);

		// store candidate in DB
		interviewerRepository.save(interviewer);
		InterviewerCache.SingletonCacheConcurrentHashMap.getInstance().put(interviewer, new Date());
		return true;

	}
	
	@Override
	public String updateInterviewer(InterviewerModel interviewerModel) throws ValidationException {

		//candidateValidator.validateCandidate(interviewerModel);

		Optional<Interviewer> interviewer = interviewerRepository.findById(interviewerModel.getEmpId());
		if (interviewer.isPresent()) {
			
			InterviewerServiceHelper.buildInterviewerDetails(interviewerModel, interviewer);			
			interviewerRepository.save(interviewer.get());
			
			//update cache
			InterviewerCache.SingletonCacheConcurrentHashMap.getInstance().put(interviewer.get(), new Date());
			
			return "Interveiwer Updated Successfully..!!";
		}	
		return "Failed to update interviewer..";
	}

	@Override
	public String updateInterviewerByEmail(InterviewerModel model) throws ValidationException {

		//candidateValidator.validateCandidate(candidateModel);
		Interviewer interviewer = new Interviewer();
		interviewer.setEmailId(model.getEmailId());
		Example<Interviewer> interviewerExample = Example.of(interviewer);
		
		List<Interviewer> interviewerList = interviewerRepository.findAll(interviewerExample);
		if (interviewerList.size()>1) {
			return "Cannot update the candidate. This email is assciated with multiple candidates..!!";
		}else {
			InterviewerServiceHelper.extractInterviewerObjectFromModel(model, interviewerList.get(0));		
			interviewerRepository.save(interviewerList.get(0));
			
			if(InterviewerCache.SingletonCacheConcurrentHashMap.getInstance().containsKey(interviewerList.get(0)) ) {
				InterviewerCache.SingletonCacheConcurrentHashMap.getInstance().remove(interviewerList.get(0));
				InterviewerCache.SingletonCacheConcurrentHashMap.getInstance().put(interviewerList.get(0), new Date());
			};
			
			return "Interviewer Updated Successfully..!!";
		}
	}

	@Override
	public String deleteInterviewerById(Long id) {
		Optional<Interviewer> interviewer = interviewerRepository.findById(id);
		if (interviewer.isPresent()) {
			interviewerRepository.deleteById(id);
			InterviewerCache.SingletonCacheConcurrentHashMap.getInstance().remove(interviewer.get());
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
