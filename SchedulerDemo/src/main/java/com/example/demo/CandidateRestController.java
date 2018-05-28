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
import com.example.demo.model.CandidateModel;

@RestController
@RequestMapping("/candidate")
public class CandidateRestController {
	
	@Autowired
	CandidateService candidateService;
	
	public CandidateRestController() {
	}
	
	@RequestMapping (value = "/create", method = RequestMethod.POST, consumes="application/json")	
	public HttpStatus createCandidate ( @RequestBody CandidateModel candidateModel) {
		try {
			boolean isCreated=candidateService.createCandidate(candidateModel);
			
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
	public String updateCandidate ( @RequestBody CandidateModel candidateModel) {
		try {
			return candidateService.updateCandidate(candidateModel);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Oops. Failed to update candidate..!!";
		}
	}
	
	@RequestMapping (value = "/delete/{id}", method = RequestMethod.POST, consumes="application/json")	
	public String deleteCandidate ( @PathVariable Long id) {
		try {
			return candidateService.deleteCandidateById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Oops. Failed to update candidate..!!";
		}
	}
	
	@RequestMapping (value = "/delete/email/{emailid}", method = RequestMethod.DELETE, consumes="application/json")	
	public String deleteCandidate ( @PathVariable String id) {
		try {
			return candidateService.deleteCandidate(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Oops. Failed to update candidate..!!";
		}
	}
	
	@RequestMapping (value = "/search/{id}", method = RequestMethod.POST, consumes="application/json")	
	public @ResponseBody CandidateModel searchCandidate ( @PathVariable Long id) {
		try {
			return candidateService.searchCandidateById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
