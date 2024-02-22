public class Juego {

    private Heroe guerrero;
    private Vampiro vampiro;

    public Juego() {
        
        guerrero = new Heroe();
        vampiro = new Vampiro();
    }

    public void iniciar() {
    	
        System.out.println("¡La batalla comienza!");

        while (guerrero.estaVivo() && vampiro.estaVivo()) {
        	
            // Verificar si el Guerrero está desmayado
            if (!guerrero.estaDesmayado()) {
            	
                // Turno del Guerrero
                guerrero.atacar(vampiro);

                if (!vampiro.estaVivo()) {
                    System.out.println("¡El Guerrero ha ganado la batalla!");
                    break;
                }

                System.out.println("Vida restante del Vampiro: " + vampiro.getPoder());
                
            } else {
            	
                System.out.println("El Guerrero está desmayado y se recupera.");
                guerrero.recuperarEnergia();
            }

            // Verificar si el Vampiro está desmayado
            if (!vampiro.estaDesmayado()) {
            	
                // Turno del Vampiro
                vampiro.atacar(guerrero);

                if (!guerrero.estaVivo()) {
                	
                    System.out.println("¡El Vampiro ha ganado la batalla!");
                    break;
                }

                System.out.println("Vida restante del Guerrero: " + guerrero.getPoder());
                
            } else {
                System.out.println("El Vampiro está desmayado y se recupera.");
                vampiro.recuperarEnergia();
            }
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciar();
    }
}