package com.example.apartment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;

import java.sql.Connection;

public class LoginController implements Initializable {
    @FXML
    private Button loginButton;

    @FXML
    private Button CreateAnAccountButton;

    @FXML
    private Label loginMessagelabel;

    @FXML
    private ImageView brandingImageView;

    @FXML
    private ImageView logoimageView;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField enterPasswordField;

    @FXML
    private BorderPane mainpane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("/../IdeaProjects/Apartment/src/main/resources/com/image/main.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File logoFile = new File(" /../IdeaProjects/Apartment/src/main/resources/com/image/logo .png");
        Image logoImage = new Image(logoFile.toURI().toString());
        logoimageView.setImage(logoImage);
    }

   @FXML
    public void loginButtonOnAction(ActionEvent event){
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Welcome.fxml");
        mainpane.setCenter(view);
       //Stage stage = (Stage)  loginButton.getScene().getWindow();
        //stage.close();

     /*   if(usernameTextField.getText().isBlank()==false && enterPasswordField.getText().isBlank()==false ){
            validateLogin();
        }
        else {
            loginMessagelabel.setText("Please enter username and password");
        }*/
    }




    public void CreateAnAccountButtonOnAction(ActionEvent event){
        Stage stage = (Stage)  CreateAnAccountButton.getScene().getWindow();
        stage.close();
    }

    
    
/*   public void validateLogin(){
        DBconnection connectNow = new DBconnection() ;
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM login_db.user_account WHERE username = '" + usernameTextField.getText() + "'AND password ='" + enterPasswordField.getText()  + "''";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet QueryResult = statement.executeQuery(verifyLogin);

            while(QueryResult.next()){
                if(QueryResult.getInt(1)==1){
                    loginMessagelabel.setText("ok");

                }else{
                    loginMessagelabel.setText("Wrong username or password");
                }

            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }*/


}
