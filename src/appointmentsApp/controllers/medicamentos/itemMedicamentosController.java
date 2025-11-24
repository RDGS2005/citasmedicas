package appointmentsApp.controllers.medicamentos;

import appointmentsApp.controllers.Medicamento;
import dataAccess.DTO.MedicamentoDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class itemMedicamentosController {

    @FXML
    private VBox infoBox;

    @FXML
    private Label lblDescripcion;

    @FXML
    private Label lblPrincipioActivo;

    public void setData(MedicamentoDTO medicamento){
        lblDescripcion.setText("Descripcion: " + medicamento.Nombre );
        lblPrincipioActivo.setText("Principio Activo: " + medicamento.PrincipioActivo);
    }

}
