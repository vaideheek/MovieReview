package com.example.moviereview.Controllers;

import com.example.moviereview.Exceptions.*;
import com.example.moviereview.Main;
import com.example.moviereview.Models.UserData;
import com.example.moviereview.Models.UserDataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class SignUpController implements Initializable {

    @FXML
    private Label MatchMessageLabel;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameTextField;


    private UserDataManager userDataManager;


    @FXML
    void SignUpButtonOnAction(ActionEvent actionEvent) throws Exception {
        try {
            registerUserValidate();
            userDataManager = new UserDataManager();
            UserData userData = new UserData();
            userData.setUsername(usernameTextField.getText());
            userData.setEmail(emailTextField.getText());
            userData.setPassword(passwordField.getText());
            userDataManager.setUserData(userData);
            userDataManager.close();
            AllAlerts.confirmAlert("Registration", "Registration Successful!", "The user was registered successfully!");
            Main.setScene("LoginMain.fxml");
        } catch (EmptyFieldException e) {
            e.errorAlertForEmptyField();
        } catch (UserDataAlreadyExistsException e) {
            e.errorAlertForUserDataAlreadyExists();
        } catch (ShortPasswordException e) {
            e.errorAlertForShortPassword();
        } catch (WrongKeyException e) {
            e.errorAlertForWrongKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void registerUserValidate() throws EmptyFieldException, UserDataAlreadyExistsException, ShortPasswordException, WrongKeyException {
        if (usernameTextField.getText().isEmpty() || emailTextField.getText().isEmpty()
                || passwordField.getText().isEmpty()) {
            throw new EmptyFieldException();
        }

        userDataManager = new UserDataManager();
        List<UserData> userDataList = userDataManager.readAllUserData();
        for (UserData userData : userDataList) {
            if (userData.getUsername().equals(usernameTextField.getText()) || userData.getEmail().equals(emailTextField.getText())) {
                throw new UserDataAlreadyExistsException();
            }
        }
        try {
            userDataManager.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (passwordField.getText().length() < 6) {
            throw new ShortPasswordException();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void backButtonOnExit(MouseEvent mouseEvent) throws IOException {
        Main.setScene("LoginMain.fxml");
    }
}


