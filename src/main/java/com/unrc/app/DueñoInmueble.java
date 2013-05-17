package com.unrc.app;

import com.unrc.app.models.OwnerBuilding;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DueñonInmueble {

//metodos insertar,modificar,eliminar dueño inmobiliaria    
	public static void insertar(String nombre,String apellido,String ciudad,String barrio,String calle,String telefono,String email,String inmobiliaria){
		OwnerBuilding inmo=new OwnerBuilding();
		RealState d= new RealState();
		inmo.set("nombre",nombre);
		inmo.set("apellido",apellido);

		inmo.set("ciudad",ciudad); 
		inmo.set("barrio",barrio);
		inmo.set("calle",calle);

		inmo.set("telefono",telefono);
		inmo.set("email",email);	
		
		d.find("nombre",inmobiliaria);
		inmo.set("id_inmobiliaria",d.get(id));
		
	}
	
	
	
	public static void modificar(String nombre,String apellido,String elemento, String  cambio){
		Owner inmo=new Owner();
		inmo.find("nombre= ?",nombre);
		inmo.set(elemento,cambio);
	}
	
	public static void eliminar(String nombre,String apellido){
		Owner inmo=new Owner();
		inmo.find("nombre= ?",nombre);
		inmo.delete(nombre);
	}
	
	
