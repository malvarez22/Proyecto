package test.java.com.unrc.app;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.spi.*;

@RunWith(Suite.class)
@Suite.SuiteClasses( { InmoTest.class, UserSpec.class, OwnerSpec.class, AdSpec.class, BuildingSpec.class, OwnerBuildingSpec.class } )
public class TestSuite {
}