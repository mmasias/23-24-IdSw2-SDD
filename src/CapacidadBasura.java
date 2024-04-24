public class CapacidadBasura {
    private int nivelBasura = 0;
    private int maximoNivelBasura;

    public CapacidadBasura(int maximoNivelBasura){
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
