package dataAccess.DAO;

import dataAccess.DTO.PacienteDTO;
import dataAccess.IDAO;
import dataAccess.MySQLDataHelper;
import framework.ExceptionLogger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO extends MySQLDataHelper implements IDAO<PacienteDTO>{

    @Override
    public PacienteDTO readBy(Integer id) throws Exception {
        PacienteDTO dto = new PacienteDTO();
        String query ="SELECT "
                    +"ID_PACIENTE, "
                    +"CEDULA, "
                    +"NOMBRES, " 
                    +"APELLIDOS, "
                    +"FECHA_NACIMIENTO, "
                    +"SEXO, "
                    +"DIRECCION, "
                    +"NACIONALIDAD, "
                    +"TELEFONO, "
                    +"CORREO, "
                    +"AFILIACION "
                    +"FROM PACIENTE "
                    +"WHERE ID_PACIENTE = " + id.toString();
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new PacienteDTO (  rs.getInt   (1)
                                        ,rs.getString(2)
                                        ,rs.getString(3)
                                        ,rs.getString(4)
                                        ,rs.getString(5)
                                        ,rs.getString(6)
                                        ,rs.getString(7)
                                        ,rs.getString(8)
                                        ,rs.getString(9)
                                        ,rs.getString(10)
                                        ,rs.getString(11)
                );
            }
        } 
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readby");
        }
        return dto;
    }

    @Override
    public List<PacienteDTO> readAll() throws Exception {
        PacienteDTO dto;
        List<PacienteDTO> lst = new ArrayList<>();
        String query ="SELECT "
                    +"ID_PACIENTE, "
                    +"CEDULA, "
                    +"NOMBRES, " 
                    +"APELLIDOS, "
                    +"FECHA_NACIMIENTO, "
                    +"SEXO, "
                    +"DIRECCION, "
                    +"NACIONALIDAD, "
                    +"TELEFONO, "
                    +"CORREO, "
                    +"AFILIACION "
                    +"FROM PACIENTE";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new PacienteDTO (  rs.getInt   (1)
                                        ,rs.getString(2)
                                        ,rs.getString(3)
                                        ,rs.getString(4)
                                        ,rs.getString(5)
                                        ,rs.getString(6)
                                        ,rs.getString(7)
                                        ,rs.getString(8)
                                        ,rs.getString(9)
                                        ,rs.getString(10)
                                        ,rs.getString(11)
                );
                lst.add(dto);
            }
        } 
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readall");
        }
        return lst;
    }

    @Override
    public boolean create(PacienteDTO entity) throws Exception {
        return true;
    }

    @Override
    public boolean update(PacienteDTO entity) throws Exception {
        return true;
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return true;
    }
}
