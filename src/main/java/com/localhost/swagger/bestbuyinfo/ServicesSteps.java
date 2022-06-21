package com.localhost.swagger.bestbuyinfo;

import com.localhost.swagger.constants.EndPoints;
import com.localhost.swagger.model.ServicesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ServicesSteps {
    @Step("Creating services with serviceID: {0},name: {1}")
    public ValidatableResponse createService(String name) {
        ServicesPojo servicesPojo = ServicesPojo.getServicesPojo(name);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(servicesPojo)
                .when()
                .post(EndPoints.CREATE_SINGLE_SERVICE)
                .then();
    }
    @Step("Getting all Services information ")
    public ValidatableResponse getAllServices(){
        return SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_ALL_STORE)
                .then().log().all();

    }

    @Step("Getting the services  information with id: {0}")
    public HashMap<String, Object> getServicesInfoById(int serviceID) {
        HashMap<String, Object> serviceMap = SerenityRest.given().log().all()
                .when()
                .pathParam("serviceID", serviceID)
                .get(EndPoints.GET_SINGLE_SERVICE_BY_ID)
                .then()
                .statusCode(200).extract().path("");

        return serviceMap;

    }

    @Step("Updating Service information with serviceId: {0},name: {1}")
    public ValidatableResponse updateService(int serviceID, String name) {
        ServicesPojo servicesPojo = ServicesPojo.getServicesPojo(name);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("serviceID", serviceID)
                .body(servicesPojo)
                .when()
                .put(EndPoints.UPDATE_SERVICE_BY_ID)
                .then();
    }

    @Step("Deleting Service information with ServiceID: {0}")
    public ValidatableResponse deleteService(int serviceID) {
        return SerenityRest
                .given()
                .pathParam("serviceID", serviceID)
                .when()
                .delete(EndPoints.DELETE_SERVICE_BY_ID)
                .then();
    }

    @Step("Getting Service information with ServiceID: {0}")
    public ValidatableResponse getServiceById(int serviceID) {
        return SerenityRest
                .given()
                .pathParam("serviceID", serviceID)
                .when()
                .get(EndPoints.GET_SINGLE_SERVICE_BY_ID)
                .then();
    }

}


