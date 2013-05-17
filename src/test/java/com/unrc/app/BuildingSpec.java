package test.java.com.unrc.app;

import main.com.unrc.app.models.Building;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.javalite.test.jspec.JSpec.the;

public class BuildingSpec{

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

        Building building = new Building();

        //check errors
        the(building).shouldNotBe("valid");
        the(building.errors().get("city")).shouldBeEqual("value is missing");
        the(building.errors().get("neighborhood")).shouldBeEqual("value is missing");
        the(building.errors().get("street")).shouldBeEqual("value is missing");
        the(building.errors().get("descriptive_text")).shouldBeEqual("value is missing");
        the(building.errors().get("price")).shouldBeEqual("value is missing");
        the(building.errors().get("isType")).shouldBeEqual("value is missing");
        the(building.errors().get("situation")).shouldBeEqual("value is missing");
        the(building.errors().get("id_realState")).shouldBeEqual("value is missing");
        the(building.errors().get("id_ownerBuiling")).shouldBeEqual("value is missing");
        //set missing values
        building.set("city", "Cordoba");

        //all is good:
        the(building).shouldBe("valid");
    }
}
