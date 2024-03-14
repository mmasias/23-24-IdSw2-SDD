import java.util.Random;

public class Vampiro extends Personaje {

    private Ataque[] ataques;
    private Random random;

    private static final int UMBRAL_DESMAYO = 20;
    private static final int RECUPERACION_ENERGIA = 2;

    public Vampiro() {

        super(60, 10, 4, 0.5, "Vampiro");

        ataques = new Ataque[] {
                new Ataque(5, 0.9),
                new Ataque(10, 0.6),
                new Ataque(20, 0.4)
        };

        random = new Random();
    }

    @Override
    public void atacar(Personaje objetivo) {

        int indiceAtaque = random.nextInt(ataques.length);
        Ataque ataqueElegido = ataques[indiceAtaque];

        // Reto adicional 1
        int dano = ataqueElegido.getAtaque();

        if (objetivo instanceof Heroe) {

            Heroe heroe = (Heroe) objetivo;

            if (heroe.estaDefendiendo()) {
                if (Math.random() < 0.8) {
                    dano = Math.max(0, dano - 5);
                }
            }
        }

        // Verificar ataque realizado
        if (random.nextDouble() < ataqueElegido.getProb()) {

            // Aplicar el daño al objetivo
            objetivo.recibirDano(ataqueElegido.getAtaque());
            System.out.println("El Vampiro ataca con éxito usando el ataque " + (indiceAtaque + 1));

        } else {

            System.out.println("El Vampiro falla el ataque.");
        }
    }

    public Ataque[] getAtaques() {
        return ataques;
    }

    public void setAtaques(Ataque[] ataques) {
        this.ataques = ataques;
    }

    @Override
    protected void recibirDano(int dano) {
        int poderActual = this.getPoder() - dano;
        this.setPoder(poderActual);

    }

    @Override
    public boolean estaDesmayado() {
        return getEnergia() < UMBRAL_DESMAYO;
    }

    @Override
    public void recuperarEnergia() {
        if (estaDesmayado()) {
            setEnergia(Math.min(getEnergia() + RECUPERACION_ENERGIA, 60)); // Asumiendo 60 como energía máxima
        }
    }

}