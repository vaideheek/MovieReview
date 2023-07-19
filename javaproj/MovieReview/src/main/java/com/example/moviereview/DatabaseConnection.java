package com.example.moviereview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    public Connection getConnection() throws SQLException {
        String databaseName = "moviereview";
        String databaseUser = "vaidehee";
        String databasePassword = "";
        String url = "jdbc:h2:/Users/vaideheekore/Downloads/javaproj/MovieReview/src/main/resources/com/example/moviereview/moviedatabase";

        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(url, databaseUser, databasePassword);


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return connection;

    }
}
