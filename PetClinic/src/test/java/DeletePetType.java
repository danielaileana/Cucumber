import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePetType {

    @Test

    public void deteletePathType(){

        RestAssured.baseURI="http://bhdtest.endava.com:8080/petclinic/api";
        RestAssured.basePath="/pettypes/";

        given().
                pathParam("petTypeId",140).
                when().
                delete().
                then().statusCode(HttpStatus.SC_NO_CONTENT);


    }
}
