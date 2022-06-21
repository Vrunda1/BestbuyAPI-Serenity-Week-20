package com.localhost.swagger.cucumber.steps;

import com.localhost.swagger.bestbuyinfo.StoreSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;

public class StoreStepDef {

    static String name = "Hopkins";
    static String type = "BigBox";
    static String address = "10 dowmtown";
    static String address2 = "London Bridge";
    static String city = "London";
    static String state = "Surey";
    static String zip = "55305";
    static double lat = 44.958216;
    static double lng = -91.442336;
    static String hours = "Mon: 10-7; Tue: 10-7; Wed: 10-8; Thurs: 10-8; Fri: 10-9; Sat: 10-7; Sun: 10-5";
    static int storeId;
    static ValidatableResponse response;

    @Steps
    StoreSteps storesSteps;


    @Then("^User must get back a valid status code (\\d+) of store$")
    public void userMustGetBackAValidStatusCodeOfStore(int code) {
        response = response.statusCode(code);
    }

    @When("^User sends a POST request to list endpoint of store$")
    public void userSendsAPOSTRequestToListEndpointOfStore() {
        HashMap<Object, Object> services = new HashMap<>();
        services.put(1, "Krishna");
        services.put(2, "Rama");
        response = storesSteps.createStore(name, type, address, address2, city,
                state, zip, lat, lng, hours, services);
        response.log().all().statusCode(201);

        storeId = response.log().all().extract().path("id");
        System.out.println(storeId);
    }

    @When("^User sends a PUT request to list endpoint of store$")
    public void userSendsAPUTRequestToListEndpointOfStore() {
        HashMap<Object, Object> services = new HashMap<>();
        services.put(1, "Krishna");
        services.put(2, "Rama");

        name = name + "_updated";
        response = storesSteps.updateStore(storeId, name, type, address, address2, city, state, zip, lat,
                lng, hours, services);
        HashMap<String, Object> storeMap = storesSteps.getStoreinfoById(storeId);
        Assert.assertThat(storeMap, hasValue(name));
    }


    @And("^User should verify that store is deleted with (\\d+)$")
    public void userShouldVerifyThatStoreIsDeletedWith(int code) {

        response.assertThat().statusCode(code);

    }

    @When("^User sends a DELETE request to list endpoint of store$")
    public void userSendsADELETERequestToListEndpointOfStore() {
        response = storesSteps.deleteStore(storeId).statusCode(200);
    }

    @When("^User sends a GET request to list endpoint of store$")
    public void userSendsAGETRequestToListEndpointOfStore() {
        response = new StoreSteps().getAllStore();
    }

    @And("^Verify  if the total is equal to (\\d+)$")
    public void verifyIfTheTotalIsEqualTo(int number) {
        response = response.body("total", equalTo(number));
    }

    @And("^Verify  if the limit is equal to (\\d+)$")
    public void verifyIfTheLimitIsEqualTo(int limit) {
        response = response.body("limit", equalTo(limit));
    }

    @And("^Check the single Name in the Array list \\(Inver Grove Heights\\)$")
    public void checkTheSingleNameInTheArrayListInverGroveHeights() {
        response.body("data.name", hasItem("Inver Grove Heights"));
    }

    @And("^Check the multiple ‘Names’ in the ArrayList \\(Roseville, Burnsville, Maplewood\\)$")
    public void checkTheMultipleNamesInTheArrayListRosevilleBurnsvilleMaplewood() {
        response.body("data.name", hasItem("Roseville"))
                .body("data.name", hasItem("Burnsville"))
                .body("data.name", hasItem("Maplewood"));
    }

    @And("^Verify the storied=(\\d+) inside storeservices of the third store of second services$")
    public void verifyTheStoriedInsideStoreservicesOfTheThirdStoreOfSecondServices(int expected) {
        int actual = response.extract().path("data[2].services[1].storeservices.storeId");
        Assert.assertEquals(expected, actual);
    }

    @And("^Check hash map values createdAt inside storeservices map where store name = Roseville$")
    public void checkHashMapValuesCreatedAtInsideStoreservicesMapWhereStoreNameRoseville() {
        response.body("data[1].services.storeservices", hasItem("2016-11-17T17:57:09.414Z"));
    }


    @And("^Verify the state = MN of forth store$")
    public void verifyTheStateMNOfForthStore() {
        response.body("data[3].state", equalTo("MN"));
    }

    @And("^Verify the storeId = 11 for the 6th store$")
    public void verifyTheStoreIdForTheThStore() {
        response = storesSteps.getAllStore();
        List<Integer> stores = response.extract().path("data[5].services.storeservices.storeId");
        for (int ids : stores) {
            Assert.assertEquals(11, ids);
        }
    }



    @And("^Verify the serviceId = 4 for the seventhth store of forth service$")
    public void verifyTheServiceIdForTheSevenththStoreOfForthService() {
        response.body("data[6].services[3].storeservices.serviceId", equalTo(4));
    }

    @And("^Verify the store name \"([^\"]*)\" of ninthth store$")
    public void verifyTheStoreNameOfNinththStore(String expected) {
      String actual = response.extract().path("data[8].name");
        Assert.assertEquals(expected, actual);
    }
}



