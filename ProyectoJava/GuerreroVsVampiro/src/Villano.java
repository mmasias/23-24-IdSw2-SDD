public class Villano extends Personaje {

    public Villano(int energia, int poder, int ataque, double prob_exito, String nombre) {
        super(energia, poder, ataque, prob_exito, nombre);
    }

    @Override
    public void atacar(Personaje objetivo) {

        int indiceAtaque = random.nextInt(this.getArmas().length);
        Arma armaElegida = this.getArmas()[indiceAtaque];
        int dano = armaElegida.getAtaque();

        if (objetivo instanceof Heroe) {

            Heroe heroe = (Heroe) objetivo;

            if (heroe.estaDefendiendo()) {
                if (Math.random() < 0.8) {
                    dano = Math.max(0, dano - 5);
                }
            }
        }

        if (random.nextDouble() < armaElegida.getProb()) {
            objetivo.recibirDano(armaElegida.getAtaque());
            System.out.println("El " + this.getNombre() + " ataca con éxito usando el ataque " + (indiceAtaque + 1));

        } else {
            System.out.println("El " + this.getNombre() + " falla el ataque.");
        }
    }
}
