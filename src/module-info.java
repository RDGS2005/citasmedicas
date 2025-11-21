module citasmedicas {
    requires java.desktop;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;
    requires javafx.swing;
    requires java.sql;

    opens appointmentsApp;
    opens appointmentsApp.controlers;
}