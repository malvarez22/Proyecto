package com.unrc.app;

import com.unrc.app.models.User;
import com.unrc.app.Dueño;
import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	Dueño d = new Dueño();
	d.insertar("eliana","dominguez","Cordoba",154220674,"balaco","concejal barrera 7878","eli_dominguez_88@hotmail.com");

	d.eliminar(1);
	d.modificar(78,"last_name","jorge");
	
	Inmobiliaria i=new Inmobiliaria();

//si se quiere insertar con un dueño que no existe tira exception
	//i.insertar("a","b","c","d","e","f","g",1);
	i.insertar("gutierrez Inmobiliaria","Cordoba","balaco","concejal barrera 7878",154220674,"e@hotmail.com","www.z.com",2);
	i.eliminar(4);
	i.modificar(2,"first_name","jorge");
	

//prueba dueño inmueble e inmueble 


	DueñoInmueble di = new DueñoInmueble();
	di.insertar("eliana","dominguez","Cordoba",154220674,"balaco","concejal barrera 7878","eli_dominguez_88@hotmail.com",1);
//	di.eliminar(1);
//	di.modificar(3,"last_name","jorge");
	
	Inmueble inm = new Inmueble();
//si se desea agregar un tipo diferente del enum creado lanza error
	inm.insertar("Cordoba","balaco","concejal barrera 7878","bueno",45,2,1,3);
	
//	inm.insertar("a","b","c","d",8,"f","g",2);
//inm.eliminar(1);
	//inm.modificar(3,"last_name","jorge");
	


        System.out.println( "Hello World!" );
    }
}
