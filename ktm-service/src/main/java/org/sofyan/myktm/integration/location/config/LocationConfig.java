package org.sofyan.myktm.integration.location.config;

import org.sofyan.myktm.integration.location.constant.LocationServiceTypeConstant;

public class LocationConfig {

    private LocationServiceTypeConstant serviceType;
    private String serviceEndpoint;
    private String jsonPathFindName;
    private String jsonPathCheckRespons;
    private String jsonPathFindErrorMessage;
    private String locationServiceImpl;
    private LocationConfigParam configParam;

    public String getLocationServiceImpl() {
        return locationServiceImpl;
    }

    public void setLocationServiceImpl(String locationServiceImpl) {
        this.locationServiceImpl = locationServiceImpl;
    }

    public LocationConfigParam getConfigParam() {
        return configParam;
    }

    public void setConfigParam(LocationConfigParam configParam) {
        this.configParam = configParam;
    }

    public LocationServiceTypeConstant getServiceType() {
        return serviceType;
    }

    public void setServiceType(LocationServiceTypeConstant serviceType) {
        this.serviceType = serviceType;
    }

    public String getJsonPathFindErrorMessage() {
        return jsonPathFindErrorMessage;
    }

    public void setJsonPathFindErrorMessage(String jsonPathFindErrorMessage) {
        this.jsonPathFindErrorMessage = jsonPathFindErrorMessage;
    }

    public String getServiceEndpoint() {
        return serviceEndpoint;
    }

    public void setServiceEndpoint(String serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
    }

    public String getJsonPathFindName() {
        return jsonPathFindName;
    }

    public void setJsonPathFindName(String jsonPathFindName) {
        this.jsonPathFindName = jsonPathFindName;
    }

    public String getJsonPathCheckRespons() {
        return jsonPathCheckRespons;
    }

    public void setJsonPathCheckRespons(String jsonPathCheckRespons) {
        this.jsonPathCheckRespons = jsonPathCheckRespons;
    }

}
