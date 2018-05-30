package com.example.demo.candidate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Candidate;
import com.example.demo.model.CandidateModel;
import com.example.demo.util.ValidationException;

@Service
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	CandidateRepository candidateRepository;
	
	@Autowired
	CandidateValidator candidateValidator;
	
	@Override
	public boolean createCandidate(CandidateModel candidateModel) throws ValidationException {
				
		//if(candidateValidator.validateCandidate(candidateModel)) {
		try {
			if(candidateValidator.validateCandidate(candidateModel)) {
				System.out.println("********Model*********"+ candidateModel.getEmailId());
				System.out.println("********Model*********"+ candidateModel.getFeedback());
				System.out.println("********Model*********"+ candidateModel.getFirstname());
				System.out.println("********Model*********"+ candidateModel.getLastname());
				System.out.println("********Model*********"+ candidateModel.getPriority());
				System.out.println("********Model*********"+ candidateModel.getStatus());
				System.out.println("********Model*********"+ candidateModel.getCandId());
				
				//extract candidate object from model class
				Candidate candidate = CandidateServiceHelper.extractCandidateObjectFromModel(candidateModel);
				
				System.out.println("************************"+candidate.getEmailId());
				System.out.println("************************"+candidate.getFeedback());
				System.out.println("************************"+candidate.getFirstname());
				System.out.println("************************"+candidate.getLastname());
				System.out.println("************************"+candidate.getPriority());
				System.out.println("************************"+candidate.getStatus());
				System.out.println("************************"+candidate.getCandId());
				
				if(candidateRepository == null) {
					System.out.println("**************Repo is null ****************");
				}else {

					//store candidate in DB
					candidateRepository.save(candidate);
				}
				
				return true;
			}else {
				throw new ValidationException("Invalid Candidate");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	@Override
	public String updateCandidate(CandidateModel candidateModel) throws ValidationException {

		candidateValidator.validateCandidate(candidateModel);

		Optional<Candidate> candidate = candidateRepository.findById(candidateModel.getCandId());
		if (candidate.isPresent()) {
			
			CandidateServiceHelper.buildCandidateEntityFromModel(candidateModel, candidate.get());			
			candidateRepository.save(candidate.get());

			return "Candidate Updated Successfully..!!";
		}	
		return "Failed to update candidate..";
	}
	
	@Override
	public String updateCandidateByEmail(CandidateModel model) throws ValidationException {

		//candidateValidator.validateCandidate(candidateModel);
		Candidate candidate = new Candidate();
		candidate.setEmailId(model.getEmailId());
		Example<Candidate> candidateExample = Example.of(candidate);
		
		List<Candidate> candidateList = candidateRepository.findAll(candidateExample);
		if (candidateList.size()>1) {
			return "Cannot update the candidate. This email is assciated with multiple candidates..!!";
		}else {
			
			CandidateServiceHelper.buildCandidateEntityFromModel(model, candidateList.get(0));			
			candidateRepository.save(candidateList.get(0));

			return "Candidate Updated Successfully..!!";
		}
	}

	

	@Override
	public List<Candidate> searchAllCandidate(String status) {
		if(status.equals(CandidateConstants.CANDIDATE_ALL)) {
			return candidateRepository.findAll();
		}else {
			return candidateRepository.findAll(Example.of(CandidateServiceHelper.createCandidateExampleByStatus(status)));
		}
	}

	@Override
	public String deleteCandidateById(Long id) {
		Optional<Candidate> candidate = candidateRepository.findById(id);
		if (candidate.isPresent()) {
			candidateRepository.deleteById(id);
			return "Candidate Successfully deleted..!!";
		}
		return "Failed to delete candidate..!!";
	}
	
	@Override
	public String deleteCandidate(String emailId) {
		try {
			Candidate candidate = new Candidate();
			candidate.setEmailId(emailId);
			Example<Candidate> candidateExample = Example.of(candidate);
			List<Candidate> candidateList = candidateRepository.findAll(candidateExample);
			if(candidateList.size() > 1) {
				return "Cannot delete this id. There are multiple candidates exists in database corresponding to this email id..!!";
			}
			candidateRepository.delete(candidateList.get(0));
			return "Candidate Successfully deleted..!!";
		}catch(Exception e) {
			return "Failed to delete candidate..!!";
		}
	}

	@Override
	public CandidateModel searchCandidateById(Long id) {
		Optional<Candidate> candidate = candidateRepository.findById(id);
		CandidateModel model;
		if (candidate.isPresent()) {
			return CandidateServiceHelper.buildCandidateModel(candidate);
		}else {
			return null;
		}
		
	}

	
}
