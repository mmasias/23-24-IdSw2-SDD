package Vista;

import Modelo.Habitacion;
import Modelo.Posicion;

public class VistaHabitacion {
    private Habitacion habitacion;

    public VistaHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void imprimir(Posicion posicionAspiradora, Posicion posicionGato) {
        imprimirBorderHorizontal();
        for (int y = 0; y < habitacion.getDimension().getLargo(); y++) {
            System.out.print("|");
            for (int x = 0; x < habitacion.getDimension().getAncho(); x++) {
                if (x == posicionAspiradora.getX() && y == posicionAspiradora.getY()) {
                    System.out.print(Utils.Elementos.ASPIRADORA.obtenerSimbolo());
                } else if (x == posicionGato.getX() && y == posicionGato.getY()) {
                    System.out.print(Utils.Elementos.GATO.obtenerSimbolo());
                } else if (habitacion.getMuebles()[x][y]) {
                    System.out.print(Utils.Elementos.SOFA.obtenerSimbolo());
                } else {
                    System.out.print(Utils.Elementos.obtenerSimboloPorValor(habitacion.getSuperficie()[x][y].getNivelSuciedad()));
                }
            }
            System.out.println("|");
        }
        imprimirBorderHorizontal();
    }

    private void imprimirBorderHorizontal() {
        System.out.print("+---");
        System.out.print("---".repeat(habitacion.getDimension().getAncho() - 2));
        System.out.println("---+");
    }
}
