package appointmentsApp.controllers.admin;

import appointmentsApp.controllers.generalController;
import appointmentsApp.controllers.manageAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class itemPacienteController {

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
    private Label lblIdPaciente;

    @FXML
    private Label lblIdResult;

    @FXML
    private Label lblNombres;

    @FXML
    private Label lblTelefono;

    @FXML
    void eliminarPaciente(ActionEvent event) {
        Alert information = manageAlert.confirmation("Confirmacion","Eliminacion de Paciente","Desea eliminar al paciente seleccionado?");

        if(information.showAndWait().get()== ButtonType.OK){
            Alert alert = manageAlert.information("Paciente eliminado", "Exito en la eliminacion del paciente", "El paciente fue dado de baja del sistema. Puede agregarlo de nuevo en cualquier momento");
            alert.showAndWait();
            infoBox.getChildren().clear();
            buttonBox.getChildren().clear();

        }

    }

    @FXML
    void modificarInformacionPaciente(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/registrarPaciente.fxml"));
        Parent root = loader.load();
        /*AQUI SE RECUPERA UN MEDICO Y SE ABRE LA OPCION DE CREAR PERFIL PERO QUE ESTARA LLENO DE LOS DATOS DE UN PERFIL EXISTENTE*/
        registrarPacienteController controller = loader.getController();
        controller.botonRegistrarPaciente.setText("ACTUALIZAR INFORMACION EXISTENTE");
        controller.fieldNombres.setText("NOMBRE ANTIGUO");
        generalController.openNewWindow(event,root,"Modificar Informacion de un Operador");


    }
    public void addData(){
        lblIdPaciente.setText("ID");
        lblNombres.setText("ERICK");
        lblApellidos.setText("BAJAÑA");
        lblCedula.setText("CEDULA");
        lblCorreo.setText("CORREO");
        lblIdResult.setText("ID");

    }

}
