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

    public void mover(Habitacion habitacion) throws InterruptedException {
        Random random = new Random();
        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;

        int nuevaX = posicion.getX() + dx;
        int nuevaY = posicion.getY() + dy;

        if (nuevaX >= 0 && nuevaX < habitacion.ancho && nuevaY >= 0 && nuevaY < habitacion.largo) {
            if (!habitacion.muebles[nuevaX][nuevaY]) {
                posicion.setX(nuevaX);
                posicion.setY(nuevaY);
                limpiarCasilla(habitacion, nuevaX, nuevaY); 
                habitacion.imprimir(this); 
                Thread.sleep(1000); 
            }
        }
        pasosRealizados++;
    }

    private void limpiarCasilla(Habitacion habitacion, int x, int y) {
        if (habitacion.superficie[x][y].getNivelSuciedad() > 0) {
            habitacion.superficie[x][y].setNivelSuciedad(0); 
            limpiezaRealizada++; 
        }
    }
}



