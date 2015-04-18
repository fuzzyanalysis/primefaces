package com.fuzzyanalysis.accadacca.view;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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

import com.fuzzyanalysis.accadacca.dao.DBManager;
import com.sun.faces.component.visit.FullVisitContext;

@ManagedBean
@ViewScoped
public class MakeDropdownView implements Serializable {

	private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
	private String make = "";
	private String model = "";
	private String year = "";
	private Map<String, String> makes;
	private Map<String, String> models;
	private Map<String, String> years;
	private Map<String, String> details;
	
	private OutputPanel panel;
	DBManager dbmanager = new DBManager();

	@ManagedProperty(value = "#{googleImagesBean}")
	private GoogleImagesBean googleImagesBean;
	
	@ManagedProperty(value = "#{wikipediaBean}")
	private WikipediaBean wikipediaBean;
	
	@ManagedProperty(value = "#{carBean}")
	private CarBean carBean;


	public CarBean getCarBean() {
		return carBean;
	}

	public void setCarBean(CarBean carBean) {
		this.carBean = carBean;
	}

	public Map<String, String> getDetails() {
		return details;
	}

	public void setDetails(Map<String, String> details) {
		this.details = details;
	}
	
	public WikipediaBean getWikipediaBean() {
		return wikipediaBean;
	}

	public void setWikipediaBean(WikipediaBean wikipediaBean) {
		this.wikipediaBean = wikipediaBean;
	}

	public GoogleImagesBean getGoogleImagesBean() {
		return googleImagesBean;
	}

	public void setGoogleImagesBean(GoogleImagesBean googleImagesBean) {
		this.googleImagesBean = googleImagesBean;
	}

	@PostConstruct
	public void init() {
		
		makes = dbmanager.getAllCarMakes();
		data.put("Makes", makes);
	}

	public Map<String, Map<String, String>> getData() {
		return data;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Map<String, String> getMakes() {
		return makes;
	}

	public Map<String, String> getModels() {
		return models;
	}
	
	public Map<String, String> getYears() {
		return years;
	}
	

	public void onMakeChange() {
		if (make != null && !make.equals("")) {
			String searchTerm = make + " " + model + " " + year;
			models = dbmanager.getCarModels(make, year);
			years = dbmanager.getCarYears(make, model);			
			googleImagesBean.setImage(
					googleImagesBean.getImage(searchTerm));
			wikipediaBean.setTitle(searchTerm);
			wikipediaBean.setLogo(wikipediaBean.getLogo(make));
		} else {
			//models = new HashMap<String, String>();
		}		
	}

	public void onModelChange() {
		if (model != null && !model.equals("")) {
			String searchTerm = make + " " + model + " " + year;
			makes = dbmanager.getCarMakes(model, year);
			years = dbmanager.getCarYears(make, model);
			googleImagesBean.setImage(
					googleImagesBean.getImage(searchTerm));
			wikipediaBean.setTitle(searchTerm);
			wikipediaBean.setLogo(searchTerm);
		} else {
			//years = new HashMap<String, String>();
		}
	}

	public void onYearChange() {
		if (year != null && !year.equals("")) {
			String searchTerm = make + " " + model + " " + year;
			makes = dbmanager.getCarMakes(model, year);
			models = dbmanager.getCarModels(make, year);
			googleImagesBean.setImage(
					googleImagesBean.getImage(searchTerm));
			wikipediaBean.setTitle(searchTerm);			
			String detail = dbmanager.getCarDetails(make, model, year);
			carBean.setAerodynamic_dragcoefisient(detail);
		}
		 
	}

	public void displayLocation() {
		FacesMessage msg;
		if (model != null && make != null)
			msg = new FacesMessage("Selected", model + " of " + make);
		else
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid",
					"Make is not selected.");

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
					.getApplication()
					.createComponent(FileUpload.COMPONENT_TYPE);
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
				if (component != null && component.getId() != null
						&& component.getId().equals(id)) {
					found[0] = component;
					return VisitResult.COMPLETE;
				}
				return VisitResult.ACCEPT;
			}
		});

		return found[0];

	}
}
