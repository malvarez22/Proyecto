package com.unrc.app;

import com.unrc.app.models.OwnerBuilding;
import org.javalite.activejdbc.Base;
import static org.javalite.test.jspec.JSpec.the;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OwnerBuildingSpec{

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
        the(ownerBulding.errors().get("id_realStates")).shouldBeEqual("value is missing");    
        
        
        //set missing values
        ownerBulding.set("first_name","matias", "last_name","alvarez","city","buenos aires","neighborhood","balacco","street","pasnkd","email","mati@gmail.com","phone_number",154220674,"id_realStates",1);

        //all is good:
        the(ownerBulding).shouldBe("valid");
    }
}
