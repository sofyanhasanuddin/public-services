package org.sofyan.myktm.integration.location.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationResponse {

    private Res res;

    @JsonProperty("Res")
    public Res getRes() { return res; }
    @JsonProperty("Res")
    public void setRes(Res value) { this.res = value; }

}
