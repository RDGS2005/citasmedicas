package appointmentsApp.controllers;

import dataAccess.DTO.CitaDTO;

public class Cita {

    private int idCita;
    private int idPaciente;
    private String especialidad;
    private String doctor;
    private String fecha;
    private String hora;

    public Cita(int idCita, int idPaciente, String especialidad, String doctor, String fecha, String hora) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.especialidad = especialidad;
        this.doctor = doctor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getIdCita() { return idCita; }
    public int getIdPaciente() { return idPaciente; }
    public String getEspecialidad() { return especialidad; }
    public String getDoctor() { return doctor; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
}
