package org.sofyan.myktm.integration.location.constant;

public enum LocationServiceRestConstant {

    URL("https://transit.api.here.com/v3/"),
    APP_ID("z5h5v6lbv48NxlZfBDmh"),
    APP_CODE("3ykMQpaV2jYIIV3Pd__FjA");

    private String restConstant;

    private LocationServiceRestConstant(String restConstant) {
        this.restConstant = restConstant;
    }

    public String getValue() {
        return this.restConstant;
    }

}
