package appointmentsApp.controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoginController {

    @FXML
    private Button login;

    @FXML
    private Label titulo;

    @FXML
    void login(ActionEvent event) {
         System.out.println("Login");
    }

}
