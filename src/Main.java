

import Controlador.ControladorHabitacion;
import Vista.Consola;

public class Main {

    public static void main(String[] args) {
        Consola consola = new Consola();
        int largo = consola.obtenerLargo();
        int ancho = consola.obtenerAncho();
        int capacidadBasura = consola.obtenerCapacidadBasura();

        ControladorHabitacion controlador = new ControladorHabitacion(largo, ancho, capacidadBasura);
        controlador.start();
        consola.cerrarScanner();
    }
}
