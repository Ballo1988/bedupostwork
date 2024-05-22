import modelo.ListadeTareas;
import modelo.Tarea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaTareas implements Serializable {
    private static final long serialVersionUID = 1L;

    private static List<ListadeTareas> listas = new ArrayList<>();
    static Menu menu = new Menu();
    static Lector lector = new Lector();
    static ManejadordeTareas manejadorTareas = new ManejadordeTareas();

    public static void createNewTaskList(ListadeTareas lista) {
        System.out.printf("Crear nueva lista de tareas: %s%n", lista.getNombre());
        listas.add(lista);
    }

    public static void deleteTaskList(int pos) {
        System.out.println("Eliminar lista de tareas");
        if (pos >= 0 && pos < listas.size()) {
            System.out.printf("Se eliminó la lista: %s%n", listas.get(pos).getNombre());
            listas.remove(pos);
        } else {
            System.out.println("Error: No existe el elemento");
        }
    }

    public static String viewTasksList(int pos) {
        if (pos >= 0 && pos < listas.size()) {
            return listas.get(pos).getNombre();
        } else {
            System.out.println("Error: No existe el elemento");
            return null;
        }
    }

    public static void viewTasksInList(int pos) {
        if (pos >= 0 && pos < listas.size()) {
            ListadeTareas lista = listas.get(pos);
            System.out.printf("Tareas en la lista %s:%n", lista.getNombre());
            List<Tarea> tareas = lista.getTareas();
            for (int i = 0; i < tareas.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, tareas.get(i).toString());
            }
        } else {
            System.out.println("Error: No existe el elemento");
        }
    }

    public static void updateTaskList(int pos) {
        if (pos >= 0 && pos < listas.size()) {
            ListadeTareas lista = listas.get(pos);
            menu.showTaskOptions();
            while (true) {
                int option = lector.readInt();
                switch (option) {
                    case 1:
                        System.out.println("Ingrese la descripción de la nueva tarea:");
                        String descripcion = lector.readString();
                        manejadorTareas.agregarTarea(lista, descripcion);
                        break;
                    case 2:
                        System.out.println("Ingrese el índice de la tarea a eliminar:");
                        int indiceEliminar = lector.readInt();
                        manejadorTareas.eliminarTarea(lista, indiceEliminar);
                        break;
                    case 3:
                        System.out.println("Ingrese el índice de la tarea a marcar como realizada:");
                        int indiceMarcar = lector.readInt();
                        manejadorTareas.marcarTareaComoRealizada(lista, indiceMarcar);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
                menu.showTaskOptions();
            }
        } else {
            System.out.println("Error: No existe el elemento");
        }
    }

    public static String getOptionMessage(int option) {
        String str = "";
        switch (option) {
            case 1:
                String name = lector.readString();
                ListadeTareas listadeTareas = new ListadeTareas(name);
                createNewTaskList(listadeTareas);
                break;
            case 2:
                System.out.println(viewTasksList(lector.readInt()));
                break;
            case 3:
                viewTasksInList(lector.readInt());
                break;
            case 4:
                System.out.println("Ingrese el índice de la lista a gestionar:");
                int pos = lector.readInt();
                updateTaskList(pos);
                break;
            case 5:
                deleteTaskList(lector.readInt());
                break;
            case 6:
                guardarEstado();
                System.exit(0);
                break;
            default:
                str = "Opción inválida";
        }
        menu.mostrarMenu();
        return str;
    }

    public static void guardarEstado() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listasTareas.ser"))) {
            oos.writeObject(listas);
            System.out.println("Estado guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el estado: " + e.getMessage());
        }
    }

    public static void cargarEstado() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("listasTareas.ser"))) {
            listas = (List<ListadeTareas>) ois.readObject();
            System.out.println("Estado cargado correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el estado: " + e.getMessage());
        }
    }
}
