package model;

import java.io.Serializable;
import java.sql.Date;

public class Client implements Serializable{
    private int id;
    private String name;
    private Date dob;
    private String tel;
    private String email;

    public Client() {
    }

    public Client(int id, String name, Date dob, String tel, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.tel = tel;
        this.email = email;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
