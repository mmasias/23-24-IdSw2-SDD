package Modelo;

public class Habitacion {
    private Azulejo[][] superficie;
    private boolean[][] muebles;
    private Dimension dimension;

    public Habitacion(Dimension dimension, Azulejo[][] superficie, boolean[][] muebles) {
        this.dimension = dimension;
        this.superficie = superficie;
        this.muebles = muebles;
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
}
