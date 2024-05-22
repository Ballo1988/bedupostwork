package modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListadeTareas implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private List<Tarea> tareas;

    public ListadeTareas(String nombre) {
        this.nombre = nombre;
        this.tareas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }
}
