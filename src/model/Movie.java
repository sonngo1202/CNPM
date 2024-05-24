package model;

import java.io.Serializable;

public class Movie implements Serializable{
    private int id;
    private String name;
    private String category;
    private String movieDuration;
    private String introduce;

    public Movie() {
    }

    public Movie(int id, String name, String category, String movieDuration, String introduce) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.movieDuration = movieDuration;
        this.introduce = introduce;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    
}
