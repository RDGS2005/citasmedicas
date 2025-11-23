package appointmentsApp.controllers.paciente;

import appointmentsApp.controllers.citas.agendarCitaController;
import appointmentsApp.controllers.generalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class patientMenuController {

    @FXML
    private Label afiliacion;

    @FXML
    private Label apellidos;

    @FXML
    private Button botonAgendarCita;

    @FXML
    private Button botonCRcita;

    @FXML
    private Button botonCerrarSesion;

    @FXML
    private Button botonConsultarHistorial;

    @FXML
    private Button botonVerDiagnosticos;

    @FXML
    private Label cedula;

    @FXML
    private Label correo;

    @FXML
    private Label fechaNacimiento;

    @FXML
    private Label fraseDia;

    @FXML
    private Label nombres;

    @FXML
    private Label telefono;

    @FXML
    void agendarCita(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/citas/agendarCita.fxml"));
        Parent root = loader.load();
        agendarCitaController controller = loader.getController();
        controller.botonAgendarCita.setText("Agendar Cita");
        generalController.openNewWindow(event, root,"Agendar Cita");


    }

    @FXML
    void cancelarReagendarCita(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/citas/ReagendarEliminarCita.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event,root,"Reagendar o Cancelar Cita" );

    }

    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/loginPage.fxml"));
        Parent root = loader.load();
        generalController.changeScene(event,root);

    }

    @FXML
    void consultarHistorial(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/paciente/verHistorialMedico.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event, root,"Ver Historial Medico");

    }

    @FXML
    void verDiagnosticos(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/paciente/verDiagnosticos.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event, root,"Ver Diagnosticos");

    }


}
