package com.example.demo.candidate;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.example.demo.entity.CandidateAvailableTimeSlot;
//import com.example.demo.entity.AvailableTimeSlotId;
import com.example.demo.entity.Candidate;
import com.example.demo.model.AvailableTimeSlotsModel;
import com.example.demo.model.CandidateModel;

public class CandidateServiceHelper {
	public static Candidate extractCandidateObjectFromModel(CandidateModel model) {
		Candidate candidate = new Candidate();
		candidate.setEmailId(model.getEmailId());
		candidate.setFeedback(model.getFeedback());
		candidate.setFirstname(model.getFirstname());
		candidate.setLastname(model.getLastname());
		candidate.setPriority(model.getPriority());
		candidate.setStatus(model.getStatus());
		candidate.setAvailableTimeSlot(buildTimeSlot(model.getAvailableTimeSlot()));
		return candidate;
	}
	
	public static Set<CandidateAvailableTimeSlot> buildTimeSlot(Set<AvailableTimeSlotsModel> avTimeSlModel){
		Set<CandidateAvailableTimeSlot> slotSet = new HashSet<>();
		
		avTimeSlModel.stream().forEach((slotModel) -> {
			CandidateAvailableTimeSlot slotEntity = new CandidateAvailableTimeSlot();
			slotEntity.setSlotDate(slotModel.getSlotDate());
			slotEntity.setSlotNum(slotModel.getSlotNum());
			slotEntity.setSlotRange(slotModel.getSlotRange());
			slotSet.add(slotEntity);
		});
		
		return slotSet;
	}
	
	/*public static Set<AvailableTimeSlot> buildTimeSlot(Set<AvailableTimeSlotsModel> avTimeSlModel){
		Set<AvailableTimeSlot> slotSet = new HashSet<>();
		AvailableTimeSlotId availableTimeSlotId = new AvailableTimeSlotId();
		avTimeSlModel.stream().forEach((slotModel) -> {
			AvailableTimeSlot slotEntity = new AvailableTimeSlot();
			slotEntity.setSlotDate(slotModel.getSlotDate());
			availableTimeSlotId.setSlotNum(slotModel.getSlotNum());
			slotEntity.setSlotRange(slotModel.getSlotRange());
			slotSet.add(slotEntity);
		});
		
		return slotSet;
	}*/
	
	public static void buildCandidateEntityFromModel(CandidateModel candidateModel, Candidate candidate) {
		candidate.setEmailId(candidateModel.getEmailId());
		candidate.setFeedback(candidateModel.getFeedback());
		candidate.setFirstname(candidateModel.getFirstname());
		candidate.setLastname(candidateModel.getLastname());
		candidate.setPriority(candidateModel.getPriority());
		candidate.setStatus(candidateModel.getStatus());
	}
	
	public static CandidateModel buildCandidateModel(Optional<Candidate> candidate) {
		CandidateModel model;
		model = new CandidateModel();
		model.setCandId(candidate.get().getCandId());
		model.setEmailId(candidate.get().getEmailId());
		model.setFeedback(candidate.get().getFeedback());
		model.setFirstname(candidate.get().getFirstname());
		model.setLastname(candidate.get().getLastname());
		model.setPriority(candidate.get().getPriority());
		model.setStatus(candidate.get().getStatus());
		return model;
	}
	
	
	public static Candidate createCandidateExampleByStatus(String status) {
		return createCandidateExample(null, null, null, null, null, status, null, null);
	}
	public static Candidate createCandidateExample(Long candId, String firstname, String lastname, String priority,
			Set<CandidateAvailableTimeSlot> availableTimeSlot, String status, String feedback, String emailId) {
		return Candidate.builder().candId(candId).firstname(firstname).lastname(lastname).priority(priority)
				.availableTimeSlot(availableTimeSlot).status(status).feedback(feedback).emailId(emailId).build();

	}
}
