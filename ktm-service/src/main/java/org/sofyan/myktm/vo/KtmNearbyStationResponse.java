package org.sofyan.myktm.vo;

public class KtmNearbyStationResponse extends RouteResponse {

    private String stationName;
    private String time;

    public KtmNearbyStationResponse() {};

    public KtmNearbyStationResponse(String stationName, String time) {
        this.stationName = stationName;
        this.time = time;
    }

    public KtmNearbyStationResponse(String route, String stationName, String time) {
        super(route);
        this.stationName = stationName;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
