package appointmentsApp.controllers.citas;

import appointmentsApp.controllers.Cita;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class citasCompletadasItemController {

    @FXML
    private VBox infoBox;

    @FXML
    private Label lblSintomas;
    @FXML
    private Label lblMedicina;
    @FXML
    private Label lblTratamiento;

    @FXML
    private Label lblDoctor;

    @FXML
    private Label lblEspecialidad;

    @FXML
    private Label lblFecha;

    @FXML
    private Label lblIdCita;

    public void setData (Cita cita){
        lblIdCita.setText("ID Cita: " + cita.getIdCita());
        lblEspecialidad.setText("Especialidad: " + cita.getEspecialidad());
        lblDoctor.setText("Doctor: " + cita.getDoctor());
        lblFecha.setText("Fecha: " + cita.getFecha());
        lblSintomas.setText("Sintomas: " + cita.getHora());
        lblMedicina.setText("Medicina: " + cita.getHora());
        lblTratamiento.setText("Tratamiento: " + cita.getHora());
    }

}
