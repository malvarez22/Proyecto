package com.unrc.app;

import com.unrc.app.models.*;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class BuildingTest {

    @Before
    public void before() {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        Base.openTransaction();
    }

    @After
    public void after() {
        Base.rollbackTransaction();
        Base.close();
    }

    @Test
    public void testInsertarB() {
        System.out.println("insertar");
        String city = "rio cuarto";
        String neighborhood = "barrio universidad";
        String street = "colon 612";
	String descriptive_text="AMPLIO, BUEN ESTADO";
	String price= "123000";
	String id_isType="1";
	String id_situation="2";
	String id_ownersBuilding="1";
        String id_realstate="1";
	Inmueble.insertar(city,neighborhood,street,descriptive_text,price,id_isType,id_situation,id_ownersBuilding,id_realstate);

        //busca TODOS los OWNER que coincidan
        LazyList<Building> encontrados = Building.where(
                "city = '" + city + "' and "
                + "neighborhood= '" + neighborhood + "' and "
                + "street='" + street + "' and "
                + "descriptive_text= '" + descriptive_text + "' and "
                + "price = '" + price + "' and "
                + "id_isType= '" + id_isType + "' and "
                + "id_situation= '" + id_situation + "' and "
		+ "id_ownersBuilding= '" + id_ownersBuilding + "' and "
                + "id_realstate= '" + id_realstate + "' ");
        assertTrue(encontrados.size() == 1);
    }
    
      @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar ");
        String city = "rio cuarto";
        String neighborhood = "barrio universidad";
        String street = "colon 612";
	String descriptive_text="AMPLIO, BUEN ESTADO";
	String price= "123000";
	String id_isType="1";
	String id_situation="2";
	String id_ownersBuilding="1";
        String id_realstate="1";
	Building b=new Building();
	Inmueble.insertar(city,neighborhood,street,descriptive_text,price,id_isType,id_situation,id_ownersBuilding,id_realstate);

        Building encontrado = Building.findFirst(
                "city = '" + city + "' and "
                + "neighborhood= '" + neighborhood + "' and "
                + "street='" + street + "' and "
                + "descriptive_text= '" + descriptive_text + "' and "
                + "price = '" + price + "' and "
                + "id_isType= '" + id_isType + "' and "
                + "id_situation= '" + id_situation + "' and "
		+ "id_ownersBuilding= '" + id_ownersBuilding + "' and "
                + "id_realstate= '" + id_ownersBuilding + "' ");
	 if (encontrado == null) {
            fail("Error: No se encontro elemento para borrar");
        } else {		
		int id =(Integer)encontrado.getId();
		String in= Integer.toString(id);
		Inmueble.eliminar(in);
		Building o=Building.findById(id);
		assertTrue(o==null);
	}
     
    }
  

    public void testModificar() {
	System.out.println("modificar");
	
        String city = "rio cuarto";
        String neighborhood = "barrio universidad";
        String street = "colon 612";
	String descriptive_text="AMPLIO, BUEN ESTADO";
	String price= "123000";
	String id_isType="1";
	String id_situation="2";
	String id_ownersBuilding="1";
        String id_realstate="1";
	Building b=new Building();
	Inmueble i=new Inmueble();
	String new_city="cordoba";
	Inmueble.insertar(city,neighborhood,street,descriptive_text,price,id_isType,id_situation,id_ownersBuilding,id_realstate);

       	Building o=new Building();
	o=Building.findFirst(
                "city = '" + city + "' and "
                + "neighborhood= '" + neighborhood + "' and "
                + "street='" + street + "' and "
                + "descriptive_text= '" + descriptive_text + "' and "
                + "price = '" + price + "' and "
                + "id_isType= '" + id_isType + "' and "
                + "id_situation= '" + id_situation + "'and "
		+ "id_ownersBuilding= '" + id_ownersBuilding +"' ");
	String id =(String)o.getId();	
    	Inmueble.modificar(id,new_city,neighborhood,street,descriptive_text,price, id_isType,id_situation,id_ownersBuilding,id_realstate);		
	o=Building.findFirst("city= ?",new_city);

	assertFalse(o==null);	
   }



     
}

