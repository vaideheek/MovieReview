package com.example.moviereview.Controllers;

import com.example.moviereview.Exceptions.EmptyFieldException;
import com.example.moviereview.Exceptions.UserDataAuthenticationFailedException;
import com.example.moviereview.Main;
import com.example.moviereview.Models.UserData;
import com.example.moviereview.Models.UserDataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private UserDataManager userDataManager;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private Button fypButton;

    @FXML
    private CheckBox shPasswordCheck;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField enterPasswordField;

    @FXML
    private AnchorPane LoginAnchorPane;


    @FXML
    public void signupButtonOnAction(ActionEvent event) throws IOException {
        Main.setScene("SignUp.fxml");
    }

    @FXML
    public void loginButtonOnAction(ActionEvent event) throws IOException {
        try {
            userDataAuthentication();
            Main.setScene("Homepage.fxml");
        } catch (EmptyFieldException e) {
            e.errorAlertForEmptyField();
        } catch (UserDataAuthenticationFailedException e) {
            e.errorAlertForUserDataAuthenticationFailed();
        }

    }

    private void userDataAuthentication() throws EmptyFieldException, UserDataAuthenticationFailedException {

        if (usernameTextField.getText().isEmpty() || enterPasswordField.getText().isEmpty()) {
            throw new EmptyFieldException();
        }
        userDataManager = new UserDataManager();
        List<UserData> userDataList = userDataManager.readAllUserData();
        for (UserData userData : userDataList) {
            if (usernameTextField.getText().equals(userData.getUsername()) && enterPasswordField.getText().equals(userData.getPassword())) {
                return;
            }
        }

        throw new UserDataAuthenticationFailedException();
    }



    @FXML
    public void fypButtonOnAction(ActionEvent event) {
        HBox hBox = new HBox();
        Label label = new Label("Enter Email ID:    ");
        label.setFont(new Font(18));
        TextField textField = new TextField();
        textField.setPromptText("Enter your Email here");
        textField.setPrefWidth(200);
        hBox.getChildren().addAll(label, textField);

        Alert forgotPassword = new Alert(Alert.AlertType.INFORMATION);
        forgotPassword.setTitle("Forgot Password");
        forgotPassword.setHeaderText("");
        forgotPassword.setGraphic(hBox);
        forgotPassword.showAndWait().ifPresent(buttonType -> {
            System.out.println(textField.getText());
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
