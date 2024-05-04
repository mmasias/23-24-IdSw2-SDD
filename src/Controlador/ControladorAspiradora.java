package Controlador;

import java.util.Random;

import Modelo.Aspiradora;
import Modelo.Habitacion;
import Modelo.Posicion;
import Vista.VistaAspiradora;

public class ControladorAspiradora {

    private Aspiradora aspiradora;

    public ControladorAspiradora(Aspiradora aspiradora) {
        this.aspiradora = aspiradora;
    }

    public void mover(Habitacion habitacion) {
        Random random = new Random();

        if (aspiradora.getEsperaRecarga() > 0) {
            aspiradora.setEsperaRecarga(aspiradora.getEsperaRecarga() - 1);
            return;
        }

        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;

        int nuevaX = aspiradora.getPosicion().getX() + dx;
        int nuevaY = aspiradora.getPosicion().getY() + dy;

        if (nuevaX >= 0 && nuevaX < habitacion.getDimension().getAncho() &&
                nuevaY >= 0 && nuevaY < habitacion.getDimension().getLargo()) {
            if (!habitacion.getMuebles()[nuevaX][nuevaY] && !aspiradora.getBateria().estaDescargada()) {
                aspiradora.getPosicion().setX(nuevaX);
                aspiradora.getPosicion().setY(nuevaY);
                limpiarCasilla(habitacion, aspiradora.getPosicion());
                aspiradora.getBateria().descargar();
                aspiradora.getCapacidadBasura().incrementar();
                if (aspiradora.getCapacidadBasura().estaLlena()) {
                    VistaAspiradora.bolsaDeBasuraLlena();
                }
                VistaAspiradora.nivelDeBateria(aspiradora.getBateria().getNivelBateria());
                aspiradora.setPasosRealizados(aspiradora.getPasosRealizados() + 1);
            } else {
                VistaAspiradora.bateriaAgotada();
                aspiradora.setEsperaRecarga(5);
                aspiradora.getBateria().recargar();
            }
        }
    }

    private void limpiarCasilla(Habitacion habitacion, Posicion posicion) {
        if (habitacion.getSuperficie()[posicion.getX()][posicion.getY()].getNivelSuciedad() > 0) {
            habitacion.getSuperficie()[posicion.getX()][posicion.getY()].setNivelSuciedad(0);
            aspiradora.setLimpiezaRealizada(aspiradora.getLimpiezaRealizada() + 1);
            VistaAspiradora.limpiarCasilla(aspiradora.getPosicion().getX(), aspiradora.getPosicion().getY());
        }
    }
}