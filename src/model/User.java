package model;

import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private String fullname;
    private String username;
    private String password;
    private String position;

    public User() {
    }

    public User(int id, String fullname, String username, String password, String position) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
}
