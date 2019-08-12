package org.sofyan.myktm.integration.location.vo.request;

public class PositionVo {

    private String longitude;
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitudeLatitude() {
        return this.longitude + "," + this.latitude;
    }

}
