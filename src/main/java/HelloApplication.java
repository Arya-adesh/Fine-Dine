package com.example.javafxlogin;
///////////////////Remember that webcam controller is not extended , still added for report purpose
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Scene1.fxml"));
        Parent root=fxmlLoader.load();
        Scene1Controller s=fxmlLoader.getController();
        s.displayimage();

        stage.setTitle("Welcome to Ease-to-Dine!");
        stage.setResizable(false);
        //BackgroundImage bi=new BackgroundImage(new Image("C:\Users\Dell\Downloads\javafx-login-form-jdbc-tutorial-master\javafxlogin\\target\watermark.jpg"));
        /*stage.setResizable(true);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Press esc to escape");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("esc"));*/
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}