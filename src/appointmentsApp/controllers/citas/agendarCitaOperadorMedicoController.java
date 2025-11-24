package appointmentsApp.controllers.citas;

import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.CitaDAO;
import dataAccess.DAO.MedicoDAO;
import dataAccess.DAO.PacienteDAO;
import dataAccess.DAO.TurnoDAO;
import dataAccess.DTO.CitaDTO;
import dataAccess.DTO.TurnoDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class agendarCitaOperadorMedicoController implements Initializable {
    MedicoDAO mdao;
    TurnoDAO tdao;
    CitaDAO cdao;
    PacienteDAO pdao;

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
    private Button botonAgendarCita;

    @FXML
    private Button botonValidarCedula;

    @FXML
    private TextField cedulaPaciente;

    @FXML
    private ComboBox<String> doctor;

    @FXML
    private ComboBox<String> especialidad;

    @FXML
    private DatePicker fecha;

    @FXML
    private ToggleButton hora1;

    @FXML
    private ToggleButton hora10;

    @FXML
    private ToggleButton hora11;

    @FXML
    private ToggleButton hora12;

    @FXML
    private ToggleButton hora13;

    @FXML
    private ToggleButton hora14;

    @FXML
    private ToggleButton hora15;

    @FXML
    private ToggleButton hora16;

    @FXML
    private ToggleButton hora17;

    @FXML
    private ToggleButton hora18;

    @FXML
    private ToggleButton hora19;

    @FXML
    private ToggleButton hora2;

    @FXML
    private ToggleButton hora20;

    @FXML
    private ToggleButton hora21;

    @FXML
    private ToggleButton hora22;

    @FXML
    private ToggleButton hora23;

    @FXML
    private ToggleButton hora24;

    @FXML
    private ToggleButton hora25;

    @FXML
    private ToggleButton hora26;

    @FXML
    private ToggleButton hora27;

    @FXML
    private ToggleButton hora3;

    @FXML
    private ToggleButton hora4;

    @FXML
    private ToggleButton hora5;

    @FXML
    private ToggleButton hora6;

    @FXML
    private ToggleButton hora7;

    @FXML
    private ToggleButton hora8;

    @FXML
    private ToggleButton hora9;

    @FXML
    private ToggleGroup horario;

    @FXML
    void botonAgendarCita(ActionEvent event) {
        String especialidadSeleccionada = especialidad.getValue();
        ToggleButton horaSelect = (ToggleButton) horario.getSelectedToggle();

        if (especialidadSeleccionada != null && !especialidadSeleccionada.isEmpty() && fecha.getValue() != null && horaSelect != null && !doctor.getValue().isEmpty()) {
            try {
                cdao.create(new CitaDTO(doctor_turno.get(doctor.getValue()), null, null, pdao.validar_cedula(cedulaPaciente.getText())));
                recargarComboBox();

            } catch (Exception e) {
                Alert mensajeError = manageAlert.error("ERROR", "Error al cargar doctores", e.getMessage());
                mensajeError.showAndWait();
            }
        }
    }

    @FXML
    void validarCedula(ActionEvent event) {
        try{
            if(pdao.validar_cedula(cedulaPaciente.getText()) != -1){
                botonAgendarCita.setDisable(false);
            }else{
                Alert mensajeError = manageAlert.error("CEDULA NO VALIDA", "CEDULA NO VALIDA", "Intentelo de nuevo");
                mensajeError.showAndWait();
            }
        }catch(Exception e){
            Alert mensajeError = manageAlert.error("CEDULA NO VALIDA", "CEDULA NO VALIDA", "Intentelo de nuevo");
            mensajeError.showAndWait();
        }

    }


    private Map<String, Integer> doctor_turno;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mdao = new MedicoDAO();
        tdao = new TurnoDAO();
        cdao = new CitaDAO();
        pdao = new PacienteDAO();
        try{
            especialidad.getItems().addAll(mdao.obtenerEspecialidades());
            especialidad.setOnAction(this::onEspecialidadSeleccionada);
            fecha.setOnAction(this::onEspecialidadSeleccionada);
            horario.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
                if (newToggle != null) {
                    recargarComboBox();
                }
            });
        }catch(Exception e){
            Alert mensajeError = manageAlert.error("ERROR AL CARGAR DATOS", "ERROR AL CARGAR DATOS", "Intentelo de nuevo");
            mensajeError.showAndWait();
        }
    }

    private void onEspecialidadSeleccionada(ActionEvent event) {
        recargarComboBox();
    }
    private void recargarComboBox()
    {
        String especialidadSeleccionada = especialidad.getValue();
        ToggleButton horaSelect = (ToggleButton) horario.getSelectedToggle();

        if (especialidadSeleccionada != null && !especialidadSeleccionada.isEmpty() && fecha.getValue() != null && horaSelect != null) {
            try {
                // Limpiar combo de doctores
                doctor.getItems().clear();
                doctor_turno = new HashMap<>();

                // Obtener doctores por especialidad
                List<TurnoDTO> disponibles = tdao.turnosDisponibles(especialidadSeleccionada, fecha.getValue(), parseTimeSafely(horaSelect.getText()));
                // Agregar nombres de doctores al combo
                for (TurnoDTO turno : disponibles) {
                    doctor_turno.put(turno.Nombre_medico, turno.Id);
                    doctor.getItems().add (turno.Nombre_medico);
                }

                // Habilitar combo de doctores
                doctor.setDisable(false);

            } catch (Exception e) {
                Alert mensajeError = manageAlert.error("ERROR", "Error al cargar doctores", e.getMessage());
                mensajeError.showAndWait();
            }
        }
    }


    public ToggleGroup getHorario() {
        return horario;
    }

    public ToggleButton getHora9() {
        return hora9;
    }

    public ToggleButton getHora8() {
        return hora8;
    }

    public ToggleButton getHora7() {
        return hora7;
    }

    public ToggleButton getHora6() {
        return hora6;
    }

    public ToggleButton getHora5() {
        return hora5;
    }

    public ToggleButton getHora4() {
        return hora4;
    }

    public ToggleButton getHora3() {
        return hora3;
    }

    public ToggleButton getHora27() {
        return hora27;
    }

    public ToggleButton getHora26() {
        return hora26;
    }

    public ToggleButton getHora25() {
        return hora25;
    }

    public ToggleButton getHora24() {
        return hora24;
    }

    public ToggleButton getHora23() {
        return hora23;
    }

    public ToggleButton getHora22() {
        return hora22;
    }

    public ToggleButton getHora21() {
        return hora21;
    }

    public ToggleButton getHora20() {
        return hora20;
    }

    public ToggleButton getHora2() {
        return hora2;
    }

    public ToggleButton getHora19() {
        return hora19;
    }

    public ToggleButton getHora18() {
        return hora18;
    }

    public ToggleButton getHora17() {
        return hora17;
    }

    public ToggleButton getHora16() {
        return hora16;
    }

    public ToggleButton getHora15() {
        return hora15;
    }

    public ToggleButton getHora14() {
        return hora14;
    }

    public ToggleButton getHora13() {
        return hora13;
    }

    public ToggleButton getHora12() {
        return hora12;
    }

    public ToggleButton getHora11() {
        return hora11;
    }

    public ToggleButton getHora10() {
        return hora10;
    }

    public ToggleButton getHora1() {
        return hora1;
    }

    public DatePicker getFecha() {
        return fecha;
    }

    public ComboBox<String> getEspecialidad() {
        return especialidad;
    }

    public ComboBox<String> getDoctor() {
        return doctor;
    }

    public TextField getCedulaPaciente() {
        return cedulaPaciente;
    }

    public Button getBotonValidarCedula() {
        return botonValidarCedula;
    }

    public Button getBotonAgendarCita() {
        return botonAgendarCita;
    }
}
