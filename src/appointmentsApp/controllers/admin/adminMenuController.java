package appointmentsApp.controllers.admin;

import appointmentsApp.controllers.generalController;
import dataAccess.DAO.MedicoDAO;
import dataAccess.fraseRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class adminMenuController implements Initializable {
    fraseRandom fr;
    @FXML
    private Label fraseDia;

    @FXML
    private Button botonCerrarSesion;

    @FXML
    private Button botonCrear;

    @FXML
    private Button botonModificarEliminar;


    @FXML
    private Button botonVerDoctores;

    @FXML
    private Button botonVerOperadores;

    @FXML
    private Button botonVerPacientes;

    @FXML
    private Label currentDate;

    @FXML
    private RadioButton rbDoctor;

    @FXML
    private RadioButton rbOperador;

    @FXML
    private RadioButton rbPaciente;

    @FXML
    private ToggleGroup rol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        fr = new fraseRandom();
        fraseDia.setText(fraseRandom.frase());
        currentDate.setText(LocalDate.now().toString());
    }

    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/loginPage.fxml"));
        Parent root = loader.load();
        generalController.changeScene(event, root);



    }

    @FXML
    void crearPerfil(ActionEvent event) throws IOException {
        if (rbDoctor.isSelected()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/registrarMedico.fxml"));
            Parent root = loader.load();
            generalController.openNewWindow(event,root,"Registrar Medico");
        }else if (rbOperador.isSelected()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/registrarOperador.fxml"));
            Parent root = loader.load();
            generalController.openNewWindow(event,root,"Registrar Operador");
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/registrarPaciente.fxml"));
            Parent root = loader.load();
            generalController.openNewWindow(event,root,"Registrar Operador");
        }

    }



    @FXML
    void habilitarBotones(ActionEvent event) {
        botonCrear.setDisable(false);
        botonModificarEliminar.setDisable(false);


    }

    @FXML
    void modificarEliminarPerfil(ActionEvent event) throws IOException {
        if (rbDoctor.isSelected()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/eliminarModificarMedicoMenu.fxml"));
            Parent root = loader.load();
            generalController.openNewWindow(event,root,"Modificar o Eliminar Medico");
        }else if (rbOperador.isSelected()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/eliminarModificarOperadorMenu.fxml"));
            Parent root = loader.load();
            generalController.openNewWindow(event,root,"Modificar o Eliminar Operador");
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/eliminarModificarPacienteMenu.fxml"));
            Parent root = loader.load();
            generalController.openNewWindow(event,root,"Modificar o Eliminar Paciente");
        }

    }

    @FXML
    void verDoctores(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/verDoctores.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event,root,"Todos los perfiles de Paciente");

    }

    @FXML
    void verOperadores(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/verOperadores.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event,root,"Todos los perfiles de Operador");
    }

    @FXML
    void verPacientes(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/appointmentsApp/fxml/admin/verPacientes.fxml"));
        Parent root = loader.load();
        generalController.openNewWindow(event,root,"Todos los perfiles de Paciente");

    }

}
