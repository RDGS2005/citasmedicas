package dataAccess.DAO;

import dataAccess.DTO.*;
import dataAccess.IDAO;
import dataAccess.MySQLDataHelper;
import framework.ExceptionLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperadorDAO extends MySQLDataHelper implements IDAO<OperadorDTO>{

    public int login(String cedula, String password) throws Exception{
        int id = -1;
        String encriptado = sha256(password);
        String query ="SELECT "
                +"ID_OPERADOR"
                +" FROM OPERADOR "
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
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readby");
        }
        return id;
    }
    public boolean create(OperadorDTO entity, String password) throws Exception
    {
        String query = " INSERT INTO OPERADOR (CEDULA, PASSWORD, NOMBRE, APELLIDO, TELEFONO, CORREO) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.Cedula);
            pstmt.setString(2, sha256(password));
            pstmt.setString(3, entity.Nombres);
            pstmt.setString(4, entity.Apellidos);
            pstmt.setString(5, entity.Telefono);
            pstmt.setString(6, entity.Correo);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "create");
        }
        return true;
    }
    //VER OPERADOR EN ESPECIFICO
    @Override
    public OperadorDTO readBy(Integer id) throws Exception {
        OperadorDTO dto = null;
        String query ="SELECT "
                +"ID_OPERADOR, "
                +"CEDULA, "
                +"NOMBRE, "
                +"APELLIDO, "
                +"TELEFONO, "
                +"CORREO "
                +"FROM OPERADOR "
                +"WHERE ID_OPERADOR = " + id.toString() + " AND DADO_DE_BAJA = 0";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new OperadorDTO (rs.getInt   (1)
                        ,rs.getString(2)
                        ,rs.getString(3)
                        ,rs.getString(4)
                        ,rs.getString(5)
                        ,rs.getString(6)
                );
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readby");
        }
        return dto;
    }
    //VER TODOS LOS OPERADORES
    @Override
    public List<OperadorDTO> readAll() throws Exception {
        OperadorDTO dto;
        List<OperadorDTO> lst = new ArrayList<>();
        String query ="SELECT "
                +"ID_OPERADOR, "
                +"CEDULA, "
                +"NOMBRE, "
                +"APELLIDO, "
                +"TELEFONO, "
                +"CORREO "
                +"FROM OPERADOR WHERE DADO_DE_BAJA = 0";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new OperadorDTO (rs.getInt   (1)
                        ,rs.getString(2)
                        ,rs.getString(3)
                        ,rs.getString(4)
                        ,rs.getString(5)
                        ,rs.getString(6)
                );
                lst.add(dto);
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readby");
        }
        return lst;
    }
    //MODIFICAR PERFIL
    public boolean update(OperadorDTO entity, String password) throws Exception {
        String query = " UPDATE OPERADOR SET CEDULA = ?, PASSWORD = ?, NOMBRE = ?, APELLIDO = ?, TELEFONO = ?, CORREO = ? WHERE ID_OPERADOR = ?";
        try {
            Connection        conn  = conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.Cedula);
            pstmt.setString(2, sha256(password));
            pstmt.setString(3, entity.Nombres);
            pstmt.setString(4, entity.Apellidos);
            pstmt.setString(5, entity.Telefono);
            pstmt.setString(6, entity.Correo);
            pstmt.setInt(7, entity.Id);


            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "update");
        }
        return true;
    }
    //ELIMINAR PERFIL
    public boolean dardebaja(Integer id_operador) throws Exception {
        String query = " UPDATE OPERADOR SET DADO_DE_BAJA = ? WHERE ID_OPERADOR = ?";
        try {
            Connection          conn = conectarBD();
            PreparedStatement  pstmt = conn.prepareStatement(query);

            pstmt.setBoolean(1, true);
            pstmt.setInt   (2, id_operador);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "dardebaja");
        }
        return true;
    }
    //RECUPERAR PERFIL
    public boolean dardealta(Integer id_operador) throws Exception {
        String query = " UPDATE OPERADOR SET DADO_DE_BAJA = ? WHERE ID_OPERADOR = ?";
        try {
            Connection          conn = conectarBD();
            PreparedStatement  pstmt = conn.prepareStatement(query);

            pstmt.setBoolean(1, false);
            pstmt.setInt   (2, id_operador);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "dardebaja");
        }
        return true;
    }
    //CONSULTAR ELIMINADOS PARA RECUPERARLOS
    public List<OperadorDTO> verEliminados() throws Exception {
        OperadorDTO dto;
        List<OperadorDTO> lst = new ArrayList<>();
        String query ="SELECT "
                +"ID_OPERADOR, "
                +"CEDULA, "
                +"NOMBRE, "
                +"APELLIDO, "
                +"TELEFONO, "
                +"CORREO "
                +"FROM OPERADOR WHERE DADO_DE_BAJA = 1";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new OperadorDTO (rs.getInt   (1)
                        ,rs.getString(2)
                        ,rs.getString(3)
                        ,rs.getString(4)
                        ,rs.getString(5)
                        ,rs.getString(6)
                );
                lst.add(dto);
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readby");
        }
        return lst;
    }
}
