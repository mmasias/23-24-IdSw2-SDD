package Controlador;

import Modelo.Aspiradora;
import Modelo.Bateria;
import Modelo.Dimension;
import Modelo.Gato;
import Modelo.Habitacion;
import Vista.VistaHabitacion;

public class ControladorHabitacion {
    private Habitacion habitacion;
    private Gato gato;
    private Aspiradora aspiradora;
    private Bateria bateria;

    public ControladorHabitacion(int largo, int ancho, int capacidadBasura) {
        this.habitacion = new Habitacion(new Dimension(largo, ancho));
        this.gato = new Gato(0, 0);
        this.bateria = new Bateria();
        this.aspiradora = new Aspiradora(bateria, capacidadBasura);
    }

    public void start() {
        ControladorAspiradora controladorAspiradora = new ControladorAspiradora(aspiradora);
        ControladorGato controladorGato = new ControladorGato(gato);
        VistaHabitacion vistaHabitacion = new VistaHabitacion(habitacion);
        for (int i = 0; i < 50; i ++){
            System.out.println("\nITERACION: " + i);
            controladorAspiradora.mover(habitacion);
            controladorGato.mover(habitacion);
            vistaHabitacion.imprimir(aspiradora.getPosicion(), gato.getPosicion());
        }
    }
}
