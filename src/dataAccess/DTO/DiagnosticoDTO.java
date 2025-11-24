package dataAccess.DTO;

import java.util.List;

public class DiagnosticoDTO {
    public Integer Id;
    public Integer Id_cita;
    public String Sintomas;
    public String Condicion;
    public String Certeza;
    public String Tratamiento;

    public DiagnosticoDTO() {}
    //CONSTRUCTOR PARA READ
    public DiagnosticoDTO(Integer id, Integer id_cita, String sintomas, String condicion, String certeza, String tratamiento) {
        Id = id;
        Id_cita = id_cita;
        Sintomas = sintomas;
        Condicion = condicion;
        Certeza = certeza;
        Tratamiento = tratamiento;
    }
    //CONSTRUCTOR PARA CREATE
    public DiagnosticoDTO(Integer id_cita, String sintomas, String condicion, String certeza, String tratamiento) {
        Id_cita = id_cita;
        Sintomas = sintomas;
        Condicion = condicion;
        Certeza = certeza;
        Tratamiento = tratamiento;
    }
}
