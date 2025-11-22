package dataAccess.DTO;

import java.util.List;

public class PacienteDTO {
    public Integer Id;
    public String  Cedula;
    public String  Nombres;
    public String  Apellidos;
    public String  Sexo;
    public String  FechaNacimiento;
    public String  Direccion;
    public String  Nacionalidad;
    public String  Telefono;
    public String  Correo;
    public String  Afiliacion;
    public List<String> Grupo_prioritario;

    public PacienteDTO() {}
    //CONSTRUCTOR PARA READ/UPDATE
    public PacienteDTO(Integer id, String cedula, String nombres, String apellidos, String sexo, String fechaNacimiento, String direccion, String nacionalidad, String telefono, String correo, String afiliacion, List<String> grupo_prioritario)
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
        Grupo_prioritario = grupo_prioritario;
    }
    //CONSTRUCTOR PARA CREATE
    public PacienteDTO(String cedula, String nombres, String apellidos, String sexo, String fechaNacimiento, String direccion, String nacionalidad, String telefono, String correo, String afiliacion, List<String> grupo_prioritario)
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
        Grupo_prioritario = grupo_prioritario;
    }

    @Override
    public String toString() {
        return "PacienteDTO [Id=" + Id + ", Cedula=" + Cedula + ", Nombres=" + Nombres + ", Apellidos=" + Apellidos
                + ", Sexo=" + Sexo + ", FechaNacimiento=" + FechaNacimiento + ", Direccion=" + Direccion
                + ", Nacionalidad=" + Nacionalidad + ", Telefono=" + Telefono + ", Correo=" + Correo + ", Afiliacion="
                + Afiliacion + "]";
    }

}
