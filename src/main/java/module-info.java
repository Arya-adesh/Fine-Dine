module com.example.javafxlogin {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires webcam.capture;
    requires java.desktop;
    requires tess4j;
    requires java.mail;
    opens com.example.javafxlogin to javafx.fxml;
    exports com.example.javafxlogin;
}