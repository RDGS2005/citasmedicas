import java.util.List;

import businessLogic.BLFactory;
import dataAccess.DAO.PacienteDAO;
import dataAccess.DTO.PacienteDTO;

public class Main {
    public static void main(String[] args) {
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
