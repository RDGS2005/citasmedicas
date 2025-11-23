package appointmentsApp.controllers.admin;

import appointmentsApp.controllers.manageAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class registrarPacienteController {

    @FXML
    public ComboBox<String> afiliacion;

    @FXML
    public Button botonRegistrarPaciente;

    @FXML
    public TextField fielNacionalidad;

    @FXML
    public TextField fieldApellidos;

    @FXML
    public TextField fieldCedula;

    @FXML
    public TextField fieldCorreo;

    @FXML
    public TextField fieldDireccion;

    @FXML
    public DatePicker fieldFechaNacimiento;

    @FXML
    public TextField fieldNombres;

    @FXML
    public TextField fieldPasswd;

    @FXML
    public TextField fieldTelefono;

    @FXML
    public ToggleGroup sexo;

    @FXML
    void registrarPaciente(ActionEvent event) {
        //AQUI SE HACE EL INSERT INTO
        //manageAlert.error("error","EEROR AL INGRESAR","LOS DATOS SON INCORRECTOS")

    }

}
