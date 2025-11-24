package appointmentsApp.controllers.admin;

import dataAccess.DTO.MedicoDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

public class item2MedicoController {

    @FXML
    private VBox infoBox;

    @FXML
    private Label lblApellido;

    @FXML
    private Label lblCedula;

    @FXML
    private Label lblEspecialidad;

    @FXML
    private Label lblIdMedico;

    @FXML
    private Label lblNombre;

    public void addData(MedicoDTO medico){
        lblIdMedico.setText(medico.Id.toString());
        lblNombre.setText(medico.Nombres);
        lblApellido.setText(medico.Apellidos);
        lblCedula.setText(medico.Cedula);
        lblEspecialidad.setText(medico.Especializacion);
    }

}

