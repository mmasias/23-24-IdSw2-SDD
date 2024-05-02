import java.util.Random;

public class Habitacion {
    public Azulejo[][] superficie;
    public boolean[][] muebles;
    public Dimension dimension;
    public Posicion estacionRecarga;

    public Habitacion(Dimension dimension) {
        this.dimension = dimension;
        this.superficie = new Azulejo[dimension.getAncho()][dimension.getLargo()];
        this.muebles = new boolean[dimension.getAncho()][dimension.getLargo()];
        this.estacionRecarga = new Posicion(10, 10); 

        Random rand = new Random();
        this.superficie = generarSuperficie(dimension.getAncho(), dimension.getLargo(), rand.nextInt(20) + 20);
        this.muebles = generarMuebles(muebles);
    }

    public Azulejo[][] getSuperficie() {
        return superficie;
    }

    public boolean[][] getMuebles() {
        return muebles;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void imprimir() {
        imprimirBorderHorizontal();
        for (int y = 0; y < dimension.getLargo(); y++) {
            System.out.print("|");
            for (int x = 0; x < dimension.getAncho(); x++) {
                if (muebles[x][y]) {
                    System.out.print(Utils.Elementos.SOFA.obtenerSimbolo());
                    continue;
                }
                System.out.print(Utils.Elementos.obtenerSimboloPorValor(superficie[x][y].getNivelSuciedad()));
            }
            System.out.println("|");
        }
        imprimirBorderHorizontal();
    }

    public void imprimir(Aspiradora aspiradora, Gato gato) {
        imprimirBorderHorizontal();
        for (int y = 0; y < dimension.getLargo(); y++) {
            System.out.print("|");
            for (int x = 0; x < dimension.getAncho(); x++) {
                if (x == aspiradora.getPosicion().getX() && y == aspiradora.getPosicion().getY()) {
                    System.out.print(Elements.ASPIRADORA.getElement());
                } else if (x == gato.getPosicion().getX() && y == gato.getPosicion().getY()) {
                    System.out.print(Elements.GATO.getElement());
                } else if (muebles[x][y]) {
                    System.out.print(Utils.Elementos.SOFA.obtenerSimbolo());
                } else {
                    System.out.print(Utils.Elementos.obtenerSimboloPorValor(superficie[x][y].getNivelSuciedad()));
                }
            }
            System.out.println("|");
        }
        imprimirBorderHorizontal();
    }

    private void imprimirBorderHorizontal() {
        System.out.print("+---");
        System.out.print("---".repeat(dimension.getAncho() - 2));
        System.out.println("---+");
    }

    private static boolean[][] generarMuebles(boolean[][] muebles) {
        int ancho = muebles.length, largo = muebles[0].length;
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