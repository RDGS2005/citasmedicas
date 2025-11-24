package appointmentsApp.controllers.admin;

import appointmentsApp.controllers.citas.citasPendientesPacienteItemController;
import appointmentsApp.controllers.medicamentos.itemMedicamentosController;
import dataAccess.DAO.MedicoDAO;
import dataAccess.DTO.MedicamentoDTO;
import dataAccess.DTO.MedicoDTO;
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

public class menuMedicoMEController implements Initializable {

    @FXML
    private VBox contenedorMedicos;

    @FXML
    private Label lblTitulo;

    private void cargarMedicos() throws IOException {
        try{
            MedicoDAO mdao = new MedicoDAO();
            List<MedicoDTO> medicos = mdao.readAll();

            for(MedicoDTO m: medicos) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/item-medico.fxml"));
                Node item = loader.load();

                itemMedicoController controller = loader.getController();
                controller.addData(m);
                contenedorMedicos.getChildren().add(item);

                Separator separator = new Separator();
                contenedorMedicos.getChildren().add(separator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
