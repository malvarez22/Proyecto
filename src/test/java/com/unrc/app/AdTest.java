package com.unrc.app;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author pato
 */
public class AdTest {
    
    @Before
    public void beforeTest() {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "");
        Base.openTransaction();
    }

    @After
    public void afterTest() {
        Base.rollbackTransaction();
        Base.close();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        String descriptive_text = "";
//        int id_buildings = 0;
//        int id_ownersBuildings = 0;
//        Ad instance = new Ad();
//        instance.insertar(descriptive_text, id_buildings, id_ownersBuildings);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        int id = 0;
//        String element = "";
//        String change = "";
//        Ad.modificar(id, element, change);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        int id = 0;
//        Ad.eliminar(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//   
        
}