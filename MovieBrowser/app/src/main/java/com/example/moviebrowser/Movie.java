package com.example.moviebrowser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {

    private String name;
    private String director;
    private int year;
    private List<String> stars = new ArrayList<>();
    private String description;



    public Movie(String name, String director, int year, List<String> stars, String
            description) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.stars = stars;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector(){
        return director;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getStars() {
        return stars;
    }

    public void setStars(List<String> stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
//Getters and setters



}
