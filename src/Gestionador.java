

public class Gestionador {
    private Habitacion habitacion;
    private Gato gato;
    private Aspiradora aspiradora;

    public Gestionador(Habitacion habitacion) {
        this.habitacion = habitacion;
        this.gato = new Gato(0, 0);
        this.aspiradora = new Aspiradora();
    }

    public void start() {
       
        for (int i = 0; i < 30; i++) {
            aspiradora.mover(habitacion);
            gato.mover(habitacion);
            habitacion.imprimir(aspiradora, gato);
        }
    }
}