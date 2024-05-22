import java.util.Scanner;

public class Lector {
    private static final Scanner scanner = new Scanner(System.in);

    public String readString() {
        System.out.println("Escriba el nombre: ");
        return scanner.nextLine();
    }

    public int readInt() {
        System.out.println("Digite un valor: ");
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return value;
    }
}

