package com.example.javafxlogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class Scene1Controller implements Initializable {
    @FXML
    private Button button;

    @FXML
    private TextField password;
    @FXML
    private ImageView foodimage;
    @FXML
    private TextField username;

    @FXML
            private Label label;
    Image i=new Image("C:\\Users\\6arya\\OneDrive\\Desktop\\javafxlogin\\target\\water.jpg");
    void displayimage(){

        foodimage.setImage(i);
    }
    Stage stage;
Scene scene;
Parent root;
    @FXML
    void login(ActionEvent event) throws IOException {
        String user = username.getText();
        String pass = password.getText();
        if (user.equals("") || pass.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username or Password empty");
            alert.show();
        }
        else {
            String from=user;String password=pass;String to=user;String sub="Welcome to Foo-delicious ";String msg="Hi, welcome";
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            //get Session
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(from,password);
                        }
                    });
            //compose message
            try {
                MimeMessage message = new MimeMessage(session);
                message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
                message.setSubject(sub);
                message.setText(msg);

                Transport.send(message);
                System.out.println("message sent successfully");

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
                //fxmlLoader.setController(this);
                root=fxmlLoader.load();
                Scene2Controller lg=fxmlLoader.getController();
                lg.disp(user);
                lg.displayimage();
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Hello!");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            } catch (MessagingException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Invalid Username or Password");
                alert.show();
                throw new RuntimeException(e);
            }


        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}