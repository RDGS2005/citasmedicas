package appointmentsApp.controllers.admin;

import dataAccess.DAO.OperadorDAO;
import dataAccess.DTO.OperadorDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class menuOperadorMEController implements Initializable {

    @FXML
    private VBox contenedorOperadores;

    @FXML
    private Label lblTitulo;

    private void cargarOperadores() throws IOException {
        try{
            OperadorDAO odao = new OperadorDAO();
            List<OperadorDTO> operadores = odao.readAll();

            for(OperadorDTO o: operadores) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/item-operador.fxml"));
                Node item = loader.load();

                itemOperadorController controller = loader.getController();
                controller.addData(o);
                contenedorOperadores.getChildren().add(item);

                Separator separator = new Separator();
                contenedorOperadores.getChildren().add(separator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            cargarOperadores();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
