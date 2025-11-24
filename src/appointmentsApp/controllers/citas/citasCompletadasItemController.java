package appointmentsApp.controllers.citas;

import appointmentsApp.controllers.Cita;
import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.DiagnosticoDAO;
import dataAccess.DAO.MedicoDAO;
import dataAccess.DAO.TurnoDAO;
import dataAccess.DTO.CitaDTO;
import dataAccess.DTO.DiagnosticoDTO;
import dataAccess.DTO.TratamientoDTO;
import dataAccess.DTO.TurnoDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import jdk.jshell.Diag;

import java.util.ArrayList;
import java.util.List;

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

    public void setData (CitaDTO cita){
        TurnoDAO tdao = new TurnoDAO();
        DiagnosticoDAO ddao = new DiagnosticoDAO();
        try{
            DiagnosticoDTO diagnostico = ddao.readByCita(cita.Id_turno);
            TurnoDTO turno = tdao.readBy(cita.Id_turno);

            lblIdCita.setText("ID Cita: " + cita.Id_cita);
            lblEspecialidad.setText("Especialidad: " + turno.Especialidad);
            lblDoctor.setText("Doctor: " + turno.Nombre_medico);
            lblFecha.setText("Fecha: " + turno.Fecha.toString());
            lblSintomas.setText("Sintomas: " + diagnostico.Sintomas);
            lblTratamiento.setText("Recomendaciones: " + diagnostico.Tratamiento);

        } catch (Exception e) {
            Alert mensajeError = manageAlert.error("ERROR AL CARGAR DATOS", "ERROR AL CARGAR DATOS",
                    "Intentelo de nuevo. Error: " + e.getMessage());
            mensajeError.showAndWait();
            e.printStackTrace(); // Para debugging
        }
    }

}
