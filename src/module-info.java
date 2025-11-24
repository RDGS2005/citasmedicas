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
    opens appointmentsApp.controllers;
    opens appointmentsApp.users;
    opens appointmentsApp.controllers.paciente;
    opens appointmentsApp.controllers.medico;
    opens appointmentsApp.controllers.citas;
    opens appointmentsApp.controllers.medicamentos;
    opens appointmentsApp.controllers.admin;
}