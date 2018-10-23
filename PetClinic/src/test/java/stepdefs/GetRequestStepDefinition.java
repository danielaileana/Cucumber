package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetRequestStepDefinition {
    private RequestSpecification request;
    private Response response;

    @Given("^I have acces to perform GET request$")
    public void iHaveAccesToPerformGETRequest() throws Throwable {
        //creem ob request si spunem unde vrem sa ne ducem
       request= given().
               baseUri("http://bhdtest.endava.com:8080/petclinic/api").
               contentType(ContentType.JSON);
    }

    @When("^I perform GET request to \"([^\"]*)\"$")
    public void iPerformGETRequestTo(String path) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        response=request.when().get(path);
    }

    @Then("^I will have status code \"([^\"]*)\"$")
    public void iWillHaveStatusCode(int statusCode) throws Throwable {//verificam codul ->rez final
       response.then().statusCode(statusCode);
        System.out.println(response.asString());
    }


    @Given("^I have acces to perform POST resquest$")
    public void iHaveAccesToPerformPOSTResquest() throws Throwable {
        request=given().
                baseUri("http://bhdtest.endava.com:8080/petclinic/api").
                body("{\"name\": \"Daniela\"}").contentType(ContentType.JSON);

    }

    @When("^I have acces to perform POST request to \"([^\"]*)\"$")
    public void iHaveAccesToPerformPOSTRequestTo(String path) throws Throwable {
      response=request.when().post(path);
    }

    @Given("^I have acces to perform PUT request$")
    public void iHaveAccesToPerformPUTRequest() throws Throwable {
        request=given().
                baseUri("http://bhdtest.endava.com:8080/petclinic/api").
                pathParam("petTypeId",113).
                body("{\"name\": \"Ileana\"}").contentType(ContentType.JSON);

    }

    @When("^I have acces to perfom PUT request to \"([^\"]*)\"$")
    public void iHaveAccesToPerfomPUTRequestTo(String path) throws Throwable {
        response=request.when().put(path);

    }


    @Given("^I have acces to perfotm DELETE request$")
    public void iHaveAccesToPerfotmDELETERequest(String path) throws Throwable {
        request=given().
                baseUri("http://bhdtest.endava.com:8080/petclinic/api").
                pathParam("petTypeId",113);

    }

    @When("^I have acces to perform DELETE reguest to\"([^\"]*)\"$")
    public void iHaveAccesToPerformDELETEReguestTo(String path) throws Throwable {
        response=request.when().delete(path);

    }
}
