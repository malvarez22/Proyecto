package com.unrc.app;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.unrc.app.models.*;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author pato
 */
public class RealStateTest {
    
   @Before
    public void before(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        Base.openTransaction();
    }

    @After
    public void after(){
        Base.rollbackTransaction();
        Base.close();
    }

    @Test
     public void testInsertarR() {
     	System.out.println("insertar");
        String first_name = "pato";
        String city = "chajan";
        String neighborhood = "bimaco";
        String street = "vlz sarfil 4";
        String phone_number = "1188899912";
        String email = "juso@hotmail.com";
        String webSite = "www.oooi.com";
	String id_owners = "4";
        Inmobiliaria.insertar(first_name, city, neighborhood, street, phone_number, email, webSite, id_owners);
	RealState real=new RealState();
        //busca TODOS las inmobiliarias que coincidan
        LazyList<RealState> encontrados = RealState.where(
                "first_name = '" + first_name + "' and "
                + "city = '" + city + "' and "
                + "neighborhood = '" + neighborhood + "' and "
                + "street = '" + street + "' and "
                + "phone_number = '" + phone_number + "' and "
                + "email = '" + email + "'and "
                + "webSite= '"+webSite+"'");             
        assertTrue(encontrados.size() == 1);
    }

    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar");
        String first_name = "pato";
        String city = "chajan";
        String neighborhood = "bimaco";
        String street = "vlz sarfil 4";
        String phone_number = "1188899912";
        String email = "juso@hotmail.com";
        String webSite = "www.oooi.com";
	String id_owner = "4";
	Inmobiliaria inmo=new Inmobiliaria();
	RealState real=new RealState();

	Inmobiliaria.insertar(first_name, city, neighborhood, street, phone_number, email, webSite, id_owner);
	RealState encontrado = RealState.findFirst(
                "first_name = '" + first_name + "' and "
                + "city = '" + city + "' and "
                + "neighborhood = '" + neighborhood + "' and "
                + "street = '" + street + "' and "
                + "phone_number = '" + phone_number + "' and "
                + "email = '" + email + "'and "
                + "webSite= '"+webSite+"'");	
        if (encontrado == null) {
            fail("Error: No se encontro elemento para borrar");
        } else {
		String id =(String)encontrado.getId();	
		Inmobiliaria.eliminar("id");
		RealState r=RealState.findById(id);
	assertTrue(r==null);
    
        }
	
    }

    public void testModificar() {
	System.out.println("modificar 1");
	String first_name = "pato";
        String city = "chajan";
        String neighborhood = "bimaco";
        String street = "vlz sarfil 4";
        String phone_number = "1188899912";
        String email = "juso@hotmail.com";
        String webSite = "www.oooi.com";
	String id_owner = "4";
	String new_firstName="Gutierrez";
	Inmobiliaria inmo=new Inmobiliaria();
	Owner owner=new Owner();
	Inmobiliaria.insertar(first_name, city, neighborhood, street, phone_number, email, webSite, id_owner);
        Owner o=new Owner();
	o=Owner.findFirst("first_name = ?",first_name);
	String id =(String)o.getId();	
    	Inmobiliaria.modificar(id,new_firstName,city,neighborhood,street,phone_number,email,webSite,id_owner);
	o=Owner.findFirst("first_name = ?",new_firstName);

	assertFalse(o==null);	
   }

}
