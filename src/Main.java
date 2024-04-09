import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Especifica el largo y ancho de la habitación.");
        int largo = Utils.obtenerEnteroValido(scanner, "Largo:");
        int ancho = Utils.obtenerEnteroValido(scanner, "Ancho:");

        Gato gato = new Gato(0, 0);
        Habitacion habitacion = new Habitacion(ancho, largo);
        Aspiradora aspiradora = new Aspiradora();

        for (int i = 0; i < 20; i++) {
            try {
                aspiradora.mover(habitacion);
                gato.mover(habitacion);
                habitacion.imprimir(aspiradora, gato); 
            } catch (InterruptedException e) {
                System.out.println("Error al pausar la ejecución: " + e.getMessage());
            }
        }
        

        scanner.close();
    }

}

