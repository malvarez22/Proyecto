package com.unrc.app;

import com.unrc.app.models.Owner;

import org.javalite.activejdbc.Base;
import org.slf4j.spi.*;

public class Dueño {

//metodos insertar,modificar,eliminar dueño inmobiliaria    
	public static void insertar(String first_name,String last_name,String city,int phone_number,String neighborhood,String street,String email){
		Owner inmo=new Owner();
		inmo.set("first_name",first_name);
		inmo.set("last_name",last_name);        
		inmo.set("city",city); 
		inmo.set("phone_number",phone_number);
		inmo.set("neighborhood",neighborhood);
		inmo.set("street",street);
		inmo.set("email",email);
		inmo.saveIt();			
	}

	
	
	public static void modificar(int id,String element, String  change){
		Owner inmo=new Owner();
		inmo=inmo.findById(id);
		if (inmo!=null){
			inmo.set(element,change);
			inmo.saveIt();			

		}
		
	}
	
	public static void eliminar(int id){
		Owner inmo=new Owner();
		inmo=inmo.findById(id);
		if (inmo!=null){
			inmo.deleteCascade();
		}

	}
}	
	
