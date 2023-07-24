package com.example.moviereview.Models;

import java.util.List;

public interface RomanceDataDAO {

    void addRomanceData(RomanceData romanceData);

    void updateRomanceData(RomanceData romanceData);

    void deleteRomanceData(RomanceData romanceData);

    List<RomanceData> getAllRomanceData();
}
