public class Bateria {

    private int nivelBateria;

    public Bateria(int nivelBateria){
        this.nivelBateria = 100;
    }

    public void descarga(){
        if(nivelBateria > 0){
            nivelBateria--;
        }
    }

    public void carga(){
        if(nivelBateria < 100 ){
            nivelBateria++;
        }
    }

    public int getNivelBateria(){
        return nivelBateria;
    }

    public int setNivelBateria(){
        return nivelBateria;
    }

}
