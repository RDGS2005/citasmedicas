package appointmentsApp.controllers.medico;

import appointmentsApp.controllers.Cita;
import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.CitaDAO;
import dataAccess.DTO.CitaDTO;
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

public class diagnosticarPacienteMenuController implements Initializable {
    private CitaDAO cdao;
    private Integer idMedico;

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
        consultarCitas();
    }
    @FXML
    private VBox contenedorCitas;

    @FXML
    private Label lblTitulo;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cdao = new CitaDAO();
    }

    private void consultarCitas()
    {
        try{
            List<CitaDTO> citas = cdao.consultarCitasFaltantes(idMedico);
            cargarCitas(citas);

        } catch (Exception e) {
            Alert mensajeError = manageAlert.error("ERROR AL CARGAR DATOS", "ERROR AL CARGAR DATOS",
                    "Intentelo de nuevo. Error: " + e.getMessage());
            mensajeError.showAndWait();
            e.printStackTrace(); // Para debugging
        }
    }

    private void cargarCitas(List<CitaDTO> citas){
        contenedorCitas.getChildren().clear();
        for(CitaDTO c: citas){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/citas/item_cita4.fxml"));
                Node item = loader.load();
                informacionCitaDiagnosticoController controller = loader.getController();
                controller.setData(c);
                contenedorCitas.getChildren().add(item);

                Separator separator = new Separator();
                contenedorCitas.getChildren().add(separator);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
