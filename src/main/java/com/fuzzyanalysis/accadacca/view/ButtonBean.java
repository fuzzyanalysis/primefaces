package com.fuzzyanalysis.accadacca.view;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@ViewScoped
public class ButtonBean implements Serializable {

	public String host;
	private String text = "Starting text";//getter + setter
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String javascriptCall(){
		return "haha";
	}
	
	public void listener() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
	    text = "Text was changed via remote command on " + dateFormat.format(cal.getTime());
	}
	
	public String getHost(String page) {
		try {
			
			/**
			 * Note: this is the hard way.
			 * 
			 * The easy way is to simply put the page url to navigate to in the xhtml.
			 */
			
			HttpServletRequest origRequest = 
					(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			
			String url = origRequest.getScheme() + //eg. http
							"://" + origRequest.getServerName() + //eg. localhost
							":" + origRequest.getServerPort() + // eg. 8080
							origRequest.getContextPath() + // eg. primefaces
							origRequest.getServletPath() + // eg. faces
							"/" + page; // eg. index.xhtml
			
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		    //((HttpServletRequest) ec.getRequest()).logout();
		    ec.invalidateSession();
		    ec.redirect(url);
			
			return url;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setHost(String host) {
		this.host = host;
	}	

}
