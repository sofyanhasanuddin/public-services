package org.sofyan.myktm.integration.location.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transport {

    private String name;
    private long mode;
    private String dir;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("mode")
    public long getMode() { return mode; }
    @JsonProperty("mode")
    public void setMode(long value) { this.mode = value; }

    @JsonProperty("dir")
    public String getDir() { return dir; }
    @JsonProperty("dir")
    public void setDir(String value) { this.dir = value; }

}
