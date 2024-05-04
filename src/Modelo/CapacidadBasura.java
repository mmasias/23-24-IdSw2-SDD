package Modelo;
public class CapacidadBasura {
    private int nivelBasura = 0;
    private int maximoNivelBasura;

    public CapacidadBasura(int maximoNivelBasura){
        this.maximoNivelBasura = maximoNivelBasura;
    }

    public void incrementar() {
        if (nivelBasura < maximoNivelBasura) {
            nivelBasura++;
        }
    }

    public void vaciar() {
        nivelBasura = 0;
    }

    public boolean estaLlena() {
        return nivelBasura == maximoNivelBasura;
    }

    public int getNivelBasura(){
        return nivelBasura;
    }

    public int getMaximoNivelBasura() {
        return maximoNivelBasura;
    }
}

