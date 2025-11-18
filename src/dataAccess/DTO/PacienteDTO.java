package dataAccess.DTO;

public class PacienteDTO {
    private Integer Id;
    private String  Cedula;
    private String  Nombres;
    private String  Apellidos;
    private String  Sexo;
    private String  FechaNacimiento;
    private String  Direccion;
    private String  Nacionalidad;
    private String  Telefono;
    private String  Correo;
    private String  Afiliacion;

    public PacienteDTO() {}

    public PacienteDTO(Integer id, String cedula, String nombres, String apellidos, String sexo, String fechaNacimiento, String direccion, String nacionalidad, String telefono, String correo, String afiliacion)
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

    @Override
    public String toString() {
        return "PacienteDTO [Id=" + Id + ", Cedula=" + Cedula + ", Nombres=" + Nombres + ", Apellidos=" + Apellidos
                + ", Sexo=" + Sexo + ", FechaNacimiento=" + FechaNacimiento + ", Direccion=" + Direccion
                + ", Nacionalidad=" + Nacionalidad + ", Telefono=" + Telefono + ", Correo=" + Correo + ", Afiliacion="
                + Afiliacion + "]";
    }

}
