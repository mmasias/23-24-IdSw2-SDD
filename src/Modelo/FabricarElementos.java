package Modelo;

import java.util.Random;

public class FabricarElementos {
    public static Habitacion crearHabitacion(Dimension dimension) {
        Azulejo[][] superficie = generarSuperficie(dimension.getAncho(), dimension.getLargo(), new Random().nextInt(20) + 20);
        boolean[][] muebles = generarMuebles(dimension.getAncho(), dimension.getLargo());
        return new Habitacion(dimension, superficie, muebles);
    }

    private static boolean[][] generarMuebles(int ancho, int largo) {
        boolean[][] muebles = new boolean[ancho][largo];
        for (int i = 0; i < 4; i++) {
            int x = (int) (Math.random() * (ancho - 1));
            int y = (int) (Math.random() * (largo - 1));
            muebles[x][y] = true;
        }
        return muebles;
    }

    private static Azulejo[][] generarSuperficie(int ancho, int largo, int porcentajeSuciedad) {
        Azulejo[][] superficie = new Azulejo[ancho][largo];
        Random rand = new Random();

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < largo; j++) {
                superficie[i][j] = new Azulejo(0);
            }
        }

        int totalAzulejos = ancho * largo;
        int azulejosSucios = (int) (totalAzulejos * porcentajeSuciedad / 100.0);

        for (int i = 0; i < azulejosSucios; i++) {
            int x, y;
            do {
                x = rand.nextInt(ancho);
                y = rand.nextInt(largo);
            } while (superficie[x][y].getNivelSuciedad() != 0);
            superficie[x][y] = new Azulejo(rand.nextInt(4) + 1);
        }
        return superficie;
    }
}
