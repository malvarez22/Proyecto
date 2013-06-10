package com.unrc.app;

import com.unrc.app.models.OwnerBuilding;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class OwnerBuildingTest {

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
    public void testInsertarOB() {
        System.out.println("insertar");
        String first_name = "carlos";
        String last_name = "sanchez";
        String city = "rio cuarto";
        String phone_number = "1251611321";
        String neighborhood = "barrio universidad";
        String street = "colon 612";
        String email = "casa@gmail.com";
        String id_building = "1";
        String id_realstate="1";
	OwnerBuilding ob=new OwnerBuilding();

	DueñoInmueble.insertar(first_name,last_name,city,phone_number,neighborhood,street,email,id_building,id_realstate);

        //busca TODOS los OWNER que coincidan
        LazyList<OwnerBuilding> encontrados = OwnerBuilding.where(
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
    public void testEliminar() throws Exception {
        System.out.println("eliminar ");
        String first_name = "carlos";
        String last_name = "sanchez";
        String city = "rio cuarto";
        String phone_number = "1251611321";
        String neighborhood = "barrio universidad";
        String street = "colon 612";
        String email = "casa@gmail.com";
        String id_building = "1";
        String id_realstate="2";
	OwnerBuilding ob=new OwnerBuilding();
	DueñoInmueble di=new DueñoInmueble();
	DueñoInmueble.insertar(first_name,last_name,city,phone_number,neighborhood,street,email,id_building,id_realstate);
        OwnerBuilding encontrado = OwnerBuilding.findFirst(
                "first_name = '" + first_name + "' and "
                + "last_name = '" + last_name + "' and "
                + "city = '" + city + "' and "
                + "phone_number = '" + phone_number + "' and "
                + "neighborhood = '" + neighborhood + "' and "
                + "street = '" + street + "' and "
                + "email = '" + email + "'");

        if (encontrado == null) {
            fail("Error: No se encontro pato para borrar");
        } else {
		
		String id =(String)encontrado.getId();	
		DueñoInmueble.eliminar("id");
		OwnerBuilding o=OwnerBuilding.findById(id);
		assertTrue(o==null);
	}
     
    }
  

    public void testModificar() {
	System.out.println("modificar");
	
        String first_name = "carlos";
        String last_name = "sanchez";
        String city = "rio cuarto";
        String phone_number = "1251611321";
        String neighborhood = "barrio universidad";
        String street = "colon 612";
        String email = "casa@gmail.com";
        String id_building = "1";
        String id_realstate="2";
	OwnerBuilding ob=new OwnerBuilding();
	DueñoInmueble di=new DueñoInmueble();
	DueñoInmueble.insertar(first_name,last_name,city,phone_number,neighborhood,street,email,id_building,id_realstate);
	String new_firstName="Juan";
	OwnerBuilding o=new OwnerBuilding();
	o=OwnerBuilding.findFirst("first_na me = ?",first_name);
	String id =(String)o.getId();	
    	DueñoInmueble.modificar(id,first_name,last_name,city,phone_number,neighborhood,street,email,id_building,id_realstate);
		
	o=OwnerBuilding.findFirst("first_name = ?",new_firstName);

	assertFalse(o==null);	
   }



     
}

