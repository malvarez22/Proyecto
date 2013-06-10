package com.unrc.app;

import com.unrc.app.models.Owner;
import com.unrc.app.models.RealState;

public class Dueño {

//metodos insertar,modificar,eliminar dueño inmobiliaria    
	public static void insertar(String first_name,String last_name,String city,String phone_number,String neighborhood,String street,String email, String id_realstate){
		Owner o=new Owner();
                RealState re=new RealState();
		o.set("first_name",first_name);
		o.set("last_name",last_name);        
		o.set("city",city); 
		o.set("phone_number",phone_number);
		o.set("neighborhood",neighborhood);
		o.set("street",street);
		o.set("email",email);
                re=RealState.findById(id_realstate);
                o.set("id_realstate",re.getId());
		o.saveIt();			
	}

	
	
	public static void modificar(String id,String first_name,String last_name,String city,String phone_number,String neighborhood,String street,String email,String id_realstate){
		Owner o=new Owner();
                RealState re=new RealState();
		o=Owner.findById(id);
		if (o!=null){
		o.set("first_name",first_name);
		o.set("last_name",last_name);        
		o.set("city",city); 
		o.set("phone_number",phone_number);
		o.set("neighborhood",neighborhood);
		o.set("street",street);
		o.set("email",email);
                re=RealState.findById(id_realstate);
                o.set("id_realstate",re.getId());
		o.saveIt();			
	
		}
		
	}
	
	public static void eliminar(String id){
		Owner inmo=new Owner();
		inmo=Owner.findById(id);
		if (inmo!=null){
			inmo.deleteCascade();
		}

	}
}	
	
