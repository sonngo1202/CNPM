package model;

import java.io.Serializable;
import java.util.List;

public class Cinema implements Serializable{
    private int id;
    private String name;
    private String address;
    private String introduce;
    private List<Room> listRoom;

    public Cinema() {
    }

    public Cinema(int id, String name, String address, String introduce, List<Room> listRoom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.introduce = introduce;
        this.listRoom = listRoom;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public List<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(List<Room> listRoom) {
        this.listRoom = listRoom;
    }
    
}