package dataAccess.DAO;

import dataAccess.DTO.CitaDTO;
import dataAccess.DTO.DiagnosticoDTO;
import dataAccess.DTO.MedicoDTO;
import dataAccess.DTO.PacienteDTO;
import dataAccess.IDAO;
import dataAccess.MySQLDataHelper;
import framework.ExceptionLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PacienteDAO extends MySQLDataHelper implements IDAO<PacienteDTO>{
    //INGRESAR AL SISTEMA
    public int login(String cedula, String password) throws Exception{
        int id = -1;
        String encriptado = sha256(password);
        String query ="SELECT "
                +"ID_PACIENTE"
                +" FROM PACIENTE "
                +"WHERE CEDULA = '" + cedula + "' AND PASSWORD = '" + encriptado + "' AND DADO_DE_BAJA = 0";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt(1);
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "login");
        }
        return id;
    }
    public int validar_cedula(String cedula) throws Exception{
        int id = -1;
        String query ="SELECT "
                +"ID_PACIENTE"
                +" FROM PACIENTE "
                +"WHERE CEDULA = '" + cedula + "'";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt(1);
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "login");
        }
        return id;
    }
    //REGISTRAR PERFIL
    public boolean create(PacienteDTO entity, String password) throws Exception {
        String query = " INSERT INTO PACIENTE (CEDULA, PASSWORD, NOMBRE, APELLIDO, SEXO, FECHA_NACIMIENTO, DIRECCION, NACIONALIDAD, TELEFONO, CORREO, AFILIACION) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.Cedula);
            pstmt.setString(2, sha256(password));
            pstmt.setString(3, entity.Nombres);
            pstmt.setString(4, entity.Apellidos);
            pstmt.setString(5, entity.Sexo);
            pstmt.setDate(6, Date.valueOf(entity.FechaNacimiento));
            pstmt.setString(7, entity.Direccion);
            pstmt.setString(8, entity.Nacionalidad);
            pstmt.setString(9, entity.Telefono);
            pstmt.setString(10, entity.Correo);
            pstmt.setString(11, entity.Afiliacion);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "create");
        }
        return true;
    }
    //CONSULTAR PACIENTE
    @Override
    public PacienteDTO readBy(Integer id) throws Exception {
        PacienteDTO dto = null;
        String query ="SELECT "
                    +"ID_PACIENTE, "
                    +"CEDULA, "
                    +"NOMBRE, "
                    +"APELLIDO, "
                    +"FECHA_NACIMIENTO, "
                    +"SEXO, "
                    +"DIRECCION, "
                    +"NACIONALIDAD, "
                    +"TELEFONO, "
                    +"CORREO, "
                    +"AFILIACION "
                    +"FROM PACIENTE "
                    +"WHERE ID_PACIENTE = " + id.toString() + " AND DADO_DE_BAJA = 0";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new PacienteDTO (  rs.getInt   (1)
                                        ,rs.getString(2)
                                        ,rs.getString(3)
                                        ,rs.getString(4)
                                        ,rs.getString(6)
                                        ,rs.getDate(5).toLocalDate()
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
    //VER TODOS LOS PACIENTES
    @Override
    public List<PacienteDTO> readAll() throws Exception {
        PacienteDTO dto;
        List<PacienteDTO> lst = new ArrayList<>();
        String query = "SELECT "
                + "ID_PACIENTE, "
                + "CEDULA, "
                + "NOMBRE, "
                + "APELLIDO, "
                + "FECHA_NACIMIENTO, "
                + "SEXO, "
                + "DIRECCION, "
                + "NACIONALIDAD, "
                + "TELEFONO, "
                + "CORREO, "
                + "AFILIACION "
                + "FROM PACIENTE WHERE DADO_DE_BAJA = 0";
        try {
            Connection conn = conectarBD();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new PacienteDTO(rs.getInt(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(6)
                        , rs.getDate(5).toLocalDate()
                        , rs.getString(7)
                        , rs.getString(8)
                        , rs.getString(9)
                        , rs.getString(10)
                        , rs.getString(11)
                );
                lst.add(dto);
            }

        } catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readall");
        }
        return lst;
    }
    //MODIFICAR PERFIL
    public boolean update(PacienteDTO entity, String password) throws Exception {
        String query = " UPDATE PACIENTE SET CEDULA = ?, PASSWORD = ?, NOMBRE = ?, APELLIDO = ?, SEXO = ?, FECHA_NACIMIENTO = ?, DIRECCION = ?, NACIONALIDAD = ?, TELEFONO = ?, CORREO = ?, AFILIACION = ? WHERE ID_PACIENTE = ?";
        try {
            Connection        conn  = conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.Cedula);
            pstmt.setString(2, sha256(password));
            pstmt.setString(3, entity.Nombres);
            pstmt.setString(4, entity.Apellidos);
            pstmt.setString(5, entity.Sexo);
            pstmt.setDate(6, Date.valueOf(entity.FechaNacimiento));
            pstmt.setString(7, entity.Direccion);
            pstmt.setString(8, entity.Nacionalidad);
            pstmt.setString(9, entity.Telefono);
            pstmt.setString(10, entity.Correo);
            pstmt.setString(11, entity.Afiliacion);
            pstmt.setInt(12, entity.Id);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "update");
        }
        return true;
    }

    //ELIMINAR PERFIL
    public boolean dardebaja(Integer id_paciente) throws Exception{
        String query = " UPDATE PACIENTE SET DADO_DE_BAJA = ? WHERE ID_PACIENTE = ?";
        try {
            Connection          conn = conectarBD();
            PreparedStatement  pstmt = conn.prepareStatement(query);

            pstmt.setBoolean(1, true);
            pstmt.setInt   (2, id_paciente);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "dardebaja");
        }
        return true;
    }
    //RECUPERAR PERFIL
    public boolean dardealta(Integer id_paciente) throws Exception{
        String query = " UPDATE PACIENTE SET DADO_DE_BAJA = ? WHERE ID_PACIENTE = ?";
        try {
            Connection          conn = conectarBD();
            PreparedStatement  pstmt = conn.prepareStatement(query);

            pstmt.setBoolean(1, false);
            pstmt.setInt   (2, id_paciente);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "dardealta");
        }
        return true;
    }
    //CONSULTAR ELIMINADOS PARA RECUPERARLOS
    public List<PacienteDTO> verEliminados() throws Exception {
        PacienteDTO dto;
        List<PacienteDTO> lst = new ArrayList<>();
        String query ="SELECT "
                +"ID_PACIENTE, "
                +"CEDULA, "
                +"NOMBRE, "
                +"APELLIDO, "
                +"FECHA_NACIMIENTO, "
                +"SEXO, "
                +"DIRECCION, "
                +"NACIONALIDAD, "
                +"TELEFONO, "
                +"CORREO, "
                +"AFILIACION "
                +"FROM PACIENTE WHERE DADO_DE_BAJA = 1";
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
                        ,rs.getDate(6).toLocalDate()
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
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "verEliminados");
        }
        return lst;
    }
}
