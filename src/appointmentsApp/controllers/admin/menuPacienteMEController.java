package appointmentsApp.controllers.admin;

import dataAccess.DAO.PacienteDAO;
import dataAccess.DTO.MedicoDTO;
import dataAccess.DTO.PacienteDTO;
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

public class menuPacienteMEController implements Initializable {

    @FXML
    private VBox contenedorPacientes;

    @FXML
    private Label lblTitulo;

    private void cargarPacientes() throws IOException {
        try{
            PacienteDAO mdao = new PacienteDAO();
            List<PacienteDTO> pacientes = mdao.readAll();

            for(PacienteDTO p: pacientes) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/item-paciente.fxml"));
                Node item = loader.load();

                itemPacienteController controller = loader.getController();
                controller.addData(p);
                contenedorPacientes.getChildren().add(item);

                Separator separator = new Separator();
                contenedorPacientes.getChildren().add(separator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            cargarPacientes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
