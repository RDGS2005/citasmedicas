package appointmentsApp.controllers.medico;

import appointmentsApp.controllers.generalController;
import appointmentsApp.controllers.manageAlert;
import appointmentsApp.controllers.operadorMenuController;
import dataAccess.DAO.MedicoDAO;
import dataAccess.DAO.PacienteDAO;
import dataAccess.DTO.MedicoDTO;
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

public class doctorMenuController implements Initializable {
    private Integer idMedico;
    MedicoDAO mdao;
    fraseRandom fr;

    public void setId(Integer id) {
        this.idMedico = id;
        cargarDatosMedico();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        mdao = new MedicoDAO();
        fr = new fraseRandom();
    }

    private void cargarDatosMedico() {
        if (idMedico == null) {
            return; // No hacer nada si el ID no está establecido
        }

        try {
            MedicoDTO dto = mdao.readBy(idMedico);
            if (dto != null) {
                lblApellidos.setText(dto.Apellidos);
                lblCedula.setText(dto.Cedula);
                lblEspecializacion.setText(dto.Especializacion);
                lblFechaNacimiento.setText(dto.FechaNacimiento.toString());
                lblNombres.setText(dto.Nombres);
                lblFraseDia.setText(fraseRandom.frase());
            } else {
                Alert mensajeError = manageAlert.error("ERROR", "Medico no encontrado",
                        "No se pudo encontrar la información del medico con ID: " + idMedico);
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

       verPendientesController controller = loader.getController();
        controller.setId(idMedico);
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
