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

public class HorrorController implements Initializable {

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
    private TableView<HorrorData>tableview;

    @FXML
    private TableColumn<HorrorData,String> movieName;
    @FXML
    private TableColumn<HorrorData,Integer> year;
    @FXML
    private TableColumn<HorrorData,Double> rating;

    private final HorrorDataDAO horrorDataManager = new HorrorDataManager();
    @FXML
    void addButtonOnAction(ActionEvent event) {
        HorrorData horrorData = new HorrorData(
                movieNameTextField.getText(),
                Integer.parseInt(yearTextField.getText()),
                Double.parseDouble(ratingTextField.getText())
        );
        horrorDataManager.addHorrorData(horrorData);
        observableList.add(horrorData);

        movieNameTextField.clear();
        yearTextField.clear();
        ratingTextField.clear();
    }

    private final ObservableList<HorrorData> observableList= FXCollections.observableArrayList (
            new HorrorData("Presa Nocturna", 2022, 9.7),
            new HorrorData("Frankenstein's Patchwork Monster", 2015, 9.0),
            new HorrorData("Insidious", 2010, 6.8)
            //new HorrorData("Bird Box ", 2018, 7.2),
            //new HorrorData("Barbarian", 2022, 7.0),
            //new HorrorData("The Shining", 1980, 8.4)
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
        List<HorrorData> horrorDataList = horrorDataManager.getAllHorrorData();
        observableList.addAll(horrorDataList);
    }


}
