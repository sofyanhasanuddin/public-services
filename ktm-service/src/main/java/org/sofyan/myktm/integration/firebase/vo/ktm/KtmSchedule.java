package org.sofyan.myktm.integration.firebase.vo.ktm;

import java.util.List;

public class KtmSchedule {

    private String route;
    private List<Station> listStation;

    public KtmSchedule() {
    }

    public KtmSchedule(String route, List<Station> listStation) {
        this.route = route;
        this.listStation = listStation;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public List<Station> getListStation() {
        return listStation;
    }

    public void setListStation(List<Station> listStation) {
        this.listStation = listStation;
    }

}
