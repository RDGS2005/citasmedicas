package dataAccess.DAO;

import dataAccess.DTO.CitaDTO;
import dataAccess.DTO.MedicamentoDTO;
import dataAccess.DTO.MedicoDTO;
import dataAccess.DTO.PacienteDTO;
import dataAccess.IDAO;
import dataAccess.MySQLDataHelper;
import framework.ExceptionLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO extends MySQLDataHelper implements IDAO<MedicoDTO>{
    //INGRESAR AL SISTEMA
    public int login(String cedula, String password) throws Exception{
        int id = -1;
        String encriptado = sha256(password);
        String query ="SELECT "
                +"ID_MEDICO"
                +" FROM MEDICO "
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
    //RECUPERAR ESPECIALIDAD POR SU ID
    public String obtenerEspecialidad(Integer id) throws Exception
    {
        String esp = null;
        String query ="SELECT "
                +"DESCRIPCION "
                +"FROM ESPECIALIZACION "
                +"WHERE ID_ESPECIALIZACION = " + id.toString();
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                esp = rs.getString(1);
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "obtenerEspecialidades");
        }
        return esp;
    }
    //RECUPERAR TODAS LAS ESPECIALIDADES
    public List<String> obtenerEspecialidades() throws Exception
    {
        List<String> lst = new ArrayList<>();
        String query ="SELECT "
                +"DESCRIPCION "
                +"FROM ESPECIALIZACION";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                lst.add(rs.getString(1));
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "obtenerEspecialidades");
        }
        return lst;
    }
    //RECUPERAR ID POR NOMBRE DE ESPECIALIDAD
    public int obtenerIdEspecialidad(String especializacion) throws Exception
    {
        int id = -1;
        String query ="SELECT "
                +"ID_ESPECIALIZACION "
                +"FROM ESPECIALIZACION WHERE DESCRIPCION = '" + especializacion + "'";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt(1);
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "obtenerIdEspecialidad");
        }
        return id;
    }
    //REGISTRAR MEDICO
    public boolean create(MedicoDTO entity, String password) throws Exception {
        String query = " INSERT INTO MEDICO (CEDULA, PASSWORD, NOMBRE, APELLIDO, SEXO, FECHA_NACIMIENTO, JORNADA_INICIO, JORNADA_FIN, ID_ESPECIALIZACION) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.Cedula);
            pstmt.setString(2, sha256(password));
            pstmt.setString(3, entity.Nombres);
            pstmt.setString(4, entity.Apellidos);
            pstmt.setString(5, entity.Sexo);
            pstmt.setDate(6, Date.valueOf(entity.FechaNacimiento));
            pstmt.setTime(7,  Time.valueOf(entity.InicioJornada));
            pstmt.setTime(8, Time.valueOf(entity.FinJornada));
            pstmt.setInt(9, obtenerIdEspecialidad(entity.Especializacion));

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "create");
        }
        return true;
    }
    //CONSULTAR MEDICO
    @Override
    public MedicoDTO readBy(Integer id) throws Exception {
        MedicoDTO dto = null;
        String query ="SELECT "
                +"ID_MEDICO, "
                +"CEDULA, "
                +"ID_ESPECIALIZACION, "
                +"NOMBRE, "
                +"APELLIDO, "
                +"SEXO, "
                +"FECHA_NACIMIENTO, "
                +"JORNADA_INICIO, "
                +"JORNADA_FIN "
                +"FROM MEDICO "
                +"WHERE ID_MEDICO = " + id.toString() + " AND DADO_DE_BAJA = 0";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new MedicoDTO (rs.getInt   (1)
                        ,rs.getString(2)
                        ,obtenerEspecialidad(rs.getInt(3))
                        ,rs.getString(4)
                        ,rs.getString(5)
                        ,rs.getString(6)
                        ,rs.getDate(7).toLocalDate()
                        ,rs.getTime(8).toLocalTime()
                        ,rs.getTime(9).toLocalTime()
                );
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readby");
        }
        return dto;
    }
    //VER TODOS LOS DOCTORES
    @Override
    public List<MedicoDTO> readAll() throws Exception {
        MedicoDTO dto;
        List<MedicoDTO> lst = new ArrayList<>();
        String query ="SELECT "
                +"ID_MEDICO, "
                +"CEDULA, "
                +"ID_ESPECIALIZACION, "
                +"NOMBRE, "
                +"APELLIDO, "
                +"SEXO, "
                +"FECHA_NACIMIENTO, "
                +"JORNADA_INICIO, "
                +"JORNADA_FIN "
                +"FROM MEDICO WHERE DADO_DE_BAJA = 0";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new MedicoDTO (rs.getInt   (1)
                        ,rs.getString(2)
                        ,obtenerEspecialidad(rs.getInt(3))
                        ,rs.getString(4)
                        ,rs.getString(5)
                        ,rs.getString(6)
                        ,rs.getDate(7).toLocalDate()
                        ,rs.getTime(8).toLocalTime()
                        ,rs.getTime(9).toLocalTime()
                );
                lst.add(dto);
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readAll");
        }
        return lst;
    }
    //MODIFICAR PERFIL
    public boolean update(MedicoDTO entity, String password) throws Exception {
        String query = " UPDATE MEDICO SET CEDULA = ?, PASSWORD = ?, NOMBRE = ?, APELLIDO = ?, SEXO = ?, FECHA_NACIMIENTO = ?, JORNADA_INICIO = ?, JORNADA_FIN = ?, ID_ESPECIALIZACION = ? WHERE ID_MEDICO = ?";
        try {
            Connection        conn  = conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.Cedula);
            pstmt.setString(2, sha256(password));
            pstmt.setString(3, entity.Nombres);
            pstmt.setString(4, entity.Apellidos);
            pstmt.setString(5, entity.Sexo);
            pstmt.setDate(6, Date.valueOf(entity.FechaNacimiento));
            pstmt.setTime(7,  Time.valueOf(entity.InicioJornada));
            pstmt.setTime(8, Time.valueOf(entity.FinJornada));
            pstmt.setInt(9, obtenerIdEspecialidad(entity.Especializacion));

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "update");
        }
        return true;
    }
    //ELIMINAR PERFIL
    public boolean dardebaja(Integer id_medico) throws Exception {
        String query = " UPDATE MEDICO SET DADO_DE_BAJA = ? WHERE ID_MEDICO = ?";
        try {
            Connection          conn = conectarBD();
            PreparedStatement  pstmt = conn.prepareStatement(query);

            pstmt.setBoolean(1, true);
            pstmt.setInt   (2, id_medico);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "dardebaja");
        }
        return true;
    }
    //RECUPERAR PERFIL
    public boolean dardealta(Integer id_medico) throws Exception {
        String query = " UPDATE MEDICO SET DADO_DE_BAJA = ? WHERE ID_MEDICO = ?";
        try {
            Connection          conn = conectarBD();
            PreparedStatement  pstmt = conn.prepareStatement(query);

            pstmt.setBoolean(1, false);
            pstmt.setInt   (2, id_medico);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "dardebaja");
        }
        return true;
    }
    //CONSULTAR ELIMINADOS PARA RECUPERARLOS
    public List<MedicoDTO> verEliminados() throws Exception {
        MedicoDTO dto;
        List<MedicoDTO> lst = new ArrayList<>();
        String query ="SELECT "
                +"ID_MEDICO, "
                +"CEDULA, "
                +"ID_ESPECIALIZACION, "
                +"NOMBRE, "
                +"APELLIDO, "
                +"SEXO, "
                +"FECHA_NACIMIENTO, "
                +"JORNADA_INICIO, "
                +"JORNADA_FIN "
                +"FROM MEDICO WHERE DADO_DE_BAJA = 1";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new MedicoDTO (rs.getInt   (1)
                        ,rs.getString(2)
                        ,obtenerEspecialidad(rs.getInt(3))
                        ,rs.getString(4)
                        ,rs.getString(5)
                        ,rs.getString(6)
                        ,rs.getDate(7).toLocalDate()
                        ,rs.getTime(8).toLocalTime()
                        ,rs.getTime(9).toLocalTime()
                );
                lst.add(dto);
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readAll");
        }
        return lst;
    }

    public List<MedicamentoDTO> consultarMedicamentos() throws Exception {
        MedicamentoDTO dto;
        List<MedicamentoDTO> lst = new ArrayList<>();
        String query ="SELECT "
                +"ID_MEDICAMENTO, "
                +"DESCRIPCION, "
                +"PRINCIPIO_ACTIVO "
                +"FROM MEDICAMENTO";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new MedicamentoDTO (rs.getInt   (1)
                        ,rs.getString(2)
                        ,rs.getString(3)
                );
                lst.add(dto);
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readAll");
        }
        return lst;
    }

    public List<MedicoDTO> obtenerMedicosPorEspecialidad(String especialidadSeleccionada) throws Exception {
        List<MedicoDTO> lst = new ArrayList<>();
        String query = "SELECT "
                + "m.ID_MEDICO, "
                + "m.CEDULA, "
                + "m.NOMBRE, "
                + "m.APELLIDO, "
                + "m.SEXO, "
                + "m.FECHA_NACIMIENTO, "
                + "m.JORNADA_INICIO, "
                + "m.JORNADA_FIN, "
                + "e.DESCRIPCION "
                + "FROM MEDICO m "
                + "INNER JOIN ESPECIALIZACION e ON m.ID_ESPECIALIZACION = e.ID_ESPECIALIZACION "
                + "WHERE e.DESCRIPCION = ? AND m.DADO_DE_BAJA = 0";

        try {
            Connection conn = conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, especialidadSeleccionada);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MedicoDTO dto = new MedicoDTO(
                        rs.getInt(1),           // ID_MEDICO
                        rs.getString(2),        // CEDULA
                        rs.getString(9),        // DESCRIPCION (especialidad)
                        rs.getString(3),        // NOMBRE
                        rs.getString(4),        // APELLIDO
                        rs.getString(5),        // SEXO
                        rs.getDate(6).toLocalDate(), // FECHA_NACIMIENTO
                        rs.getTime(7).toLocalTime(), // JORNADA_INICIO
                        rs.getTime(8).toLocalTime()  // JORNADA_FIN
                );
                lst.add(dto);
            }

        } catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "obtenerMedicosPorEspecialidad");
        }
        return lst;
    }
}
