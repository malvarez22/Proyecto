package com.unrc.app;

import com.unrc.app.models.Building;
import com.unrc.app.models.OwnerBuilding;
import com.unrc.app.models.RealState;

public class Inmueble {
//metodos insertar,modificar,eliminar inmueble    

	public static void insertar(String city,String neighborhood,String street,String descriptive_text,String price,String id_isType,String id_situation,String id_ownersBuilding, String id_realstate){
		Building b=new Building();
		OwnerBuilding ob= new OwnerBuilding();
                RealState re= new RealState();
		b.set("city",city); 
		b.set("neighborhood",neighborhood);
		b.set("street",street);
		b.set("descriptive_text",descriptive_text);
		b.set("price",price);			
		b.set("id_isType",id_isType);
		b.set("id_situation",id_situation);
		ob=OwnerBuilding.findById(id_ownersBuilding);
		b.set("id_ownersBuilding",ob.getId());
                re=RealState.findById(id_realstate);
                b.set("id_realstate",re.getId());
                b.saveIt();			
	
	}
	
	

	public static void modificar(String id,String city,String neighborhood,String street,String descriptive_text,String price,String id_isType,String id_situation,String id_ownersBuilding, String id_realstate){
		Building b=new Building();		
		OwnerBuilding ob= new OwnerBuilding();
                RealState re=new RealState();
		b=Building.findById(id);
		if (b!=null){
			b.set("city",city); 
			b.set("neighborhood",neighborhood);
			b.set("street",street);
			b.set("descriptive_text",descriptive_text);
			b.set("price",price);			
			b.set("id_isType",id_isType);
			b.set("id_situation",id_situation);
			ob=OwnerBuilding.findById(id_ownersBuilding);
			b.set("id_ownersBuilding",ob.getId());
                        re=RealState.findById(id_realstate);
                        b.set("id_realstate",re.getId());
			b.saveIt();			
		}

	}
	

	public static void eliminar(String id){
		Building ob=new Building();
		ob=Building.findById(id);
		if (ob!=null){
			ob.deleteCascade();
		}

	}
	
}	
