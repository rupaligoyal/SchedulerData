package com.example.demo.candidate;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Candidate;
import com.example.demo.model.CandidateModel;
import com.example.demo.util.ValidationException;

@Component
public interface CandidateService {
	boolean createCandidate(CandidateModel candidateModel) throws ValidationException;
	String updateCandidate(CandidateModel candidateModel) throws ValidationException;
	List<Candidate> searchCandidate(CandidateModel candidateModel) ;
	CandidateModel searchCandidateById(Long id) ;
	String deleteCandidateById(Long id) ;
	String deleteCandidate(String emailId);
	String updateCandidateByEmail(CandidateModel model) throws ValidationException;
}
