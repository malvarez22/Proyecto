package com.unrc.app;

import com.unrc.app.models.*;

public class DueñoInmueble {

//metodos insertar,modificar,eliminar dueño inmobiliaria    
	public static void insertar(String first_name,String last_name,String city,String neighborhood,String street,String email,String phone_number,String id_building, String id_realstate){
		OwnerBuilding ob=new OwnerBuilding();
		RealState re= new RealState();
                Building b=new Building();
		ob.set("first_name",first_name);
		ob.set("last_name",last_name);
		ob.set("city",city);
		ob.set("phone_number",phone_number);
		ob.set("neighborhood",neighborhood);
		ob.set("street",street);		
		ob.set("email",email);
                b = Building.findById(id_building);
		ob.set("id_building",re.getId());//para ver a que inmobiliaria pertence
		re = RealState.findById(id_realstate);
		ob.set("id_realStates",re.getId());//para ver a que inmobiliaria pertence
		ob.saveIt();
		
	}





	public static void modificar(String id,String first_name,String last_name,String city,String neighborhood,String street,String email,String phone_number,String id_building, String id_realstate){
		
		OwnerBuilding ob=new OwnerBuilding();
		ob=OwnerBuilding.findById(id);
		RealState re= new RealState();
                Building b=new Building();
		if (ob!=null){
			ob.set("first_name",first_name);
			ob.set("last_name",last_name);
			ob.set("city",city);
			ob.set("phone_number",phone_number);
			ob.set("neighborhood",neighborhood);
			ob.set("street",street);		
			ob.set("email",email);
			re = RealState.findById(id_realstate);
			ob.set("id_realStates",re.getId());//para ver a que inmobiliaria pertence
                        b = Building.findById(id_building);
			ob.set("id_building",b.getId());//para ver que inmueble posee 
			ob.saveIt();
		}

	}



	public static void eliminar(String id){
		OwnerBuilding ob=new OwnerBuilding();
		ob=OwnerBuilding.findById(id);
		if (ob!=null){
			ob.deleteCascade();
		}

	}

}	
	
	
