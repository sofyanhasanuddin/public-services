package org.sofyan.myktm.integration.firebase.constant;

public enum FirebaseEndpointConstant {

    BASE("https://my-ktm.firebaseio.com/"),
    PUT("put"),
    JSON(".json"),
    KTM_GET_ALL("rest/ktm");

    private String endpoint;

    private FirebaseEndpointConstant(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getValue() {
        return this.endpoint;
    }

}