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
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class WebController extends Scene2Controller{
    ArrayList<String> food= new ArrayList<>();
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private Label label;
    String user;
    @FXML
    private TextField url;
    @FXML
    private ImageView webimg;
    @FXML
    Image i=new Image("C:\\Users\\6arya\\OneDrive\\Desktop\\javafxlogin\\target\\istockphoto-936991552-170667a.jpg");
    void displayimage(){

        webimg.setImage(i);
    }
    @FXML
    void disp(String user){
        label.setText("Welcome ");
        this.user=user;
    }
    String getuser(){
        return user;
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
    void next(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
        root=fxmlLoader.load();
        Scene3Controller lg=fxmlLoader.getController();
        lg.disp(user);
        String geturl=url.getText();
        if(geturl.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter the url");
            alert.show();
        }
        else{
            try{
                String fileName = "down_image.jpg";
                System.out.println("Downloading File From: " + geturl);

                URL url = new URL(geturl);
                InputStream inputStream = url.openStream();
                OutputStream outputStream = new FileOutputStream(fileName);
                byte[] buffer = new byte[2048];

                int length = 0;

                while ((length = inputStream.read(buffer)) != -1) {
                    System.out.println("Buffer Read of length: " + length);
                    outputStream.write(buffer, 0, length);
                }

                inputStream.close();
                outputStream.close();

                Tesseract tesseract = new Tesseract();
                try {
                    tesseract.setDatapath("C:\\Users\\6arya\\OneDrive\\Desktop\\JAVA DEPEND\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
                    // the path of your tess data folder
                    // inside the extracted file
                    String text = tesseract.doOCR(new File("down_image.jpg"));
                    // path of your image file
                    System.out.print(text);

                    String[] food_items = text.split("\\r?\\n");
                    for (int i = 0; i < food_items.length; i++) {
                        System.out.println(food_items[i]);
                        food_items[i] = food_items[i].replaceAll("[^a-zA-Z ]", " ");

                        food_items[i] = food_items[i].toLowerCase();

                        food_items[i] = food_items[i].trim().replaceAll(" +", " ");
                        if(food_items[i].compareTo("")!=0)
                        food.add(food_items[i]);
                        System.out.println(food_items[i]);
                    }

                }
                catch (TesseractException e) {
                    e.printStackTrace();
                }

            } catch(Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }



            lg.setarray(food);
            lg.createbut(food);
            lg.setl();
            lg.displayimage();
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }

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
}
