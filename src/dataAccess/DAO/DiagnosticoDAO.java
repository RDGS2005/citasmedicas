package dataAccess.DAO;

import dataAccess.DTO.CitaDTO;
import dataAccess.DTO.MedicamentoDTO;
import dataAccess.DTO.DiagnosticoDTO;
import dataAccess.DTO.TratamientoDTO;
import dataAccess.IDAO;
import dataAccess.MySQLDataHelper;
import framework.ExceptionLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticoDAO extends MySQLDataHelper implements IDAO<DiagnosticoDTO> {

    @Override
    public DiagnosticoDTO readBy(Integer id) throws Exception {
        DiagnosticoDTO dto = null;
        String query = "SELECT "
                + "ID_DIAGNOSTICO, "
                + "ID_CITA, "
                + "SINTOMAS_IDENTIFICADOS, "
                + "CONDICION, "
                + "CERTEZA, "
                + "TRATAMIENTO "
                + "FROM DIAGNOSTICO "
                + "WHERE ID_DIAGNOSTICO = " + id.toString();
        try {
            Connection conn = conectarBD();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new DiagnosticoDTO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
            }
        } catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readBy");
        }
        return dto;
    }
    public DiagnosticoDTO readByCita(Integer id) throws Exception {
        DiagnosticoDTO dto = null;

        String query = "SELECT ID_DIAGNOSTICO, ID_CITA, SINTOMAS_IDENTIFICADOS, " +
                "CONDICION, CERTEZA, TRATAMIENTO " +
                "FROM DIAGNOSTICO WHERE ID_CITA = ?";

        try {
            Connection conn = conectarBD();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            System.out.println("QUERY ==> " + ps.toString());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dto = new DiagnosticoDTO(
                        rs.getInt("ID_DIAGNOSTICO"),
                        rs.getInt("ID_CITA"),
                        rs.getString("SINTOMAS_IDENTIFICADOS"),
                        rs.getString("CONDICION"),
                        rs.getString("CERTEZA"),
                        rs.getString("TRATAMIENTO")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }



    @Override
    public List<DiagnosticoDTO> readAll() throws Exception {
        DiagnosticoDTO dto;
        List<DiagnosticoDTO> lst = new ArrayList<>();
        String query = "SELECT "
                + "ID_DIAGNOSTICO, "
                + "ID_CITA, "
                + "SINTOMAS_IDENTIFICADOS, "
                + "CONDICION, "
                + "CERTEZA, "
                + "TRATAMIENTO "
                + "FROM DIAGNOSTICO";
        try {
            Connection conn = conectarBD();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new DiagnosticoDTO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                lst.add(dto);
            }
        } catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readAll");
        }
        return lst;
    }

    //AGREGAR DIAGNOSTICO
    public boolean create(DiagnosticoDTO entity) throws Exception {
        String query = "INSERT INTO DIAGNOSTICO (ID_CITA, SINTOMAS_IDENTIFICADOS, CONDICION, CERTEZA, TRATAMIENTO) VALUES (?, ?, ?, ?, ?)";
        String query2 = "UPDATE CITA SET ASISTIDA = ? WHERE ID_CITA = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;

        try {
            conn = conectarBD();

            // INSERT del diagnóstico
            pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, entity.Id_cita);
            pstmt.setString(2, entity.Sintomas);
            pstmt.setString(3, entity.Condicion);
            pstmt.setString(4, entity.Certeza);
            pstmt.setString(5, entity.Tratamiento);
            pstmt.executeUpdate();

            // UPDATE de la cita
            pstmt2 = conn.prepareStatement(query2);
            pstmt2.setBoolean(1, true);
            pstmt2.setInt(2, entity.Id_cita);
            pstmt2.executeUpdate();

        } catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "create");
        } finally {
            if (pstmt != null) pstmt.close();
            if (pstmt2 != null) pstmt2.close();
            if (conn != null) conn.close();
        }
        return true;
    }


    public boolean update(DiagnosticoDTO entity) throws Exception {
        String query = "UPDATE DIAGNOSTICO SET ID_CITA = ?, SINTOMAS_IDENTIFICADOS = ?, CONDICION = ?, CERTEZA = ?, TRATAMIENTO = ? WHERE ID_DIAGNOSTICO = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = conectarBD();
            pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, entity.Id_cita);
            pstmt.setString(2, entity.Sintomas);
            pstmt.setString(3, entity.Condicion);
            pstmt.setString(4, entity.Certeza);
            pstmt.setString(5, entity.Tratamiento);
            pstmt.setInt(6, entity.Id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "update");
        } finally {
            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException e) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return true;
    }

    // Métodos auxiliares para manejar tratamientos
    public List<TratamientoDTO> obtenerTratamientos(Integer idDiagnostico) throws Exception {
        TratamientoDTO dto;
        List<TratamientoDTO> lst = new ArrayList<>();
        String query = "SELECT "
                + "ID_DIAGNOSTICO, "
                + "ID_MEDICAMENTO,"
                + "DOSIS_MG,"
                + "FRECUENCIA_HORAS,"
                + "TIEMPO_DIAS "
                + "FROM TRATAMIENTO WHERE ID_DIAGNOSTICO = " + idDiagnostico.toString();
        try {
            Connection conn = conectarBD();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new TratamientoDTO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getFloat(3),
                        rs.getInt(4),
                        rs.getInt(5)
                );
                lst.add(dto);
            }
        } catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "obtenerTratamientos");
        }
        return lst;
    }
}