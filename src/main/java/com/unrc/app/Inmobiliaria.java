package com.unrc.app;

import com.unrc.app.models.*;

public class Inmobiliaria {

//metodos insertar,modificar,eliminar inmobiliaria    
	public static void insertar(String first_name,String city,String neighborhood,String street,String phone_number,String email,String webSite,String id_owners){
		RealState re=new RealState();
		Owner d=new Owner();
		re.set("first_name",first_name);
		re.set("city",city); 
		re.set("neighborhood",neighborhood);
		re.set("street",street);
		re.set("phone_number",phone_number);
		re.set("email",email);
		re.set("webSite",webSite);
		d=Owner.findById(id_owners);
		re.set("id_owners",d.getId());
		re.saveIt();			
	}
	public static void modificar(String id,String first_name,String city,String neighborhood,String street,String phone_number,String email,String webSite,String id_owners){
		RealState re=new RealState();
		Owner d=new Owner();
		re=RealState.findById(id);
		if (re!=null){
			re.set("first_name",first_name);
			re.set("city",city); 
			re.set("neighborhood",neighborhood);
			re.set("street",street);
			re.set("phone_number",phone_number);
			re.set("email",email);
			re.set("webSite",webSite);
			d=Owner.findById(id_owners);
			re.set("id_owners",d.getId());
			re.saveIt();			
		}
	}
        
	public static void eliminar(String id){
		RealState re=new RealState();
		re=RealState.findById(id);
		if (re!=null){
			re.deleteCascade();
		}

	}


	
}	
	
	
