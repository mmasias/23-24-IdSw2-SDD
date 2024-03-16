public class Aspiradora {
    private int pasosRealizados;
    private int limpiezaRealizada;
    private CapacidadBasura capacidadBasura;
    private Bateria bateria;
    private Posicion posicion;

    public Aspiradora(CapacidadBasura capacidadBolsa, int suciedadMaxima, int limpiezaRealizada, Bateria bateria) {
        this.pasosRealizados = 0;
        this.limpiezaRealizada = 0;
        this.bateria = bateria;
        this.capacidadBasura = capacidadBolsa;
    }

    public Posicion getPosicion(){
        return posicion;
    }

    public Bateria getBateria(){
        return bateria;
    }

    public CapacidadBasura getBasura(){
        return capacidadBasura;
    }

    public int getPasosRealizados( ) {
        return pasosRealizados;
    }
    
    public void setPasosRealizados(int pasosRealizados) {
        this.pasosRealizados = pasosRealizados;
    }

    public int getLimpiezaRealizada( ) {
        return limpiezaRealizada;
    }
    
    public void setLimpiezaRealizados(int limpiezaRealizada) {
        this.limpiezaRealizada = limpiezaRealizada;
    }
    
    /*public void limpiar(int pasos) {
        Random random = new Random();
        for (int i = 0; i < pasos; i++) {
        
            pasosRealizados++;
            bateria--;
            if (bateria <= 0) {
                System.out.println("Batería agotada. Deteniendo la aspiradora.");
                break;  
            }
        }
    }*/
}
