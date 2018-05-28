package com.example.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.ScheduleModel;
import com.example.demo.util.ValidationException;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.themes.ValoTheme;

@Component
public class SchedularForm extends FormLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	SchedularFormData schedularFormData;
	ScheduleModel scheduleModel;
	
	public void registerListener(MyUi myUI) {
		//schedularFormData.scheduleModel = new ScheduleModel();
		schedularFormData.schedule.addStyleName(ValoTheme.BUTTON_PRIMARY);
		schedularFormData.schedule.addClickListener(e -> {
			try {
				scheduleTime();
				showScheduleDetails();
			} catch (ValidationException e1) {
				e1.printStackTrace();
			}
		});
		HorizontalLayout hlayout = new HorizontalLayout(schedularFormData.schedule);
		hlayout.setSpacing(true);
		schedularFormData.schedule.setClickShortcut(KeyCode.ENTER);
		addComponents(schedularFormData.schduleFormLabel, schedularFormData.candidateEmail, schedularFormData.schedule, hlayout);
	}
	
	private void scheduleTime() throws ValidationException {
		fetchFromUI();
	}
	
	

	private void fetchFromUI() {
		try {
			scheduleModel=schedularFormData.schedulerService.scheduleInterviewByCandidateEmail(schedularFormData.candidateEmail.getValue());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void showScheduleDetails() {
		if(scheduleModel != null) {
			TextArea scheduleArea = new TextArea("Schedule for candidate ");
			scheduleArea.setWordWrap(true);
			scheduleArea.setValue("The candidate will have interview on "+ scheduleModel.getTimeOfInterview() + " with " + scheduleModel.getInterviewerId());
			addComponent(scheduleArea);
		}
	}

}
