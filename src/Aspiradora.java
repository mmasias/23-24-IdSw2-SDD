import java.util.Random;

public class Aspiradora {
    private int pasosRealizados;
    private int limpiezaRealizada;
    private CapacidadBasura capacidadBasura;
    private Bateria bateria;
    private Posicion posicion;

    public Aspiradora() {
        this.pasosRealizados = 0;
        this.limpiezaRealizada = 0;
        this.posicion = new Posicion(0, 0);
    }

    public Posicion getPosicion(){
        return posicion;
    }

    public Bateria getBateria(){
        return bateria;
    }
    
    public void setBateria(Bateria bateria){
        this.bateria = bateria;
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
    
    public void mover(Habitacion habitacion){
        Random random = new Random();
        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;

        int nuevaX = posicion.getX() + dx;
        int nuevaY = posicion.getY() + dy;

        if (nuevaX >= 0 && nuevaX < habitacion.ancho && nuevaY >= 0 && nuevaY < habitacion.largo) {
            if (!habitacion.muebles[nuevaX][nuevaY]) {
                posicion.setX(nuevaX);
                posicion.setY(nuevaY);
            }
        }
        pasosRealizados+=1;
    }


    public void limpiar(int pasos) {
        Random random = new Random();
        for (int i = 0; i < pasos; i++) {
        
            int nivBasura = bateria.getNivelBateria();
            pasosRealizados++;
            nivBasura--;
            if (nivBasura <= 0) {
                System.out.println("Batería agotada. Deteniendo la aspiradora.");
                break;
            }
        }
    }
}
