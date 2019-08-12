package org.sofyan.myktm.integration.location.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transports {

    private Transport[] transport;

    @JsonProperty("Transport")
    public Transport[] getTransport() { return transport; }
    @JsonProperty("Transport")
    public void setTransport(Transport[] value) { this.transport = value; }

}
