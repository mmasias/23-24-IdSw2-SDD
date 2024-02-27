import java.util.Scanner;

public class Heroe extends Personaje {

	private Arma[] armas;
	private boolean defendiendo;
	private int turnosRestantesParaAtacar = 0;
	private Scanner scanner;
	private static final int UMBRAL_DESMAYO = 30;
	private static final int RECUPERACION_ENERGIA = 2;

	public Heroe() {

		super(150, 20, 2, 0.5);

		armas = new Arma[] {
				new Arma(7, 0.5),
				new Arma(15, 0.25),
				new Arma(30, 0.12)
		};

		scanner = new Scanner(System.in);
	}

	@Override
	public void atacar(Personaje objetivo) {

		if (turnosRestantesParaAtacar == 0) {
			handleTurnoHeroe(objetivo);
		} else {
			turnosRestantesParaAtacar--;
			if (turnosRestantesParaAtacar == 0) {
				this.setPoder(20);
				System.out.println("El Heroe ha sobrevivido 3 turnos. Ahora tiene todo su poder de regreso.");
				handleTurnoHeroe(objetivo);
			}
		}

	}

	private void handleTurnoHeroe(Personaje objetivo) {
		System.out.println("Elige un arma para atacar (1, 2 o 3):");
		if (turnosRestantesParaAtacar < 1) {
			System.out.println("Pulsa 4 para tomar una poción:");
		}
		int eleccion = scanner.nextInt();

		while (eleccion < 1 || eleccion > armas.length + 1) {
			System.out.println("Elección inválida. Por favor elige entre 1, 2, 3, o 4:");
			eleccion = scanner.nextInt();
		}

		if (eleccion < 4) {
			Arma armaElegida = armas[eleccion - 1];

			if (Math.random() < armaElegida.getProb()) {

				objetivo.recibirDano(armaElegida.getAtaque());
				System.out.println("El Guerrero ataca con éxito usando el arma " + eleccion);

			} else {
				System.out.println("El Guerrero falla el ataque.");
			}
		} else if (eleccion == 4) {
			tomarPocion();
			System.out.println("EL guerrero ha tomado una pocion. No podras atacar o defender por 3 turnos");
		}

		dejarDeDefender();
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