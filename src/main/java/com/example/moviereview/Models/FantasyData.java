package com.example.moviereview.Models;

import javax.persistence.*;

@Entity
@Table(name = "FantasyData")
public class FantasyData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false)
    private String movieName;

    @Basic(optional = false)
    private int releaseYear;

    @Basic(optional = false)
    private double rating;


    public FantasyData() {
    }

    public FantasyData(String movieName, int releaseYear, double rating) {
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
        return "FantasyData{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", year=" + releaseYear +
                ", rating=" + rating +
                '}';
    }
}