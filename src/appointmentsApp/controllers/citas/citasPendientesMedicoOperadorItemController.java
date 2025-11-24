
package appointmentsApp.controllers.citas;

import appointmentsApp.controllers.Cita;
import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.DiagnosticoDAO;
import dataAccess.DAO.PacienteDAO;
import dataAccess.DAO.TurnoDAO;
import dataAccess.DTO.CitaDTO;
import dataAccess.DTO.PacienteDTO;
import dataAccess.DTO.TratamientoDTO;
import dataAccess.DTO.TurnoDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class citasPendientesMedicoOperadorItemController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnReagendar;

    @FXML
    private VBox buttonBox;

    @FXML
    private VBox infoBox;

    @FXML
    private Label lblApellidoPaciente;

    @FXML
    private Label lblDoctor;

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

    @FXML
    void cancelarCita(ActionEvent event) {

    }

    @FXML
    void reagendarCita(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/citas/agendarCita.fxml"));
        Parent root = loader.load();
        //PRIMERO ELIMINO LAS OPCIONES QUE ESTEN
        agendarCitaOperadorMedicoController controller = loader.getController();
        controller.getDoctor().getItems().clear();
        controller.getEspecialidad().getItems().clear();
        /*REALIZAO LA CONSULTA Y COMPARO*/

        //Integer.parseInt(lblIdCita.getText());
        //LUEGO, PONGO LA ESPECIALIDAD Y EL MEDICO DE ESA CITA EN PARTICULAR

        controller.getDoctor().getItems().add("DOCTOR DE LA CITA");
        controller.getEspecialidad().getItems().add("ESPECIALIDAD DE LA CITA");

        // MARCO COMO SELECCIONADA ESA OPCION Y BLOQUEO EL ELEMENTO

        controller.getDoctor().getSelectionModel().select("DOCTOR DE LA CITA");
        controller.getEspecialidad().getSelectionModel().select("ESPECIALIDAD DE LA CITA");

        controller.getDoctor().setDisable(true);
        controller.getEspecialidad().setDisable(true);

        //REEMPLZAR DOCTOR DE LA CITA POR EL NOMBRE DEL DOCTOR Y ESPECIALIDAD POR LA ESPECILIDA CARGADA DE LA BASE DE DATOS

        controller.getBotonAgendarCita().setText("Re Agendar Cita");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }


    public void setData (CitaDTO cita){
        TurnoDAO tdao = new TurnoDAO();
        PacienteDAO pdao = new PacienteDAO();
        try{
            TurnoDTO turno = tdao.readBy(cita.Id_turno);
            PacienteDTO paciente = pdao.readBy(cita.Id_paciente);

            lblIdCita.setText("ID Cita: " + cita.Id_cita);
            lblIdPaciente.setText(Integer.toString(cita.Id_paciente));
            lblNombrePaciente.setText("Nombre Paciente: " + paciente.Nombres);
            lblApellidoPaciente.setText("Apellido Paciente: " + paciente.Apellidos);
            lblEspecialidad.setText("Especialidad: " + turno.Especialidad);
            lblDoctor.setText("Doctor: " + turno.Nombre_medico);
            lblFecha.setText("Fecha: " + turno.Fecha.toString());
            lblHora.setText("Hora: " + turno.Hora.toString());

        } catch (Exception e) {
            Alert mensajeError = manageAlert.error("ERROR AL CARGAR DATOS", "ERROR AL CARGAR DATOS",
                    "Intentelo de nuevo. Error: " + e.getMessage());
            mensajeError.showAndWait();
            e.printStackTrace(); // Para debugging
        }
    }

}

