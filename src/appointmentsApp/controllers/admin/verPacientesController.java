package appointmentsApp.controllers.admin;

import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.OperadorDAO;
import dataAccess.DAO.PacienteDAO;
import dataAccess.DTO.OperadorDTO;
import dataAccess.DTO.PacienteDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class verPacientesController implements Initializable {
    PacienteDAO pdao;

    @FXML
    private VBox contenedorPacientes;

    @FXML
    private Label lblTitulo;

    private void cargarPacientes() throws IOException {
        try{
            List<PacienteDTO> pacientes = pdao.readAll();
            for(PacienteDTO m : pacientes)
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/item-paciente2.fxml"));
                Node item = loader.load();

                item2PacienteController controller = loader.getController();
                controller.addData(m);

                contenedorPacientes.getChildren().add(item);
                Separator separator = new Separator();
                contenedorPacientes.getChildren().add(separator);
            }


        } catch (Exception e) {
            Alert mensajeError = manageAlert.error("ERROR AL CARGAR DATOS", "ERROR AL CARGAR DATOS",
                    "Intentelo de nuevo. Error: " + e.getMessage());
            mensajeError.showAndWait();
            e.printStackTrace(); // Para debugging
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pdao = new PacienteDAO();
        try {
            cargarPacientes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
