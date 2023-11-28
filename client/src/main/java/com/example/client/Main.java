package com.example.client;

import com.google.inject.Guice;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static final String APP_TITLE = "PW PAMIW Lab";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle(APP_TITLE);
        Views.APP_VIEW.loadScene(stage);
        stage.show();
    }

}