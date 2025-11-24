package appointmentsApp.controllers.admin;

import dataAccess.DTO.OperadorDTO;
import dataAccess.DTO.PacienteDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class item2PacienteController {

    @FXML
    private VBox infoBox;

    @FXML
    private Label lblApellidos;

    @FXML
    private Label lblCedula;

    @FXML
    private Label lblCorreo;

    @FXML
    private Label lblIdPaciente;

    @FXML
    private Label lblNombres;

    @FXML
    private Label lblTelefono;

    public void addData(PacienteDTO paciente){
        lblIdPaciente.setText(paciente.Id.toString());
        lblNombres.setText(paciente.Nombres);
        lblApellidos.setText(paciente.Apellidos);
        lblCedula.setText(paciente.Cedula);
        lblCorreo.setText(paciente.Correo);
        lblTelefono.setText(paciente.Telefono);
    }

}

