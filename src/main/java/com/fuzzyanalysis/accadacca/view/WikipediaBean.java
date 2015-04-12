package com.fuzzyanalysis.accadacca.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.json.JSONObject;

import com.jayway.jsonpath.JsonPath;

@ManagedBean
@ViewScoped
public class WikipediaBean {

	public final String WIKIPEDIA_URL = 
			"https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=";
	
	public final String WIKIPEDIA_LOGO_FRAGMENT = 
			"&prop=pageimages&format=json&pithumbsize=100";
	
	public String title;
	public String html;
	public String logo;

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getHtml() {
		if (this.title != null) {
			return getHtml(this.title);
		} else {
			return getHtml("car");
		}

	}

	public String getLogo(String search){
		
		StringBuffer sb = new StringBuffer();
		search = search.replace(" ", "_");
		URL url;
		InputStream is = null;
		BufferedReader br;
		String line;

		try {
			url = new URL(WIKIPEDIA_URL + search + WIKIPEDIA_LOGO_FRAGMENT);
			is = url.openStream(); // throws an IOException
			br = new BufferedReader(new InputStreamReader(is));

			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException ioe) {
				// nothing to see here
			}
		}
		JSONObject obj;
		String val;
		List<String> contents = JsonPath.read(sb.toString(),  "$..source");
//			obj = new JSONObject(sb.toString());
//			val = (String) obj.getJSONObject("query").getJSONObject("pages").getJSONObject("13673345").get("extract");
		val = contents.get(0).toString();
		this.logo = val;
		return val;
		
	}
	
	public String getHtml(String search) {

		StringBuffer sb = new StringBuffer();
		search = search.replace(" ", "_");
		URL url;
		InputStream is = null;
		BufferedReader br;
		String line;

		try {
			url = new URL(WIKIPEDIA_URL + search);
			is = url.openStream(); // throws an IOException
			br = new BufferedReader(new InputStreamReader(is));

			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException ioe) {
				// nothing to see here
			}
		}
		JSONObject obj;
		String val;
		List<String> contents = JsonPath.read(sb.toString(),  "$..extract");
//			obj = new JSONObject(sb.toString());
//			val = (String) obj.getJSONObject("query").getJSONObject("pages").getJSONObject("13673345").get("extract");
		val = contents.toString().substring(0, 400) + " ...";
		this.html = val;
		return val;
		
	}

}
