package appointmentsApp;

import businessLogic.BLFactory;
import dataAccess.DAO.PacienteDAO;
import dataAccess.DTO.PacienteDTO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class AppIess extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/appointmentsApp/fxml/loginPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        BLFactory<PacienteDTO> pacienteBL = new BLFactory<>(PacienteDAO::new);
        try
        {
            List<PacienteDTO> pdtoList = pacienteBL.getAll();
            for (PacienteDTO pdto : pdtoList) {
                System.out.println(pdto.toString());
            }
        }catch(Exception e)
        {
            System.out.println("ERROR");
        }
    }
}
