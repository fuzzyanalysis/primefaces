package com.datasciencebox.editor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;

@ManagedBean(name = "buttonBean")
@ViewScoped
public class ButtonBean implements Serializable {

	public String host;
	private String text = "Starting text";// getter + setter
	private String metadata = null;
	private String message = "bean message";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	
	public String getMetadata() {
		return this.metadata;
	}

	public void getJSON() {
		FileInputStream inputStream;
		try {

			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			inputStream = (FileInputStream) loader
					.getResourceAsStream("/metadata.json");
			this.metadata = IOUtils.toString(inputStream);
			inputStream.close();			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return this.metadata;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String javascriptCall(String one, String two) {
		return "haha " + one + " " + two;
	}
	
	public void listener() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		text = "Text was changed via remote command on "
				+ dateFormat.format(cal.getTime());
	}

	public String getHost(String page) {
		try {

			/**
			 * Note: this is the hard way.
			 * 
			 * The easy way is to simply put the page url to navigate to in the
			 * xhtml.
			 */

			HttpServletRequest origRequest = (HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();

			String url = origRequest.getScheme() + // eg. http
					"://" + origRequest.getServerName() + // eg. localhost
					":" + origRequest.getServerPort() + // eg. 8080
					origRequest.getContextPath() + // eg. primefaces
					origRequest.getServletPath() + // eg. faces
					"/" + page; // eg. index.xhtml

			ExternalContext ec = FacesContext.getCurrentInstance()
					.getExternalContext();
			// ((HttpServletRequest) ec.getRequest()).logout();
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
