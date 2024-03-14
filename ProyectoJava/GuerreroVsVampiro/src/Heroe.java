import java.util.Scanner;

public class Heroe extends Personaje {

	private boolean defendiendo;
	private int turnosRestantesParaAtacar = 0;
	private Scanner scanner;
	private static final int UMBRAL_DESMAYO = 30;
	private static final int RECUPERACION_ENERGIA = 2;

	public Heroe(int energia, int poder, int ataque, double prob_exito, String nombre) {
		super(energia, poder, ataque, prob_exito, nombre);
		scanner = new Scanner(System.in);
		//if statement con los datos de cada personaje?
	}

	@Override
	public void atacar(Personaje objetivo) {

		if (turnosRestantesParaAtacar == 0) {
			handleTurnoHeroe(objetivo);
		} else {
			turnosRestantesParaAtacar--;
			if (turnosRestantesParaAtacar == 0) {
				this.setPoder(20);
				System.out.println("El " + this.getNombre() + "ha sobrevivido 3 turnos. Ahora tiene todo su poder de regreso.");
				handleTurnoHeroe(objetivo);
			}
		}

	}

	private void handleTurnoHeroe(Personaje objetivo) {
		System.out.println("Elige un arma para atacar:\n" +
				"1 - " + this.armas[0].getNombre() + " (Ataque: " + this.armas[0].getAtaque() + " | Probabilidad de éxito: " + this.armas[0].getProb() + " %)\n" +
				"2 - " + this.armas[1].getNombre() + " (Ataque: " + this.armas[0].getAtaque() + " | Probabilidad de éxito: " + this.armas[0].getProb() + " %)\n" +
				"3 - " + this.armas[2].getNombre() + " (Ataque: " + this.armas[0].getAtaque() + " | Probabilidad de éxito: " + this.armas[0].getProb() + " %)");

		if (turnosRestantesParaAtacar < 1) {
			System.out.println("4 - Poción (No puedes atacar o defender por 3 turnos)");
		}
		int eleccion = scanner.nextInt();

		while (eleccion < 1 || eleccion > armas.length + 1) {
			System.out.println("Elección inválida. Por favor elige entre 1, 2, 3, o 4:");
			eleccion = scanner.nextInt();
		}

		if (eleccion < 4) {
			Arma armaElegida = this.armas[eleccion - 1];

			if (Math.random() < armaElegida.getProb()) {

				objetivo.recibirDano(armaElegida.getAtaque());
				System.out.println("El Guerrero ataca con éxito usando el arma " + eleccion);

			} else {
				System.out.println("El Guerrero falla el ataque.");
			}
		} else if (eleccion == 4) {
			tomarPocion();
			System.out.println("El Guerrero ha tomado una poción. No podras atacar o defender por 3 turnos");
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