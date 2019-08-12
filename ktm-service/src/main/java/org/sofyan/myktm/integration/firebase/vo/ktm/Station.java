package org.sofyan.myktm.integration.firebase.vo.ktm;

import java.util.ArrayList;
import java.util.List;

public class Station {

    private String fromTo;
    private String name;

    private List<Schedule> listSchedule = new ArrayList<Schedule>();

    public String getFromTo() {
        return fromTo;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Schedule> getListSchedule() {
        return listSchedule;
    }

    public void setListSchedule(List<Schedule> listSchedule) {
        this.listSchedule = listSchedule;
    }
}
