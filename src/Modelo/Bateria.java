package Modelo;
public class Bateria {

    private int nivelBateria;

    public Bateria(){
        this.nivelBateria = 100;
    }

    public void descargar(){
        if(nivelBateria > 0){
            nivelBateria--;
        }
    }

    public void recargar(){
        while(nivelBateria < 100 ){
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
