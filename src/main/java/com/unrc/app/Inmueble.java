

package com.unrc.app;

import com.unrc.app.models.Building;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inmueble {


  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  ciudad VARCHAR(60),
  barrio VARCHAR(60),
  calle VARCHAR(60),
  texto_descriptivo text,
  precio int (12),
  tipo ENUM ('campo','quinta', 'casa', 'departamento','oficina','cochera'),
  situacion ENUM('VENTA','ALQUILER'),
  id_dueñoInmueble int(11),
  id_inmobiliaria int (11),
//metodos insertar,modificar,eliminar inmueble    
	public static void insertar(String ciudad,String barrio,String calle,String texto,Integer precio,String tipo,String situacion,String nombreDueño,String apellidoDueño){
		Building inmo=new Building();
		OwnerBuilding d= new ObwnerBuilding();

		inmo.set("ciudad",ciudad); 
		inmo.set("barrio",barrio);
		inmo.set("calle",calle);

		inmo.set("texto_descriptivo",texto);
		inmo.set("precio",precio);	
		inmo.set("tipo",tipo);
		inmo.set("situacion",situacion);
		d.find("nombre= ?"nombreDueño);
		inmo.set("id_dueño",id);
	}
	
	
	
	public static void modificar(String nombre,String apellido,String elemento, String  cambio){
		Building inmo=new Building();
		inmo.find("nombre= ?",nombre);
		inmo.set(elemento,cambio);
	}
	
	public static void eliminar(String nombre,String apellido){
		Building inmo=new Building();
		inmo.find("nombre= ?",nombre);
		inmo.delete(nombre);
	}
	
	
