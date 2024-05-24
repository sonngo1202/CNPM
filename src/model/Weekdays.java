package model;

import java.io.Serializable;

public class Weekdays implements Serializable{
    private int id;
    private String dayname;

    public Weekdays() {
    }

    public Weekdays(int id, String dayname) {
        this.id = id;
        this.dayname = dayname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayname() {
        return dayname;
    }

    public void setDayname(String dayname) {
        this.dayname = dayname;
    }
    
}
