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

public class RomanceController implements Initializable {

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
    private TableView<RomanceData> tableview;
    @FXML
    private TableColumn<RomanceData, String> movieName;
    @FXML
    private TableColumn<RomanceData, Integer> year;
    @FXML
    private TableColumn<RomanceData, Double> rating;

    private final RomanceDataDAO romanceDataManager = new RomanceDataManager();
    @FXML
    void addButtonOnAction(ActionEvent event) {
        RomanceData romanceData= new RomanceData(
                movieNameTextField.getText(),
                Integer.parseInt(yearTextField.getText()),
                Double.parseDouble(ratingTextField.getText())
        );
        romanceDataManager.addRomanceData(romanceData);
        observableList.add(romanceData);

        movieNameTextField.clear();
        yearTextField.clear();
        ratingTextField.clear();
    }

    private final ObservableList<RomanceData> observableList = FXCollections.observableArrayList(
            new RomanceData(" Titanic ", 1997, 7.9),
            new RomanceData(" Forrest Gump", 1994, 8.8),
            new RomanceData(" La La Land", 2016, 8.0)
            //new RomanceData(" Crazy Rich Asians ", 2018, 8.6),
            //new RomanceData(" Cinderella", 1981, 9.1),
            //new RomanceData(" A Marriage Made in Heaven ", 2022, 10.0)
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
        List<RomanceData> romanceDataList = romanceDataManager.getAllRomanceData();
        observableList.addAll(romanceDataList);
    }
}
