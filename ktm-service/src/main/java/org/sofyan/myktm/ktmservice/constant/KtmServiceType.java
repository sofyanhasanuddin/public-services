package org.sofyan.myktm.ktmservice.constant;

public enum KtmServiceType {

    KTM_NEAREST_STATION("nearestKtmStation"),
    KTM_ROUTE("ktmRoute"),
    KTM_STATION_BY_ROUTE("stationByRoute");

    private String serviceType;

    private KtmServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getValue() {
        return this.serviceType;
    }

}
