package com.fuzzyanalysis.accadacca.view;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class BasicView {
     
    private String text;
 
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}