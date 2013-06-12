package com.unrc.app;

import com.unrc.app.models.Owner;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class OwnerTest {

    @Before
    public void beforeTest() {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        Base.openTransaction();
    }

    @After
    public void afterTest() {
        Base.rollbackTransaction();
        Base.close();
    }

    @Test
    public void testInsertar1() {
        System.out.println("insertar 1");
        String first_name = "pato";
        String last_name = "lagable";
        String city = "rio cuarto";
        String phone_number = "1251611321";
        String neighborhood = "barrio universidad";
        String street = "colon 612";
        String email = "casa@gmail.com";
        String id_realstate="1";
	Dueño dueño=new Dueño();
	Owner owner=new Owner();
	Owner o=new Owner();

	dueño.insertar(first_name, last_name, city, phone_number, neighborhood, street, email,id_realstate);
        //busca TODOS los OWNER que coincidan
        LazyList<Owner> encontrados = Owner.where(
                "first_name = '" + first_name + "' and "
                + "last_name = '" + last_name + "' and "
                + "city = '" + city + "' and "
                + "phone_number = '" + phone_number + "' and "
                + "neighborhood = '" + neighborhood + "' and "
                + "street = '" + street + "' and "
                + "email = '" + email + "'");
             
        assertTrue(encontrados.size() == 1);
    }

    @Test
    public void testInsertar2() {
        System.out.println("insertar 2");
        String first_name = "carlos";
        String last_name = "lopez";
        String city = "buenos aires ";
        String phone_number = "1251";
        String neighborhood = "centro";
        String street = "colon 612";
        String email = "casagmail@hotmail.com";
        String id_realstate="1";
        Dueño.insertar(first_name, last_name, city, phone_number, neighborhood, street, email,id_realstate);
        //busca TODOS los OWNER que coincidan
        LazyList<Owner> encontrados = Owner.where(
                "first_name = '" + first_name + "' and "
                + "last_name = '" + last_name + "' and "
                + "city = '" + city + "' and "
                + "phone_number = '" + phone_number + "' and "
                + "neighborhood = '" + neighborhood + "' and "
                + "street = '" + street + "' and "
                + "email = '" + email + "'");

        assertTrue(encontrados.size() == 1);
    }

    @Test
    public void testInsertar3() {
        System.out.println("insertar 3");
        String first_name = "puedo tener un nombre asi: _:lslsls**//8 ";
        String last_name = "bonnet";
        String city = "laboulaie ";
        String phone_number = "1251611001";
        String neighborhood = " ";
        String street = "colon 612";
        String email = "casagmail@hh.com"; //checkeado que funciona validate
        String id_realstate="1";

        Dueño.insertar(first_name, last_name, city, phone_number, neighborhood, street, email,id_realstate);
        //busca TODOS los OWNER que coincidan
        LazyList<Owner> encontrados = Owner.where(
                "first_name = '" + first_name + "' and "
                + "last_name = '" + last_name + "' and "
                + "city = '" + city + "' and "
                + "phone_number = '" + phone_number + "' and "
                + "neighborhood = '" + neighborhood + "' and "
                + "street = '" + street + "' and "
                + "email = '" + email + "' ");

        assertTrue(encontrados.size() == 1);
    }

    
    @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar 1");

        String first_name = "pato";
        String last_name = "lagable";
        String city = "rio cuarto";
        String phone_number = "1251611321";
        String neighborhood = "barrio centro";
        String street = "colon 612";
        String email = "lapato@gmail.com";
        String id_realstate="1";
	Dueño d=new Dueño();
	Owner owner=new Owner();
        Dueño.insertar(first_name, last_name, city, phone_number, neighborhood, street, email,id_realstate);
        Owner encontrado = Owner.findFirst(
                "first_name = '" + first_name + "' and "
                + "last_name = '" + last_name + "' and "
                + "city = '" + city + "' and "
                + "phone_number = '" + phone_number + "' and "
                + "neighborhood = '" + neighborhood + "' and "
                + "street = '" + street + "' and "
                + "email = '" + email + "'");
	int id =(Integer)encontrado.getId();
	String in=Integer.toString(id);
        if (encontrado == null) {
            fail("Error: No se encontro elemento para borrar");
        } else {
		Dueño.eliminar(in);
        	}
	Owner o=Owner.findById(id);
	assertTrue(o==null);
    }

    @Test
    public void testModificar() {
	System.out.println("modificar 1");
	Dueño dueño=new Dueño();
	Owner owner=new Owner();
	Owner o=new Owner();
	
        String first_name = "pato";
        String last_name = "lagable";
        String city = "rio cuarto";
        String phone_number = "1251611321";
        String neighborhood = "barrio universidad";
        String street = "colon 612";
        String email = "eli_dominguez_88@hotmail.com";
        String id_realstate="1";
	String new_firstName="patricia";
	Dueño.insertar(first_name, last_name, city, phone_number, neighborhood, street, email,id_realstate);
	o=Owner.findFirst("first_name = ?",first_name);
	int id =(Integer)o.getId();
	String in= Integer.toString(id);	
    	Dueño.modificar(in,new_firstName,last_name,city,phone_number,neighborhood,street,email,id_realstate);
	o=Owner.findFirst("first_name = ?",new_firstName);

	assertFalse(o==null);	
   }
}
