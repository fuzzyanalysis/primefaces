package com.fuzzyanalysis.accadacca.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class PropertiesManager {

	static {
		
	}
	public PropertiesManager(){
		
	}
	
	public String getProperty(String propertyName) {
		
		Properties prop = new Properties();
		InputStream input = null;
	 
		try {
	 
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			input = loader.getResourceAsStream("/database.properties");
	 
			// load a properties file
			prop.load(input);

			// return the property value
			return prop.getProperty(propertyName);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
		
	}
	
}
