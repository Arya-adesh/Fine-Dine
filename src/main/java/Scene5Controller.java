package com.example.javafxlogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Scene5Controller  {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private Button backbut;
    @FXML
    private ImageView s5img;
    Image i=new Image("C:\\Users\\6arya\\OneDrive\\Desktop\\javafxlogin\\target\\fruits-vegetables.jpg");
    void displayimage(){
        s5img.setImage(i);
    }
    @FXML
    private Button butlogout;
    String user;

    @FXML
    private Label label;

    @FXML
    private RadioButton saveaddr;

    @FXML
    private RadioButton saverec;
    @FXML
    String getuser(){
        return user;
    }
    @FXML
    void disp(String user){
        label.setText("Welcome ");
        this.user=user;
    }
    ArrayList<String>ar=new ArrayList<>();
    @FXML
    void address(ActionEvent event) {

    }
    void buttons(ArrayList<String> a){
        ar=a;
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene4.fxml"));
        root=fxmlLoader.load();
        Scene4Controller lg=fxmlLoader.getController();
        lg.disp(getuser());
        lg.buttons(ar);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
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
    void recipe(ActionEvent event) {

    }
}
