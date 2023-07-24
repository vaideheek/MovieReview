package com.example.moviereview.Controllers;

import com.example.moviereview.Main;
import com.example.moviereview.Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SciFiController implements Initializable {


    @FXML
    private Button addButton;
    @FXML
    private TextField movieNameTextField;
    @FXML
    private TextField ratingTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private ImageView backButton;
    @FXML
    private TableView<SciFiData> tableview;
    @FXML
    private TableColumn<SciFiData, String> movieName;
    @FXML
    private TableColumn<SciFiData, Integer> year;
    @FXML
    private TableColumn<SciFiData, Double> rating;

    private final SciFiDataDAO sciFiDataManager = new SciFiDataManager();

    @FXML
    void addButtonOnAction(ActionEvent event) {
        SciFiData sciFiData = new SciFiData(
                movieNameTextField.getText(),
                Integer.parseInt(yearTextField.getText()),
                Double.parseDouble(ratingTextField.getText())
        );
        sciFiDataManager.addSciFiData(sciFiData);
        observableList.add(sciFiData);

        movieNameTextField.clear();
        yearTextField.clear();
        ratingTextField.clear();
    }
    private final ObservableList<SciFiData> observableList = FXCollections.observableArrayList(
            new SciFiData("Guardians of the Galaxy Vol. 3", 2023, 8.1),
            new SciFiData(" Interstellar ", 2014, 8.7),
            new SciFiData(" Inception", 2010, 8.8)
            //new SciFiData("Jurassic Park", 1993, 8.2),
            //new SciFiData("The Hunger Games", 2012, 7.2),
            //new SciFiData(" Avengers: Endgame", 2019, 8.4)
    );

    @FXML
    void backButtonOnExit(MouseEvent event) throws IOException {
        Main.setScene("Homepage.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDataFromDatabase();
        movieName.setCellValueFactory(new PropertyValueFactory<>("MovieName"));
        year.setCellValueFactory(new PropertyValueFactory<>("ReleaseYear"));
        rating.setCellValueFactory(new PropertyValueFactory<>("Rating"));
        tableview.setItems(observableList);
    }
    private void loadDataFromDatabase() {
        List<SciFiData> sciFiDataList = sciFiDataManager.getAllSciFiData();
        observableList.addAll(sciFiDataList);
    }
}
