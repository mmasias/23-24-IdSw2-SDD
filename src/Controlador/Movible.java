package Controlador;

import java.util.Random;

import Modelo.Habitacion;
import Modelo.Posicion;

public abstract class Movible {
    public void mover(Habitacion habitacion){
        Random random = new Random();

        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;

        int nuevaX = getPosicion().getX() + dx;
        int nuevaY = getPosicion().getY() + dy;

        if (nuevaX >= 0 && nuevaX < habitacion.getDimension().getAncho() &&
                nuevaY >= 0 && nuevaY < habitacion.getDimension().getLargo()) {
            realizarAccion(habitacion, nuevaX, nuevaY);
        }
    }

    protected abstract void realizarAccion(Habitacion habitacion, int nuevaX, int nuevaY);

    protected abstract Posicion getPosicion();
}
