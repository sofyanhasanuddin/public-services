package org.sofyan.myktm.vo;

import org.sofyan.myktm.integration.firebase.vo.ktm.Schedule;

import java.util.List;

public class KtmNearbyStationResponse extends RouteResponse {

    private String stationName;
    private String time;
    private List<Schedule> times;

    public KtmNearbyStationResponse() {};

    public KtmNearbyStationResponse(String stationName, String time, List<Schedule> times) {
        this.stationName = stationName;
        this.time = time;
        this.times = times;
    }

    public KtmNearbyStationResponse(String route, String stationName, String time, List<Schedule> times) {
        super(route);
        this.stationName = stationName;
        this.time = time;
        this.times = times;
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

    public List<Schedule> getTimes() {
        return times;
    }

    public void setTimes(List<Schedule> times) {
        this.times = times;
    }

}
