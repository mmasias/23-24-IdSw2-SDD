import java.util.Scanner;

public class Juego {

    private Personaje personaje;
    private Villano villano;

    public Juego() {
        personaje = seleccionarPersonaje();
        villano = new Villano(150, 20, 2, 0.5, "Vampiro"); // Agregar funcionalidad de randomize el villano!!
        villano.setArmas("1", 3, 0.5,"2", 5, 0.3, "3", 10, 0.2, "4", 3, 0.2);
    }

    public void iniciar() {
        System.out.println("¡La batalla comienza!");
        
        while (personaje.estaVivo() && villano.estaVivo()) {
            if (!personaje.estaDesmayado()) {
                personaje.atacar(villano);
                
               
                if (!villano.estaVivo()) {
                    System.out.println("¡El " + personaje.getNombre() + " ha ganado la batalla!");
                    break;
                }
                

                System.out.println("Vida restante del " + villano.getNombre() + " : " + villano.getPoder());
            } else {
                System.out.println("El " + personaje.getNombre() + " está desmayado y se recupera.");
                personaje.recuperarEnergia();
            }

            if (!villano.estaDesmayado()) {
                villano.atacar(personaje);

                if (!personaje.estaVivo()) {
                    System.out.println("¡El " + villano.getNombre() + " ha ganado la batalla!");
                    break;
                }

                System.out.println("Vida restante del " + personaje.getNombre() + ": " + personaje.getPoder());
            } else {
                System.out.println("El " + villano.getNombre() + " está desmayado y se recupera.");
                villano.recuperarEnergia();
            }
        }
    }

    private Personaje seleccionarPersonaje() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona tu personaje: 1 - Bárbaro, 2 - Asesino, 3 - Arquero");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            Heroe heroe = new Heroe(150,20,2,0.5, "Bárbaro");
            heroe.setArmas("Puños", 3, 0.5,"Cabezazo", 5, 0.3,"Maza", 10, 0.2, "Bloqueo", 3, 0.2);
            return heroe;
        } else if (opcion == 2) {
            Heroe heroe = new Heroe(150,20,2,0.5, "Asesino");
            heroe.setArmas("Dardo", 3, 0.5,"Navaja", 5, 0.3,"Estoque", 10, 0.2, "Bloqueo", 3, 0.2);
            return heroe;
        } else if (opcion == 3) {
            Heroe heroe = new Heroe(150,20,2,0.5, "Arquero");
            heroe.setArmas("Flecha", 3, 0.5,"Ballesta", 5, 0.3,"Lanza", 10, 0.2, "Bloqueo", 3, 0.2);
            return heroe;
        } else {
            System.out.println("Opción inválida. Seleccionando al Asesino por defecto.");
            Heroe heroe = new Heroe(150,20,2,0.5, "Asesino");
            heroe.setArmas("Dardo", 3, 0.5,"Navaja", 5, 0.3,"Estoque", 10, 0.2, "Bloqueo", 3, 0.2);
            return heroe;
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciar();
    }
}