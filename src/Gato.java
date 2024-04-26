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

    public void mover(Habitacion habitacion) {
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
                    ensuciarCasilla(habitacion, posicion); 
                }
            }
        }
        pasosRealizados++;
    }

    private void ensuciarCasilla(Habitacion habitacion, Posicion posicion) {
        Random random = new Random();
        int nivelSuciedad = random.nextInt(5); 
        if (habitacion.superficie[posicion.getX()][posicion.getY()].getNivelSuciedad() < nivelSuciedad) {
            habitacion.superficie[posicion.getX()][posicion.getY()].setNivelSuciedad(nivelSuciedad); 
            System.out.println("El gato ensució la casilla en las coordenadas: (" + posicion.getX() + ", " + posicion.getY() + ") con nivel de suciedad: " + nivelSuciedad);
        }
    }
}