package com.unrc.app;

import com.unrc.app.models.*;

import org.javalite.activejdbc.Base;
import org.slf4j.spi.*;

public class Inmobiliaria {

//metodos insertar,modificar,eliminar inmobiliaria    
	public static void insertar(String first_name,String city,String neighborhood,String street,int phone_number,String email,String webSite,int id_owner){
		RealState inmo=new RealState();
		Owner d=new Owner();
		inmo.set("first_name",first_name);
		inmo.set("city",city); 
		inmo.set("neighborhood",neighborhood);
		inmo.set("street",street);
		inmo.set("phone_number",phone_number);
		inmo.set("email",email);
		inmo.set("webSite",webSite);
		d=d.findById(id_owner);
		inmo.set("id_owners",d.getId());
		inmo.saveIt();			
	}

	public static void modificar(int id,String element, String  change){
		RealState inmo=new RealState();
		inmo=inmo.findById(id);
		if (inmo!=null){
			inmo.set(element,change);
			inmo.saveIt();
		}

	}
	
	

	public static void eliminar(int id){
		RealState inmo=new RealState();
		inmo=inmo.findById(id);
		if (inmo!=null){
			inmo.deleteCascade();
		}

	}


	
}	
	
	
