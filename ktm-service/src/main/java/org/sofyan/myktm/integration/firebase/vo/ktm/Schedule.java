package org.sofyan.myktm.integration.firebase.vo.ktm;

public class Schedule {

    private String time;

    public String getTime() {
        if( this.time != null && this.time.length() > 0 && this.time.contains(":")) {
            String[] temp = this.time.split(":");
            if (temp[0].length() == 1)
                temp[0] = "0" + temp[0];
            return String.join(":", temp);
        }
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
