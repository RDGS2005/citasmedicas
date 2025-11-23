package appointmentsApp.controllers.citas;

import appointmentsApp.controllers.Cita;
import appointmentsApp.controllers.manageAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class citasPendientesPacienteItemController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnReagendar;

    @FXML
    private VBox infoBox;
    @FXML
    private VBox buttonBox;

    @FXML
    private Label lblDoctor;

    @FXML
    private Label lblEspecialidad;

    @FXML
    private Label lblFecha;

    @FXML
    private Label lblHora;

    @FXML
    private Label lblIdCita;

    @FXML
    void cancelarCita(ActionEvent event) {
        Alert information = manageAlert.confirmation("Confirmacion","Eliminacion de Cita","Desea eliminar la cita seleccionada?");

        if(information.showAndWait().get()== ButtonType.OK){
            Alert alert = manageAlert.information("Cita eliminada", "Exito en la cancelacion de la cita", "La cita fue eliminada del sistema, puede volver a agendar una cita en cualquuier momento");
            alert.showAndWait();
            infoBox.getChildren().clear();
            buttonBox.getChildren().clear();

        }

    }

    @FXML
    void reagendarCita(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/citas/agendarCita.fxml"));
        Parent root = loader.load();
        agendarCitaController controller = loader.getController();
        controller.botonAgendarCita.setText("Re Agendar Cita");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public void setData (Cita cita){
        lblIdCita.setText("ID Cita: " + cita.getIdCita());
        lblEspecialidad.setText("Especialidad: " + cita.getEspecialidad());
        lblDoctor.setText("Doctor: " + cita.getDoctor());
        lblFecha.setText("Fecha: " + cita.getFecha());
        lblHora.setText("Hora: " + cita.getHora());
    }


}






