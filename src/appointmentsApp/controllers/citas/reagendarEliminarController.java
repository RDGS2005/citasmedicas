package appointmentsApp.controllers.citas;

import appointmentsApp.controllers.Cita;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class reagendarEliminarController implements Initializable {

    @FXML
    private VBox contenedorCitas;

    @FXML
    private Label lblTitulo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // EJEMPLO: cargar citas de prueba
        ArrayList<Cita> lista = new ArrayList<>();
        lista.add(new Cita(1, 101, "Cardiología", "Dr. López", "2025-12-10", "14:00"));
        lista.add(new Cita(2, 101, "Dermatología", "Dra. Pérez", "2025-12-12", "09:00"));
        lista.add(new Cita(3, 101, "Odontología", "Dr. García", "2025-12-15", "11:30"));

        cargarCitas(lista);

    }

    private void cargarCitas(ArrayList<Cita> citas){
        contenedorCitas.getChildren().clear();
        for(Cita c: citas){
            try{// AQUI SE DEBE VERIFICAR SI ESQUE ES PARA PACIENTE O PARA OPERADOR/MEDICO, EL QUE SE DESCRIBE ES PARA PACIENTE
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/citas/item_cita1.fxml"));
                Node item = loader.load();

                citasPendientesPacienteItemController controller = loader.getController();
                controller.setData(c);
                contenedorCitas.getChildren().add(item);

                Separator separator = new Separator();
                contenedorCitas.getChildren().add(separator);

                /*con la verificacion de si el usuario es operador o medico es lo mismo pero
                                    se carga el item de cita 5
                *                 FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/citas/item_cita5.fxml"));

                                    citasPendientesMedicoOperadorItemController controller = loader.getController();
                                    se carga el operador para medico y operador

                 * */

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
