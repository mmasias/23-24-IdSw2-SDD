package Controlador;

import java.util.Random;

import Modelo.Gato;
import Modelo.Habitacion;
import Modelo.Posicion;
import Vista.VistaGato;

public class ControladorGato extends Movible{
    private Gato gato;
    
    public ControladorGato(Gato gato) {
        this.gato = gato;
    }

    @Override
    protected void realizarAccion(Habitacion habitacion, int nuevaX, int nuevaY) {
        if (!habitacion.getMuebles()[nuevaX][nuevaY]) {
            gato.getPosicion().setX(nuevaX);
            gato.getPosicion().setY(nuevaY);
            ensuciarCasilla(habitacion);
        }
    }

    @Override
    protected Posicion getPosicion() {
        return gato.getPosicion();
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
