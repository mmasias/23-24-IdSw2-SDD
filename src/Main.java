import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dimension dimension = Dimension.obtenerDimension(scanner);
        Habitacion habitacion = new Habitacion(dimension);
        Gestionador gestionador = new Gestionador(habitacion);
        gestionador.start();
        
        scanner.close();
    }
}
