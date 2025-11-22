package dataAccess.DAO;

import dataAccess.DTO.TurnoDTO;
import dataAccess.IDAO;
import dataAccess.MySQLDataHelper;
import framework.ExceptionLogger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAO extends MySQLDataHelper implements IDAO<TurnoDTO>{

    @Override
    public TurnoDTO readBy(Integer id) throws Exception {
        TurnoDTO dto = new TurnoDTO();
        return dto;
    }

    @Override
    public List<TurnoDTO> readAll() throws Exception {
        TurnoDTO dto;
        List<TurnoDTO> lst = new ArrayList<>();
        return lst;
    }

    @Override
    public boolean create(TurnoDTO entity) throws Exception {
        return true;
    }

    @Override
    public boolean update(TurnoDTO entity) throws Exception {
        return true;
    }

    public List<TurnoDTO> turnosDisponibles(String especialidad, LocalDate fecha, LocalTime hora) throws Exception {
        List<TurnoDTO> lst = new ArrayList<>();
        return lst;
    }
}
