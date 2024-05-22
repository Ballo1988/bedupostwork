package modelo;

import java.io.Serializable;

public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;

    private String descripcion;
    private boolean realizada;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.realizada = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    @Override
    public String toString() {
        return descripcion + (realizada ? " [Realizada]" : " [Pendiente]");
    }
}
