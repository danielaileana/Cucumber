import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateTwitter {

    @Test
    public void createTwitter(){
        RestAssured.baseURI="http://api.twitter.com";
        RestAssured.basePath="/1.1/statuses/";

        given().auth().
                oauth("r1SktL1rdaFe3jsF7uaC46uky",
                        "M3Y72JtfLgNruQMXJloFlXPIpd61QGV2rERgNe9ZmSMlPLyO62",
                        "4923063747-u2L19lo0t5L5k6I5XLGlMGVN6cq2qzMWDsahCVR ",
                        "O28DGNswrwhdcLD9ehv97TJPMqHZ7OyMZxVpOjsmTbgCQ").
                queryParam("status","Daniela").log().all().
                when().
                post("/update.json").then().log().all();

    }
    //contentType->restrictionez eu cum vreau sa mi apelez json sau altceva

    @Test
    public void getTwitter(){
        given().
                when().
                get().
                then().log().all().
                assertThat().
                statusCode(HttpStatus.SC_OK);
    }
}
