package Controlador;

import java.util.Random;

import Modelo.Gato;
import Modelo.Habitacion;
import Vista.VistaGato;

public class ControladorGato {
    private Gato gato; 
    
    public ControladorGato(Gato gato) {
        this.gato = gato;
    }
    public void mover(Habitacion habitacion) {
        Random random = new Random();
        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;

        if (Math.abs(dx) + Math.abs(dy) == 1) {
            int nuevaX = gato.getPosicion().getX() + dx;
            int nuevaY = gato.getPosicion().getY() + dy;

            if (nuevaX >= 0 && nuevaX < habitacion.getDimension().getAncho() &&
                nuevaY >= 0 && nuevaY < habitacion.getDimension().getLargo()) {
                if (!habitacion.getMuebles()[nuevaX][nuevaY]) {
                    gato.getPosicion().setX(nuevaX);
                    gato.getPosicion().setY(nuevaY);
                    ensuciarCasilla(habitacion); 
                }
            }
        }
    }

    private void ensuciarCasilla(Habitacion habitacion) {
        Random random = new Random();
        int nivelSuciedad = random.nextInt(5); 
        if (habitacion.getSuperficie()[gato.getPosicion().getX()][gato.getPosicion().getY()].getNivelSuciedad() < nivelSuciedad) {
            habitacion.getSuperficie()[gato.getPosicion().getX()][gato.getPosicion().getY()].setNivelSuciedad(nivelSuciedad); 
            VistaGato.ensuciarCasilla(gato.getPosicion().getX(), gato.getPosicion().getY(), nivelSuciedad);
        }
    }
}
