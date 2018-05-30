package com.example.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.AvailableTimeSlotsModel;
import com.example.demo.model.CandidateModel;
import com.example.demo.util.ValidationException;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Component
public class CandidateForm extends FormLayout {
	private static final long serialVersionUID = 1L;
	@Autowired
	CandidateFormData data ;
	

	public void registerListener(MyUi myUI) {
		
		data.searchAvailableCandidates.addStyleName(ValoTheme.BUTTON_PRIMARY);
		data.searchAllCandidates.addClickListener(e -> {
			try {
				searchAllCandidates();
			} catch (ValidationException e1) {
				e1.printStackTrace();
			}
		});
		
		data.searchAllCandidates.addStyleName(ValoTheme.BUTTON_PRIMARY);
		data.searchAllCandidates.addClickListener(e -> {
			try {
				searchAllCandidates();
			} catch (ValidationException e1) {
				e1.printStackTrace();
			}
		});
		
		data.create.addStyleName(ValoTheme.BUTTON_PRIMARY);
		data.create.addClickListener(e -> {
			try {
				createCandidate();
			} catch (ValidationException e1) {
				e1.printStackTrace();
			}
		});
		data.update.addStyleName(ValoTheme.BUTTON_PRIMARY);
		data.update.addClickListener(e -> {
			try {
				updateCandidate();
			} catch (ValidationException e1) {
				
				e1.printStackTrace();
			}
		});

		data.delete.addStyleName(ValoTheme.BUTTON_PRIMARY);
		data.delete.addClickListener(e -> {
			deleteCandidate();
		});

		//this.data.myUI = myUI;
		setSizeUndefined();
		HorizontalLayout hlayout = new HorizontalLayout(data.create, data.update, data.delete);
		hlayout.setSpacing(true);
		data.create.setClickShortcut(KeyCode.ENTER);
		addComponents(data.candidateSearchLabel, data.searchAvailableCandidates, data.searchCancelledCandidates,
				data.searchCScheduledCandidates, data.searchRejectedCandidates, data.searchSelectedCandidates,
				data.searchAllCandidates, data.candidatelabel, data.firstname, data.lastname, data.priority,
				data.status, data.feedback, data.email, data.date, data.timeSlot, hlayout);
	}

	public void setCandidate(CandidateModel candidate) {
		this.data.candidate = candidate;
		setVisible(true);
	}
	
	private void searchAllCandidates() throws ValidationException{
		//data.candidateService.
	}

	private void createCandidate() throws ValidationException {
		fetchFromUI();
		data.candidateService.createCandidate(data.candidate);
	}

	private void deleteCandidate() {
		fetchFromUI();
		data.candidateService.deleteCandidate(data.candidate.getEmailId());
	}

	private void updateCandidate() throws ValidationException {
		fetchFromUI();
		data.candidateService.updateCandidateByEmail(data.candidate);
	}

	public void fetchFromUI() {
		data.candidate = new CandidateModel();
		data.candidate.setFirstname(data.firstname.getValue());
		data.candidate.setLastname(data.lastname.getValue());
		data.candidate.setEmailId(data.email.getValue());
		data.candidate.setPriority(data.priority.getValue());
		data.candidate.setStatus(data.status.getValue());
		data.candidate.setFeedback(data.feedback.getValue());
		AvailableTimeSlotsModel candidateAvailableTimeSlot = new AvailableTimeSlotsModel();
		System.out.println("***************Date: "+ data.date.getValue().toString());
		candidateAvailableTimeSlot.setSlotDate(data.date.getValue().toString());
		candidateAvailableTimeSlot.setSlotRange(data.timeSlot.getValue());		
		data.candidate.getAvailableTimeSlot().add(candidateAvailableTimeSlot);
	}

}
