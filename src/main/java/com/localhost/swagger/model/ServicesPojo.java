package com.localhost.swagger.model;

/**
 * Created by Jay Vaghani
 */
public class ServicesPojo {
    //only from request body from postman-payload
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ServicesPojo getServicesPojo (String name){
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName(name);
        return servicesPojo;
    }

}




