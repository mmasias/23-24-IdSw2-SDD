package Modelo;

public class Aspiradora {
    private int pasosRealizados;
    private int limpiezaRealizada;
    private CapacidadBasura capacidadBasura;
    private Bateria bateria;
    private Posicion posicion;

    public Aspiradora(Bateria bateria, int capacidadBasura) {
        this.pasosRealizados = 0;
        this.limpiezaRealizada = 0;
        this.bateria = bateria;
        this.capacidadBasura = new CapacidadBasura(capacidadBasura);
        this.posicion = new Posicion(0, 0);
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public int getPasosRealizados() {
        return pasosRealizados;
    }

    public int getLimpiezaRealizada() {
        return limpiezaRealizada;
    }

    public CapacidadBasura getCapacidadBasura() {
        return capacidadBasura;
    }

    public Bateria getBateria() {
        return bateria;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void setPasosRealizados(int pasosRealizados) {
        this.pasosRealizados = pasosRealizados;
    }

    public void setLimpiezaRealizada(int limpiezaRealizada) {
        this.limpiezaRealizada = limpiezaRealizada;
    }

    public void setCapacidadBasura(CapacidadBasura capacidadBasura) {
        this.capacidadBasura = capacidadBasura;
    }

    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }

}
