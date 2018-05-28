package com.example.demo.candidate;

import org.springframework.stereotype.Service;

import com.example.demo.model.CandidateModel;
import com.example.demo.util.ValidationException;
import com.example.demo.util.ValidationUtil;

@Service
public class CandidateValidator extends ValidationUtil implements CandidateConstants{
	
	public boolean validateCandidate(CandidateModel c) throws ValidationException {
		
		//validateRequiredField(CANDIDATE_ID, c.getCandId(), true);
		//validateRequiredField(CANDIDATE_FIRSTNAME, c.getCandId(), false);
		//validateRequiredField(CANDIDATE_PRIORITY, c.getPriority(), true);
		
		return true;
	}
}
