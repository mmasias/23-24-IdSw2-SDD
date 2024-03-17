import java.util.Scanner;

public class Main {

     public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Especifica el largo y ancho de la habitación.");
          int largo = Utils.obtenerEnteroValido(scanner, "Largo:");
          int ancho = Utils.obtenerEnteroValido(scanner, "Ancho:");          

          Gato gato = new Gato(0,0);
          Habitacion habitacion = new Habitacion(ancho, largo);
          habitacion.imprimir();
          scanner.close();
     }
}