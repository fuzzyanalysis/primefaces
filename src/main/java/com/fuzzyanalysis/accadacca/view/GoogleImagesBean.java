package com.fuzzyanalysis.accadacca.view;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
//import org.primefaces.model.DefaultString;
//import org.primefaces.model.String;
import org.primefaces.json.JSONObject;

@ManagedBean
@ViewScoped
public class GoogleImagesBean {

	public String image;

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		if(this.image != null){
			return getImage(this.image);	
		} else {
			return getImage("car");
		}
		
	}

	public String getImage(String search) {

		String imageUrl = null;
        try{
        	search = search.replace(" ", "%20");
            URL url = new URL("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=" + search);
            URLConnection connection = url.openConnection();

            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((line = reader.readLine()) != null) {
                builder.append(line);
            }

            JSONObject json = new JSONObject(builder.toString());
            imageUrl = json.getJSONObject("responseData").getJSONArray("results").getJSONObject(0).getString("url");

            //BufferedImage image = ImageIO.read(new URL(imageUrl));
            //JOptionPane.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(image));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Failure", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
		return imageUrl;
	}

}
