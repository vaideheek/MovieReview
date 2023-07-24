package com.example.moviereview.Models;

import javax.persistence.*;

@Entity
@Table(name = "SciFiData")
public class SciFiData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false)
    private String movieName;

    @Basic(optional = false)
    private int releaseYear;

    @Basic(optional = false)
    private double rating;


    public SciFiData() {
    }

    public SciFiData(String movieName, int releaseYear, double rating) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ComedyData{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", year=" + releaseYear +
                ", rating=" + rating +
                '}';
    }
}






























/*
package com.example.moviereview.Models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;

public class ComedyData {
    private SimpleStringProperty movieName;
    private SimpleIntegerProperty year;
    private SimpleDoubleProperty rating;

    public ComedyData(String movieName, int year, double rating) {
        this.movieName = new SimpleStringProperty(movieName);
        this.year = new SimpleIntegerProperty(year);
        this.rating = new SimpleDoubleProperty(rating);
    }

    public String getMovieName() {
        return movieName.get();
    }

    public void setMovieName(String movieName) {
        this.movieName = new SimpleStringProperty(movieName);
    }

    public int getYear() {
        return year.get();
    }

    public void setYear(int year) {
        this.year = new SimpleIntegerProperty(year);
    }

    public double getRating() {
        return rating.get();
    }

    public void setRating(double rating) {
        this.rating = new SimpleDoubleProperty(rating);
    }
}
*/
















































