package com.example.javafxlogin;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Scene4Controller implements Initializable {

    Stage stage;

    @FXML
    private ImageView foodimg;
    @FXML
    private ScrollPane scrp;
    Scene scene;
    Parent root;
    String user;
    ArrayList <String> ar=new ArrayList<>();
    @FXML
    private ListView<String> mylist;
    @FXML
    Label label;
    @FXML
    String getuser(){
        return user;
    }
    @FXML
    void disp(String user){
        label.setText("Welcome "+user);
        this.user=user;
    }
    void buttons(ArrayList<String>a){
        ar=a;
    }
    @FXML
    private Label item;
    @FXML
    private Label det;
    @FXML
    void logout(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
        root=fxmlLoader.load();

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void next(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene5.fxml"));
        root=fxmlLoader.load();
        Scene5Controller lg=fxmlLoader.getController();
        lg.disp(user);
        lg.buttons(ar);
        lg.displayimage();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void back(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
        root=fxmlLoader.load();
        Scene3Controller lg=fxmlLoader.getController();
        lg.disp(getuser());
        //lg.buttons(ar);
        lg.setl();
        lg.setarray(ar);
        lg.createbut(ar);
        lg.displayimage();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    String cursel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] dett={"Cuisine","Intolerance","Ingredients","Process","Link for Recipe"};
        HashMap<String,String> hm=new HashMap<>();
        item.setText("Name: Croissant");
        hm.put("Cuisine","French");
        hm.put("Intolerance","Gluten");
        hm.put("Ingredients","Flour :400 gms\n" +
                "Milk:260 ml\n" +
                "Butter:180-200 gms\n" +
                "Sugar 4 Tbsp/60 gms\n" +
                "Salt :1/4 Tsp\n" +
                "Active Dry Yeast:1 Tsp\n" +
                "For egg wash:Beat 1 egg+1 tsp milk");
        hm.put("Process","make easy dough from butter, flour, sugar, salt, yeast, and milk\n" +
                "roll out dough into a large rectangle\n" +
                "make the butter layer (I have an easy trick for this!!!)\n" +
                "enclose the butter layer inside the dough\n" +
                "roll out the dough into another large rectangle, then fold it back together\n" +
                "roll out the dough again, fold it back together again\n" +
                "roll out the dough one more time, fold it back together\n" +
                "shape the croissants\n"+"bake at 200 degree C for 30 mins");
        hm.put("Link for Recipe","https://www.allrecipes.com/recipe/6916/croissants/");

        mylist.getItems().addAll(dett);
        Image ii=new Image("C:\\Users\\Dell\\OneDrive\\Desktop\\OOPS\\croissant.jpeg");
        foodimg.setImage(ii);
        mylist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                cursel=mylist.getSelectionModel().getSelectedItem();
                det.setText(cursel+":\n"+hm.get(cursel));



            }
        });
    }
}
