package com.datasciencebox.editor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.context.FacesContext;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.component.outputpanel.OutputPanel;
import org.primefaces.component.panel.Panel;
import org.primefaces.context.ApplicationContext;

import com.sun.faces.component.visit.FullVisitContext;

@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {

	private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
	private String country;
	private String city;
	private Map<String, String> countries;
	private Map<String, String> cities;
	private OutputPanel panel;

	@PostConstruct
	public void init() {
		countries = new HashMap<String, String>();
		countries.put("USA", "USA");
		countries.put("Germany", "Germany");
		countries.put("Brazil", "Brazil");

		Map<String, String> map = new HashMap<String, String>();
		map.put("New York", "New York");
		map.put("San Francisco", "San Francisco");
		map.put("Denver", "Denver");
		data.put("USA", map);

		map = new HashMap<String, String>();
		map.put("Berlin", "Berlin");
		map.put("Munich", "Munich");
		map.put("Frankfurt", "Frankfurt");
		data.put("Germany", map);

		map = new HashMap<String, String>();
		map.put("Sao Paolo", "Sao Paolo");
		map.put("Rio de Janerio", "Rio de Janerio");
		map.put("Salvador", "Salvador");
		data.put("Brazil", map);
	}

	public Map<String, Map<String, String>> getData() {
		return data;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Map<String, String> getCountries() {
		return countries;
	}

	public Map<String, String> getCities() {
		return cities;
	}

	public void onCountryChange() {
		if (country != null && !country.equals(""))
			cities = data.get(country);
		else
			cities = new HashMap<String, String>();
	}

	public void displayLocation() {
		FacesMessage msg;
		if (city != null && country != null)
			msg = new FacesMessage("Selected", city + " of " + country);
		else
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid",
					"City is not selected.");

		FacesContext.getCurrentInstance().addMessage(null, msg);

		FacesContext.getCurrentInstance().getApplication()
				.createComponent(null, null);
	}

	public OutputPanel getPanel() {

		return this.panel;

	}

	public void setPanel(OutputPanel panel) {
		this.panel = panel;
		if (panel != null) {
			if (findComponent("tester") == null) {
				Calendar cal = (Calendar) FacesContext.getCurrentInstance()
						.getApplication()
						.createComponent(Calendar.COMPONENT_TYPE);
				cal.setId("tester");
				cal.setAlt("oh yeah");
				cal.setTitle("this is a dynamic title");
				this.panel.getChildren().add(cal);
			}
		}
	}

	public void createUI() {
		if (findComponent("tester2") == null) {
			FileUpload fu = (FileUpload) FacesContext.getCurrentInstance()
					.getApplication().createComponent(FileUpload.COMPONENT_TYPE);
			fu.setId("tester2");
			this.panel.getChildren().add(fu);			
		}

	}

	public UIComponent findComponent(final String id) {

		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot root = context.getViewRoot();
		final UIComponent[] found = new UIComponent[1];

		root.visitTree(new FullVisitContext(context), new VisitCallback() {
			@Override
			public VisitResult visit(VisitContext context, UIComponent component) {
				if (component != null && component.getId() != null && component.getId().equals(id)) {
					found[0] = component;
					return VisitResult.COMPLETE;
				}
				return VisitResult.ACCEPT;
			}
		});

		return found[0];

	}
}
