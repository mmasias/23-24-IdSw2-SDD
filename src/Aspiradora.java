import java.util.Random;

public class Aspiradora {
    private int pasosRealizados;
    private int limpiezaRealizada;
    private CapacidadBasura capacidadBasura;
    private Bateria bateria;
    private Posicion posicion;

    public Aspiradora() {
        this.pasosRealizados = 0;
        this.limpiezaRealizada = 0;
        this.posicion = new Posicion(0, 0);
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void mover(Habitacion habitacion) {
        Random random = new Random();
        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;

        int nuevaX = posicion.getX() + dx;
        int nuevaY = posicion.getY() + dy;

        if (nuevaX >= 0 && nuevaX < habitacion.ancho && nuevaY >= 0 && nuevaY < habitacion.largo) {
            if (!habitacion.muebles[nuevaX][nuevaY]) {
                posicion.setX(nuevaX);
                posicion.setY(nuevaY);
                
                limpiarCasilla(habitacion,posicion);
            }
        }
        pasosRealizados++;
    }

    private void limpiarCasilla(Habitacion habitacion, Posicion posicion) {
        if (habitacion.superficie[posicion.getX()][posicion.getY()].getNivelSuciedad() > 0) {
            habitacion.superficie[posicion.getX()][posicion.getY()].setNivelSuciedad(0); 
            limpiezaRealizada++; 
        }
    }
}



