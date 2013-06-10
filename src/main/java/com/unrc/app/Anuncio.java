package com.unrc.app;

import com.unrc.app.models.Building;
import com.unrc.app.models.Ad;
import com.unrc.app.models.OwnerBuilding;
import com.unrc.app.models.RealState;

public class Anuncio {
//metodos insertar,modificar,eliminar anuncio    

	public static void insertar(String descriptive_text,String id_buildings, String id_ownersBuildings, String realstate){
		Building b=new Building();
		OwnerBuilding ob= new OwnerBuilding();
                RealState re=new RealState();
		Ad ad= new Ad();
		ad.set("descriptive_text",descriptive_text);
		ob=OwnerBuilding.findById(id_ownersBuildings);
		ad.set("id_ownersBuilding",ob.getId());
                re=RealState.findById("id_realstate");
                ad.set("id_realtate",re.getId());		
		b=Building.findById(id_buildings);
		ad.set("id_Building",b.getId());
		ad.saveIt();			
	
	}
	
	

	public static void modificar(String id,String descriptive_text,String id_buildings,String id_ownersBuildings,String id_realstate){
		Ad ad= new Ad();
		ad=Ad.findById(id);
		if (ad!=null){
			Building b=new Building();
			OwnerBuilding ob= new OwnerBuilding();
                        RealState re=new RealState();	
			ad.set("descriptive_text",descriptive_text);
                        
			ob=OwnerBuilding.findById(id_ownersBuildings);
			ad.set("id_ownersBuilding",ob.getId());
			
			b=Building.findById(id_buildings);
			ad.set("id_Building",b.getId());
                        
                        re=RealState.findById(id_realstate);
                        ad.set("id_realstate",re.getId());
			ad.saveIt();			
		}
	}

	

	public static void eliminar(String id){
		Ad ad=new Ad();
		ad=Ad.findById(id);
		if (ad!=null){
			ad.deleteCascade();
		}

	}
	
}	
