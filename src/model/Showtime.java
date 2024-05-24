package model;

import java.io.Serializable;
import java.sql.Date;

public class Showtime implements Serializable{
    private int id;
    private String starttime;
    private Date day;
    private String note;
    private Room room;
    private Movie movie;
    private Weekdays weekdays;

    public Showtime() {
    }

    public Showtime(int id, String starttime, Date day, String note, Room room, Movie movie, Weekdays weekdays) {
        this.id = id;
        this.starttime = starttime;
        this.day = day;
        this.note = note;
        this.room = room;
        this.movie = movie;
        this.weekdays = weekdays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public Date getDay() {
        return day;
    }

    public void setDaty(Date day) {
        this.day = day;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Weekdays getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(Weekdays weekdays) {
        this.weekdays = weekdays;
    }
    
}

