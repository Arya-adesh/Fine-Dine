package com.example.javafxlogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Scene3Controller implements Initializable {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private RadioButton dish1;

    @FXML
    private RadioButton dish2;

    @FXML
    private RadioButton dish3;

    @FXML
    private RadioButton dish4;

    @FXML
    private RadioButton dish5;
    @FXML
    private Button backbut;
    @FXML
    private ImageView s3img;
    Image i=new Image("C:\\Users\\6arya\\Downloads\\javafinal\\javafxlogin\\target\\wall5.jpg");
    void displayimage(){

        s3img.setImage(i);
    }
    public int l;
    @FXML
    private Button butlogout;
    ArrayList<String> ar=new ArrayList<>();
    void setarray(ArrayList<String>a){
        this.ar=a;
    }
    String st;
    public boolean flag;
    int count;
    @FXML
    private RadioButton but1;
    void setl()
    {
        this.l=0;
        this.flag=false;
        this.count=0;
    }
    @FXML
    private Label label;
    String user;
    @FXML
    String getuser(){
        return user;
    }
    @FXML
    void disp(String user){
        label.setText("Welcome "+user);
        this.user=user;
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
    void next(ActionEvent event) throws IOException{


        if(!this.flag) {
            this.l=this.l+1;
            this.flag= createbut(ar);
        }

    }

    /* public void get(){
         ToggleGroup tg = new ToggleGroup();
         dish1.setToggleGroup(tg);
         dish2.setToggleGroup(tg);
         dish3.setToggleGroup(tg);
         dish4.setToggleGroup(tg);
         dish5.setToggleGroup(tg);
         tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
         {


             public void changed(ObservableValue<? extends Toggle> ob,
                                 Toggle o, Toggle n)
             {

                 RadioButton rb = (RadioButton)tg.getSelectedToggle();

                 if (rb != null) {
                     String s = rb.getText();
                     this.st=s;
                     // change the label

                 }
                 this.st=null;
             }
         });
     }*/
    boolean createbut(ArrayList<String>a)
    {
        int c=0;
        if(this.l<=a.size()-1) dish1.setText(ar.get(this.l));
        else { dish1.setText("--"); c=c+1;}
        this.l=this.l+1;
        if(this.l<=a.size()-1) dish2.setText(ar.get(this.l));
        else { dish2.setText("--"); c=c+1;}
        this.l=this.l+1;

        if(this.l<=a.size()-1) dish3.setText(ar.get(this.l));
        else { dish3.setText("--"); c=c+1;}
        this.l=this.l+1;

        if(this.l<=a.size()-1) dish4.setText(ar.get(this.l));
        else { dish4.setText("--"); c=c+1;}
        this.l=this.l+1;
        if(this.l<=a.size()-1) dish5.setText(ar.get(this.l));
        else { dish5.setText("--"); c=c+1;}
        //this.l=this.l+1;
        return this.l==a.size()-1+c;
    }
    boolean reversecreatebut(ArrayList<String>a)
    {
        if(this.l>=0) dish5.setText(ar.get(this.l));
        this.l=this.l-1;
        if(this.l>=0) dish4.setText(ar.get(this.l));
        //else { dish2.setText("--"); flag= true;}
        this.l=this.l-1;

        if(this.l>=0) dish3.setText(ar.get(this.l));
        //else { dish3.setText("--"); flag=  true;}
        this.l=this.l-1;

        if(this.l>=0) dish2.setText(ar.get(this.l));
        //else { dish4.setText("--"); flag= true;}
        this.l=this.l-1;
        if(this.l>=0) dish1.setText(ar.get(this.l));
        //else { dish5.setText("--"); flag=  true;}
        this.l=this.l-1;
        return this.l != -1;

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        if(count==0){
            this.l=this.l-5;
            count=count+1;
        }
        if(this.flag){
            this.flag=reversecreatebut(ar);
        }else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
            root=fxmlLoader.load();
            Scene2Controller lg=fxmlLoader.getController();
            lg.disp(user);
            lg.displayimage();
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();}
    }
    String s;
    @FXML
    void details(ActionEvent event) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene4.fxml"));
        root=fxmlLoader.load();
        Scene4Controller lg=fxmlLoader.getController();
        lg.disp(user);
        lg.buttons(ar);
        if(dish1.isSelected())
            s=dish1.getText();
        else if(dish2.isSelected())
            s=dish2.getText();
        else if(dish3.isSelected())
            s=dish3.getText();
        else if(dish4.isSelected())
            s=dish4.getText();
        else
            s=dish5.getText();
        System.out.println(s);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
