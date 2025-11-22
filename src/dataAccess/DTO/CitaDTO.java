package dataAccess.DTO;

import java.util.List;

public class CitaDTO {
    Integer Id_cita;
    Integer Id_turno;
    TurnoDTO Turno;
    Integer Id_referencia;
    Integer Id_contarreferencia;
    Integer Id_paciente;
    PacienteDTO Paciente;
    List<DiagnosticoDTO> Diagnosticos;
    Boolean Cancelada;

    public CitaDTO() {}
    //CONSTRUCTOR PARA READ
    public CitaDTO(Integer id_cita, Integer id_turno, TurnoDTO turno, Integer id_referencia, Integer id_contarreferencia, Integer id_Paciente, PacienteDTO paciente, List<DiagnosticoDTO> diagnosticos, Boolean cancelada) {
        Id_cita = id_cita;
        Id_turno = id_turno;
        Turno = turno;
        Id_referencia = id_referencia;
        Id_contarreferencia = id_contarreferencia;
        Id_paciente = id_Paciente;
        Paciente = paciente;
        Diagnosticos = diagnosticos;
        Cancelada = cancelada;
    }
    //CONSTRUCTOR PARA CREATE
    public CitaDTO(Integer id_turno, Integer id_referencia, Integer id_contarreferencia, Integer id_Paciente) {
        Id_turno = id_turno;
        Id_referencia = id_referencia;
        Id_contarreferencia = id_contarreferencia;
        Id_paciente = id_Paciente;
        Cancelada = false;
    }
    //CONSTRUCTOR PARA CREATE/UPDATE
    public CitaDTO(TurnoDTO turno, PacienteDTO paciente, Integer id_contarreferencia, Integer id_referencia, Boolean cancelada) {
        Turno = turno;
        Paciente = paciente;
        Id_contarreferencia = id_contarreferencia;
        Id_referencia = id_referencia;
        Cancelada = cancelada;
    }
}
