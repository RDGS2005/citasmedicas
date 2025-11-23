package appointmentsApp.controllers.medicamentos;

import appointmentsApp.controllers.Medicamento;
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

public class verMedicamentosController implements Initializable {

    @FXML
    private VBox contenedorMedicamentos;

    @FXML
    private Label lblTitulo;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // EJEMPLO: cargar citas de prueba
        ArrayList<Medicamento> lista = new ArrayList<>();
        lista.add(new Medicamento("Buprex forte Jarabe","Ibuprofeno 450 mg"));
        lista.add(new Medicamento("Singripal Sobre","Paracetamol + Pseudorefrina + Loratadina"));
        lista.add(new Medicamento("Un medicamento","Una descripcion"));


        cargarCitas(lista);

    }

    private void cargarCitas(ArrayList<Medicamento> medicamentos){
        contenedorMedicamentos.getChildren().clear();
        for(Medicamento m:medicamentos){
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





