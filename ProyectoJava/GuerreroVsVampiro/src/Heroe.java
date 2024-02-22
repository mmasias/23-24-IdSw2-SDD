import java.util.Scanner;

public class Heroe extends Personaje {

	private Arma[] armas;
	private boolean defendiendo;
	private Scanner scanner;
	private static final int UMBRAL_DESMAYO = 30;
	private static final int RECUPERACION_ENERGIA = 2;

	public Heroe() {

		super(150, 20, 2, 0.5); 

		armas = new Arma[]{
				new Arma(7, 0.5),
				new Arma(15, 0.25),
				new Arma(30, 0.12)
		};

		scanner = new Scanner(System.in);
	}

	@Override
	public void atacar(Personaje objetivo) {

		System.out.println("Elige un arma para atacar (1, 2 o 3):");
		int eleccion = scanner.nextInt();

		while (eleccion < 1 || eleccion > armas.length) {
			System.out.println("Elección inválida. Por favor elige entre 1, 2 o 3:");
			eleccion = scanner.nextInt();
		}

		Arma armaElegida = armas[eleccion - 1];

		if (Math.random() < armaElegida.getProb()) {

			objetivo.recibirDano(armaElegida.getAtaque());
			System.out.println("El Guerrero ataca con éxito usando el arma " + eleccion);

		} else {
			System.out.println("El Guerrero falla el ataque.");
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
}