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
            List<DiagnosticoDTO> diagnosticos = new ArrayList<>();
            TurnoDTO turno = tdao.readBy(cita.Id_turno);
            int nDiagnostico = ddao.contarDiagnosticoPorCita(cita.Id_cita);
            if(nDiagnostico > 0)
            {
                diagnosticos = ddao.obtenerDiagnosticosPorCita(cita.Id_cita);
            }

            lblIdCita.setText("ID Cita: " + cita.Id_cita);
            lblEspecialidad.setText("Especialidad: " + turno.Especialidad);
            lblDoctor.setText("Doctor: " + turno.Nombre_medico);
            lblFecha.setText("Fecha: " + turno.Fecha.toString());

            StringBuilder sintomas = new StringBuilder();
            StringBuilder tratamientos = new StringBuilder();
            StringBuilder medicina = new StringBuilder();
            int contadorMedicina = 1;
            if(nDiagnostico > 0)
            {
                for(int i =0; i < diagnosticos.size(); i++)
                {
                    sintomas.append(i + ".-" + diagnosticos.get(i).Sintomas + '\n');
                    tratamientos.append(i + ".-" + diagnosticos.get(i).Tratamiento + '\n');
                    List<TratamientoDTO> trat = ddao.obtenerTratamientos(diagnosticos.get(i).Id);
                    for(int j = 0; j < trat.size(); i++)
                    {
                        medicina.append(contadorMedicina + ".-" + trat.get(j).toString());
                        contadorMedicina++;
                    }
                }

            }

            lblSintomas.setText("Sintomas: " + sintomas.toString());
            lblMedicina.setText("Medicina: " + medicina.toString());
            lblTratamiento.setText("Tratamiento: " + tratamientos.toString());
        } catch (Exception e) {
            Alert mensajeError = manageAlert.error("ERROR AL CARGAR DATOS", "ERROR AL CARGAR DATOS",
                    "Intentelo de nuevo. Error: " + e.getMessage());
            mensajeError.showAndWait();
            e.printStackTrace(); // Para debugging
        }
    }

}
