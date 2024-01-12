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

public class FantasyController implements Initializable {


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
    private TableView<FantasyData> tableview;
    @FXML
    private TableColumn<FantasyData, String> movieName;
    @FXML
    private TableColumn<FantasyData, Integer> year;
    @FXML
    private TableColumn<FantasyData, Double> rating;

    private final FantasyDataDAO fantasyDataManager = new FantasyDataManager();
    @FXML
    void addButtonOnAction(ActionEvent event) {
        FantasyData fantasyData = new FantasyData(
                movieNameTextField.getText(),
                Integer.parseInt(yearTextField.getText()),
                Double.parseDouble(ratingTextField.getText())
        );
        fantasyDataManager.addFantasyData(fantasyData);
        observableList.add(fantasyData);

        movieNameTextField.clear();
        yearTextField.clear();
        ratingTextField.clear();

    }

    @FXML
    void backButtonOnExit(MouseEvent event) throws IOException {
        Main.setScene("Homepage.fxml");

    }
    private final ObservableList<FantasyData> observableList = FXCollections.observableArrayList(


    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDataFromDatabase();
        movieName.setCellValueFactory(new PropertyValueFactory<>("MovieName"));
        year.setCellValueFactory(new PropertyValueFactory<>("ReleaseYear"));
        rating.setCellValueFactory(new PropertyValueFactory<>("Rating"));
        tableview.setItems(observableList);
    }
    private void loadDataFromDatabase() {
        List<FantasyData> fantasyDataList = fantasyDataManager.getAllFantasyData();
        observableList.addAll(fantasyDataList);
    }
}
