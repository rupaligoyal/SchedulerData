package com.bak;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.CandidateModel;
import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("valo")
public class CandidateFormBak extends UI {

	private static final long serialVersionUID = 1L;
	private VerticalLayout vlayout;
	private HorizontalLayout hlayout;
	FormLayout form;

	@Autowired
	TodoList todoList; 

	@Override
	protected void init(VaadinRequest request) {
		//form =  new FormLayout();
		setUpLayout();
		//addToDoList();
		//addHeader();
		//addDate();
		//AddActionButton();
		//addCandidateTable();
		//addForm();
		addCandidateForm();
	}

	private void addCandidateTable() {
		
		Grid<CandidateModel> grid = new Grid<>();
		grid.addColumn(CandidateModel::getCandId).setCaption("Id");
		grid.addColumn(CandidateModel::getPriority).setCaption("Priority");
		grid.addColumn(CandidateModel::getFirstname).setCaption("Firstname");
		//grid.addColumn(CandidateModel::getDate).setCaption("Date");
		hlayout.addComponent(grid);
	}
	
	private void addCandidateForm() {
		TextField textField = new TextField("First Name : ");
		hlayout.addComponents(textField);
		hlayout.setComponentAlignment(textField, Alignment.MIDDLE_LEFT);
		//vlayout.addComponent(hlayout);
	}

	private void setUpLayout() {
		vlayout = new VerticalLayout();
		hlayout = new HorizontalLayout();
		//setContent(vlayout);
		setContent(hlayout);
	}

	private void addToDoList() {
		// layout.addComponent(todoList);
	}

	private void AddActionButton() {
		// HorizontalLayout formLayout = new HorizontalLayout();
		// Button delete = new Button("Delete");
		// layout.addComponent(delete);

	}

	private void addForm() {
		TextField textField = new TextField();
		Button submit = new Button("Submit");
		vlayout.addComponents(textField, submit);
		vlayout.setComponentAlignment(submit, Alignment.MIDDLE_LEFT);
	}

	private void addHeader() {
		Label header = new Label("<b>Candidate Details</b>", ContentMode.HTML);
		vlayout.addComponent(header);

	}

	private void addDate() {
		hlayout = new HorizontalLayout();
		DateField dateField = new DateField();
		dateField.setData(new Date());
		hlayout.addComponent(dateField);
		vlayout.addComponent(hlayout);

	}

	/*public static class Candidate {
		private int id;
		private String name;
		private int age;
		private Date date;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

	}*/
}

