package com.unrc.app;

import com.unrc.app.models.Building;
import com.unrc.app.models.Ad;
import com.unrc.app.models.OwnerBuilding;
import com.unrc.app.models.RealState;

public class Anuncio {
//metodos insertar,modificar,eliminar anuncio    

	public static void insertar(String descriptive_text,String id_Building, String id_ownersBuilding, String id_realstate){
		Building b=new Building();
		OwnerBuilding ob= new OwnerBuilding();
                RealState re=new RealState();
                Ad ad= new Ad();
                
                b=Building.findById(id_Building);                
                ob=OwnerBuilding.findById(id_ownersBuilding);                
                re=RealState.findById(id_realstate);

		ad.set("descriptive_text",descriptive_text);
                ad.set("id_Building",b.getId());
                ad.set("id_ownersBuilding",ob.getId());
	        ad.set("id_realstate",re.getId());
                                		
                ad.saveIt();	
	}

	public static void modificar(String id,String descriptive_text,String id_Building,String id_ownersBuilding,String id_realstate){
		Ad ad= new Ad();
		ad=Ad.findById(id);
		if (ad!=null){
			Building b=new Building();
			OwnerBuilding ob= new OwnerBuilding();
                        RealState re=new RealState();
                        
			ad.set("descriptive_text",descriptive_text);
                        
			b=Building.findById(id_Building);
			ad.set("id_Building",b.getId());

                        
                        ob=OwnerBuilding.findById(id_ownersBuilding);
			ad.set("id_ownersBuilding",ob.getId());
			
			                        
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
