package com.example.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
public class MyUi extends UI {
	private static final long serialVersionUID = 1L;

	@Autowired
	private SchedularForm schedularForm;
	@Autowired
	private CandidateForm candidateForm;
	@Autowired
	private InterviewerForm interviewerForm;
	Button button = new Button("Submit");

	@Override
	protected void init(VaadinRequest request) {
		candidateForm.registerListener(this);
		interviewerForm.registerListener(this);
		schedularForm.registerListener(this);
		final VerticalLayout layout = new VerticalLayout();
		// layout.addComponent(candidateForm);
		setContent(layout);
		HorizontalLayout main = new HorizontalLayout();
		main.addComponent(candidateForm);
		main.addComponent(interviewerForm);
		main.addComponent(schedularForm);
		main.setSpacing(true);
		main.setSizeFull();
		layout.addComponent(main);
	}

}
