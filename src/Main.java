
public class Main {
    public static void main(String[] args) {
        Lector lector = new Lector();
        Menu menu = new Menu();
        System.out.print(MailValidator.isValidEmail(lector.readString())+ "\n");
        ListaTareas.cargarEstado();
        menu.mostrarMenu();
    }
}
