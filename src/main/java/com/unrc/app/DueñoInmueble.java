package com.unrc.app;
import com.unrc.app.models.*;

import org.javalite.activejdbc.Base;

import org.slf4j.spi.*;

public class DueñoInmueble {
//metodos insertar,modificar,eliminar dueño inmobiliaria    
	public static void insertar(String first_name,String last_name,String city,int phone_number,String neighborhood,String street,String email, int id){	
		OwnerBuilding o=new OwnerBuilding();
		RealState d= new RealState();	
		o.set("first_name",first_name);
		o.set("last_name",last_name);
		o.set("city",city);
		o.set("phone_number",phone_number);
		o.set("neighborhood",neighborhood);
		o.set("street",street);		
		o.set("email",email);
		d = d.findById(id);
		o.set("id_realStates",d.getId());//para ver a que inmobiliaria pertence
		o.saveIt();		
	}

	public static void modificar(int id,String element, String  change){
		OwnerBuilding o=new OwnerBuilding();
		o=o.findById(id);
		if (o!=null){
			o.set(element,change);
			o.saveIt();
		}
	}

	public static void eliminar(int id){
		OwnerBuilding o=new OwnerBuilding();
		o=o.findById(id);
		if (o!=null){
			o.deleteCascade();
		}

	}

}	
	
	
