package test.functional.product;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.thoughtworks.gaia.Application;
import com.thoughtworks.gaia.common.constant.EnvProfile;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jxzhong on 2017/5/10.
 */

@ActiveProfiles({EnvProfile.TEST})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloAPITest {

    private static final String API_PATH = "/api/gaia";
    private static final String MSG_TEMPLATE = "Hello %s. Version %s - passed in %s";

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setup() {
        RestAssured.port = this.port;
        RestAssured.baseURI = "http://localhost";

    }

    @Test
    public void shouldRetrieveNameVersion1InURL() {
        String name = "world";
        RestAssured.
                given().
                accept(ContentType.JSON).
                when().
                get(String.format("%s/hello/{name}", API_PATH), name).
                then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON).
                body("msg", Matchers.equalTo(String.format(MSG_TEMPLATE, name, 1, "URL")));
    }

//    @Test
//    public void testMockAPI() throws Exception {
//        when()
//                .get("/hello")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .body("code", equalTo("111"));
//    }
}
