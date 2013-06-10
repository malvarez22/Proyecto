package com.unrc.app;

import com.unrc.app.models.User;
import org.javalite.activejdbc.Base;

public class Inmo {
    public static void main( String[] args )
    {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");

        User e = new User();
        e.set("email", "user@email.com");
        e.set("first_name", "John");
        e.set("last_name", "Doe");
        e.saveIt();

/*en este bloque de codigo se prueban clases dueño e inmobiliaria*/
	Dueño.insertar("","eliana","dominguez","Cordoba","154220674","balaco","concejal barrera 7878","eli_dominguez_88@hotmail.com");

	Dueño.eliminar("1");
	Dueño.modificar("","78","last_name","jorge","f","g","d","a","");
	
	
	Inmobiliaria.eliminar("4");
	Inmobiliaria.modificar("2","first_name","jorge","","","","","","");
	

//prueba dueño inmueble e inmueble 

	DueñoInmueble.insertar("eliana","dominguez","Cordoba","154220674","balaco","concejal barrera 7878","eli_dominguez_88@hotmail.com","1","");
	
//si se desea agregar un tipo diferente del enum creado lanza error
	Inmueble.insertar("Cordoba","balaco","concejal barrera 7878","bueno","45","2","1","3","");
	System.out.println( "Hello Inmo!" );
    }
}
