import java.util.Scanner;

public class Main {

     public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Especifica el largo y ancho de la habitación.");
          int largo = Utils.obtenerEnteroValido(scanner, "Largo:");
          int ancho = Utils.obtenerEnteroValido(scanner, "Ancho:");

          Gato gato = new Gato(0,0);
          Habitacion habitacion = new Habitacion(ancho, largo);
          Aspiradora aspiradora = new Aspiradora();

          for (int i = 0; i < 20; i++) {
               aspiradora.mover(habitacion);
               habitacion.imprimir(aspiradora);
          }

          scanner.close();
     }
}