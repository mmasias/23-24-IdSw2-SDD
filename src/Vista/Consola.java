package Vista;

import java.util.Scanner;

public class Consola {

    private Scanner scanner;

    public Consola(){
        this.scanner = new Scanner(System.in);
    }

    public int obtenerLargo(){
        System.out.println("Especifique el largo y ancho de la habitación.");
        System.out.println("Largo:");
        int largo = Utils.obtenerEnteroValido(this.scanner);
        return largo;
    }

    public int obtenerAncho(){
        System.out.println("Ancho:");
        int ancho = Utils.obtenerEnteroValido(this.scanner);
        return ancho;
    }

    public int obtenerCapacidadBasura(){
        System.out.println("Especifique la capacidad de basura de la aspiradora.");
        int capacidadBasura = Utils.obtenerEnteroValido(scanner);
        return capacidadBasura;
    }

    public void cerrarScanner(){
        this.scanner.close();
    }
}
