package com.example.apartment;

import javafx.scene.layout.Pane;

import java.net.URL;

public class FxmlLoader {

    private Pane view;

    public Pane getPage(String fileName){
        try{
            URL fileUrl= Main.class.getResource("/main"+ fileName + ".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("FXML file cannot be found");
            }
            view = new FxmlLoader().load(fileUrl);
        }
        catch (Exception e){
            System.out.println("No page" + fileName + "please check FxmlLoader");
        }
        return view;
    }

    private Pane load(URL fileUrl) {
        return null;
    }
}
