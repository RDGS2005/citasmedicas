package appointmentsApp.controllers.admin;

import appointmentsApp.controllers.manageAlert;
import dataAccess.DAO.OperadorDAO;
import dataAccess.DTO.MedicoDTO;
import dataAccess.DTO.OperadorDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class registrarOperadorController implements Initializable {
    OperadorDAO dao;
    private boolean update = false;
    public void setDto(OperadorDTO dto)
    {
        fieldCedula.setText(dto.Cedula);
        fieldNombres.setText(dto.Nombres);
        fieldApellidos.setText(dto.Apellidos);
        fieldTelefono.setText(dto.Telefono);
        fieldCorreo.setText(dto.Correo);
        update = true;
    }
    @FXML
    public Button botonRegistrarOperador;

    @FXML
    public TextField fieldApellidos;

    @FXML
    public TextField fieldCedula;

    @FXML
    public TextField fieldCorreo;

    @FXML
    public TextField fieldNombres;

    @FXML
    public TextField fieldPasswd;

    @FXML
    public TextField fieldTelefono;

    @FXML
    void registrarOperador(ActionEvent event) {

        if(     fieldCedula.getText().isEmpty() ||
                fieldPasswd.getText().isEmpty() ||
                fieldNombres.getText().isEmpty() ||
                fieldApellidos.getText().isEmpty() ||
                fieldTelefono.getText().isEmpty() ||
                fieldCorreo.getText().isEmpty()
        ){
            Alert mensajeError = manageAlert.error("Datos Incompletos", "No se puede registrar con datos incompletos", "Agregue los datos faltantes y pruebe nuevamente");
            mensajeError.showAndWait();
        }
        else{
            OperadorDTO operador = new OperadorDTO(
                    fieldCedula.getText()
                    ,fieldNombres.getText()
                    ,fieldApellidos.getText()
                    ,fieldTelefono.getText()
                    ,fieldCorreo.getText()
            );
            try{
                if(update) dao.update(operador, fieldPasswd.getText()); else dao.create(operador, fieldPasswd.getText());
                dao.create(operador, fieldPasswd.getText());
            }catch(Exception e){
                Alert mensajeError = manageAlert.error("Datos Invalidos", "No se puede registrar con datos invalidos", "Existen errores en los datos suministrados");
                mensajeError.showAndWait();
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dao = new OperadorDAO();
    }
}
