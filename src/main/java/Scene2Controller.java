package com.example.javafxlogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

interface userpass{
    String get();
}

public class Scene2Controller implements Initializable,userpass {

    private Stage stage;
    Scene scene;
    Parent root;
    @FXML
    RadioButton camera;
    @FXML
    RadioButton text;
    @FXML
    private Label label;
    String user;
    @FXML
    private ImageView water2;
    @FXML
    void disp(String user){
        label.setText("Welcome "+user);
        this.user=user;
    }
    String gettheuser(){
        return user;
    }
    Image i=new Image("C:\\Users\\6arya\\OneDrive\\Desktop\\java_done\\javafxlogin\\target\\water2.jpg");
    void displayimage(){

        water2.setImage(i);
    }
    @FXML
    void logout(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
        root=fxmlLoader.load();
        Scene1Controller s=fxmlLoader.getController();
        s.displayimage();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void cameraswitch(ActionEvent event) throws IOException {
        //arya add the camera code over here
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Image.fxml"));
        root=fxmlLoader.load();
        ImageController t=fxmlLoader.getController();
        t.disp(getuser.get());
        t.displayimage();
        //t.displayimagescan();add the camera image path or url
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void webswitch(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Web.fxml"));
        root=fxmlLoader.load();
        WebController t=fxmlLoader.getController();
        t.disp(getuser.get());
        t.displayimage();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void manswitch(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manual.fxml"));
        root=fxmlLoader.load();
        ManualController t=fxmlLoader.getController();
        t.disp(getuser.get());
        t.displayimage();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void textswitch(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Info.fxml"));
        root=fxmlLoader.load();
        InfoController t=fxmlLoader.getController();
        t.disp(getuser.get());
        t.displayimage();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    userpass getuser=()-> user;

    @Override
    public String get() {

        return null;
    }
}
