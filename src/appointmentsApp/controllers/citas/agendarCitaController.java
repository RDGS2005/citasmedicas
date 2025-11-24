package appointmentsApp.controllers.citas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class agendarCitaController implements Initializable {

    @FXML
    public Button botonAgendarCita;

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
    void agendarCita(ActionEvent event) {

    }
    private String especialidades [] = {"nombre ESPE1", "nombre ESPE2"};
    private String doctores [] = {"nombre DOC1","nombre DOC2"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        especialidad.getItems().addAll(especialidades);
        doctor.getItems().addAll(doctores);
    }

    public Button getBotonAgendarCita() {
        return botonAgendarCita;
    }

    public ComboBox<String> getDoctor() {
        return doctor;
    }

    public ComboBox<String> getEspecialidad() {
        return especialidad;
    }

    public DatePicker getFecha() {
        return fecha;
    }

    public ToggleButton getHora1() {
        return hora1;
    }

    public ToggleButton getHora10() {
        return hora10;
    }

    public ToggleButton getHora11() {
        return hora11;
    }

    public ToggleButton getHora12() {
        return hora12;
    }

    public ToggleButton getHora13() {
        return hora13;
    }

    public ToggleButton getHora14() {
        return hora14;
    }

    public ToggleButton getHora15() {
        return hora15;
    }

    public ToggleButton getHora16() {
        return hora16;
    }

    public ToggleButton getHora17() {
        return hora17;
    }

    public ToggleButton getHora18() {
        return hora18;
    }

    public ToggleButton getHora19() {
        return hora19;
    }

    public ToggleButton getHora2() {
        return hora2;
    }

    public ToggleButton getHora20() {
        return hora20;
    }

    public ToggleButton getHora21() {
        return hora21;
    }

    public ToggleButton getHora22() {
        return hora22;
    }

    public ToggleButton getHora23() {
        return hora23;
    }

    public ToggleButton getHora24() {
        return hora24;
    }

    public ToggleButton getHora25() {
        return hora25;
    }

    public ToggleButton getHora26() {
        return hora26;
    }

    public ToggleButton getHora27() {
        return hora27;
    }

    public ToggleButton getHora3() {
        return hora3;
    }

    public ToggleButton getHora4() {
        return hora4;
    }

    public ToggleButton getHora5() {
        return hora5;
    }

    public ToggleButton getHora6() {
        return hora6;
    }

    public ToggleButton getHora7() {
        return hora7;
    }

    public ToggleButton getHora8() {
        return hora8;
    }

    public ToggleButton getHora9() {
        return hora9;
    }

    public ToggleGroup getHorario() {
        return horario;
    }


}
