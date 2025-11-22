package dataAccess.DTO;

import java.time.LocalTime;

public class MedicoDTO {
    public Integer Id;
    public String Cedula;
    public String Especializacion;
    public String Nombres;
    public String Apellidos;
    public LocalTime InicioJornada;
    public LocalTime FinJornada;

    public MedicoDTO(){};
    //CONSTRUCTOR PARA READ/UPDATE
    public MedicoDTO(Integer id, String cedula, String especializacion, String nombres, String apellidos, LocalTime inicioJornada, LocalTime finJornada) {
        Id = id;
        Cedula = cedula;
        Especializacion = especializacion;
        Nombres = nombres;
        Apellidos = apellidos;
        InicioJornada = inicioJornada;
        FinJornada = finJornada;
    }
    //CONSTRUCTOR PARA WRITE
    public MedicoDTO(String cedula, String especializacion, String nombres, String apellidos, LocalTime inicioJornada, LocalTime finJornada) {
        Cedula = cedula;
        Especializacion = especializacion;
        Nombres = nombres;
        Apellidos = apellidos;
        InicioJornada = inicioJornada;
        FinJornada = finJornada;
    }


}
