package com.example.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.AvailableTimeSlotsModel;
import com.example.demo.model.InterviewerModel;
import com.example.demo.util.ValidationException;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Component
public class InterviewerForm extends FormLayout {
	private static final long serialVersionUID = 1L;
	@Autowired
	InterviewerFormData interviewerFormData;

	public void registerListener(MyUi myUI) {
		
		interviewerFormData.create.addStyleName(ValoTheme.BUTTON_PRIMARY);
		interviewerFormData.create.addClickListener(e -> {
			try {
				createInterviewer();
			} catch (ValidationException e1) {
				e1.printStackTrace();
			}
		});
		interviewerFormData.update.addStyleName(ValoTheme.BUTTON_PRIMARY);
		interviewerFormData.update.addClickListener(e -> {
			try {
				updateInterviewer();
			} catch (ValidationException e1) {

				e1.printStackTrace();
			}
		});

		interviewerFormData.delete.addStyleName(ValoTheme.BUTTON_PRIMARY);
		interviewerFormData.delete.addClickListener(e -> {
			// deleteCandidate();
		});
		setSizeUndefined();
		HorizontalLayout hlayout = new HorizontalLayout(interviewerFormData.create, interviewerFormData.update,
				interviewerFormData.delete);
		hlayout.setSpacing(true);
		interviewerFormData.create.setClickShortcut(KeyCode.ENTER);
		addComponents(interviewerFormData.interviewlabel, interviewerFormData.firstname, interviewerFormData.lastname,
				interviewerFormData.priority, interviewerFormData.status, interviewerFormData.feedback,
				interviewerFormData.email, interviewerFormData.date, interviewerFormData.timeSlot, hlayout);
	}

	public void setInterviewer(InterviewerModel interviewerModel) {
		this.interviewerFormData.interviewerModel = interviewerModel;
		setVisible(true);
	}

	private void createInterviewer() throws ValidationException {
		fetchFromUI();
		interviewerFormData.interviewerService.createInterviewer(interviewerFormData.interviewerModel);
	}

	// private void deleteCandidate() {
	// fetchFromUI();
	// interviewerFormData.interviewerService.deleteCandidate(interviewerFormData.interviewerModel.getEmailId());
	// }

	private void updateInterviewer() throws ValidationException {
		fetchFromUI();
		interviewerFormData.interviewerService.updateInterviewerByEmail(interviewerFormData.interviewerModel);
	}

	public void fetchFromUI() {
		interviewerFormData.interviewerModel = new InterviewerModel();
		interviewerFormData.interviewerModel.setFirstname(interviewerFormData.firstname.getValue());
		interviewerFormData.interviewerModel.setLastname(interviewerFormData.lastname.getValue());
		interviewerFormData.interviewerModel.setEmailId(interviewerFormData.email.getValue());
		interviewerFormData.interviewerModel.setPriority(interviewerFormData.priority.getValue());
		interviewerFormData.interviewerModel.setAvilabilityStatus(interviewerFormData.status.getValue());
		// interviewerFormData.interviewerModel.setFirstname();(interviewerFormData.feedback.getValue());
		AvailableTimeSlotsModel availableTimeSlot = new AvailableTimeSlotsModel();
		availableTimeSlot.setSlotDate(interviewerFormData.date.getValue().toString());
		availableTimeSlot.setSlotRange(interviewerFormData.timeSlot.getValue());		
		interviewerFormData.interviewerModel.getAvailableTimeSlot().add(availableTimeSlot);
	}

}
