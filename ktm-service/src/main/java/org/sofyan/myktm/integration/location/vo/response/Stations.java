package org.sofyan.myktm.integration.location.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stations {

    private Stn[] stn;

    @JsonProperty("Stn")
    public Stn[] getStn() { return stn; }
    @JsonProperty("Stn")
    public void setStn(Stn[] value) { this.stn = value; }

}
