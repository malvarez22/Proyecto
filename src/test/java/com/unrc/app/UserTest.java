/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unrc.app;

import com.unrc.app.models.User;
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
public class UserTest {

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
    public void testInsertarU() {
        System.out.println("insertar 1");
        String first_name = "pato";
        String last_name = "lagable";
        String email = "casa@gmail.com";
        String contraseña="matute@hotmail.com";


        Usuario.insertar(email, first_name, last_name,contraseña);

        //busca TODOS los Usuarios que coincidan
        LazyList<User> encontrados = User.where(
                "first_name = '" + first_name + "' and "
                + "last_name = '" + last_name + "' and "
                + "email = '" + email + "'"
                + "contraseña = '" + contraseña + "'");
        assertTrue(encontrados.size() == 1);
    }

    @Test
    public void testEliminarU() throws Exception {
        System.out.println("eliminar 1");

        String first_name = "pato";
        String last_name = "lagable";
        String email = "lapato@gmail.com";
        String contraseña="12345";

        Usuario.insertar("pato@hotmail.com", "pat", "fernanndez","lato@gmail.com");
        Usuario.insertar("toe@hotmail.com", "teo", "adaaaa","lapo@gmail.com");
        Usuario.insertar(email, first_name, last_name,contraseña);

        User encontrado = User.findFirst(
                "first_name = '" + first_name + "' and "
                + "last_name = '" + last_name + "' and "
                + "email = '" + email + "'"
                + "contraseña = '" + contraseña + "'");

        if (encontrado == null) {
            fail("Error: No se encontro elemento para borrar");
        } else {
            Integer id = encontrado.getInteger("id");
            encontrado.deleteCascade();
            LazyList<User> todosLosUser = User.findAll();

            for (User u : todosLosUser) {
                assertFalse(
                        id == u.getInteger("id")
                        && first_name.equals(u.getString("first_name"))
                        && last_name.equals(u.getString("last_name"))
                        && email.equals(u.getString("email")));
            }
        }

    }
}