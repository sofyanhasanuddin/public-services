package org.sofyan.myktm.integration.location.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stn {

    private String id;
    private String name;
    private long distance;
    private String duration;
    private double x;
    private double y;
    private long hasBoard;
    private String country;
    private String ccode;
    private String state;
    private String postal;
    private String district;
    private String city;
    private Transports transports;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("distance")
    public long getDistance() { return distance; }
    @JsonProperty("distance")
    public void setDistance(long value) { this.distance = value; }

    @JsonProperty("duration")
    public String getDuration() { return duration; }
    @JsonProperty("duration")
    public void setDuration(String value) { this.duration = value; }

    @JsonProperty("x")
    public double getX() { return x; }
    @JsonProperty("x")
    public void setX(double value) { this.x = value; }

    @JsonProperty("y")
    public double getY() { return y; }
    @JsonProperty("y")
    public void setY(double value) { this.y = value; }

    @JsonProperty("has_board")
    public long getHasBoard() { return hasBoard; }
    @JsonProperty("has_board")
    public void setHasBoard(long value) { this.hasBoard = value; }

    @JsonProperty("country")
    public String getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(String value) { this.country = value; }

    @JsonProperty("ccode")
    public String getCcode() { return ccode; }
    @JsonProperty("ccode")
    public void setCcode(String value) { this.ccode = value; }

    @JsonProperty("state")
    public String getState() { return state; }
    @JsonProperty("state")
    public void setState(String value) { this.state = value; }

    @JsonProperty("postal")
    public String getPostal() { return postal; }
    @JsonProperty("postal")
    public void setPostal(String value) { this.postal = value; }

    @JsonProperty("district")
    public String getDistrict() { return district; }
    @JsonProperty("district")
    public void setDistrict(String value) { this.district = value; }

    @JsonProperty("city")
    public String getCity() { return city; }
    @JsonProperty("city")
    public void setCity(String value) { this.city = value; }

    @JsonProperty("Transports")
    public Transports getTransports() { return transports; }
    @JsonProperty("Transports")
    public void setTransports(Transports value) { this.transports = value; }

}
