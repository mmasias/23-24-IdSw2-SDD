import java.util.Scanner;

public class Juego {

    private Personaje personaje;
    private Vampiro vampiro;

    public Juego() {
        personaje = seleccionarPersonaje();
        vampiro = new Vampiro();
    }

    public void iniciar() {
        System.out.println("¡La batalla comienza!");

        while (personaje.estaVivo() && vampiro.estaVivo()) {
            if (!personaje.estaDesmayado()) {
                personaje.atacar(vampiro);

                if (!vampiro.estaVivo()) {
                    System.out.println("¡El " + personaje.getNombre() + " ha ganado la batalla!");
                    break;
                }

                System.out.println("Vida restante del Vampiro: " + vampiro.getPoder());
            } else {
                System.out.println("El " + personaje.getNombre() + " está desmayado y se recupera.");
                personaje.recuperarEnergia();
            }

            if (!vampiro.estaDesmayado()) {
                vampiro.atacar(personaje);

                if (!personaje.estaVivo()) {
                    System.out.println("¡El Vampiro ha ganado la batalla!");
                    break;
                }

                System.out.println("Vida restante del " + personaje.getNombre() + ": " + personaje.getPoder());
            } else {
                System.out.println("El Vampiro está desmayado y se recupera.");
                vampiro.recuperarEnergia();
            }
        }
    }

    private Personaje seleccionarPersonaje() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona tu personaje: 1 - Heroe, 2 - Asesino");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            return new Heroe();
        } else if (opcion == 2) {
            return new Asesino();
        } else {
            System.out.println("Opción inválida. Seleccionando al Heroe por defecto.");
            return new Heroe();
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciar();
    }
}