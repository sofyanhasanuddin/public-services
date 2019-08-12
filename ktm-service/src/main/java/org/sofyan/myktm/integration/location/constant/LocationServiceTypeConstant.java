package org.sofyan.myktm.integration.location.constant;

public enum LocationServiceTypeConstant {

    NEARBY_STATION("nearbyStation");

    private String serviceType;

    private LocationServiceTypeConstant(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getValue() {
        return this.serviceType;
    }
}
