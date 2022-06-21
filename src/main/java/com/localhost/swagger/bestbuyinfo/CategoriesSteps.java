package com.localhost.swagger.bestbuyinfo;

import com.localhost.swagger.constants.EndPoints;
import com.localhost.swagger.model.CategoriesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class CategoriesSteps {

    @Step("Creating Category with name: {0}, id: {1}")
    public ValidatableResponse createCategory(String name, String id) {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post(EndPoints.CREATE_SINGLE_CATEGORY_BY_ID)
                .then();
    }
    @Step("Getting all Categories information ")
    public ValidatableResponse getAllCategories(){
        return SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.GET_ALL_CATEGORY)
                .then().log().all();

    }
    @Step("Getting the Category information with ID: {1}")
    public HashMap<String, Object> getCategoryinfoById(String categoryId) {
        HashMap<String, Object> categoryMap = SerenityRest.given().log().all()
                .when()
                .pathParam("categoryId", categoryId)
                .get(EndPoints.GET_SINGLE_CATEGORY_BY_ID)
                .then()
                .statusCode(200)
                .extract().path("");

        return categoryMap;
    }
    @Step("Updating Category information with name : {0}, ID: {1}")
    public ValidatableResponse updateCategory(String categoryId,String name,String id) {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("categoryId", categoryId)
                .body(categoriesPojo)
                .when()
                .put(EndPoints.UPDATE_CATEGORY_BY_ID)
                .then();
    }
    @Step("Deleting Category information with CategoryID: {0}")
    public ValidatableResponse deleteCategory(String categoryId) {
        return SerenityRest
                .given()
                .pathParam("categoryId", categoryId)
                .when()
                .delete(EndPoints.DELETE_CATEGORY_BY_ID)
                .then();
    }
    @Step("Getting Category information with CategoryID: {0}")
    public ValidatableResponse getCategoryById(String categoryId) {
        return SerenityRest
                .given()
                .pathParam("categoryId", categoryId)
                .when()
                .get(EndPoints.GET_SINGLE_CATEGORY_BY_ID)
                .then();
    }
    }




