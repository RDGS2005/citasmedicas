package appointmentsApp.controllers.medico;

import appointmentsApp.controllers.generalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class doctorMenuController {

    @FXML
    private Button botonAgendarCita;

    @FXML
    private Button botonCRCita;

    @FXML
    private Button botonCerrarSesion;

    @FXML
    private Button botonCitasPendiente;

    @FXML
    private Button botonResultadoCita;

    @FXML
    private Button botonVerMedicamentos;

    @FXML
    private Label lblApellidos;

    @FXML
    private Label lblCedula;

    @FXML
    private Label lblEspecializacion;

    @FXML
    private Label lblFechaNacimiento;

    @FXML
    private Label lblFraseDia;

    @FXML
    private Label lblNombres;

    @FXML
    void registrarResultadoCita(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/medico/diagnosticarCitaMenu.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event, root,"Diagnosticar Cita");


    }

    @FXML
    void agendarCita(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/operadores/agendarCitaOperadorMedico.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event, root,"Agendar Cita");

    }

    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/loginPage.fxml"));
        Parent root = loader.load();
        generalController.changeScene(event, root);
    }

    @FXML
    void consultarCitasPendientes(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/medico/verCitasPendientes.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event, root,"Ver Citas Pendientes");
    }

    @FXML
    void reagendarCita(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/citas/ReagendarEliminarCita.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event, root,"Reagendar Cita");
    }
    @FXML
    void verMedicamentos(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/medicamentos/verMedicamentosDisponibles.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event, root,"Ver medicamentos Disponibles");



    }
}
