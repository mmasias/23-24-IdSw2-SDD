public class Azulejo{
    private TipoSuciedad nivelSuciedad;
    private Posicion posicion;
    private Elemento elemento = null;

    public Azulejo(TipoSuciedad nivelSuciedad, Posicion posicion) {
        this.nivelSuciedad = nivelSuciedad;
        this.posicion = posicion;
    }

    public TipoSuciedad getNivelSuciedad() {
        return nivelSuciedad;
    }

    public void setNivelSuciedad(TipoSuciedad nivelSuciedad) {
        this.nivelSuciedad = nivelSuciedad;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }
}