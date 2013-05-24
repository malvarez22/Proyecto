package com.unrc.app;

import com.unrc.app.models.Building;
import com.unrc.app.models.OwnerBuilding;
import org.javalite.activejdbc.Base;
import org.slf4j.spi.*;

public class Inmueble {
//metodos insertar,modificar,eliminar inmueble    

	public void insertar(String city,String neighborhood,String street,String descriptive_text,int price,int id_isType,int id_situation,int id_ownersBuilding){
		Building b=new Building();
		OwnerBuilding ob= new OwnerBuilding();
		
		b.set("city",city); 
		b.set("neighborhood",neighborhood);
		b.set("street",street);
		b.set("descriptive_text",descriptive_text);
		b.set("price",price);			
		b.set("id_isType",id_isType);
		b.set("id_situation",id_situation);
		ob=ob.findById(id_ownersBuilding);
		b.set("id_ownersBuilding",ob.getId());
		b.saveIt();			
	
	}
	
	

	public static void modificar(int id,String element, String  change){
		OwnerBuilding ob= new OwnerBuilding();
		ob=ob.findById(id);
		if (ob!=null){
			ob.set(element,change);
			ob.saveIt();
		}

	}
	

	public static void eliminar(int id){
		OwnerBuilding ob=new OwnerBuilding();
		ob=ob.findById(id);
		if (ob!=null){
			ob.deleteCascade();
		}

	}
	
}	
