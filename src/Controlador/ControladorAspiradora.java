package Controlador;

import java.util.Random;

import Modelo.Aspiradora;
import Modelo.Habitacion;
import Modelo.Posicion;
import Vista.VistaAspiradora;

public class ControladorAspiradora extends Movible {

    private Aspiradora aspiradora;

    public ControladorAspiradora(Aspiradora aspiradora) {
        this.aspiradora = aspiradora;
    }

    @Override
    protected void realizarAccion(Habitacion habitacion, int nuevaX, int nuevaY) {
        if (!habitacion.getMuebles()[nuevaX][nuevaY] && !aspiradora.getBateria().estaDescargada()) {
            aspiradora.getPosicion().setX(nuevaX);
            aspiradora.getPosicion().setY(nuevaY);

            limpiarCasilla(habitacion, aspiradora.getPosicion());
            aspiradora.getBateria().descargar();
            aspiradora.getCapacidadBasura().incrementar();

            if (aspiradora.getCapacidadBasura().estaLlena()) {
                VistaAspiradora.bolsaDeBasuraLlena();
                aspiradora.getCapacidadBasura().vaciar();
                VistaAspiradora.bolsaDeBasuraVaciada();
            }

            VistaAspiradora.nivelDeBateria(aspiradora.getBateria().getNivelBateria());
            aspiradora.setPasosRealizados(aspiradora.getPasosRealizados() + 1);

        } else if (aspiradora.getBateria().estaDescargada()) {
            VistaAspiradora.bateriaAgotada();
            aspiradora.getBateria().recargar();
        }
    }

    @Override
    protected Posicion getPosicion() {
        return aspiradora.getPosicion();
    }

    private void limpiarCasilla(Habitacion habitacion, Posicion posicion) {

        Random random = new Random();
        int nivelSuciedad = random.nextInt(5);

        if (habitacion.getSuperficie()[posicion.getX()][posicion.getY()].getNivelSuciedad() > 0) {
            setNivelSuciedadPosicion(habitacion, posicion, nivelSuciedad);
            aspiradora.setLimpiezaRealizada(aspiradora.getLimpiezaRealizada() + 1);
            VistaAspiradora.limpiarCasilla(aspiradora.getPosicion().getX(), aspiradora.getPosicion().getY());
        }
    }

    private void setNivelSuciedadPosicion(Habitacion habitacion, Posicion posicion, int nivelSuciedad) {
        habitacion.getSuperficie()[posicion.getX()][posicion.getY()].setNivelSuciedad(0);
    }

}