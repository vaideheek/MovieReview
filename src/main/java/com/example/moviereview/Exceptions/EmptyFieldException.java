package com.example.moviereview.Exceptions;

public class EmptyFieldException extends Throwable {

    public void errorAlertForEmptyField() {
        AllAlerts.errorAlert("EmptyFieldException", "Empty Field Exception caught!", "Fields cannot be left empty!\nPlease try Again.");
    }
}
