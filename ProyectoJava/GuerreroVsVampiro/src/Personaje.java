import java.util.Random;

public abstract class Personaje {

	private int poder;
	private int ataque;
	private int energia;
	private double prob_exito;
	private Random random;
	
	private static final int UMBRAL_DESMAYO = 0; 
    private static final int RECUPERACION_ENERGIA = 0; 

	public Personaje(int energia, int poder, int ataque, double prob_exito) {
		this.energia = energia;
		this.poder = poder;
		this.ataque = ataque;
		this.prob_exito = prob_exito;
		this.random = new Random();
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

	public void atacar(Personaje objetivo) {		
	}

	protected abstract void recibirDano(int dano);
	
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