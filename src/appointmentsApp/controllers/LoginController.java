package appointmentsApp.controllers;

import appointmentsApp.users.Usuario;
import appointmentsApp.users.managerUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {


    @FXML
    private Button loginButton;

    @FXML
    private Label titulo;

    @FXML
    private TextField userLogin;

    @FXML
    private PasswordField userPassword;
    @FXML
    private AnchorPane loginWindow;

    @FXML
    private ComboBox<String> userRoles;

    @FXML
    void login(ActionEvent event) throws IOException {
        String login = userLogin.getText();
        String password = userPassword.getText();
        Usuario usuario = new Usuario("");



            switch (userRoles.getSelectionModel().getSelectedItem()) {
                case "PACIENTE":

                    usuario.setTipo("PACIENTE");

                    if(login.isEmpty() || password.isEmpty()){
                        Alert error = manageAlert.error("Error",null,"Todos los campos son obligatorios");
                        error.showAndWait();


                    }else{
                        //AQUI SE DEBE CARGAR LA INFORMACION DE TODAS LAS CEDULAS Y CONTRASEÑAS Y VERIFICAR QUE EXISTA

                        /*si usuario existe entonces verificar contraseña, si contraseña coincide, entonces entrar.
                        * si usuario no existe, emitir alerta de error. Si usuario existe pero contraseña incorrecta, emiitir mensaje de error
                        * en todos los escenarios el mensaje de error debe ser "CREDENCIAL INCORRECTAS O INEXISTENTES
                        *
                        * PARA EMITIR ERRORE DEDINIR UN OBJETO ALERT CON LA DEVOLUCION DEL METODO error de la clase manageAlert
                        * Alert mensajeError = manageAlert.error()
                        *


                        * */

                        Alert information = manageAlert.information("Ingreso Exitoso al sistema","Paciente", String.format("Bienvenido al Sistema IEES para citas medicas paciente %s",login));
                        information.showAndWait();
                        managerUsuario.setUser(usuario);
                        FXMLLoader loader = new FXMLLoader (getClass().getResource("/appointmentsApp/fxml/paciente/patientMenu.fxml"));
                        Parent root = loader.load();
                        generalController.changeScene(event,root);
                         // esta linea va si y solo si existe el usuario y la contraseña corresponde a ese usuario
                    }

                    break;
                case "MEDICO":
                    usuario.setTipo("MEDICO");
                    if(login.isEmpty() || password.isEmpty()){
                        Alert error = manageAlert.error("Error",null,"Todos los campos son obligatorios");
                        error.showAndWait();

                    }else{
                        //AQUI SE DEBE CARGAR LA INFORMACION DE TODAS LAS CEDULAS Y CONTRASEÑAS Y VERIFICAR QUE EXISTA

                        /*si usuario existe entonces verificar contraseña, si contraseña coincide, entonces entrar.
                         * si usuario no existe, emitir alerta de error. Si usuario existe pero contraseña incorrecta, emiitir mensaje de error
                         * en todos los escenarios el mensaje de error debe ser "CREDENCIAL INCORRECTAS O INEXISTENTES

                         * */
                        Alert information = manageAlert.information("Ingreso Exitoso al sistema","Doctor", String.format("Bienvenido al Sistema IEES para citas medicas doctor %s",login));
                        information.showAndWait();
                        managerUsuario.setUser(usuario);
                        FXMLLoader loader = new FXMLLoader (getClass().getResource("/appointmentsApp/fxml/medico/doctorMenu.fxml"));
                        Parent root = loader.load();
                        generalController.changeScene(event,root);

                    }
                    break;
                case "OPERADOR":
                    usuario.setTipo("OPERADOR");
                    if(login.isEmpty() || password.isEmpty()){
                        Alert error = manageAlert.error("Error",null,"Todos los campos son obligatorios");
                        error.showAndWait();

                    }else{
                        //AQUI SE DEBE CARGAR LA INFORMACION DE TODAS LAS CEDULAS Y CONTRASEÑAS Y VERIFICAR QUE EXISTA

                        /*si usuario existe entonces verificar contraseña, si contraseña coincide, entonces entrar.
                         * si usuario no existe, emitir alerta de error. Si usuario existe pero contraseña incorrecta, emiitir mensaje de error
                         * en todos los escenarios el mensaje de error debe ser "CREDENCIAL INCORRECTAS O INEXISTENTES

                         * */
                        Alert information = manageAlert.information("Ingreso Exitoso al sistema","OPERADOR", String.format("Bienvenido al Sistema IEES para citas medicas operador %s",login));
                        information.showAndWait();
                        managerUsuario.setUser(usuario);
                        // esta linea va si y solo si existe el usuario y la contraseña corresponde a ese usuario
                        FXMLLoader loader = new FXMLLoader (getClass().getResource("/appointmentsApp/fxml/operadores/operadorMenu.fxml"));
                        Parent root = loader.load();
                        generalController.changeScene(event,root);
                    }

                    break;
                case "ADMIN":
                    usuario.setTipo("ADMIN");
                    if(login.isEmpty() || password.isEmpty()){
                        Alert error = manageAlert.error("Error",null,"Todos los campos son obligatorios");
                        error.showAndWait();

                    }else{
                        //AQUI SE DEBE CARGAR LA INFORMACION DE TODAS LAS CEDULAS Y CONTRASEÑAS Y VERIFICAR QUE EXISTA

                        /*si usuario existe entonces verificar contraseña, si contraseña coincide, entonces entrar.
                         * si usuario no existe, emitir alerta de error. Si usuario existe pero contraseña incorrecta, emiitir mensaje de error
                         * en todos los escenarios el mensaje de error debe ser "CREDENCIAL INCORRECTAS O INEXISTENTES

                         * */
                        Alert information = manageAlert.information("Ingreso Exitoso al sistema","ADMIN", "INGRESO AL SISTEMA COMO ADMINISTRADOR");
                        information.showAndWait();
                        managerUsuario.setUser(usuario);
                        FXMLLoader loader = new FXMLLoader (getClass().getResource("/appointmentsApp/fxml/admin/adminMenu.fxml"));
                        Parent root = loader.load();
                        generalController.changeScene(event,root);

                    }
                    break;

            }



    }



    private String roles [] = {"PACIENTE", "MEDICO", "OPERADOR", "ADMIN"};



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        userRoles.getItems().addAll(roles);

        userLogin.setPromptText("LOGIN");
        userPassword.setPromptText("PASSWORD");
        userLogin.requestFocus();

    }


}


