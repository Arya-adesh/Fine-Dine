package com.example.javafxlogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ManualController {
    @FXML
    private Label label;
    String user;
    Parent root;
    Stage stage;
    Scene scene;
    @FXML
    private TextField tarea;
    void disp(String user){
        label.setText("Welcome ");
        this.user=user;
    }
    String getuser(){
        return user;
    }
    @FXML
    private ImageView manimg;
    @FXML
    Image i=new Image("C:\\Users\\6arya\\OneDrive\\Desktop\\javafxlogin\\target\\istockphoto-936991552-170667a.jpg");
    void displayimage(){

        manimg.setImage(i);
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
        String s= tarea.getText();
        if(s.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter the dishes");
            alert.show();
        }
        String[] str=s.split(" ");
        ArrayList<String>a=new ArrayList<>();
        for(int i=0;i<str.length;i++)
        {
            a.add(str[i]);
        }
        int n=a.size(),m;
        if(n%5==0)
            m=n/5;
        else
            m=n/5+1;
        lg.setl();
        lg.setarray(a);
       // lg.l=lg.l+1;
        lg.createbut(a);
        //lg.buttons(a);
        lg.displayimage();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        root=fxmlLoader.load();
        Scene2Controller lg=fxmlLoader.getController();
        lg.disp(getuser());
        lg.displayimage();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
