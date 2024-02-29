public class Arma {
	
	private int ataque;
	private double prob;
	
	public Arma(int ataque, double prob) {
		this.ataque = ataque;
		this.prob = prob;
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
