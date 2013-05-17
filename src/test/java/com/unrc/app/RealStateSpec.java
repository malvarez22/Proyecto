package test.java.com.unrc.app;

import main.com.unrc.app.models.RealState;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.javalite.test.jspec.JSpec.the;

public class RealStateSpec{

    @Before
    public void before(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
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
        realState.set("first_name", "John");

        //all is good:
        the(realState).shouldBe("valid");
    }
}
