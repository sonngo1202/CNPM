package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Bill implements Serializable{
    private int id;
    private float saleOff;
    private Date paymentDate;
    private int totalTicket;
    private float totalAmount;
    private List<Ticket> listTicket;
    private User user;
    private Client client;

    public Bill() {
    }

    public Bill(int id, float saleOff, Date paymentDate, int totalTicket, float totalAmount, List<Ticket> listTicket, User user, Client client) {
        this.id = id;
        this.saleOff = saleOff;
        this.paymentDate = paymentDate;
        this.totalTicket = totalTicket;
        this.totalAmount = totalAmount;
        this.listTicket = listTicket;
        this.user = user;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(float saleOff) {
        this.saleOff = saleOff;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(int totalTicket) {
        this.totalTicket = totalTicket;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Ticket> getListTicket() {
        return listTicket;
    }

    public void setListTicket(List<Ticket> listTicket) {
        this.listTicket = listTicket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
