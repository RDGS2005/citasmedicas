package dataAccess.DAO;

import dataAccess.DTO.CitaDTO;
import dataAccess.DTO.MedicamentoDTO;
import dataAccess.DTO.DiagnosticoDTO;
import dataAccess.IDAO;
import dataAccess.MySQLDataHelper;
import framework.ExceptionLogger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticoDAO extends MySQLDataHelper implements IDAO<DiagnosticoDTO>{

    @Override
    public DiagnosticoDTO readBy(Integer id) throws Exception {
        DiagnosticoDTO dto = new DiagnosticoDTO();
        return dto;
    }

    @Override
    public List<DiagnosticoDTO> readAll() throws Exception {
        DiagnosticoDTO dto;
        List<DiagnosticoDTO> lst = new ArrayList<>();
        return lst;
    }
    //AGREGAR DIAGNOSTICO
    public boolean create(DiagnosticoDTO entity) throws Exception {
        return true;
    }

    public boolean update(DiagnosticoDTO entity) throws Exception {
        return true;
    }

    public List<DiagnosticoDTO> consultarDiagnosticos(Integer id_paciente) throws Exception {
        return null;
    }
}
