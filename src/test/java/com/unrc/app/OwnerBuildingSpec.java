package test.java.com.unrc.app;

import main.com.unrc.app.models.OwnerBuilding;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.javalite.test.jspec.JSpec.the;

public class OwnerBuildingSpec{

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

        OwnerBuilding ownerBulding = new OwnerBuilding();

        //check errors
        the(ownerBulding).shouldNotBe("valid");
        the(ownerBulding.errors().get("first_name")).shouldBeEqual("value is missing");
        the(ownerBulding.errors().get("last_name")).shouldBeEqual("value is missing");
        the(ownerBulding.errors().get("city")).shouldBeEqual("value is missing");
        the(ownerBulding.errors().get("neighborhood")).shouldBeEqual("value is missing");
        the(ownerBulding.errors().get("street")).shouldBeEqual("value is missing");
        the(ownerBulding.errors().get("email")).shouldBeEqual("value is missing");
        the(ownerBulding.errors().get("phone_number")).shouldBeEqual("value is missing");
        the(ownerBulding.errors().get("idRealState")).shouldBeEqual("value is missing");    
        
        
        //set missing values
        ownerBulding.set("first_name", "Matias", "last_name", "Alvarez");

        //all is good:
        the(ownerBulding).shouldBe("valid");
    }
}
