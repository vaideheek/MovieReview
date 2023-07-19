package com.example.moviereview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private Button fypButton;

    @FXML
    private CheckBox rmCheck;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField enterPasswordField;

    @FXML
    private ImageView closeButton;



    @FXML
    public void signupButtonOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Stage stage = (Stage) signupButton.getScene().getWindow();
        stage.setScene(new Scene(root, 600, 400));
    }

    @FXML
    public void loginButtonOnAction(ActionEvent event) {
        //Parent root = FxmlLoader.load(getClass().getResource(""))

    }

    @FXML
    public void fypButtonOnAction(ActionEvent event) {
    }

    @FXML
    void closeButtonOnExit(MouseEvent event) {
        javafx.application.Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
