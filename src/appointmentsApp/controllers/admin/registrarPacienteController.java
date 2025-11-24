package appointmentsApp.controllers.admin;

import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.PacienteDAO;
import dataAccess.DTO.PacienteDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class registrarPacienteController implements Initializable {
    private String opcionesAfiliacion [] = {"SEGURO GENERAL", "SEGURO CAMPESINO", "SEGURO VOLUNTARIO"};
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
        RadioButton sexoSelect = (RadioButton) sexo.getSelectedToggle();

        if( fieldCedula.getText().isEmpty() ||
            fieldPasswd.getText().isEmpty() ||
            fieldNombres.getText().isEmpty() ||
            fieldApellidos.getText().isEmpty() ||
            sexoSelect.getText().isEmpty() ||
            fieldFechaNacimiento.getValue() == null ||
            fieldDireccion.getText().isEmpty() ||
            fielNacionalidad.getText().isEmpty() ||
            fieldTelefono.getText().isEmpty() ||
            fieldCorreo.getText().isEmpty() ||
            afiliacion.getValue().isEmpty()
            ){
            Alert mensajeError = manageAlert.error("Datos Incompletos", "No se puede registrar con datos incompletos", "Agregue los datos faltantes y pruebe nuevamente");
            mensajeError.showAndWait();
        }
        else{
            PacienteDAO dao = new PacienteDAO();


            PacienteDTO paciente = new PacienteDTO(
                    fieldCedula.getText()
                    ,fieldNombres.getText()
                    ,fieldApellidos.getText()
                    ,sexoSelect.getText()
                    ,fieldFechaNacimiento.getValue()
                    ,fieldDireccion.getText()
                    ,fielNacionalidad.getText()
                    ,fieldTelefono.getText()
                    ,fieldCorreo.getText()
                    ,afiliacion.getValue()
            );
            try{
                dao.create(paciente, fieldPasswd.getText());
            }catch(Exception e){
                Alert mensajeError = manageAlert.error("Datos Invalidos", "No se puede registrar con datos invalidos", "Existen errores en los datos suministrados");
                mensajeError.showAndWait();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        afiliacion.getItems().addAll(opcionesAfiliacion);

    }

}
