package dataAccess.DAO;

import dataAccess.DTO.CitaDTO;
import dataAccess.DTO.MedicamentoDTO;
import dataAccess.DTO.CitaDTO;
import dataAccess.IDAO;
import dataAccess.MySQLDataHelper;
import framework.ExceptionLogger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO extends MySQLDataHelper implements IDAO<CitaDTO>{

    @Override
    public CitaDTO readBy(Integer id) throws Exception{
        CitaDTO dto = new CitaDTO();
        return dto;
    }
    //CONSULTAR TODAS LAS CITAS
    @Override
    public List<CitaDTO> readAll() throws Exception{
        CitaDTO dto;
        List<CitaDTO> lst = new ArrayList<>();
        return lst;
    }
    //AGENDAR CITA
    public boolean create(CitaDTO entity) throws Exception{
        return true;
    }
    //REAGENDAR/CANCELAR CITA
    public boolean update(CitaDTO entity) throws Exception{
        return true;
    }

    public List<CitaDTO> consultarCitasPendientes(Integer id_medico) throws Exception{
        List<CitaDTO> lst = new ArrayList<>();
        return lst;
    }
    public List<CitaDTO> consultarHistorialMedico(Integer id_paciente) throws Exception{
        List<CitaDTO> lst = new ArrayList<>();
        return lst;
    }
}
