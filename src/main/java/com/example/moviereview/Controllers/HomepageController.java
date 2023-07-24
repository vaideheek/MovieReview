package com.example.moviereview.Controllers;

import com.example.moviereview.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomepageController implements Initializable {
    @FXML
    private ImageView closeButton;

    @FXML
    private ImageView comedy;

    @FXML
    private ImageView fantasy;

    @FXML
    private ImageView horror;

    @FXML
    private ImageView romance;

    @FXML
    private ImageView scifi;

    @FXML
    private Button logOutButton;



    @FXML
    void scifiOnClick(MouseEvent event) throws IOException {
        Main.setScene("SciFi.fxml");

    }

    @FXML
    void comedyOnClick(MouseEvent event) throws IOException {
        Main.setScene("Comedy.fxml");

    }

    @FXML
    void fantasyOnClick(MouseEvent event) throws IOException {
        Main.setScene("Fantasy.fxml");

    }

    @FXML
    void horrorOnClick(MouseEvent event) throws IOException {
        Main.setScene("Horror.fxml");

    }

    @FXML
    void romanceOnClick(MouseEvent event) throws IOException {
        Main.setScene("Romance.fxml");

    }
    @FXML
    void logOutButtonOnAction(ActionEvent event) throws IOException {
        Main.setScene("LoginMain.fxml");
    }
    @FXML
    void closeButtonOnExit(MouseEvent event) {
        javafx.application.Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
