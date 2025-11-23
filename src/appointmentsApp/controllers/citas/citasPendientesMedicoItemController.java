package appointmentsApp.controllers.citas;

import appointmentsApp.controllers.Cita;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class citasPendientesMedicoItemController {

    @FXML
    private VBox infoBox;

    @FXML
    private Label lblApellidosPaciente;

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

    @FXML
    private Label lblNombrePaciente;

    public void setData (Cita cita){
        lblIdCita.setText("ID Cita: " + cita.getIdCita());
        lblEspecialidad.setText("Especialidad: " + cita.getEspecialidad());
        lblIdPaciente.setText("ID Paciente: " + cita.getDoctor());
        lblNombrePaciente.setText("ID Paciente: " + cita.getDoctor());
        lblApellidosPaciente.setText("ID Paciente: " + cita.getDoctor());
        lblFecha.setText("Fecha: " + cita.getFecha());
        lblHora.setText("Hora: " + cita.getHora());
    }

}
