public class CapacidadDeBasura {
    private int nivelBasura = 0;
    private int maximoNivelBasura;

    public CapacidadDeBasura(int maximoNivelBasura){
        this.maximoNivelBasura = maximoNivelBasura;
    }

    public void rellenarBolsa(){
        if(nivelBasura < maximoNivelBasura){
            nivelBasura++;
        }
    }

    public void vaciarBolsa(){
        nivelBasura = 0;
    }

    public int getNivelDeBasura(){
        return nivelBasura;
    }
}
