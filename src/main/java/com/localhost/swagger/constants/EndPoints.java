package com.localhost.swagger.constants;


public class EndPoints {

    /**
     * This is Endpoints of products api
     */
    public static final String GET_ALL_PRODUCTS = "/products";
    public static final String CREATE_SINGLE_PRODUCTS = "/products";
    public static final String GET_SINGLE_PRODUCT_BY_ID = "products/{productId}";
    public static final String UPDATE_PRODUCT_BY_ID = "products/{productId}";
    public static final String DELETE_PRODUCT_BY_ID = "products/{productId}";

    //This Endpoints is for STORES

    public static final String GET_SINGLE_STORE_BY_ID = "/stores/{storeId}";
    public static final String CREATE_SINGLE_STORE = "/stores";
    public static final String GET_ALL_STORE = "/stores";
    public static final String UPDATE_STORE_BY_ID = "/stores/{storeId}";
    public static final String DELETE_STORE_BY_ID = "/stores/{storeId}";

    //This Endpoints is for CATEGORIES

    public static final String GET_SINGLE_CATEGORY_BY_ID = "/categories/{categoryId}";
    public static final String CREATE_SINGLE_CATEGORY_BY_ID = "/categories";
    public static final String GET_ALL_CATEGORY = "/categories";
    public static final String UPDATE_CATEGORY_BY_ID = "/categories/{categoryId}";
    public static final String DELETE_CATEGORY_BY_ID = "/categories/{categoryId}";

    // This Endpoints is for SERVICES
    public static final String GET_SINGLE_SERVICE_BY_ID = "services/{serviceID}";
    public static final String CREATE_SINGLE_SERVICE = "/services";
    public static final String GET_ALL_SERVICES = "/services";
    public static final String UPDATE_SERVICE_BY_ID = "services/{serviceID}";
    public static final String DELETE_SERVICE_BY_ID = "services/{serviceID}";

    // This Endpoints is for Utilities
    public static final String GET_UTILITIES = "/version";
    public static final String GET_HEALTHCHECK = "/healthcheck";




    /**
     * This is Endpoints of Authentication api
     */

}
