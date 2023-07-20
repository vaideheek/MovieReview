package com.example.moviereview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class SignUpController implements Initializable {

    @FXML
    private Button SignUpButton;

    @FXML
    private PasswordField confirmField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField fnameTextField;

    @FXML
    private TextField lnameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Label SavedMessageLabel;
    @FXML
    private Label MatchMessageLabel;

    @FXML
    private Menu backMenuOption;

    @FXML
    private ImageView CloseButton;


    @FXML
    void SignUpButtonOnAction(ActionEvent event) throws IOException {
        if(passwordField.getText().equals(confirmField.getText())){
            MatchMessageLabel.setText("Account Created!");
            //SaveUser();

        }else{
            MatchMessageLabel.setText("Password does not match");


        }

        Parent root = FXMLLoader.load(getClass().getResource("LoginMain.fxml"));
        Stage stage = (Stage) SignUpButton.getScene().getWindow();
        stage.setScene(new Scene(root, 600, 400));
    }

    @FXML
    void CloseButtonOnExit(MouseEvent event) {
        javafx.application.Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


