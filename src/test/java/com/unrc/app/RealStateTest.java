package com.unrc.app;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author pato
 */
public class RealStateTest {
    
   @Before
    public void before(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "");
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
         int phone_number = 1188899912;
         String email = "juso@hotmail.com";
         String webSite = "www.oooi.com";
         int id_owner = 4;
         RealState.insertar(first_name, city, neighborhood, street, phone_number, email, webSite, id_owner);
          RealState.insertar(first_name, last_name, city, phone_number, neighborhood, street, email);
        //busca TODOS las inmobiliarias que coincidan
        LazyList<RealState> encontrados = RealState.where(
                "first_name = '" + first_name + "' and "
                + "city = '" + city + "' and "
                
                + "neighborhood = '" + neighborhood + "' and "
                + "street = '" + street + "' and "
                + "phone_number = '" + phone_number + "' and "
                + "email = '" + email + "'"
                + "w+ "email = '" + email + "'"
                 = '" + email + "'"
                );
             
        assertTrue(encontrados.size() == 1);
    }

//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        int id = 0;
//        String element = "";
//        String change = "";
//        RealState.modificar(id, element, change);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        int id = 0;
//        RealState.eliminar(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}