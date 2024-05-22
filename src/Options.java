public class Options {

    public String selectOption(short option) {
        String str = "";
        switch (option) {
            case 0:
                System.out.println("1. Crear nueva lista de tareas" + "\n" + "En construcción");
                str = "Crear nueva lista de tareas";
                break;
            case 1:
                System.out.println("2. Ver lista de tareas" + "\n" + "En construcción");
                str = "Ver lista de tareas";
                break;
            case 2:
                System.out.println("3. Ver tareas de lista" + "\n" + "En construcción");
                str = "Ver tareas de lista";
                break;
            case 3:
                System.out.println("4. Actualizar lista de tareas" + "\n" + "En construcción");
                str = "Actualizar lista de tareas";
                break;
            case 4:
                System.out.println("5. Eliminar lista de tareas" + "\n" + "En construcción");
                str = "Eliminar lista de tareas";
                break;
            default:
                System.out.println("Opción inválida");
        }
    return str;
    }

}
