import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostPetRype {

    @Test

    public void postPetType(){
        RestAssured.baseURI="http://bhdtest.endava.com:8080/petclinic/api";
        RestAssured.basePath="/pettypes/";
     //pentru post si put avem si body in given ;put->update
        given().
                contentType(ContentType.JSON).
                body("{\"name\": \"animalTest2\"}").
                when().
                post().
                then().log().body().                     //dupa then facem verificarile
                statusCode(HttpStatus.SC_CREATED)
                .body("name",equalTo("animalTest2"));
    }
}
