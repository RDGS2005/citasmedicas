package dataAccess.DAO;

import dataAccess.DTO.MedicoDTO;
import dataAccess.DTO.TurnoDTO;
import dataAccess.IDAO;
import dataAccess.MySQLDataHelper;
import framework.ExceptionLogger;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAO extends MySQLDataHelper implements IDAO<TurnoDTO>{
    public int buscarHorario(LocalTime hora) throws Exception
    {
        int id = -1;
        String query ="SELECT "
                +"ID_HORARIO "
                +"FROM HORARIO WHERE HORA_INICIO = '" + hora.toString() + "'";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt(1);
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "obtenerIdHorario");
        }
        return id;
    }
    public LocalTime buscarHorarioID(Integer id) throws Exception
    {
        LocalTime hora = null;
        String query ="SELECT "
                +"HORA_INICIO "
                +"FROM HORARIO WHERE ID_HORARIO = " + id.toString();
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                hora = rs.getTime(1).toLocalTime();
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "obtenerHorario");
        }
        return hora;
    }
    public int buscarFecha(LocalDate fecha) throws Exception
    {
        int id = -1;
        String query ="SELECT "
                +"ID_FECHA "
                +"FROM FECHA WHERE FECHA = '" + fecha.toString() + "'";
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt(1);
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "obtenerIdFecha");
        }
        return id;
    }
    public LocalDate buscarFechaID(Integer id) throws Exception
    {
        LocalDate hora = null;
        String query ="SELECT "
                +"FECHA "
                +"FROM FECHA WHERE ID_FECHA = " + id.toString();
        try {
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                hora = rs.getDate(1).toLocalDate();
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "obtenerFecha");
        }
        return hora;
    }
    public boolean create(TurnoDTO entity) throws Exception {
        String query = " INSERT INTO TURNO (ID_FECHA, ID_HORARIO, ID_MEDICO) VALUES (?, ?, ?)";
        try {
            Connection conn = conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, buscarFecha(entity.Fecha));
            pstmt.setInt(2, buscarHorario(entity.Hora));
            pstmt.setInt(3, entity.Id_medico);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "create");
        }
        return true;
    }
    @Override
    public TurnoDTO readBy(Integer id) throws Exception {
        TurnoDTO dto = null;
        String query ="SELECT "
                +"ID_TURNO, "
                +"ID_CITA, "
                +"ID_FECHA, "
                +"ID_HORARIO, "
                +"ID_MEDICO "
                +"FROM TURNO "
                +"WHERE ID_TURNO = " + id.toString();
        try {
            Connection conn = conectarBD();
            MedicoDAO mdao = new MedicoDAO();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                MedicoDTO medico = mdao.readBy(rs.getInt(5));
                dto = new TurnoDTO (rs.getInt   (1)
                        ,rs.getInt(2)
                        ,buscarFechaID(rs.getInt(3))
                        ,buscarHorarioID(rs.getInt(4))
                        ,rs.getInt(5)
                        ,medico.Especializacion
                        ,"Dr. " + medico.Nombres + " " + medico.Apellidos
                );
            }

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readby");
        }
        return dto;
    }

    @Override
    public List<TurnoDTO> readAll() throws Exception {
        TurnoDTO dto;
        List<TurnoDTO> lst = new ArrayList<>();
        String query ="SELECT "
                +"ID_TURNO, "
                +"ID_CITA, "
                +"ID_FECHA, "
                +"ID_HORARIO, "
                +"ID_MEDICO "
                +"FROM TURNO";
        try {
            MedicoDAO mdao = new MedicoDAO();
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                MedicoDTO medico = mdao.readBy(rs.getInt(5));
                dto = new TurnoDTO (rs.getInt   (1)
                        ,rs.getInt(2)
                        ,buscarFechaID(rs.getInt(3))
                        ,buscarHorarioID(rs.getInt(4))
                        ,rs.getInt(5)
                        ,medico.Especializacion
                        ,"Dr. " + medico.Nombres + " " + medico.Apellidos
                );
                lst.add(dto);
            }
        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readby");
        }
        return lst;
    }

    public boolean update(TurnoDTO entity) throws Exception {
        return true;
    }

    public boolean agendarTurno(Integer id_turno, Integer id_cita) throws Exception
    {
        String query = " UPDATE TURNO SET ID_CITA = ? WHERE ID_TURNO = ?";
        try {
            Connection        conn  = conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, id_turno);
            pstmt.setInt(2, id_cita);

            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "update");
        }
        return true;
    }

    public List<TurnoDTO> turnosDisponibles(String especialidad, LocalDate fecha, LocalTime hora) throws Exception {
        TurnoDTO dto;
        List<TurnoDTO> lst = new ArrayList<>();
        String query ="SELECT "
                +"ID_TURNO, "
                +"ID_CITA, "
                +"ID_FECHA, "
                +"ID_HORARIO, "
                +"ID_MEDICO "
                +"FROM TURNO WHERE ID_FECHA = " + buscarFecha(fecha)
                + " AND ID_HORARIO = " + buscarHorario(hora)
                + " AND ID_CITA IS NULL";

        try {
            MedicoDAO mdao = new MedicoDAO();
            Connection conn = conectarBD();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                MedicoDTO medico = mdao.readBy(rs.getInt(5));
                dto = new TurnoDTO (rs.getInt   (1)
                        ,rs.getInt(2)
                        ,buscarFechaID(rs.getInt(3))
                        ,buscarHorarioID(rs.getInt(4))
                        ,rs.getInt(5)
                        ,medico.Especializacion
                        ,"Dr. " + medico.Nombres + " " + medico.Apellidos
                );
                if(dto.Especialidad.equals(especialidad))
                {
                    lst.add(dto);
                }
            }
        }
        catch (SQLException e) {
            throw new ExceptionLogger(e.getMessage(), getClass().getName(), "readby");
        }
        return lst;
    }
}
