package com.example.moviereview.Exceptions;

public class UserDataAlreadyExistsException extends Throwable {
    public void errorAlertForUserDataAlreadyExists() {
        AllAlerts.errorAlert("UserDataAlreadyExistsException", "UserData Already Exists Exception caught!", "The entered user already exists! \nPlease Enter a new user or try logging in.");
    }
}
