package dataAccess.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoDTO {
    public Integer Id;
    public Integer Id_Cita;
    public LocalDate Fecha;
    public LocalTime Hora;
    public Integer Id_medico;
    public String Especialidad;
    public String Nombre_medico;

    public TurnoDTO() {}
    //CONSTRUCTOR PARA WRITE
    public TurnoDTO(LocalDate fecha, LocalTime hora, Integer id_medico) {
        Fecha = fecha;
        Hora = hora;
        Id_medico = id_medico;
    }
    //CONSTRUCTOR PARA READ
    public TurnoDTO(Integer id, Integer id_Cita, LocalDate fecha, LocalTime hora, Integer id_medico, String especialidad, String nombre_medico) {
        Id = id;
        Id_Cita = id_Cita;
        Fecha = fecha;
        Hora = hora;
        Id_medico = id_medico;
        Especialidad = especialidad;
        Nombre_medico = nombre_medico;
    }
    //CONSTRUCTOR PARA UPDATE
    public TurnoDTO(Integer id, Integer id_Cita, LocalDate fecha, LocalTime hora, Integer id_medico) {
        Id = id;
        Id_Cita = id_Cita;
        Fecha = fecha;
        Hora = hora;
        Id_medico = id_medico;
    }
}
