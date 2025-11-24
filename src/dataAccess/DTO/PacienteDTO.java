package dataAccess.DTO;

import java.time.LocalDate;
import java.util.List;

public class PacienteDTO {
    public Integer Id;
    public String  Cedula;
    public String  Nombres;
    public String  Apellidos;
    public String  Sexo;
    public LocalDate FechaNacimiento;
    public String  Direccion;
    public String  Nacionalidad;
    public String  Telefono;
    public String  Correo;
    public String  Afiliacion;

    public PacienteDTO() {}
    //CONSTRUCTOR PARA READ/UPDATE
    public PacienteDTO(Integer id, String cedula, String nombres, String apellidos, String sexo, LocalDate fechaNacimiento, String direccion, String nacionalidad, String telefono, String correo, String afiliacion)
    {
        Id = id;
        Cedula = cedula;
        Nombres = nombres;
        Apellidos = apellidos;
        Sexo = sexo;
        FechaNacimiento = fechaNacimiento;
        Direccion = direccion;
        Nacionalidad = nacionalidad;
        Telefono = telefono;
        Correo = correo;
        Afiliacion = afiliacion;
    }
    //CONSTRUCTOR PARA CREATE
    public PacienteDTO(String cedula, String nombres, String apellidos, String sexo, LocalDate fechaNacimiento, String direccion, String nacionalidad, String telefono, String correo, String afiliacion)
    {
        Cedula = cedula;
        Nombres = nombres;
        Apellidos = apellidos;
        Sexo = sexo;
        FechaNacimiento = fechaNacimiento;
        Direccion = direccion;
        Nacionalidad = nacionalidad;
        Telefono = telefono;
        Correo = correo;
        Afiliacion = afiliacion;
    }
}
