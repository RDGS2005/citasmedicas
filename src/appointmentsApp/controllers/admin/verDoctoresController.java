package appointmentsApp.controllers.admin;

import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.MedicoDAO;
import dataAccess.DTO.MedicoDTO;
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

public class verDoctoresController implements Initializable {
    MedicoDAO mdao;

    @FXML
    private VBox contenedorMedicos;

    @FXML
    private Label lblTitulo;

    private void cargarMedicos() throws IOException {
        try{
            List<MedicoDTO> medicos = mdao.readAll();
            for(MedicoDTO m : medicos)
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/item-medico2.fxml"));
                Node item = loader.load();

                item2MedicoController controller = loader.getController();
                controller.addData(m);

                contenedorMedicos.getChildren().add(item);
                Separator separator = new Separator();
                contenedorMedicos.getChildren().add(separator);
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
        mdao = new MedicoDAO();
        try {
            cargarMedicos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}