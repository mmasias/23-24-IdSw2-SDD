import java.util.Scanner;
public class Dimension {
    private int largo;
    private int ancho;

    public Dimension(int largo, int ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public int getAncho() {
        return ancho;
    }
    public static Dimension obtenerDimension(Scanner scanner) {
        System.out.println("Largo:");
        int largo = Utils.obtenerEnteroValido(scanner);
        System.out.println("Ancho:");
        int ancho = Utils.obtenerEnteroValido(scanner);
        return new Dimension(largo, ancho);
    }
}