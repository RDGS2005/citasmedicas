package appointmentsApp.controllers.admin;

import appointmentsApp.controllers.generalController;
import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.MedicoDAO;
import dataAccess.DTO.MedicoDTO;
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

public class itemMedicoController {

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private VBox buttonBox;

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
    private Label lblIdResult;

    @FXML
    private Label lblNombre;

    @FXML
    void eliminarMedico(ActionEvent event) {
        Alert information = manageAlert.confirmation("Confirmacion","Eliminacion de Medico","Desea eliminar al medico seleccionado?");

        if(information.showAndWait().get()== ButtonType.OK){
            try{
                MedicoDAO mdao = new MedicoDAO();
                mdao.dardebaja(Integer.parseInt(lblIdMedico.getText()));
            } catch (Exception e) {
                Alert alert = manageAlert.information("Medico no fue eliminado", "Medico no valido", "El medico no pudo ser dado de baja");
                alert.showAndWait();
                e.printStackTrace();
            }
            Alert alert = manageAlert.information("Medico eliminado", "Exito en la eliminacion del medico", "El medico fue dado de baja del sistema");
            alert.showAndWait();
            infoBox.getChildren().clear();
            buttonBox.getChildren().clear();

        }

    }

    @FXML
    void modificarInformacionMedico(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/registrarMedico.fxml"));
        Parent root = loader.load();
        /*AQUI SE RECUPERA UN MEDICO Y SE ABRE LA OPCION DE CREAR PERFIL PERO QUE ESTARA LLENO DE LOS DATOS DE UN PERFIL EXISTENTE*/
        registrarMedicoController controller = (registrarMedicoController) loader.getController();
        controller.botonRegistrarMedico.setText("ACTUALIZAR INFORMACION EXISTENTE");
        controller.fieldNombres.setText("NOMBRE ANTIGUO");
        try{
            MedicoDAO mdao = new MedicoDAO();
            controller.setDto(mdao.readBy(Integer.parseInt(lblIdMedico.getText())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        generalController.openNewWindow(event,root,"Registrar Medico");

    }

    public void addData(MedicoDTO medico){
        lblIdMedico.setText(medico.Id.toString());
        lblNombre.setText(medico.Nombres);
        lblApellido.setText(medico.Apellidos);
        lblCedula.setText(medico.Cedula);
        lblIdResult.setText(medico.Especializacion);

    }

}
