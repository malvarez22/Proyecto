package test.java.com.unrc.app;

import com.unrc.app.models.Building;
import org.javalite.activejdbc.Base;
import static org.javalite.test.jspec.JSpec.the;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuildingSpec{

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

        Building building = new Building();

        //check errors
        the(building).shouldNotBe("valid");
        the(building.errors().get("city")).shouldBeEqual("value is missing");
        the(building.errors().get("neighborhood")).shouldBeEqual("value is missing");
        the(building.errors().get("street")).shouldBeEqual("value is missing");
        the(building.errors().get("descriptive_text")).shouldBeEqual("value is missing");
        the(building.errors().get("price")).shouldBeEqual("value is missing");
        the(building.errors().get("id_situation")).shouldBeEqual("value is missing");
        the(building.errors().get("id_ownerBuiling")).shouldBeEqual("value is missing");
        the(building.errors().get("id_isType")).shouldBeEqual("value is missing");
        //set missing values
        building.set("city","cordoba","neighborhood","barrio","street","street","descriptive_text","bueno","price",23,"id_situation",1,"id_ownersBuilding",1,"id_isType",4);

        //all is good:
        the(building).shouldBe("valid");
    }
}
