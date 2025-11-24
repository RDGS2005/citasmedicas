package appointmentsApp.controllers;

import dataAccess.DAO.OperadorDAO;
import dataAccess.DTO.OperadorDTO;
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

public class operadorMenuController implements Initializable {
    private Integer idOperador;
    OperadorDAO mdao;
    fraseRandom fr;

    public void setId(Integer id) {
        this.idOperador = id;
        cargarDatosMedico();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        mdao = new OperadorDAO();
        fr = new fraseRandom();
    }

    private void cargarDatosMedico() {
        if (idOperador == null) {
            return; // No hacer nada si el ID no está establecido
        }

        try {
            OperadorDTO dto = mdao.readBy(idOperador);
            if (dto != null) {
                lblApellidos.setText(dto.Apellidos);
                lblCorreo.setText(dto.Correo);
                lblTelefono.setText(dto.Telefono);
                lblNombres.setText(dto.Nombres);
                lblFrase.setText(fraseRandom.frase());
            } else {
                Alert mensajeError = manageAlert.error("ERROR", "Medico no encontrado",
                        "No se pudo encontrar la información del medico con ID: " + idOperador);
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
    private Button botonRegistrarPacienteNuevo;

    @FXML
    private Label lblApellidos;

    @FXML
    private Label lblCorreo;

    @FXML
    private Label lblFrase;

    @FXML
    private Label lblNombres;

    @FXML
    private Label lblTelefono;

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
        generalController.changeScene(event,root);

    }

    @FXML
    void reagendarCancelarCita(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/citas/ReagendarEliminarCita.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event,root,"Reagendar o Cancelar Cita");
    }

    @FXML
    void registrarPacienteNuevo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/registrarPaciente.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event,root,"Registrar Paciente");

    }

}
