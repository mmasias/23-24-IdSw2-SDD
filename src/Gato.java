import java.util.Random;

public class Gato {
    private Posicion posicion;
    private int pasosRealizados;

    public Gato(int x, int y) {
        this.posicion = new Posicion(x, y);
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void mover(Habitacion habitacion) throws InterruptedException {
        Random random = new Random();
        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;

        if (Math.abs(dx) + Math.abs(dy) == 1) {
            int nuevaX = posicion.getX() + dx;
            int nuevaY = posicion.getY() + dy;

            if (nuevaX >= 0 && nuevaX < habitacion.ancho && nuevaY >= 0 && nuevaY < habitacion.largo) {
                if (!habitacion.muebles[nuevaX][nuevaY]) {
                    posicion.setX(nuevaX);
                    posicion.setY(nuevaY);
                    Thread.sleep(1000);
                }
            }
        }
        pasosRealizados++;
    }
}
