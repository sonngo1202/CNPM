package model;

import java.io.Serializable;

public class Ticket implements Serializable{
    private int id;
    private String category;
    private float price;
    private Seat seat;
    private Showtime showtime;

    public Ticket() {
    }

    public Ticket(int id, String category, float price, Seat seat, Showtime showtime) {
        this.id = id;
        this.category = category;
        this.price = price;
        this.seat = seat;
        this.showtime = showtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }
    
}
