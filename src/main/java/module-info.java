module com.example.moviereview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.moviereview to javafx.fxml;
    exports com.example.moviereview;
}