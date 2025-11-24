package appointmentsApp.controllers.admin;

import dataAccess.DTO.MedicoDTO;
import dataAccess.DTO.OperadorDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class item2OperadorController {

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private VBox buttonBox;

    @FXML
    private VBox infoBox;

    @FXML
    private Label lblApellidos;

    @FXML
    private Label lblCedula;

    @FXML
    private Label lblCorreo;

    @FXML
    private Label lblIdOperador;

    @FXML
    private Label lblNombres;

    @FXML
    private Label lblTelefono;

    public void addData(OperadorDTO operador){
        lblIdOperador.setText(operador.Id.toString());
        lblNombres.setText(operador.Nombres);
        lblApellidos.setText(operador.Apellidos);
        lblCedula.setText(operador.Cedula);
        lblCorreo.setText(operador.Correo);
        lblTelefono.setText(operador.Telefono);
    }

}
