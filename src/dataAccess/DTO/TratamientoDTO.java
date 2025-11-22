package dataAccess.DTO;

public class TratamientoDTO {
    Integer Id;
    Integer Id_diagnostico;
    Integer Id_mediamento;
    String Nombre_medicamento;
    Float Dosis_mg;
    Integer Frecuencia_horas;
    Integer Tiempo_dias;

    public TratamientoDTO() {}
    //CONSTRUCTOR PARA READ
    public TratamientoDTO(Integer tiempo_dias, Integer frecuencia_horas, Float dosis_mg, String nombre_medicamento, Integer id_mediamento, Integer id_diagnostico, Integer id) {
        Tiempo_dias = tiempo_dias;
        Frecuencia_horas = frecuencia_horas;
        Dosis_mg = dosis_mg;
        Nombre_medicamento = nombre_medicamento;
        Id_mediamento = id_mediamento;
        Id_diagnostico = id_diagnostico;
        Id = id;
    }
    //CONSTRUCTOR PARA WRITE
    public TratamientoDTO(Integer id_diagnostico, Integer id_mediamento, Float dosis_mg, Integer frecuencia_horas, Integer tiempo_dias) {
        Id_diagnostico = id_diagnostico;
        Id_mediamento = id_mediamento;
        Dosis_mg = dosis_mg;
        Frecuencia_horas = frecuencia_horas;
        Tiempo_dias = tiempo_dias;
    }
    //CONSTRUCTOR PARA UPDATE
    public TratamientoDTO(Integer id, Integer id_diagnostico, Integer id_mediamento, Float dosis_mg, Integer frecuencia_horas, Integer tiempo_dias) {
        Id = id;
        Id_diagnostico = id_diagnostico;
        Id_mediamento = id_mediamento;
        Dosis_mg = dosis_mg;
        Frecuencia_horas = frecuencia_horas;
        Tiempo_dias = tiempo_dias;
    }
}
