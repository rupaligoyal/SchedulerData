package com.example.demo.ui;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.schedule.SchedulerService;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

@Component
public class SchedularFormData implements InitializingBean {
	public TextField candidateEmail;
	public Button schedule;
	//public ScheduleModel scheduleModel;
	@Autowired
	SchedulerService  schedulerService;
	public com.vaadin.ui.Label schduleFormLabel;
	
	public SchedularFormData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.candidateEmail = new TextField("Enter Candidate's Email Id");
		this.schedule = new Button("Schedule");
		this.schduleFormLabel = new Label("<b>Schedule Interview</b>", ContentMode.HTML);
		schduleFormLabel.addStyleName(ValoTheme.LABEL_LARGE);
	}
	
	
}
