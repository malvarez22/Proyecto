package com.unrc.app;

import com.unrc.app.models.Owner;

import org.javalite.activejdbc.Base;

import static org.javalite.test.jspec.JSpec.the;

public class OwnerSpec{
    public void before(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "");
        Base.openTransaction();
    }
    public void after(){
        Base.rollbackTransaction();
        Base.close();
    }
    public void shouldValidateMandatoryFields(){

        Owner owner = new Owner();

        //check errors
        the(owner).shouldNotBe("valid");
        the(owner.errors().get("first_name")).shouldBeEqual("value is missing");
        the(owner.errors().get("last_name")).shouldBeEqual("value is missing");
        the(owner.errors().get("city")).shouldBeEqual("value is missing");
        the(owner.errors().get("phone_number")).shouldBeEqual("value is missing");
        the(owner.errors().get("neighborhood")).shouldBeEqual("value is missing");
        the(owner.errors().get("street")).shouldBeEqual("value is missing");
        the(owner.errors().get("email")).shouldBeEqual("value is missing");

        //set missing values
        owner.set("first_name", "eliana", "last_name", "dominguez", "city", "Cordoba","phone_number",154220674,"neighborhood","balaco","street","concejal barrera 7878","email","eli_dominguez_88@hotmail.com");

        //all is good:
        the(owner).shouldBe("valid");
    }
}
