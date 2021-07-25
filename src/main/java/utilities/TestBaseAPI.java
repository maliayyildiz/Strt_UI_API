package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class TestBaseAPI {
   static protected RequestSpecification spec01;


    @Before
    public void setUp01() {
        spec01 = new RequestSpecBuilder().
                setBaseUri("https://api.sandbox.stuart.com/v2/jobs").
                build();
    }
}
