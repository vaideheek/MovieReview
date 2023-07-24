package com.example.moviereview.Models;

import java.util.List;

public interface HorrorDataDAO {

    void addHorrorData(HorrorData horrorData);

    void updateHorrorData(HorrorData horrorData);

    void deleteHorrorData(HorrorData horrorData);

    List<HorrorData> getAllHorrorData();
}
