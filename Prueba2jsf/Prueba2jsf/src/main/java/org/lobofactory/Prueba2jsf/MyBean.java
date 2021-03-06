package org.lobofactory.Prueba2jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;



public class MyBean implements Serializable {

    private static final long serialVersionUID = 8301865434469950945L;

    private List<SelectItem> listaIdiomas;

    String str = "hello";

    private String idioma;
    public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public void init(){

    	listaIdiomas = new ArrayList<SelectItem>();
    	SelectItem es = new SelectItem();
    	SelectItem en = new SelectItem();
    	SelectItem fr = new SelectItem();
    	es.setLabel("es");
    	es.setValue(new Locale("es") );
    	en.setLabel("en");
    	en.setValue(Locale.ENGLISH);
    	fr.setLabel("fr");
    	fr.setValue(Locale.FRENCH);
    	
    	listaIdiomas.add(es);
    	listaIdiomas.add(en);
    	listaIdiomas.add(fr);
    	
    }
    public List<SelectItem> getListaIdiomas() {
    	SelectItem lala;
    	
		return listaIdiomas;
	}
	public void setListaIdiomas(List<SelectItem> listaIdiomas) {
		this.listaIdiomas = listaIdiomas;
	}
	public String getStr() {
        return str;
    }

    
	public void setStr(String str) {
        this.str = str;
    }

    public void reset(ActionEvent ae) {
        str = "";
    }
    
    public void selectedLocaleListener(ValueChangeEvent vce){
    	Locale l= new Locale(vce.getNewValue().toString());
    	FacesContext.getCurrentInstance().getViewRoot().setLocale(l);
    }

}
