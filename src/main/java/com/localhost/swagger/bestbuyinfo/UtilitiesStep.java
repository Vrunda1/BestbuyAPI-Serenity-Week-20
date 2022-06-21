package com.localhost.swagger.bestbuyinfo;

import com.localhost.swagger.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UtilitiesStep {

    @Step("Getting version information of utilities: {0}")
    public ValidatableResponse getVersiondetal() {
        return SerenityRest
                .given()
                .when()
                .get(EndPoints.GET_UTILITIES)
                .then();
    }

    @Step("Getting store information of utilities: {0}")
    public ValidatableResponse getHealthcheckupDetail() {
        return SerenityRest
                .given()
                .when()
                .get(EndPoints.GET_HEALTHCHECK)
                .then();
    }
}







