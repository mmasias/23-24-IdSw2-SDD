import java.util.Random;

public class Aspiradora {
    private int pasosRealizados;
    private int suciedadTotal;
    private int bateria;
    private int capacidadBolsa;
    private int suciedadMaxima;

    public Aspiradora(int capacidadBolsa, int suciedadMaxima) {
        this.capacidadBolsa = capacidadBolsa;
        this.suciedadMaxima = suciedadMaxima;
        this.pasosRealizados = 0;
        this.suciedadTotal = 0;
        this.bateria = 5; 
    }
    

    public int getPasosRealizados( ) { 
        return pasosRealizados;}
    
    public int getSuciedadTotal() {
        return suciedadTotal;
    }
    
    public int getBateria() {
        return bateria;
    }
    
    public int getCapacidadBolsa() {
        return capacidadBolsa;
    }
    
    public int getSuciedadMaxima() {
        return suciedadMaxima;
    }
    
    public void setPasosRealizados(int pasosRealizados) {
        this.pasosRealizados = pasosRealizados;
    }
    
    public void setSuciedadTotal(int suciedadTotal) {
        this.suciedadTotal = suciedadTotal;
    }
    
    public void setBateria(int bateria) {
        this.bateria = bateria;
    }
    
    public void setCapacidadBolsa(int capacidadBolsa) {
        this.capacidadBolsa = capacidadBolsa;
    }
    
    public void setSuciedadMaxima(int suciedadMaxima) {
        this.suciedadMaxima = suciedadMaxima;
    }
    
    public void limpiar(int pasos) {
        Random random = new Random();
        for (int i = 0; i < pasos; i++) {
        
            pasosRealizados++;
            bateria--;
            if (bateria <= 0) {
                System.out.println("Batería agotada. Deteniendo la aspiradora.");
                break;
            }
           
            int suciedad = random.nextInt(5); 
            suciedadTotal += suciedad;
            if (suciedadTotal >= suciedadMaxima) {
                System.out.println("Bolsa llena. Deteniendo la aspiradora.");
                break;
            }
        }
    }
    public void dirigirHaciaZonaMasSucia() {

        System.out.println("Dirigiendo hacia la zona más sucia...");
    }
}
