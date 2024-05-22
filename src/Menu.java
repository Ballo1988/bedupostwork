public class Menu {
    public String[] showOptions(){
        String[] options = {
                "1. Crear nueva lista de tareas",
                "2. Ver lista de tareas",
                "3. Ver tareas de lista",
                "4. Actualizar lista de tareas",
                "5. Eliminar lista de tareas",
                "6. Salir"
        };
        for (String option : options) {
            System.out.println(option);
        }
        return options;
    }
    public String[] showTaskOptions(){
        String[] options = {
                "1. Agregar nueva tarea",
                "2. Eliminar tarea",
                "3. Marcar tarea",
                "4. Regresar"
        };
        for (String option : options) {
            System.out.println(option);
        }
        return options;
    }
    public void mostrarMenu(){
        showOptions();
        Lector lector = new Lector();
        ListaTareas.getOptionMessage(lector.readInt());


    }
}
