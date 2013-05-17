package com.unrc.app;

import com.unrc.app.models.RealState;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inmobiliaria {

//metodos insertar,modificar,eliminar inmobiliaria    
	public static void insertar(String nombre,String ciudad,String barrio,String calle,String telefono,String email,String sitio_Web,String nombreDueño,String apellidoDueño){
		RealState inmo=new RealState();
		Owner d=new Owner();
		inmo.set("nombre",nombre);
		inmo.set("ciudad",ciudad); 
		inmo.set("barrio",barrio);
		inmo.set("calle",calle);

		inmo.set("telefono",telefono);
		inmo.set("email",email);
		inmo.set("sitio_Web",sitio_Web);
		d.find("nombre = ?","apellido=?" ,nombreDueño);
		inmo.set("id_dueño",d.get(id));
			
	}
	
	
	
	public static void modificar(String nombre,String elemento, String  cambio){
		RealState inomo=new RealState();
		inmo.find("nombre= ?",nombre);
		inmo.set(elemento,cambio);
	}
	
	public static void eliminar(String nombre){
		RealState inmo=new RealState();
		inmo.find("nombre= ?",nombre);
		inmo.delete(nombre);
	}
	
	
