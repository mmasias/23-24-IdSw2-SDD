public class Arma {
	
	private int ataque;
	private double prob;
	private String nombre;
	
	public Arma(String nombre, int ataque, double prob) {
		this.ataque = ataque;
		this.prob = prob;
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.ataque = ataque;
	}
	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public double getProb() {
		return prob;
	}

	public void setProb(double prob) {
		this.prob = prob;
	}
}
