package Gato;

import java.util.Random;

public class Gato {
    private int pasos;

    public Gato (){
        this.pasos = 0;
    }

    public int getPasos(){
        return pasos;
    }

    public void setPasos(int pasos){
        this.pasos = pasos;
    }

    public void pasear(Matriz superficie){
        Random random = new Random();

        int pasos = 25; 

        while (pasos > 0) {
            int x = random.nextInt(superficie.getAncho());
            int y = random.nextInt(superficie.getAlto());
            if (superficie.getGrid()[y][x] < 4) {
                superficie.getGrid()[y][x]++;
                superficie.setSuciedadTotal(superficie.getSuciedadTotal() + 1);
            }
            pasos --;
        }
        this.pasos = 25;
    }

    
}

