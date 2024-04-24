public class Gestionador {
    private Habitacion habitacion;
    Gato gato = new Gato(0, 0);
    Aspiradora aspiradora = new Aspiradora();

    public Gestionador(Habitacion habitacion){
        this.habitacion = habitacion;
    }

    public void start(){
        for (int i = 0; i < 20; i++) {
            aspiradora.mover(habitacion);
            gato.mover(habitacion);
            habitacion.imprimir(aspiradora, gato);
        }
    }
}

