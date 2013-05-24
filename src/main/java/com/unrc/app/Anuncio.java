package com.unrc.app;

import com.unrc.app.models.Building;
import com.unrc.app.models.Ad;
import com.unrc.app.models.OwnerBuilding;
import org.javalite.activejdbc.Base;
import org.slf4j.spi.*;

public class Anuncio {
//metodos insertar,modificar,eliminar anuncio    

	public void insertar(String descriptive_text,int id_buildings, int id_ownersBuildings){
		Building b=new Building();
		OwnerBuilding ob= new OwnerBuilding();
		Ad ad= new Ad();
		ad.set("descriptive_text",descriptive_text);
		ob=ob.findById(id_ownersBuildings);
		ad.set("id_ownersBuildings",ob.getId());
		
		b=b.findById(id_buildings);
		ad.set("id_buildings",b.getId());
		ad.saveIt();			
	
	}
	
	

	public static void modificar(int id,String element, String  change){
		Ad ad= new Ad();
		ad=ad.findById(id);
		if (ad!=null){
			ad.set(element,change);
			ad.saveIt();
		}

	}
	

	public static void eliminar(int id){
		Ad ad=new Ad();
		ad=ad.findById(id);
		if (ad!=null){
			ad.deleteCascade();
		}

	}
	
}	
