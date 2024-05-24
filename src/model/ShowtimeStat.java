package model;

import java.io.Serializable;

public class ShowtimeStat extends Showtime implements Serializable {
    private int totalTicket;
    private float revenue;

    public ShowtimeStat() {
    }

    public ShowtimeStat(int totalTicket, float revenue) {
        this.totalTicket = totalTicket;
        this.revenue = revenue;
    }

    public int getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(int totalTicket) {
        this.totalTicket = totalTicket;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }
    
}
