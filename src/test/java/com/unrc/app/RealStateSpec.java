package com.unrc.app;

import com.unrc.app.models.RealState;
import org.javalite.activejdbc.Base;
import static org.javalite.test.jspec.JSpec.the;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RealStateSpec{

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
    public void shouldValidateMandatoryFields(){

        RealState realState = new RealState();

        //check errors
        the(realState).shouldNotBe("valid");
        the(realState.errors().get("first_name")).shouldBeEqual("value is missing");
        the(realState.errors().get("city")).shouldBeEqual("value is missing");
        the(realState.errors().get("neighborhood")).shouldBeEqual("value is missing");
        the(realState.errors().get("street")).shouldBeEqual("value is missing");
        the(realState.errors().get("phone_number")).shouldBeEqual("value is missing");
        the(realState.errors().get("email")).shouldBeEqual("value is missing");
        the(realState.errors().get("WebSite")).shouldBeEqual("value is missing");
        the(realState.errors().get("idOwner")).shouldBeEqual("value is missing");
        //set missing values
	realState.set("first_name", "gutierrez Inmobiliaria", "city", "Cordoba","neighborhood","balaco","street","concejal barrera 7878","email","eli_dominguez_88@hotmail.com","phone_number",154220674,"web","www.inmogutierrez.com");

        //all is good:
        the(realState).shouldBe("valid");
    }
}
