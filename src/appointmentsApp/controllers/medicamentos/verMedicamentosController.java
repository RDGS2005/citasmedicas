package appointmentsApp.controllers.medicamentos;

import appointmentsApp.controllers.Medicamento;
import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.MedicoDAO;
import dataAccess.DTO.MedicamentoDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class verMedicamentosController implements Initializable {

    @FXML
    private VBox contenedorMedicamentos;

    @FXML
    private Label lblTitulo;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MedicoDAO mdao = new MedicoDAO();
        try{
            List<MedicamentoDTO> lista = mdao.consultarMedicamentos();
            cargarMedicamentos(lista);
        } catch (Exception e) {
            Alert mensajeError = manageAlert.error("ERROR AL CARGAR DATOS", "ERROR AL CARGAR DATOS",
                    "Intentelo de nuevo. Error: " + e.getMessage());
            mensajeError.showAndWait();
            e.printStackTrace(); // Para debugging
        }
    }

    private void cargarMedicamentos(List<MedicamentoDTO> medicamentos){
        contenedorMedicamentos.getChildren().clear();
        for(MedicamentoDTO m:medicamentos){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/medicamentos/item-medicamento.fxml"));
                Node item = loader.load();

                itemMedicamentosController controller = loader.getController();
                controller.setData(m);
                contenedorMedicamentos.getChildren().add(item);

                Separator separator = new Separator();
                contenedorMedicamentos.getChildren().add(separator);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}





