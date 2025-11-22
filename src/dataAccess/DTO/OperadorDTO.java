package dataAccess.DTO;

public class OperadorDTO {
    Integer Id;
    String Cedula;
    String Nombres;
    String Apellidos;
    String Telefono;
    String Correo;

    public OperadorDTO() {}
    //CONSTRUCTOR PARA READ/UPDATE
    public OperadorDTO(Integer id, String cedula, String nombres, String apellidos, String telefono, String correo) {
        Id = id;
        Cedula = cedula;
        Nombres = nombres;
        Apellidos = apellidos;
        Telefono = telefono;
        Correo = correo;
    }
    //CONSTRUCTOR PARA CREATE
    public OperadorDTO(String cedula, String nombres, String apellidos, String telefono, String correo) {
        Cedula = cedula;
        Nombres = nombres;
        Apellidos = apellidos;
        Telefono = telefono;
        Correo = correo;
    }


}
