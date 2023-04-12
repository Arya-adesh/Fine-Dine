package com.example.javafxlogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ImageController {
    Parent root;
    Stage stage;
    Scene scene;
    @FXML
    private Button backbut;

    @FXML
    private Button butlogout;

    @FXML
    private Button butnext;

    @FXML
    private ImageView imagemenu;

    @FXML
    private Label label;

    @FXML
    private ImageView s3img;

    Image i=new Image("C:\\Users\\Dell\\Downloads\\javafx-login-form-jdbc-tutorial-master\\javafxlogin\\target\\wall5.jpg");
    void displayimage(){

        s3img.setImage(i);
    }
    void displayimage(Image i){
        s3img.setImage(i);
    }
    int l,count;
    boolean flag;
    ArrayList<String> ar=new ArrayList<>();
    void setarray(ArrayList<String>a){
        this.ar=a;
        //displayimage(i);
    }
    void setl()
    {
        this.l=0;
        this.flag=false;
        this.count=0;
    }
    String user;
    //enter the url of that image which u scan
    void displayimagescan(String s){
        Image im=new Image(s);
        imagemenu.setImage(im);
    }
    @FXML
    void disp(String user){
        label.setText("Welcome "+user);
        this.user=user;
    }
    String getuser(){
        return user;
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        root=fxmlLoader.load();
        Scene2Controller lg=fxmlLoader.getController();
        lg.disp(user);
        lg.displayimage();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
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
    void next(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
        root=fxmlLoader.load();
        Scene3Controller lg=fxmlLoader.getController();
        lg.disp(user);
        lg.displayimage();
        lg.setl();
        lg.setarray(ar);
        lg.createbut(ar);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
