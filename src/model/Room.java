package model;

import java.io.Serializable;
import java.util.List;

public class Room implements Serializable{
    private int id;
    private String name;
    private String type;
    private int nSeat;
    private String introduce;
    private List<Seat> listSeat;
    private Cinema cinema;

    public Room() {
    }

    public Room(int id, String name, String type, int nSeat, String introduce, List<Seat> listSeat, Cinema cinema) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.nSeat = nSeat;
        this.introduce = introduce;
        this.listSeat = listSeat;
        this.cinema = cinema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getnSeat() {
        return nSeat;
    }

    public void setnSeat(int nSeat) {
        this.nSeat = nSeat;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public List<Seat> getListSeat() {
        return listSeat;
    }

    public void setListSeat(List<Seat> listSeat) {
        this.listSeat = listSeat;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    
}

