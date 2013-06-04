package com.unrc.app;

import org.javalite.activejdbc.Base;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

//este test describiaria y modelaria toda la dinamica de una inmobiliaria por ej: no se puede crear un dueño inmueble son antes tener un dueño

//falta ver casos que pienso: contraseña usuario y dni en owner
//1-solo debe haber un usuario administrador, el cual él sera el único que pueda REALIZAR ABM USUARIO común
//2-el usuario comùn puede cambiar sus datos
//3-un dueño inmueble esta asociado por lo menos con una inmobiliaria
//4-un dueño puedo no pued etener el mismo inmueble  en varias inmobiliarias

public class InmoTest {
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
    @Test
    public void testTest(){
	
        assertEquals(10, 10);
    }

}
