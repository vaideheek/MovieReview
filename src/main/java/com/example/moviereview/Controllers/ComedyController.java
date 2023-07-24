package com.example.moviereview.Controllers;

import com.example.moviereview.Main;
import com.example.moviereview.Models.ComedyData;
import com.example.moviereview.Models.ComedyDataDAO;
import com.example.moviereview.Models.ComedyDataManager;
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

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ComedyController implements Initializable {

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
    private TableView<ComedyData> tableview;
    @FXML
    private TableColumn<ComedyData, String> movieName;
    @FXML
    private TableColumn<ComedyData, Integer> year;
    @FXML
    private TableColumn<ComedyData, Double> rating;

    private final ComedyDataDAO comedyDataManager = new ComedyDataManager();

    @FXML
    void addButtonOnAction(ActionEvent event) {
        ComedyData comedyData = new ComedyData(
                movieNameTextField.getText(),
                Integer.parseInt(yearTextField.getText()),
                Double.parseDouble(ratingTextField.getText())
        );
        comedyDataManager.addComedyData(comedyData);
        observableList.add(comedyData);

        movieNameTextField.clear();
        yearTextField.clear();
        ratingTextField.clear();
    }

    @FXML
    void backButtonOnExit(MouseEvent event) throws IOException {
        Main.setScene("Homepage.fxml");
    }

    private String reviewTextField;
    private final ObservableList<ComedyData> observableList = FXCollections.observableArrayList(
            new ComedyData("777 Charlie", 2022, 8.8),
            new ComedyData("Spider-Man: Into the Spider-Verse", 2018, 8.4),
            new ComedyData("Toy Story", 1995, 8.3)
            //new ComedyData("The Grand Budapest Hotel", 2014, 8.1),
            //new ComedyData("Monsters, Inc.", 2001, 8.1),
            //new ComedyData("Sholay", 1975, 7.9)

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
        List<ComedyData> comedyDataList = comedyDataManager.getAllComedyData();
        observableList.addAll(comedyDataList);
    }
}
