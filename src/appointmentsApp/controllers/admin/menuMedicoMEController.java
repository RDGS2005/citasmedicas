package appointmentsApp.controllers.admin;

import appointmentsApp.controllers.citas.citasPendientesPacienteItemController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class menuMedicoMEController implements Initializable {

    @FXML
    private VBox contenedorMedicos;

    @FXML
    private Label lblTitulo;

    private void cargarMedicos() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/item-medico.fxml"));
        Node item = loader.load();

        itemMedicoController controller = loader.getController();
        controller.addData();
        contenedorMedicos.getChildren().add(item);

        Separator separator = new Separator();
        contenedorMedicos.getChildren().add(separator);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            cargarMedicos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
