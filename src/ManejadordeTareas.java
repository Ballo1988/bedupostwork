import modelo.ListadeTareas;

import modelo.Tarea;

import java.util.List;

public class ManejadordeTareas {

    public void agregarTarea(ListadeTareas lista, String descripcion) {
        Tarea nuevaTarea = new Tarea(descripcion);
        lista.getTareas().add(nuevaTarea);
        System.out.println("Tarea agregada: " + descripcion);
    }

    public void eliminarTarea(ListadeTareas lista, int indice) {
        List<Tarea> tareas = lista.getTareas();
        if (indice >= 0 && indice < tareas.size()) {
            Tarea tareaEliminada = tareas.remove(indice);
            System.out.println("Tarea eliminada: " + tareaEliminada.getDescripcion());
        } else {
            System.out.println("Índice no válido.");
        }
    }

    public void marcarTareaComoRealizada(ListadeTareas lista, int indice) {
        List<Tarea> tareas = lista.getTareas();
        if (indice >= 0 && indice < tareas.size()) {
            Tarea tarea = tareas.get(indice);
            tarea.setRealizada(true);
            System.out.println("Tarea marcada como realizada: " + tarea.getDescripcion());
        } else {
            System.out.println("Índice no válido.");
        }
    }
}

