import java.util.Random;

public abstract class Personaje {

	protected int poder;
	protected int ataque;
	protected int energia;
	protected double prob_exito;
	protected String nombre;
	protected Random random;
	protected Arma[] armas = new Arma[3];

	protected static final int UMBRAL_DESMAYO = 0;
	protected static final int RECUPERACION_ENERGIA = 0;

	public Personaje(int energia, int poder, int ataque, double prob_exito, String nombre) {
		this.energia = energia;
		this.poder = poder;
		this.ataque = ataque;
		this.prob_exito = prob_exito;
		this.nombre = nombre;
		this.random = new Random();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public Arma[] getArmas(){
		return armas;
	}
	public void setArmas(String nombre0, int ataque0, double prob_exito0, String nombre1, int ataque1, double prob_exito1, String nombre2, int ataque2, double prob_exito2){
		this.armas[0] = new Arma(nombre0, ataque0, prob_exito0);
		this.armas[1] = new Arma(nombre1, ataque1, prob_exito1);
		this.armas[2] = new Arma(nombre2, ataque2, prob_exito2);
	}
	public int getPoder() {
		return poder;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public double getProbExito() {
		return prob_exito;
	}

	public void setProbExito(double prob_exito) {
		this.prob_exito = prob_exito;
	}

	public abstract void atacar(Personaje objetivo);

	protected void recibirDano(int dano){
		int poderActual = this.getPoder() - dano;
        this.setPoder(poderActual);
	};

	public boolean estaVivo() {
		return this.poder > 0;
	}

	public boolean estaDesmayado() {
		return getEnergia() < UMBRAL_DESMAYO;
	}

	public void recuperarEnergia() {
		if (estaDesmayado()) {
			setEnergia(Math.min(getEnergia() + RECUPERACION_ENERGIA, getEnergia()));
		}
	}
}