import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Especifique el largo y ancho de la habitación.");
        Dimension dimension = Dimension.obtenerDimension(scanner);
        
        System.out.println("Especifique la capacidad de basura de la aspiradora.");
        int capacidadBasura = Utils.obtenerEnteroValido(scanner);
        
        Habitacion habitacion = new Habitacion(dimension);
        Gestionador gestionador = new Gestionador(habitacion, capacidadBasura);
        gestionador.start();
        
        scanner.close();
    }
}
