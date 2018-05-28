package com.example.demo.ui;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.candidate.CandidateService;
import com.example.demo.model.CandidateModel;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

@Component
public class CandidateFormData implements InitializingBean {
	public TextField firstname;
	public TextField lastname;
	public TextField priority;
	public TextField status;
	public TextField feedback;
	public TextField email;
	public Button create;
	public Button update;
	public Button delete;
	public DateField date;
	public TextField timeSlot;
	@Autowired
	public CandidateService candidateService;
	public CandidateModel candidate;
	public MyUi myUI;
	public Label candidatelabel;

	public CandidateFormData() {

	}

	
/*	public CandidateFormData(TextField firstname, TextField lastname, TextField priority, TextField status,
			TextField feedback, TextField email, Button create, Button update, Button delete) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.priority = priority;
		this.status = status;
		this.feedback = feedback;
		this.email = email;
		this.create = create;
		this.update = update;
		this.delete = delete;
	}
*/
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
		this.candidatelabel = new Label("<b>Candidate Details</b>", ContentMode.HTML);
		candidatelabel.addStyleName(ValoTheme.LABEL_LARGE);
	}
}