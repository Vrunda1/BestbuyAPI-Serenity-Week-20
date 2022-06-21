package com.localhost.swagger.cucumber.steps;

import com.localhost.swagger.bestbuyinfo.ProductSteps;
import com.localhost.swagger.utils.TestUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasValue;


public class ProductStepDef {
    static String name = "Duracell - AAA Batteries" + TestUtils.getRandomValue();
    static String type = "HardGood1" + TestUtils.getRandomValue();
    static int price = 599;
    static int shipping = 0;
    static String upc = "041333424012";
    static String description = "Compatible with select electronic devices";
    static String manufacturer = "Duracell";
    static String model = "MN2400B4A";
    static String url = "This is url for Duracell battery Pro";
    static String image = "This is image for Duracell pack";
    static int productId;

    static ValidatableResponse response;
    @Steps
    ProductSteps productSteps;
    @When("^User sends a GET request to list endpoint$")
    public void userSendsAGETRequestToListEndpoint() {
        response = new ProductSteps().getAllProducts();
    }

    @Then("^User must get back a valid status code (\\d+)$")
    public void userMustGetBackAValidStatusCode(int code) {
        response.statusCode(code);
    }

    @When("^User sends a POST request to list endpoint$")
    public void userSendsAPOSTRequestToListEndpoint() {
        response= productSteps.createProduct(name,type,price,shipping,upc,
                description,manufacturer,model,url,image).log().all().statusCode(201);
        productId = response.log().all().extract().path("id");
        System.out.println(productId);
    }

    @When("^User sends a PUT request to list endpoint$")
    public void userSendsAPUTRequestToListEndpoint() {
        name = name + "_updated";
        response = productSteps.updateProduct(productId, name, type, price, shipping, upc,description,
                manufacturer,model,url,image);

        HashMap<String, Object> productMap = productSteps.getProductsInfoByid(productId);
        Assert.assertThat(productMap, hasValue(name));

    }

    @When("^User sends a DELETE request to list endpoint$")
    public void userSendsADELETERequestToListEndpoint() {
        response =  productSteps.deleteProduct(productId);
        response.assertThat().statusCode(200);

    }


    @And("^User should verify that product is deleted with (\\d+)$")
    public void userShouldVerifyThatProductIsDeletedWith(int code) {

       response = response.assertThat().statusCode(code);
    }



}

