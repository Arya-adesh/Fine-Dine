package com.example.javafxlogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoController {
    String user;
    Parent root;
    Stage stage;
    Scene scene;
    void disp(String user){
        label.setText("Welcome "+user);
        this.user=user;
    }
    String getuser(){
        return user;
    }

    @FXML
    private Button backbut;

    @FXML
    private Button butlogout;

    @FXML
    private Button butnext;

    @FXML
    private TextField cal;

    @FXML
    private CheckBox d;

    @FXML
    private CheckBox e;

    @FXML
    private CheckBox gl;

    @FXML
    private CheckBox gr;


    @FXML
    private RadioButton nv;

    @FXML
    private CheckBox p;

    @FXML
    private CheckBox sf;

    @FXML
    private CheckBox sh;

    @FXML
    private CheckBox soy;

    @FXML
    private CheckBox ss;

    @FXML
    private CheckBox sul;

    @FXML
    private CheckBox tn;

    @FXML
    private RadioButton veg;

    @FXML
    private CheckBox wh;

    @FXML
    private Label label;


    @FXML
    private ImageView infoimg;
    @FXML
    Image i=new Image("C:\\Users\\6arya\\Downloads\\javafinal\\javafxlogin\\target\\istockphoto-936991552-170667a.jpg");
    void displayimage(){

        infoimg.setImage(i);
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

        String calories= cal.getText();
        String s="";
        String st="";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
        root=fxmlLoader.load();
        Scene3Controller lg=fxmlLoader.getController();
        lg.disp(user);
        if(d.isSelected()) s=d.getText()+" ";
        else if(e.isSelected()) s=e.getText()+" ";
        else if(gl.isSelected()) s=gl.getText()+" ";
        else if(gr.isSelected()) s=gr.getText()+" ";
        else if(p.isSelected()) s=p.getText()+" ";
        else if(sf.isSelected()) s=sf.getText()+" ";
        else if(ss.isSelected()) s=ss.getText()+" ";
        else if(sf.isSelected()) s=sf.getText()+" ";
        else if(soy.isSelected()) s=soy.getText()+" ";
        else if(sul.isSelected()) s=sul.getText()+" ";
        else if(tn.isSelected()) s=tn.getText()+" ";
        else if(wh.isSelected()) s=wh.getText()+" ";
        String str[]=s.split(" ");
        if(veg.isSelected()&&!nv.isSelected()) st="veg"+" ";
        else if(nv.isSelected()&&veg.isSelected()) st="nonveg";
        else st="veg nonveg";
        /*if(intolerrences.equals("")||calories.equals("")||pref.equals("")||cuisine.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter the details");
            alert.show();
        }*/
        //else {

        //arya put the filtering code here
        lg.displayimage();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        //}




    }

}
