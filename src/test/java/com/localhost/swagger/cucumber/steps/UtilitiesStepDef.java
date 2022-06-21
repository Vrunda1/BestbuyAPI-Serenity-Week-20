package com.localhost.swagger.cucumber.steps;

import com.localhost.swagger.bestbuyinfo.UtilitiesStep;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class UtilitiesStepDef {

    @Steps
    UtilitiesStep utilitiesStep;
    static ValidatableResponse response;
    @When("^User sends a GET request to list endpoint of version$")
    public void userSendsAGETRequestToListEndpointOfVersion() {
        response = new UtilitiesStep().getVersiondetal();
    }

    @Then("^User must get back a valid status code (\\d+) of version$")
    public void userMustGetBackAValidStatusCodeOfVersion(int code) {
        response = response.statusCode(code);
    }

    @When("^User sends a GET request to list endpoint of healthcheck$")
    public void userSendsAGETRequestToListEndpointOfHealthcheck() {
        response = new UtilitiesStep().getHealthcheckupDetail();
    }

    @Then("^User must get back a valid status code (\\d+) of healthcheck$")
    public void userMustGetBackAValidStatusCodeOfHealthcheck(int code) {
        response = response.statusCode(code);
    }
}
