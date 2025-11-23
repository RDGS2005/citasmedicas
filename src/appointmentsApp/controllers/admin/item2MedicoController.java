package appointmentsApp.controllers.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

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

    public void addData(){
        lblIdMedico.setText("ID");
        lblNombre.setText("ERICK");
        lblApellido.setText("BAJAÑA");
        lblCedula.setText("CEDULA");

    }

}

