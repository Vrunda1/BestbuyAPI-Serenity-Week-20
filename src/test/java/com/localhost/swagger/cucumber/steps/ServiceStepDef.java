package com.localhost.swagger.cucumber.steps;

import com.localhost.swagger.bestbuyinfo.ServicesSteps;
import com.localhost.swagger.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class ServiceStepDef {

    static String name = "Mobile Shop" + TestUtils.getRandomValue();
    static int serviceID;

    @Steps
    ServicesSteps servicesSteps;

    static ValidatableResponse response;
    @When("^User sends a GET request to list endpoint of Services$")
    public void userSendsAGETRequestToListEndpointOfServices() {
        response = new ServicesSteps().getAllServices();
    }

    @Then("^User must get back a valid status code (\\d+) of Services$")
    public void userMustGetBackAValidStatusCodeOfServices(int code) {
        response = response.statusCode(code);

    }

    @When("^User sends a POST request to list endpoint of Services$")
    public void userSendsAPOSTRequestToListEndpointOfServices() {
        response = servicesSteps.createService(name);
        serviceID = response.log().all().extract().path("id");
        System.out.println(serviceID);
    }

    @When("^User sends a PUT request to list endpoint of Services$")
    public void userSendsAPUTRequestToListEndpointOfServices() {
        name = name + "_updated";
        response = servicesSteps.updateService(serviceID, name).log().all().statusCode(200);
        HashMap<String, Object> storeyMap = servicesSteps.getServicesInfoById(serviceID);
        Assert.assertThat(storeyMap, hasValue(name));

    }

    @When("^User sends a DELETE request to list endpoint of Services$")
    public void userSendsADELETERequestToListEndpointOfServices() {
        servicesSteps.deleteService(serviceID).statusCode(200);
    }

    @And("^User should verify that Services is deleted with (\\d+)$")
    public void userShouldVerifyThatServicesIsDeletedWith(int code) {

        response.assertThat().statusCode(code);
    }
}
