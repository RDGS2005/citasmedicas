package appointmentsApp.controllers;

public class Medicamento {
    private String descripcion;
    private String principioActivo;

    public Medicamento(String descripcion, String principioActivo) {
        this.descripcion = descripcion;
        this.principioActivo = principioActivo;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }
}
