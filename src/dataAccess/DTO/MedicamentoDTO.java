package dataAccess.DTO;

public class MedicamentoDTO {
    public Integer Id;
    public String Nombre;
    public String PrincipioActivo;

    public MedicamentoDTO(){};
    //CONSTRUCTOR PARA READ/UPDATE
    public MedicamentoDTO(Integer id, String nombre, String principio)
    {
        Id = id;
        Nombre = nombre;
        PrincipioActivo = principio;
    }
    //CONSTRUCTOR PARA CREATE
    public MedicamentoDTO(String nombre, String principio)
    {
        Nombre = nombre;
        PrincipioActivo = principio;
    }
}
