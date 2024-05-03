import java.util.Random;

public class Aspiradora {
    private int pasosRealizados;
    private int limpiezaRealizada;
    private CapacidadBasura capacidadBasura;
    private Bateria bateria;
    private Posicion posicion;
    private int esperaRecarga;

    public Aspiradora(Bateria bateria, int capacidadBasura) {
        this.pasosRealizados = 0;
        this.limpiezaRealizada = 0;
        this.bateria = bateria;
        this.capacidadBasura = new CapacidadBasura(capacidadBasura);
        this.posicion = new Posicion(0, 0);
        this.esperaRecarga = 0;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public int getPasosRealizados() {
        return pasosRealizados;
    }

    public int getLimpiezaRealizada() {
        return limpiezaRealizada;
    }

    public void mover(Habitacion habitacion) {
        Random random = new Random();

        if (esperaRecarga > 0) {
            esperaRecarga--;
            return;
        }

        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;

        int nuevaX = posicion.getX() + dx;
        int nuevaY = posicion.getY() + dy;

        if (nuevaX >= 0 && nuevaX < habitacion.getDimension().getAncho() &&
            nuevaY >= 0 && nuevaY < habitacion.getDimension().getLargo()) {
            if (!habitacion.getMuebles()[nuevaX][nuevaY] && !bateria.estaDescargada()) {
                posicion.setX(nuevaX);
                posicion.setY(nuevaY);
                limpiarCasilla(habitacion, posicion);
                bateria.descargar();
                capacidadBasura.incrementar();
                System.out.println("Nivel de bateria de la aspiradora: " + bateria.getNivelBateria());
                pasosRealizados++;
            } else {
                System.err.println("Bateria agotada, no se mueve. Entrando en recarga");
                esperaRecarga = 5;
                bateria.recargar();
            }
        }
    }

    private void limpiarCasilla(Habitacion habitacion, Posicion posicion) {
        if (habitacion.getSuperficie()[posicion.getX()][posicion.getY()].getNivelSuciedad() > 0) {
            habitacion.getSuperficie()[posicion.getX()][posicion.getY()].setNivelSuciedad(0);
            limpiezaRealizada++;
            System.out.println("La aspiradora limpió la casilla en las coordenadas: (" + posicion.getX() + ", " + posicion.getY() + ")");
        }
    }
}
