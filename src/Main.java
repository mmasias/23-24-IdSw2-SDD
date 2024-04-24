import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Especifica el largo y ancho de la habitación.");
        int largo = Utils.obtenerEnteroValido(scanner, "Largo:");
        int ancho = Utils.obtenerEnteroValido(scanner, "Ancho:");

        Habitacion habitacion = new Habitacion(ancho, largo);

        Gestionador gestionador = new Gestionador(habitacion);
        gestionador.start();
        
        scanner.close();
    }

}

