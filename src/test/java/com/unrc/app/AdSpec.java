package test.java.com.unrc.app;

import main.com.unrc.app.models.Ad;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.javalite.test.jspec.JSpec.the;

public class AdSpec{

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

        Ad ad = new Ad();

        //check errors
        the(ad).shouldNotBe("valid");
        the(ad.errors().get("descriptive_text")).shouldBeEqual("value is missing");
       
        //set missing values
        ad.set("descriptive_text", "texto");

        //all is good:
        the(ad).shouldBe("valid");
    }
}
