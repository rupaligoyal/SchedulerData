package com.example.demo.interviewer;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.example.demo.entity.CandidateAvailableTimeSlot;
//import com.example.demo.entity.AvailableTimeSlotId;
import com.example.demo.entity.Candidate;
import com.example.demo.entity.Interviewer;
import com.example.demo.entity.InterviewerAvailableTimeSlot;
import com.example.demo.model.AvailableTimeSlotsModel;
import com.example.demo.model.CandidateModel;
import com.example.demo.model.InterviewerModel;

public class InterviewerServiceHelper {
	public static Interviewer extractInterviewerObjectFromModel(InterviewerModel model, Interviewer interviewer) {
		interviewer.setAvilabilityStatus(model.getAvilabilityStatus());
		interviewer.setEmailId(model.getEmailId());
		interviewer.setFirstname(model.getFirstname());
		interviewer.setLastname(model.getLastname());
		interviewer.setManagerEmailId(model.getManagerEmailId());
		interviewer.setPriority(model.getPriority());
		interviewer.setAvailableTimeSlot(buildTimeSlot(model.getAvailableTimeSlot()));
		return interviewer;
	}
	
	public static Set<InterviewerAvailableTimeSlot> buildTimeSlot(Set<AvailableTimeSlotsModel> avTimeSlModel){
		Set<InterviewerAvailableTimeSlot> slotSet = new HashSet<>();
		
		avTimeSlModel.stream().forEach((slotModel) -> {
			InterviewerAvailableTimeSlot slotEntity = new InterviewerAvailableTimeSlot();
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
	
	public static void buildInterviewerDetails(InterviewerModel candidateModel, Optional<Interviewer> interviewer) {
		interviewer.get().setEmailId(candidateModel.getEmailId());
		interviewer.get().setFirstname(candidateModel.getFirstname());
		interviewer.get().setLastname(candidateModel.getLastname());
		interviewer.get().setPriority(candidateModel.getPriority());
		interviewer.get().setAvilabilityStatus(candidateModel.getAvilabilityStatus());
	}
	
	public static InterviewerModel buildInterviewerModel(Interviewer interviewer) {
		InterviewerModel model = new InterviewerModel();
		model.setEmpId(interviewer.getEmpId());
		model.setEmailId(interviewer.getEmailId());
		model.setFirstname(interviewer.getFirstname());
		model.setLastname(interviewer.getLastname());
		model.setPriority(interviewer.getPriority());
		model.setAvilabilityStatus(interviewer.getAvilabilityStatus());
		//model.setAvailableTimeSlot(interviewer.get().getAvailableTimeSlot());
		return model;
	}
}
