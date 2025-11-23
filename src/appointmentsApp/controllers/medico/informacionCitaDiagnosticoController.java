package appointmentsApp.controllers.medico;

import appointmentsApp.controllers.Cita;
import appointmentsApp.controllers.generalController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class informacionCitaDiagnosticoController {

    @FXML
    private Button btnDiagnosticar;

    @FXML
    private VBox infoBox;

    @FXML
    private Label lblEspecialidad;

    @FXML
    private Label lblFecha;

    @FXML
    private Label lblHora;

    @FXML
    private Label lblIdCita;

    @FXML
    private Label lblIdPaciente;

    public void setData (Cita cita){
        lblIdCita.setText("ID Cita: " + cita.getIdCita());
        lblEspecialidad.setText("Especialidad: " + cita.getEspecialidad());
        lblIdPaciente.setText("ID Paciente: " + cita.getDoctor());
        lblFecha.setText("Fecha: " + cita.getFecha());
        lblHora.setText("Hora: " + cita.getHora());
    }


    @FXML
    public void diagnosticarCita(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/medico/diagnosticarCita.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event,root,"Diagnosticar Cita");

    }


}
