package dataAccess.DTO;

import java.util.List;

public class CitaDTO {
    public Integer Id_cita;
    public Integer Id_turno;
    public Integer Id_referencia;
    public Integer Id_contarreferencia;
    public Integer Id_paciente;
    public Boolean Cancelada;
    public Boolean Atendida;

    public CitaDTO() {}
    //CONSTRUCTOR PARA READ
    public CitaDTO(Integer id_cita, Integer id_turno, Integer id_referencia, Integer id_contarreferencia, Integer id_Paciente, Boolean cancelada, Boolean atendida) {
        Id_cita = id_cita;
        Id_turno = id_turno;
        Id_referencia = id_referencia;
        Id_contarreferencia = id_contarreferencia;
        Id_paciente = id_Paciente;
        Cancelada = cancelada;
        Atendida = atendida;
    }
    //CONSTRUCTOR PARA CREATE
    public CitaDTO(Integer id_turno, Integer id_referencia, Integer id_contarreferencia, Integer id_Paciente) {
        Id_turno = id_turno;
        Id_referencia = id_referencia;
        Id_contarreferencia = id_contarreferencia;
        Id_paciente = id_Paciente;
        Cancelada = false;
        Atendida = false;
    }
    //CONSTRUCTOR PARA CREATE/UPDATE
    public CitaDTO(Integer id_contarreferencia, Integer id_referencia, Boolean cancelada) {

        Id_contarreferencia = id_contarreferencia;
        Id_referencia = id_referencia;
        Cancelada = cancelada;
    }
}
