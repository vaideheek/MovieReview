package com.example.moviereview.Models;

import java.util.List;

public interface FantasyDataDAO {

    void addFantasyData(FantasyData fantasyData);

    void updateFantasyData(FantasyData fantasyData);


    void deleteFantasyData(FantasyData fantasyData);

    List<FantasyData> getAllFantasyData();
}
