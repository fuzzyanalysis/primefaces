package com.fuzzyanalysis.accadacca.view;

 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
 
@ManagedBean(eager=true)
public class GrowlView {
 
	@ManagedProperty(value="#{calendarView}") 
	private CalendarView calendarView;
	
	@ManagedProperty(value = "#{makeDropdownView}")
	private MakeDropdownView makeDropdownView;

	public MakeDropdownView getMakeDropdownView() {
		return makeDropdownView;
	}

	public void setMakeDropdownView(MakeDropdownView makeDropdownView) {
		this.makeDropdownView = makeDropdownView;
	}
	
    public CalendarView getCalendarView() {
		return calendarView;
	}

	public void setCalendarView(CalendarView calendarView) {
		this.calendarView = calendarView;
	}

	private String message;
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
     
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(
        		null, new FacesMessage(
        				"Successful",  
        				"Your message: " + 
        				message + "\n" + 
        				calendarView.getDate().toString() + "\n" +
        				makeDropdownView.getMake() + 
        				" " + 
        				makeDropdownView.getModel()));
    }
}