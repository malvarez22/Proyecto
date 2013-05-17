package main.com.unrc.app;

import main.com.unrc.app.models.Ad;

import org.javalite.activejdbc.Base;
import org.slf4j.spi.*;

public class Anuncio {

//metodos insertar,modificar,eliminar dueño un Anuncio    
	public static void insertar(String descriptive_text){
		Ad inmo=new Ad();
		inmo.set("texto descriptivo",descriptive_text);					
	}
	
	
	
	public static void modificar(String descriptive_text, String element, String change){
		Ad inmo=new Ad();
		inmo.find("texto descriptivo= ?",descriptive_text);
		inmo.set(element,change);
	}
	
	public static void eliminar(String descriptive_text){
		Ad inmo=new Ad();
		inmo.find("texto descriptivo= ?",descriptive_text);
		inmo.delete(descriptive_text);
	}
}	
	
