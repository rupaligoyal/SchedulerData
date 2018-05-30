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
	public Label candidateSearchLabel;
	
	public Button searchAvailableCandidates;
	public Button searchRejectedCandidates;
	public Button searchSelectedCandidates;
	public Button searchCancelledCandidates;
	public Button searchCScheduledCandidates;
	public Button searchAllCandidates;
	
	public CandidateFormData() {

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
		this.candidatelabel = new Label("<b>Candidate Details</b>", ContentMode.HTML);
		candidatelabel.addStyleName(ValoTheme.LABEL_LARGE);
		this.candidateSearchLabel = new Label("<b>Candidate Search</b>", ContentMode.HTML);
		candidateSearchLabel.addStyleName(ValoTheme.LABEL_LARGE);
		
		//search button
		this.searchAvailableCandidates = new Button("Search Candidates who are yet to scheduled");
		this.searchCancelledCandidates = new Button("Search Candidates who cancelled the interview");
		this.searchCScheduledCandidates = new Button("Search Candidates who are scheduled");
		this.searchRejectedCandidates = new Button("Search Rejected Candidates");
		this.searchSelectedCandidates = new Button("Search Selected Candidates");
		this.searchAllCandidates = new Button("Search All Candidates");
	}
}