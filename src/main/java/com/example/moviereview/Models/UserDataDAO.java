package com.example.moviereview.Models;

import java.util.List;

public interface UserDataDAO extends AutoCloseable {
    void setUserData(UserData userData);

    void deleteUserData(UserData userData);

    void updateUserData(UserData userData);

    List<UserData> readAllUserData();
}
