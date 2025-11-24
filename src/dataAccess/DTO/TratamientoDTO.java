package dataAccess.DTO;

public class TratamientoDTO {
    public Integer Id_diagnostico;
    public Integer Id_mediamento;
    public String Nombre_medicamento;
    public Float Dosis_mg;
    public Integer Frecuencia_horas;
    public Integer Tiempo_dias;

    public TratamientoDTO() {}
    //CONSTRUCTOR PARA WRITE
    public TratamientoDTO(Integer id_diagnostico, Integer id_mediamento, Float dosis_mg, Integer frecuencia_horas, Integer tiempo_dias) {
        Id_diagnostico = id_diagnostico;
        Id_mediamento = id_mediamento;
        Dosis_mg = dosis_mg;
        Frecuencia_horas = frecuencia_horas;
        Tiempo_dias = tiempo_dias;
    }

    @Override
    public String toString() {
        return Nombre_medicamento + '(' +
                Dosis_mg + "mg cada" +
                Frecuencia_horas + " horas, por" +
                Tiempo_dias + ')';
    }
}
