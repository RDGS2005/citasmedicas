package dataAccess.DTO;

import java.util.List;

public class DiagnosticoDTO {
    Integer Id;
    Integer Id_cita;
    String Sintomas;
    String Condicion;
    String Certeza;
    String Tratamiento;
    List<TratamientoDTO> Receta;

    public DiagnosticoDTO() {}
    //CONSTRUCTOR PARA READ
    public DiagnosticoDTO(Integer id, Integer id_cita, String sintomas, String condicion, String certeza, String tratamiento, List<TratamientoDTO> receta) {
        Id = id;
        Id_cita = id_cita;
        Sintomas = sintomas;
        Condicion = condicion;
        Certeza = certeza;
        Tratamiento = tratamiento;
        Receta = receta;
    }
    //CONSTRUCTOR PARA CREATE
    public DiagnosticoDTO(Integer id_cita, String sintomas, String condicion, String certeza, String tratamiento, List<TratamientoDTO> receta) {
        Id_cita = id_cita;
        Sintomas = sintomas;
        Condicion = condicion;
        Certeza = certeza;
        Tratamiento = tratamiento;
        Receta = receta;
    }
}
