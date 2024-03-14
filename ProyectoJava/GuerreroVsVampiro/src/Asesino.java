import java.util.Scanner;

public class Asesino extends Personaje {

    private Arma[] armas;
    private boolean defendiendo;
    private int turnosRestantesParaAtacar = 0;
    private Scanner scanner;
    private static final int UMBRAL_DESMAYO = 30;
    private static final int RECUPERACION_ENERGIA = 2;

    public Asesino() {

        super(150, 20, 2, 0.5, "Asesino");

        armas = new Arma[] {
                new Arma(3, 0.5), // Dardo con veneno
                new Arma(5, 0.25), // Ballesta
                new Arma(20, 0.30) // Estoque
        };

        scanner = new Scanner(System.in);
    }

    @Override
    public void atacar(Personaje objetivo) {

        if (turnosRestantesParaAtacar == 0) {
            handleTurnoAsesino(objetivo);
        } else {
            turnosRestantesParaAtacar--;
            if (turnosRestantesParaAtacar == 0) {
                this.setPoder(20);
                System.out.println("El Asesino ha sobrevivido 3 turnos. Ahora tiene todo su poder de regreso.");
                handleTurnoAsesino(objetivo);
            }
        }

    }

    private void handleTurnoAsesino(Personaje objetivo) {
        System.out.println("Elige un arma para atacar:\n" +
                "1 - Dardo con veneno (Ataque: 3 | Probabilidad de éxito 50 %)\n" +
                "2 - Ballesta (Ataque: 5 cada flecha [2 flechas] | Probabilidad de éxito 25 % cada flecha)\n" +
                "3 - Estoque (Ataque: 20 | Probabilidad de éxito 30 %)");

        if (turnosRestantesParaAtacar < 1) {
            System.out.println("4 - para tomar una poción(No podras atacar o defender por 3 turnos)");
        }
        int eleccion = scanner.nextInt();

        while (eleccion < 1 || eleccion > armas.length + 1) {
            System.out.println("Elección inválida. Por favor elige entre 1, 2, 3, o 4:");
            eleccion = scanner.nextInt();
        }

        if (eleccion < 4) {
            Arma armaElegida = armas[eleccion - 1];

            if (Math.random() < armaElegida.getProb()) {
                if (eleccion == 1) {
                    objetivo.recibirDano(armaElegida.getAtaque());
                    System.out.println("El Asesino ataca con éxito usando el arma " + eleccion);
                    aplicarVeneno(objetivo);
                } else if (eleccion == 2) {
                    for (int i = 0; i < 2; i++) {
                        objetivo.recibirDano(armaElegida.getAtaque());
                    }
                    System.out.println("El Asesino ataca con éxito usando el arma " + eleccion);
                } else {
                    objetivo.recibirDano(armaElegida.getAtaque());
                    System.out.println("El Asesino ataca con éxito usando el arma " + eleccion);
                }

            } else {
                System.out.println("El Asesino falla el ataque.");
            }
        } else if (eleccion == 4) {
            tomarPocion();
            System.out.println("EL Asesino ha tomado una pocion. No podras atacar o defender por 3 turnos");
        }

        dejarDeDefender();
    }

    private void aplicarVeneno(Personaje objetivo) {
        objetivo.recibirDano(3);
        System.out.println("El veneno hace 3 de daño por 3 turnos.");
    }

    public Arma[] getArmas() {
        return armas;
    }

    public void setArmas(Arma[] armas) {
        this.armas = armas;
    }

    @Override
    protected void recibirDano(int dano) {
        int poderActual = this.getPoder() - dano;
        this.setPoder(poderActual);
    }

    public void defender() {
        defendiendo = true;
    }

    public void dejarDeDefender() {
        defendiendo = false;
    }

    public boolean estaDefendiendo() {
        return defendiendo;
    }

    @Override
    public boolean estaDesmayado() {
        return this.getEnergia() < UMBRAL_DESMAYO;
    }

    @Override
    public void recuperarEnergia() {
        if (estaDesmayado()) {
            setEnergia(Math.min(getEnergia() + RECUPERACION_ENERGIA, 150));
        }
    }

    public void tomarPocion() {
        turnosRestantesParaAtacar = 3;
    }
}
