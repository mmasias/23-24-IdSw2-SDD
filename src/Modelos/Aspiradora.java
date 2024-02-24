import java.util.Random;

public class Aspiradora {
    private int pasosRealizados;
    private int bateria;
    private int posicionX;
    private int posicionY;

    public Aspiradora(int capacidadBolsa, int suciedadMaxima) {
        this.pasosRealizados = 0;
        this.bateria = 100;
    }
    

    public int getPasosRealizados( ) { 
        return pasosRealizados;}
    
   
    public int getBateria() {
        return bateria;
    }

    
    public void setPasosRealizados(int pasosRealizados) {
        this.pasosRealizados = pasosRealizados;
    }
    
    public void setBateria(int bateria) {
        this.bateria = bateria;
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
