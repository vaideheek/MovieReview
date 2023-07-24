package com.example.moviereview.Models;

import java.util.List;

public interface SciFiDataDAO {


    void addSciFiData(SciFiData sciFiData);

    void updateSciFiData(SciFiData sciFiData);

    void deleteSciFiData(SciFiData sciFiData);

    List<SciFiData> getAllSciFiData();
}
