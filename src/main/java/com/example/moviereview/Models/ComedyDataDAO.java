package com.example.moviereview.Models;

import java.util.List;

public interface ComedyDataDAO{
    void addComedyData(ComedyData comedyData);

    void updateComedyData(ComedyData comedyData);

    void deleteComedyData(ComedyData comedyData);

    List<ComedyData> getAllComedyData();
}
