package appointmentsApp.controllers.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class registrarMedicoController {

    @FXML
    public Button botonRegistrarMedico;

    @FXML
    public ComboBox<?> especialidad;

    @FXML
    public TextField fieldApellidos;

    @FXML
    public TextField fieldCedula;

    @FXML
    public TextField fieldHoraFin;

    @FXML
    public TextField fieldHoraInicio;

    @FXML
    public TextField fieldNombres;

    @FXML
    public TextField fieldPasswd;

    @FXML
    public RadioButton rbHombre;

    @FXML
    public RadioButton rbMujer;

    @FXML
    public ToggleGroup sexo;

    @FXML
    public DatePicker fieldFechaNacimiento;

    @FXML
    void registrarMedico(ActionEvent event) {

    }

}
