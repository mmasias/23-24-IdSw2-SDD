package Vista;

public class VistaAspiradora {
    public static void bolsaDeBasuraLlena() {
        System.out.println("¡La bolsa de basura de la aspiradora está llena!");
    }

    public static void bolsaDeBasuraVaciada() {
        System.out.println("¡La bolsa de basura de la aspiradora ha sido vaciada!");
    }

    public static void nivelDeBateria(int nivel) {
        System.out.println("Nivel de bateria de la aspiradora: " + nivel);
    }

    public static void bateriaAgotada() {
        System.err.println("Bateria agotada, no se mueve. Entrando en recarga");
    }

    public static void limpiarCasilla(int x, int y) {
        System.out.println("La aspiradora limpió la casilla en las coordenadas: (" + x + ", "
                + y + ")");
    }
}
