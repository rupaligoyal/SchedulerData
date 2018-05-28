package com.example.demo.ui;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.interviewer.InterviewerService;
import com.example.demo.model.InterviewerModel;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

@Component
public class InterviewerFormData implements InitializingBean {
	public TextField firstname;
	public TextField lastname;
	public TextField priority;
	public TextField status;
	public TextField feedback;
	public TextField email;
	public DateField date;
	public TextField timeSlot;
	public Button create;
	public Button update;
	public Button delete;
	public Label interviewlabel;
	
	@Autowired
	public InterviewerService interviewerService;
	public InterviewerModel interviewerModel;

	public InterviewerFormData() {

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.firstname = new TextField("First Name");
		this.lastname = new TextField("Last Name");
		this.priority = new TextField("Priority");
		this.status = new TextField("Status");
		this.feedback = new TextField("Feed Back");
		this.email = new TextField("Email");
		this.date = new DateField("Available Date");
		this.timeSlot = new TextField("Time Slot");
		this.create = new Button("Create");
		this.update = new Button("Update");
		this.delete = new Button("Delete");
		this.interviewlabel = new Label("<b>Interviewer Details</b>", ContentMode.HTML);
		interviewlabel.addStyleName(ValoTheme.LABEL_LARGE);
	}
}