package com.localhost.swagger.cucumber.steps;

import com.localhost.swagger.bestbuyinfo.CategoriesSteps;
import com.localhost.swagger.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class CategoryStepDef {
    static  String name = "Electronics & Computers" + TestUtils.getRandomValue();
    static String id = "12" +TestUtils.getRandomValue();
    static String categoryId;
    static ValidatableResponse response;

    @Steps
    CategoriesSteps categoriesSteps;
    @When("^User sends a GET request to list endpoint of category$")
    public void userSendsAGETRequestToListEndpointOfCategory()
    {
        response = new CategoriesSteps().getAllCategories();
    }

    @Then("^User must get back a valid status code (\\d+) of category$")
    public void userMustGetBackAValidStatusCodeOfCategory(int code)
    {
        response = response.statusCode(code);
    }

    @When("^User sends a POST request to list endpoint of category$")
    public void userSendsAPOSTRequestToListEndpointOfCategory() {
        response = categoriesSteps.createCategory(name,id);
        categoryId = response.log().all().extract().path("id");
        System.out.println(categoryId);
    }

    @When("^User sends a PUT request to list endpoint of category$")
    public void userSendsAPUTRequestToListEndpointOfCategory() {
         name = name + "_updated";
        response = categoriesSteps.updateCategory(categoryId,name,id).log().all().statusCode(200);
        HashMap<String, Object> value = categoriesSteps.getCategoryinfoById(categoryId);
        Assert.assertThat(value, hasValue(categoryId));
        System.out.println(value);
    }

    @When("^User sends a DELETE request to list endpoint of category$")
    public void userSendsADELETERequestToListEndpointOfCategory() {
        response =  categoriesSteps.deleteCategory(categoryId);
        response.assertThat().statusCode(200);
    }

    @And("^User should verify that category is deleted with (\\d+)$")
    public void userShouldVerifyThatCategoryIsDeletedWith(int code) {

        response.assertThat().statusCode(code);
    }
}
