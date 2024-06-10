package Modelo;
public class Bateria {

    private int nivelBateria;
    private static final int CAPACIDAD_MAXIMA = 100;

    public Bateria(){
        this.nivelBateria = CAPACIDAD_MAXIMA;
    }

    public void descargar(){
        if(nivelBateria > 0){
            nivelBateria--;
        }
    }

    public void recargar(){
        while(nivelBateria < CAPACIDAD_MAXIMA ){
            nivelBateria++;
        }
    }

    public int getNivelBateria(){
        return nivelBateria;
    }

    public boolean estaDescargada() {
        return nivelBateria <= 0;
    }



}
