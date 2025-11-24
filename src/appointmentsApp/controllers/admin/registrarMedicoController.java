package appointmentsApp.controllers.admin;

import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.MedicoDAO;
import dataAccess.DTO.MedicoDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.List;

public class registrarMedicoController implements Initializable {
    private MedicoDAO dao;
    private boolean update = false;
    public void setDto(MedicoDTO dto)
    {
        fieldCedula.setText(dto.Cedula);
        especialidad.setValue(dto.Especializacion);
        fieldNombres.setText(dto.Nombres);
        fieldApellidos.setText(dto.Apellidos);
        if(dto.Sexo.equals("MASCULINO")) sexo.selectToggle(rbHombre); else sexo.selectToggle(rbMujer);
        fieldFechaNacimiento.setValue(dto.FechaNacimiento);
        fieldHoraInicio.setText(dto.InicioJornada.toString());
        fieldHoraFin.setText(dto.FinJornada.toString());
        update = true;
    }
    @FXML
    public Button botonRegistrarMedico;

    @FXML
    public ComboBox<String> especialidad;

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

    private static LocalTime parseTimeSafely(String input) {
        // Common time patterns
        String[] patterns = {
                "H:mm",      // 0-23 hour format
                "HH:mm",     // 00-23 hour format
                "h:mma",     // 1-12 hour format with AM/PM
                "hh:mma",    // 01-12 hour format with AM/PM
                "h a",       // e.g., 5 PM
                "hh a"       // e.g., 05 PM
        };

        for (String pattern : patterns) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
                return LocalTime.parse(input.toUpperCase(Locale.ENGLISH), formatter);
            } catch (DateTimeParseException ignored) {
                // Try next pattern
            }
        }
        return null; // No pattern matched
    }

    @FXML
    void registrarMedico(ActionEvent event) {
        RadioButton sexoSelect = (RadioButton) sexo.getSelectedToggle();

        if( fieldCedula.getText().isEmpty() ||
                especialidad.getValue().isEmpty() ||
                fieldPasswd.getText().isEmpty() ||
                fieldNombres.getText().isEmpty() ||
                fieldApellidos.getText().isEmpty() ||
                sexoSelect.getText().isEmpty() ||
                fieldFechaNacimiento.getValue() == null ||
                fieldHoraInicio.getText().isEmpty() ||
                fieldHoraFin.getText().isEmpty()
        ){
            Alert mensajeError = manageAlert.error("Datos Incompletos", "No se puede registrar con datos incompletos", "Agregue los datos faltantes y pruebe nuevamente");
            mensajeError.showAndWait();
        }
        else{
            MedicoDTO medico = new MedicoDTO(
                    fieldCedula.getText()
                    ,especialidad.getValue()
                    ,fieldNombres.getText()
                    ,fieldApellidos.getText()
                    ,sexoSelect.getText()
                    ,fieldFechaNacimiento.getValue()
                    ,parseTimeSafely(fieldHoraInicio.getText())
                    ,parseTimeSafely(fieldHoraFin.getText())
            );
            try{
                if(update) dao.update(medico, fieldPasswd.getText()); else dao.create(medico, fieldPasswd.getText());
            }catch(Exception e){
                Alert mensajeError = manageAlert.error("Datos Invalidos", "No se puede registrar con datos invalidos", "Existen errores en los datos suministrados");
                mensajeError.showAndWait();
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dao = new MedicoDAO();
        try{
            List<String> especialidades = dao.obtenerEspecialidades();
            especialidad.getItems().addAll(especialidades);
        }catch(Exception e)
        {
            Alert mensajeError = manageAlert.error("ERROR AL CARGAR DATOS", "ERROR AL CARGAR DATOS", "Intentelo de nuevo");
            mensajeError.showAndWait();
        }


    }
}
