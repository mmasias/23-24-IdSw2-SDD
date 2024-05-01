

public class Gestionador {
    private Habitacion habitacion;
    private Gato gato;
    private Aspiradora aspiradora;
    private Bateria bateria;

    public Gestionador(Habitacion habitacion) {
        this.habitacion = habitacion;
        this.gato = new Gato(0, 0);
        this.bateria = new Bateria();
        this.aspiradora = new Aspiradora(bateria);
    }

    public void start() {
        for (int i = 0; i < 50; i ++){
            aspiradora.mover(habitacion);
            gato.mover(habitacion);
            habitacion.imprimir(aspiradora, gato);
        }
    }
}