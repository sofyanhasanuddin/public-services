package org.sofyan.myktm.integration.location.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Res {

    private String serviceURL;
    private Stations stations;

    @JsonProperty("serviceUrl")
    public String getServiceURL() { return serviceURL; }
    @JsonProperty("serviceUrl")
    public void setServiceURL(String value) { this.serviceURL = value; }

    @JsonProperty("Stations")
    public Stations getStations() { return stations; }
    @JsonProperty("Stations")
    public void setStations(Stations value) { this.stations = value; }

}
