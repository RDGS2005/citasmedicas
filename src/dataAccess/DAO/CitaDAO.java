package dataAccess.DAO;

import dataAccess.DTO.*;
import dataAccess.IDAO;
import dataAccess.MySQLDataHelper;
import framework.ExceptionLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO extends MySQLDataHelper implements IDAO<CitaDTO>{
    //AGENDAR CITA
    public Integer create(CitaDTO entity) throws Exception {
        String queryCita = "INSERT INTO CITA (ID_TURNO, REFERENCIA, CONTRARREFERENCIA, ID_PACIENTE) VALUES (?, ?, ?, ?)";
        String queryUpdateTurno = "UPDATE TURNO SET ID_CITA = ? WHERE ID_TURNO = ?";

        try (Connection conn = conectarBD()) {
            conn.setAutoCommit(false);

            // 1. Insertar la cita
            Integer idCitaGenerada;
            try (PreparedStatement pstmtCita = conn.prepareStatement(queryCita, Statement.RETURN_GENERATED_KEYS)) {
                pstmtCita.setInt(1, entity.Id_turno);
                pstmtCita.setObject(2, entity.Id_referencia, Types.INTEGER);
                pstmtCita.setObject(3, entity.Id_contarreferencia, Types.INTEGER);
                pstmtCita.setInt(4, entity.Id_paciente);

                if (pstmtCita.executeUpdate() == 0) {
                    throw new SQLException("Creating cita failed, no rows affected.");
                }

                try (ResultSet generatedKeys = pstmtCita.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idCitaGenerada = generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("Creating cita failed, no ID obtained.");
                    }
                }
            }

            // 2. Actualizar el turno
            try (PreparedStatement pstmtTurno = conn.prepareStatement(queryUpdateTurno)) {
                pstmtTurno.setInt(1, idCitaGenerada);
                pstmtTurno.setInt(2, entity.Id_turno);

                if (pstmtTurno.executeUpdate() == 0) {
                    throw new SQLException("Updating turno failed, no rows affected.");
                }
            }

            conn.commit();
            return idCitaGenerada;

        } catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "create");
        }
    }

    @Override
    public CitaDTO readBy(Integer id) throws Exception{
        CitaDTO dto = null;
        String query ="SELECT "
                +"ID_CITA, "
                +"ID_TURNO, "
                +"REFERENCIA, "
                +"CONTRARREFERENCIA, "
                +"ID_PACIENTE, "
                +"CANCELADA, "
                +"ATENDIDA "
                +"FROM CITA "
                +"WHERE ID_CITA = " + id.toString();
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {

                dto = new CitaDTO (rs.getInt(1)
                        ,rs.getInt(2)
                        ,rs.getInt(3)
                        ,rs.getInt(4)
                        ,rs.getInt(5)
                        ,rs.getBoolean(6)
                        ,rs.getBoolean(7)
                );
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readby");
        }
        return dto;
    }

    //CONSULTAR TODAS LAS CITAS
    @Override
    public List<CitaDTO> readAll() throws Exception{
        CitaDTO dto;
        List<CitaDTO> lst = new ArrayList<>();
        String query = "SELECT "
                + "ID_CITA, "
                + "ID_TURNO, "
                + "REFERENCIA, "
                + "CONTRARREFERENCIA, "
                + "ID_PACIENTE, "
                + "CANCELADA, "
                + "ATENDIDA "
                + "FROM CITA "
                + "ORDER BY ID_CITA DESC";
        try {
            TurnoDAO tdao = new TurnoDAO();
            PacienteDAO pdao = new PacienteDAO();

            Connection conn = conectarBD();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new CitaDTO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getBoolean(6),
                        rs.getBoolean(7)
                );
                lst.add(dto);
            }
        } catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readAll");
        }
        return lst;
    }

    //REAGENDAR/CANCELAR CITA
    public boolean update(CitaDTO entity) throws Exception{
        String query = "UPDATE CITA SET ID_TURNO = ?, REFERENCIA = ?, CONTRARREFERENCIA = ?, ID_PACIENTE = ?, CANCELADA = ? WHERE ID_CITA = ?";
        try {
            Connection conn = conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, entity.Id_turno);
            pstmt.setObject(2, entity.Id_referencia, Types.INTEGER);
            pstmt.setObject(3, entity.Id_contarreferencia, Types.INTEGER);
            pstmt.setInt(4, entity.Id_paciente);
            pstmt.setBoolean(5, entity.Cancelada);
            pstmt.setInt(6, entity.Id_cita);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "update");
        }
        return true;
    }

    //CANCELAR CITA
    public boolean cancelarCita(Integer id_cita) throws Exception {
        String query = "UPDATE CITA SET CANCELADA = ? WHERE ID_CITA = ?";
        try {
            Connection conn = conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setBoolean(1, true);
            pstmt.setInt(2, id_cita);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "cancelarCita");
        }
        return true;
    }

    //REACTIVAR CITA
    public boolean reactivarCita(Integer id_cita) throws Exception {
        String query = "UPDATE CITA SET CANCELADA = ? WHERE ID_CITA = ?";
        try {
            Connection conn = conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setBoolean(1, false);
            pstmt.setInt(2, id_cita);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "reactivarCita");
        }
        return true;
    }

    public List<CitaDTO> consultarCitasPendientes(Integer id_medico) throws Exception{
        List<CitaDTO> lst = new ArrayList<>();
        String query = "SELECT c.ID_CITA, c.ID_TURNO, c.REFERENCIA, c.CONTRARREFERENCIA, c.ID_PACIENTE, c.CANCELADA "
                + "FROM CITA c "
                + "INNER JOIN TURNO t ON c.ID_TURNO = t.ID_TURNO "
                + "INNER JOIN FECHA f ON t.ID_FECHA = f.ID_FECHA "
                + "WHERE t.ID_MEDICO = " + id_medico.toString()
                + " AND c.CANCELADA = 0 "
                + " AND f.FECHA >= CURDATE() "
                + "ORDER BY f.FECHA ASC, t.ID_HORARIO ASC";
        try {
            Connection conn = conectarBD();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                CitaDTO dto = new CitaDTO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getBoolean(6),
                        false
                );
                lst.add(dto);
            }
        } catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "consultarCitasPendientes");
        }
        return lst;
    }

    public List<CitaDTO> consultarCitasFaltantes(Integer id_medico) throws Exception{
        List<CitaDTO> lst = new ArrayList<>();
        String query = "SELECT c.ID_CITA, c.ID_TURNO, c.REFERENCIA, c.CONTRARREFERENCIA, c.ID_PACIENTE, c.CANCELADA "
                + "FROM CITA c "
                + "INNER JOIN TURNO t ON c.ID_TURNO = t.ID_TURNO "
                + "INNER JOIN FECHA f ON t.ID_FECHA = f.ID_FECHA "
                + "WHERE t.ID_MEDICO = " + id_medico.toString()
                + " AND c.CANCELADA = 0 "
                + " AND c.ATENDIDA = 0"
                + " AND f.FECHA <= CURDATE() "
                + "ORDER BY f.FECHA DESC, t.ID_HORARIO DESC";
        try {
            Connection conn = conectarBD();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                CitaDTO dto = new CitaDTO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getBoolean(6),
                        false
                );
                lst.add(dto);
            }
        } catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "consultarCitasPendientes");
        }
        return lst;
    }

    public List<CitaDTO> consultarHistorialMedico(Integer id_paciente) throws Exception{
        List<CitaDTO> lst = new ArrayList<>();
        String query = "SELECT c.ID_CITA, c.ID_TURNO, c.REFERENCIA, c.CONTRARREFERENCIA, c.ID_PACIENTE, c.CANCELADA "
                + "FROM CITA c "
                + "INNER JOIN TURNO t ON c.ID_TURNO = t.ID_TURNO "
                + "INNER JOIN FECHA f ON t.ID_FECHA = f.ID_FECHA "
                + "WHERE c.ID_PACIENTE = " + id_paciente.toString()
                + " AND c.ATENDIDA = 1"
                + " ORDER BY f.FECHA DESC, t.ID_HORARIO DESC";
        try {

            Connection conn = conectarBD();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                CitaDTO dto = new CitaDTO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getBoolean(6),
                        true
                );
                lst.add(dto);
            }
        } catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "consultarHistorialMedico");
        }
        return lst;
    }


}