package appointmentsApp.controllers.paciente;

import appointmentsApp.controllers.citas.agendarCitaController;
import appointmentsApp.controllers.generalController;
import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.PacienteDAO;
import dataAccess.DTO.PacienteDTO;
import dataAccess.fraseRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class patientMenuController implements Initializable {
    private Integer idPaciente;
    PacienteDAO pdao;
    fraseRandom fr;

    public void setId(Integer id) {
        this.idPaciente = id;
        cargarDatosPaciente();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        pdao = new PacienteDAO();
        fr = new fraseRandom();
    }

    private void cargarDatosPaciente() {
        if (idPaciente == null) {
            return; // No hacer nada si el ID no está establecido
        }

        try {
            PacienteDTO dto = pdao.readBy(idPaciente);
            if (dto != null) {
                afiliacion.setText(dto.Afiliacion != null ? dto.Afiliacion : "No especificado");
                apellidos.setText(dto.Apellidos != null ? dto.Apellidos : "");
                cedula.setText(dto.Cedula != null ? dto.Cedula : "");
                correo.setText(dto.Correo != null ? dto.Correo : "");
                fechaNacimiento.setText(dto.FechaNacimiento != null ? dto.FechaNacimiento.toString() : "");
                nombres.setText(dto.Nombres != null ? dto.Nombres : "");
                telefono.setText(dto.Telefono != null ? dto.Telefono : "No especificado");
                fraseDia.setText(fraseRandom.frase());
            } else {
                Alert mensajeError = manageAlert.error("ERROR", "Paciente no encontrado",
                        "No se pudo encontrar la información del paciente con ID: " + idPaciente);
                mensajeError.showAndWait();
            }
        } catch (Exception e) {
            Alert mensajeError = manageAlert.error("ERROR AL CARGAR DATOS", "ERROR AL CARGAR DATOS",
                    "Intentelo de nuevo. Error: " + e.getMessage());
            mensajeError.showAndWait();
            e.printStackTrace(); // Para debugging
        }
    }

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
        controller.setIdPaciente(idPaciente);
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
        historialMedicoController controller = loader.getController();
        controller.setIdPaciente(idPaciente);
        generalController.openNewWindow(event, root,"Ver Historial Medico");

    }

    @FXML
    void verDiagnosticos(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/paciente/verDiagnosticos.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event, root,"Ver Diagnosticos");

    }


}
