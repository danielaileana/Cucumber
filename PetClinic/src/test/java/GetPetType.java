import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class GetPetType {

    @BeforeClass //se ruleaza inainte de toate adnotarile
    public void setUp(){
        RestAssured.baseURI="http://bhdtest.endava.com:8080/petclinic/api";
        RestAssured.basePath="/pettypes";
    }

    @Test
    public void getAllPetTypes(){
//le ducem in before
//        RestAssured.baseURI="http://bhdtest.endava.com:8080/petclinic/api";
//        RestAssured.basePath="/pettypes";


        given().
                when().//log().all().  //punem metoda ->pe partea de request
                get().
                then().log().all().    //log pe partea de response
                assertThat().
                statusCode(HttpStatus.SC_OK);//asteapta status cu 200


    }

    @Test
    public void getAllPetTypes_assertions(){

//        RestAssured.baseURI="http://bhdtest.endava.com:8080/petclinic/api";
//        RestAssured.basePath="/pettypes";
//in body facem validarile
        given().
                when().//log().all().
                get().
                then().log().all().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                body("id[0]",equalTo(101)).
                body("name[0]",equalTo("Camel")).
                body("id",hasItems(101,112,7));


    }

}
