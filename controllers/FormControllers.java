package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.GreatestSportsMoment;
import databaseServices.DatabaseService;

@ManagedBean
public class FormControllers {

	public FormControllers() {

	}

	public String onSubmitCreate() throws SQLException {
		// when the user creates a new line

		// read the 'get' values from the form
		FacesContext context = FacesContext.getCurrentInstance();

		// store the 'get' values in an object
		GreatestSportsMoment gsm = context.getApplication().evaluateExpressionGet(context, "#{greatestSportsMoment}",
				GreatestSportsMoment.class);

		// the result is that b holds the value of the submitted object

		System.out.println("the object you entered is  " + gsm.getSporting_moment());

		// store the object into a database

		DatabaseService ds = new DatabaseService();
		ds.insertOne(gsm);

		// put the 'get' values into a response page

		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("greatestSportsMoment", gsm);

		// show the response page
		return "ResponsePage.xhtml";
	}

	public String onSubmitEdit() throws SQLException {
		// when the user creates a new line

		// read the 'get' values from the form
		FacesContext context = FacesContext.getCurrentInstance();

		// store the 'get' values in an object
		GreatestSportsMoment gsm = context.getApplication().evaluateExpressionGet(context, "#{greatestSportsMoment}",
				GreatestSportsMoment.class);
		// the result is that b holds the value of the submitted object

		System.out.println("the object you edited is  " + gsm.getSporting_moment());

		// store the object into a database

		DatabaseService ds = new DatabaseService();
		ds.UpdateOne(gsm.getId(), gsm);

		// put the 'get' values into a response page

		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("greatestSportingMoment", gsm);

		// show the response page
		return "ResponsePage.xhtml";
	}

	public ArrayList<GreatestSportsMoment> fetchAll() throws SQLException {
		DatabaseService ds = new DatabaseService();

		return ds.readAll();

	}

	public String OnDelete(GreatestSportsMoment gsm) throws SQLException {

		System.out.println("the object you planning to delete is  " + gsm.getSporting_moment());

		// store the object into a database

		DatabaseService ds = new DatabaseService();
		ds.deleteOne(gsm.getId());

		// put the 'get' values into a response page

		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("greatestSportsMoment", gsm);

		// show the response page
		return "ResponsePage.xhtml";

	}

	public String onShowEdit(GreatestSportsMoment gsm) {

		System.out.println("the object you planning to edit is  " + gsm.getSporting_moment());
		// put the 'get' values into a response page

		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("greatestSportsMoment", gsm);

		return "EditForm.xhtml";

	}

	public String showEntryForm() {
		return "EntryForm.xhtml";
	}

	public String showIndex() {
		return "index.xhtml";
	}
}
