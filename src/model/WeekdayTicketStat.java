package model;

import java.io.Serializable;

public class WeekdayTicketStat extends Weekdays implements Serializable{
    private int totalTicket;
    private float revenue;
    private int nShowtime;

    public WeekdayTicketStat() {
    }

	public WeekdayTicketStat(int totalTicket, float revenue, int nShowtime) {
		super();
		this.totalTicket = totalTicket;
		this.revenue = revenue;
		this.nShowtime = nShowtime;
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

	public int getnShowtime() {
		return nShowtime;
	}

	public void setnShowtime(int nShowtime) {
		this.nShowtime = nShowtime;
	}

    
        
}
