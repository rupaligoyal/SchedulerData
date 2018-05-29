package com.example.demo.schedule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.cache.InterviewerCache;
import com.example.demo.candidate.CandidateConstants;
import com.example.demo.candidate.CandidateRepository;
import com.example.demo.entity.Candidate;
import com.example.demo.entity.Interviewer;
import com.example.demo.entity.InterviewerAvailableTimeSlot;
import com.example.demo.entity.Schedule;
import com.example.demo.entity.ScheduleId;
import com.example.demo.interviewer.InterviewerConstants;
import com.example.demo.interviewer.InterviewerRepository;
import com.example.demo.interviewer.InterviewerServiceHelper;
import com.example.demo.model.InterviewResult;
import com.example.demo.model.InterviewerModel;
import com.example.demo.model.ScheduleModel;

@Service
public class SchedulerServiceImpl implements SchedulerService {
	@Autowired
	CandidateRepository candidateRepository;
	
	@Autowired
	SchedulerRepository schedulerRepository;
	
	@Autowired
	InterviewerRepository interviewerRepository;
	
	@Override
	public List<InterviewerModel> serachAvailableInterviewerForCandidate(Long id) throws Exception {
		//find candidate by id in DB
		Optional<Candidate> candidate = candidateRepository.findById(id);
		
		if(candidate.isPresent()) {
			//get the interviewer available in the same time slot as candidate availability
			Interviewer interviewer = new Interviewer();
			interviewer.setAvilabilityStatus(InterviewerConstants.AVAILABLE);
			interviewer.setPriority(candidate.get().getPriority());
			
			/*candidate.get().getAvailableTimeSlot().stream().forEach(candidateSlot -> {
				InterviewerAvailableTimeSlot interviewerAvailableTimeSlot = new InterviewerAvailableTimeSlot();
				interviewerAvailableTimeSlot.setSlotDate(candidateSlot.getSlotDate());
				interviewerAvailableTimeSlot.setSlotNum(candidateSlot.getSlotNum());
				interviewer.getAvailableTimeSlot().add(interviewerAvailableTimeSlot);
			});*/
			
			//query interviewer by example 
			Example<Interviewer> interviewerExample = Example.of(interviewer);
			List<Interviewer> result = interviewerRepository.findAll(interviewerExample);
			
			List<InterviewerModel> model = new ArrayList<>();
			
			result.stream().forEach(interviwerRecord -> {
				model.add(InterviewerServiceHelper.buildInterviewerModel(interviwerRecord));
			});
			
			return model;
			
		}else {
			throw new Exception("Candidate Id is not present. Please try with another Id.");
		}
	}
	
	/*@Override
	public ScheduleModel scheduleInterviewByCandidate(Long id) throws Exception {
		//find candidate by id in DB
		Optional<Candidate> candidate = candidateRepository.findById(id);
		
		if(candidate.isPresent()) {
			//get the interviewer available in the same time slot as candidate availability
			Interviewer interviewer = new Interviewer();
			interviewer.setAvilabilityStatus(InterviewerConstants.AVAILABLE);
			interviewer.setPriority(candidate.get().getPriority());
			
			candidate.get().getAvailableTimeSlot().stream().forEach(candidateSlot -> {
				InterviewerAvailableTimeSlot interviewerAvailableTimeSlot = new InterviewerAvailableTimeSlot();
				interviewerAvailableTimeSlot.setSlotDate(candidateSlot.getSlotDate());
				interviewerAvailableTimeSlot.setSlotNum(candidateSlot.getSlotNum());
				interviewer.getAvailableTimeSlot().add(interviewerAvailableTimeSlot);
			});
			
			//query interviewer by example 
			Example<Interviewer> interviewerExample = Example.of(interviewer);
			Optional<Interviewer> result = interviewerRepository.findOne(interviewerExample);
			
			if(result.isPresent()) {
				Schedule schedule = new Schedule();
				ScheduleId scheduleId = new ScheduleId();
				scheduleId.setCandId(id);
				scheduleId.setInterviewerId(result.get().getEmpId());
				schedule.setId(scheduleId);
				schedule.setInterviewStatus(SchedulerConstants.SCHEDULED);
				schedule.setTimeOfInterview(result.get().getAvailableTimeSlot().stream().findFirst().get().getSlotDate() + " " + result.get().getAvailableTimeSlot().stream().findFirst().get().getSlotRange());
				
				schedulerRepository.save(schedule);
				
				result.get().setAvilabilityStatus(InterviewerConstants.BUSY);
				interviewerRepository.save(result.get());
				
				candidate.get().setStatus(CandidateConstants.CANDIDATE_STATUS_SCHEDULED);
				candidateRepository.save(candidate.get());
				
				return SchedulerServiceHelper.buildModelFromEntity(schedule);
			}else {
				//say no candidate is available during that period
				throw new Exception("No interviewer is available during this time..!!");
			}
			
		}else {
			throw new Exception("Candidate Id is not present. Please try with another Id.");
		}
	}*/
	
	@Override
	public ScheduleModel scheduleInterviewByCandidateEmail(String emailId) throws Exception {
		Schedule schedule = null;
		
		System.out.println("****************Priniting cache**************");
		InterviewerCache.print();
		System.out.println("***********Print done");
		
		if(SchedulerServiceHelper.isAlreadyScheduled(emailId, schedulerRepository)) {
			new Exception("The candidate's interview is already scheduled");
		}else {
			//find candidate by id in DB
			Candidate candidate = new Candidate();
			candidate.setEmailId(emailId);
			
			Example<Candidate> candidateExample = Example.of(candidate);
			Optional<Candidate> candidateResult = candidateRepository.findOne(candidateExample);
			
			if(candidateResult.isPresent()) {
				//get the interviewer available in the same time slot as candidate availability
				Interviewer interviewer = new Interviewer();
				interviewer.setAvilabilityStatus(InterviewerConstants.AVAILABLE);
				interviewer.setPriority(candidateResult.get().getPriority());
				
				candidateResult.get().getAvailableTimeSlot().stream().forEach(candidateSlot -> {
					InterviewerAvailableTimeSlot interviewerAvailableTimeSlot = new InterviewerAvailableTimeSlot();
					interviewerAvailableTimeSlot.setSlotDate(candidateSlot.getSlotDate());
					interviewerAvailableTimeSlot.setSlotRange(candidateSlot.getSlotRange());
					interviewer.getAvailableTimeSlot().add(interviewerAvailableTimeSlot);
				});
			
				//query interviewer by example 
				Example<Interviewer> interviewerExample = Example.of(interviewer);
				List<Interviewer> result = interviewerRepository.findAll(interviewerExample);
				
				
				if(result.size() > 0) {
					schedule = new Schedule();
					ScheduleId scheduleId = new ScheduleId();
					scheduleId.setCandidateEmailId(candidateResult.get().getEmailId());
					scheduleId.setInterviewerEmailId(result.get(0).getEmailId());
					schedule.setId(scheduleId);
					schedule.setInterviewStatus(SchedulerConstants.SCHEDULED);
					schedule.setTimeOfInterview(result.get(0).getAvailableTimeSlot().iterator().next().getSlotDate() + " " + result.get(0).getAvailableTimeSlot().iterator().next().getSlotRange());
					
					schedulerRepository.save(schedule);
					
					result.get(0).setAvilabilityStatus(InterviewerConstants.BUSY);
					interviewerRepository.save(result.get(0));
					
					candidateResult.get().setStatus(CandidateConstants.CANDIDATE_STATUS_SCHEDULED);
					candidateRepository.save(candidateResult.get());
					
					Optional<Schedule> scheduleOptional = Optional.of(schedule);
				}else {
					//say no candidate is available during that period
					throw new Exception("No interviewer is available during this time..!!");
				}
			}else {
				throw new Exception("Candidate Id is not present. Please try with another Id.");
			}
		}
		return SchedulerServiceHelper.buildModelFromEntity(schedule);
	}
	
	@Override
	public List<ScheduleModel> scheduleInterviewForAll() throws Exception{
		Candidate candidateCriteria = new Candidate();
		candidateCriteria.setStatus(CandidateConstants.CANDIDATE_STATUS_NEW);
		Example<Candidate> candidateExample = Example.of(candidateCriteria);
		List<Candidate> listOfCandidate = candidateRepository.findAll(candidateExample);
		List<ScheduleModel> scheduleModels = new ArrayList<>();

		if (listOfCandidate != null && listOfCandidate.size() > 0) {
			for (Candidate candidate : listOfCandidate) {
				scheduleModels.add(scheduleInterviewByCandidateEmail(candidate.getEmailId()));
			}
		}

		return scheduleModels;
	}
	
	@Override
	public String updateInterviewResult(InterviewResult result) throws Exception {
		ScheduleId sid = new ScheduleId();
		sid.setCandidateEmailId(result.getCandidateEmailId());
		sid.setInterviewerEmailId(result.getInterviewedByEmailId());
		
		Optional<Schedule> scheduleOptional = schedulerRepository.findById(sid);
		
		if(scheduleOptional.isPresent()) {
			Candidate candidate = new Candidate();
			candidate.setEmailId(result.getCandidateEmailId());
			
			Example<Candidate> candidateExample = Example.of(candidate);
			Optional<Candidate> candidateResult = candidateRepository.findOne(candidateExample);
			candidateResult.get().setFeedback(result.getFeedback());
			candidateResult.get().setStatus(result.getStatus());
			
			scheduleOptional.get().setInterviewStatus(result.getStatus());
			
			candidateRepository.save(candidateResult.get());
			schedulerRepository.save(scheduleOptional.get());
			return "Result updated successfully";
		}else {
			throw new Exception("No such interview is scheduled. Please check candidate id and intreview id once again..!!");
		}
	}
	
	@Override
	public String cancelInterviewForCandidate(String candidateEmailId) throws Exception{
		ScheduleId sid = new ScheduleId();
		sid.setCandidateEmailId(candidateEmailId);
		Schedule schedule = new Schedule();
		schedule.setId(sid);
		
		Example<Schedule> scheduleExample = Example.of(schedule);
		Optional<Schedule> scheduleResult = schedulerRepository.findOne(scheduleExample);
		
		if(scheduleResult.isPresent()) {
			schedulerRepository.deleteById(scheduleResult.get().getId());
			
			//update candidate status as cancelled
			Candidate candidate = SchedulerServiceHelper.findCandidateByEmail(candidateEmailId, candidateRepository);			
			candidate.setStatus(CandidateConstants.CANDIDATE_CANCELLED_INTERVIEW);
			candidateRepository.save(candidate);
			
			//update interviewer status as free
			Interviewer interviewer = SchedulerServiceHelper.findInterviewerByEmail(candidateEmailId, interviewerRepository);
			interviewer.setAvilabilityStatus(InterviewerConstants.AVAILABLE);
			interviewerRepository.save(interviewer);
			
			return "Interview Cancelled Successfully..!!";
		}else {
			return "No interview schedule found for this candidate..! Please check candidate email id..";
		}
	}
	
	
}
