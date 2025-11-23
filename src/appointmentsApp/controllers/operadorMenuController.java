package appointmentsApp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class operadorMenuController {

    @FXML
    private Button botonAgendarCita;

    @FXML
    private Button botonCRCita;

    @FXML
    private Button botonCerrarSesion;

    @FXML
    private Button botonRegistrarPacienteNuevo;

    @FXML
    private Label lblApellidos;

    @FXML
    private Label lblCorreo;

    @FXML
    private Label lblFrase;

    @FXML
    private Label lblNombres;

    @FXML
    private Label lblTelefono;

    @FXML
    void agendarCita(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/operadores/agendarCitaOperador.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event, root,"Agendar Cita");


    }

    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/loginPage.fxml"));
        Parent root = loader.load();
        generalController.changeScene(event,root);

    }

    @FXML
    void reagendarCancelarCita(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/citas/ReagendarEliminarCita.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event,root,"Reagendar o Cancelar Cita");
    }

    @FXML
    void registrarPacienteNuevo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/registrarPaciente.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event,root,"Registrar Paciente");

    }

}
