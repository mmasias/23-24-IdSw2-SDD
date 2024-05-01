import java.util.Random;

public class Aspiradora {
    private int pasosRealizados;
    private int limpiezaRealizada;
    private CapacidadBasura capacidadBasura;
    private Bateria bateria;
    private Posicion posicion;
    private Habitacion habitacion;
    private int esperaRecarga;

    public Aspiradora(Bateria bateria) {
        this.pasosRealizados = 0;
        this.limpiezaRealizada = 0;
        this.bateria = bateria;
        this.posicion = new Posicion(0, 0);
        this.esperaRecarga = 0;
    }

    public Posicion getPosicion() {
        return posicion;
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

        if (nuevaX >= 0 && nuevaX < habitacion.ancho && nuevaY >= 0 && nuevaY < habitacion.largo) {
            if (!habitacion.muebles[nuevaX][nuevaY] && !bateria.estaDescargada()) {
                posicion.setX(nuevaX);
                posicion.setY(nuevaY);
                limpiarCasilla(habitacion, posicion);
                bateria.descargar();
                System.out.println("Nivel de bateria de la aspiradora: " + bateria.getNivelBateria());
                pasosRealizados++;
            } else{
                System.err.println("bateria agotada,  no se mueve.. entrando en recarga");
                esperaRecarga = 5;
                bateria.recargar();
            }
        }
    }

    private void limpiarCasilla(Habitacion habitacion, Posicion posicion) {
        if (habitacion.superficie[posicion.getX()][posicion.getY()].getNivelSuciedad() > 0) {
            habitacion.superficie[posicion.getX()][posicion.getY()].setNivelSuciedad(0); 
            limpiezaRealizada++;
            System.out.println("La aspiradora limpio la casilla en las coordenadas: (" + posicion.getX() + ", " + posicion.getY()+ ")");
        }
    }
}



