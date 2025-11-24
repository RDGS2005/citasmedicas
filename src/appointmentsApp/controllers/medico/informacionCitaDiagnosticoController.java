package appointmentsApp.controllers.medico;

import appointmentsApp.controllers.Cita;
import appointmentsApp.controllers.generalController;
import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.MedicoDAO;
import dataAccess.DAO.PacienteDAO;
import dataAccess.DAO.TurnoDAO;
import dataAccess.DTO.CitaDTO;
import dataAccess.DTO.MedicoDTO;
import dataAccess.DTO.PacienteDTO;
import dataAccess.DTO.TurnoDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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

    public void setData (CitaDTO cita){
        TurnoDAO tdao = new TurnoDAO();
        PacienteDAO pdao = new PacienteDAO();
        MedicoDAO mdao = new MedicoDAO();
        try{
            TurnoDTO turno = tdao.readBy(cita.Id_turno);
            PacienteDTO paciente = pdao.readBy(cita.Id_paciente);
            MedicoDTO medico = mdao.readBy(turno.Id_medico);

            lblIdCita.setText("ID Cita: " + cita.Id_cita.toString());
            lblEspecialidad.setText("Especialidad: " + medico.Especializacion);
            lblIdPaciente.setText("Paciente: " + paciente.Nombres + " " + paciente.Apellidos);
            lblFecha.setText("Fecha: " + turno.Fecha.toString());
            lblHora.setText("Hora: " + turno.Hora.toString());

        } catch (Exception e) {
            Alert mensajeError = manageAlert.error("ERROR AL CARGAR DATOS", "ERROR AL CARGAR DATOS",
                    "Intentelo de nuevo. Error: " + e.getMessage());
            mensajeError.showAndWait();
            e.printStackTrace(); // Para debugging
        }

    }


    @FXML
    public void diagnosticarCita(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/medico/diagnosticarCita.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event,root,"Diagnosticar Cita");

    }


}
