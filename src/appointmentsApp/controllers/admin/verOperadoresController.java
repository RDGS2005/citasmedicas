package appointmentsApp.controllers.admin;

import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.MedicoDAO;
import dataAccess.DAO.OperadorDAO;
import dataAccess.DTO.OperadorDTO;
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

public class verOperadoresController implements Initializable {
    OperadorDAO odao;

    @FXML
    private VBox contenedorOperadores;

    @FXML
    private Label lblTitulo;

    private void cargarOperadores() throws IOException {
        try{
            List<OperadorDTO> operadores = odao.readAll();
            for(OperadorDTO m : operadores)
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/item-operador2.fxml"));
                Node item = loader.load();

                item2OperadorController controller = loader.getController();
                controller.addData(m);

                contenedorOperadores.getChildren().add(item);
                Separator separator = new Separator();
                contenedorOperadores.getChildren().add(separator);
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
        odao = new OperadorDAO();
        try {
            cargarOperadores();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
