package com.datasciencebox.editor;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@ViewScoped
public class ButtonBean implements Serializable {

	public String host;
	
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
