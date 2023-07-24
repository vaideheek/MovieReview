package com.example.moviereview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.h2.tools.Server;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    private static final Server server = new Server();
    private static Scene scene;


    public static void main(String[] args) throws SQLException {
        startDatabase();
        System.out.println("Movie Review");
        launch(args);
        stopDatabase();
    }

    private static Parent loadFxml(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/" + fxml));
        return loader.load();
    }

    public static void setScene(String fxml) throws IOException {
        scene.setRoot(loadFxml(fxml));
    }

    public static void startDatabase() throws SQLException {
        server.runTool("-tcp", "-web", "-ifNotExists");
    }

    private static void stopDatabase() {
        server.shutdown();
    }

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFxml("LoginMain.fxml"));
        stage.setTitle("Movie Review");
        stage.setScene(scene);
        stage.show();
    }
}