package test.java.com.unrc.app;

import main.com.unrc.app.models.Owner;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.javalite.test.jspec.JSpec.the;

public class OwnerSpec{
    public void before(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
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
        the(owner.errors().get("street")).shouldBeEqual("value is missing");
        the(owner.errors().get("email")).shouldBeEqual("value is missing");

        //set missing values
        owner.set("first_name", "eliana", "last_name", "dominguez", "city", "Cordoba");

        //all is good:
        the(owner).shouldBe("valid");
    }
}
