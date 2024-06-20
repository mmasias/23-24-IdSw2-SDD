# El guerrero vs el vampiro

> "El guerrero vs el vampiro" es un juego de consola desarrollado en Java. En este juego, los jugadores pueden elegir entre múltiples personajes, cada uno con habilidades y características únicas, para enfrentarse a una variedad de enemigos monstruosos.

## Tabla de Contenidos

- [Diseño](#diseño)
  - [Relaciones entre clases](#relaciones-entre-clase)
    - [Colaboración](#colaboración)
- [Código Limpio](#código-limpio)
- [Cambios Al Codigo](#cambios-al-codigo)
- [Conclucion final](#conclusión-final)




## Diseño


#### Estrategias de Clasificación


#### Descripción del Problema


Este proyecto simula una batalla entre un guerrero y un vampiro hostil durante una travesía. La batalla se desarrolla por turnos, donde cada oponente realiza un ataque y existe una probabilidad de éxito del 50% para acertar.
El guerrero, equipado con un hacha, cuenta con un poder de 20 HP y un ataque con un 24% de probabilidad de éxito. Por otro lado, el vampiro, aunque más débil con 10 HP, es ágil y puede atacar mordiendo al guerrero con una probabilidad de éxito del 50%.
En la versión extendida, el guerrero (también llamado Héroe) y el vampiro cuentan con una energía inicial de 150 y 60 puntos, respectivamente. El Héroe tiene tres armas con diferentes probabilidades de éxito (75%, 25% y 12%), mientras que el vampiro cuenta con tres ataques con probabilidades de éxito del 90%, 60% y 40%. El usuario controla las acciones del Héroe, eligiendo el arma en cada turno, mientras que el programa controla las acciones del vampiro, seleccionando aleatoriamente uno de los ataques.
Además, se implementan tres retos adicionales:




El Héroe puede elegir defenderse del ataque del vampiro, con una probabilidad de éxito del 80% y reduciendo el daño en 5 puntos.
Si la energía del Héroe o del vampiro cae por debajo de un límite (30 y 20 puntos, respectivamente), el personaje se desmaya, perdiendo la capacidad de atacar y recuperando 2 puntos de energía por turno.
El Héroe tiene la posibilidad de beber una poción que le permita recuperar toda su energía, pero debe pasar un tiempo de 3 turnos, durante el cual no puede atacar ni defenderse, aunque sí recibe ataques.




El algoritmo simula y describe cada paso de la batalla, determinando finalmente quién ha ganado.




##### Análisis de comportamiento




- **BatallaSImulador:** Representa la simulación de la batalla. Sus responsabilidades incluyen:
    - **Simular** la batalla entre el Guerrero y el Vampiro.
    - **Aplica** las reglas de la batalla y los turnos.
    - **Determinar** el ganador al final de la batalla.








- **Guerrero:** Representa al héroe en la batalla. Sus responsabilidades son:
    - **Conocer** su poder, energía inicial y armas disponibles.
    - **Atacar** al Vampiro utilizando una de sus armas.
    - **Defenderse** de los ataques del Vampiro.
    - **batallar** Ejecuta las acciones del Guerrero en cada turno.








- **Vampiro:** Representa al oponente en la batalla. Sus responsabilidades incluyen:




    - **Conocer** su poder, energía inicial y ataques disponibles.
    - **Atacar** al Guerrero utilizando uno de sus ataques (seleccionado aleatoriamente).
    - **Energía inicial:** 60 puntos de energía.
    - **Ataque 1 (90%), Ataque 2 (60%), Ataque 3 (40%):** Diferentes ataques con probabilidades de éxito variables.








- **Arma:** Representa las armas que puede utilizar el Guerrero. Sus responsabilidades son:




    - **Conocer** la probabilidad de éxito del arma.
    - **Arma 1** (75%), Arma 2 (25%), Arma 3 (12%): Diferentes armas con probabilidades de éxito variables.








- **Defensa (Reto adicional 1):** Representa la capacidad del Guerrero de defenderse de los ataques del Vampiro. Sus responsabilidades incluyen:




    - **Conocer** la probabilidad de éxito de la defensa (80%).
    - **Bloquear** el daño del ataque del Vampiro.




##### Interacciones y Flujo de Trabajo




1. **Inicio:** El proceso comienza con el inicio de la batalla entre el héroe y el enemigo.
2. **Está vivo el héroe:** Se verifica si el héroe sigue con vida (su energía o puntos de vida son mayores a cero). Si es así, se procede a atacar al héroe.
3. **Ataca al héroe:** El héroe realiza su ataque contra el enemigo. Después de este ataque, se verifica si el enemigo ha muerto.
4. **Está vivo el enemigo:** Se verifica si el enemigo sigue con vida después del ataque del héroe. Si es así, se procede a que el enemigo ataque al héroe.
5. **Ataca al enemigo:** El enemigo realiza su ataque contra el héroe.
6. **¿Alguien ha muerto?:** Después de los ataques mutuos, se verifica si alguno de los dos (héroe o enemigo) ha fallecido (su energía o puntos de vida han llegado a cero).




- **Si ninguno ha muerto:** el flujo regresa al inicio para continuar con la siguiente ronda de ataques.
- **Si alguno ha muerto** el proceso de batalla termina.




### Relaciones entre clase




#### **Colaboración**




- **Composición**: No hay clases con relación de composición en nuestro proyecto.




- **Agregación**: Personaje ---> Heroe/Villano




- **Asociación**: Personaje ––– Arma




### Optimización del Código




 > Implementamos mejoras significativas en la base de código para aumentar la legibilidad y mantenibilidad, siguiendo principios de código limpio:




- **Estructura y Formato Mejorado:** Se ajustó la estructura del código para seguir un estilo consistente y legible, utilizando adecuadamente la indentación y el espaciado.




- **Eliminación de Código Innecesario:** Se eliminaron segmentos de código sin uso y se actualizaron los comentarios desactualizados para mejorar la claridad y comprensión de la funcionalidad del sistema.




- **Nombres Descriptivos:** Se revisaron los nombres de variables y métodos para que sean intuitivos y descriptivos, facilitando la comprensión del código.




### Código Limpio




Implementamos mejoras significativas en la base de código para aumentar la legibilidad y mantenibilidad, siguiendo principios de código limpio:




- **Eliminación de Código Innecesario:** Se eliminaron segmentos de código sin uso y se actualizaron los comentarios desactualizados para mejorar la claridad y comprensión de la funcionalidad del sistema.




- **Nombres Descriptivos**: Se revisaron los nombres de variables y métodos para que sean intuitivos y descriptivos, facilitando la comprensión del código.




- **Estructura y Formato Mejorado**: Se ajustó la estructura del código para seguir un estilo consistente y legible, utilizando adecuadamente la indentación y el espaciado.




## **Cambios Al Codigo**




## Función para Limpiar Pantalla








- **Descripción del Problema:**








  La consola se llenaba rápidamente con mensajes y texto, lo que dificultaba la legibilidad y el seguimiento de la batalla por turnos. Era necesario mejorar la claridad y la legibilidad de la información presentada al jugador durante el juego.








- **Solución Del Problema:**








  Se agregó una función para limpiar la pantalla en la clase Heroe. Esta función se llama limpiarPantalla y se invoca al final de cada turno para limpiar la consola, mejorando así la legibilidad de los mensajes y el seguimiento de la batalla.








- **Cambios Al Codigo:**








  Se agregó el siguiente método a la clase Heroe:




``` java
private void limpiarPantalla() { System.out.print("\033[H\033[2J"); System.out.flush(); }




```




 Además, se llamó a este método al final de la función handleTurnoHeroe:
 
``` java
 `private void handleTurnoHeroe(Personaje objetivo) { // código existente... limpiarPantalla(); }`
```




- **Beneficios de la Solución Propuesta:**








  La nueva función de limpiar pantalla mejora significativamente la legibilidad de la información presentada al jugador durante el juego. Ahora, cada turno comienza con una pantalla limpia, lo que permite a los jugadores centrarse en la información relevante del turno actual sin distracciones del texto anterior. Esto mejora la experiencia del usuario y facilita el seguimiento de la batalla.




## Modificaciones en Arma








- **Descripción del Problema:**








  El código original para la clase Arma no incluía un atributo para el nombre del arma, lo que hacía difícil identificar qué arma se estaba utilizando en las interacciones del juego.








- **Solución Del Problema:**








  Se agregó un atributo nombre a la clase Arma, y se modificó el constructor para aceptar este nuevo parámetro. También se agregaron métodos getNombre y setNombre para acceder y modificar este atributo.








- **Cambios Al Codigo:**








``` java
private int ataque; private double prob; private String nombre; public Arma(String nombre, int ataque, double prob) { this.ataque = ataque; this.prob = prob; this.nombre = nombre; } public String getNombre() { return nombre; } public void setNombre(String nombre) { this.nombre = nombre; } public int getAtaque() { return ataque; }
```
## Eliminación de la Clase Asesino








- **Descripción del Problema:**








La clase Asesino no era necesaria para la estructura actual del juego.








- **Solución Del Problema:**








  Se eliminó todo el código relacionado con la clase Asesino.


## Eliminación de la Clase Ataque








- **Descripción del Problema:**








La clase Ataque no era necesaria para la estructura actual del juego.








- **Solución Del Problema:**








Se eliminó todo el código relacionado con la clase Ataque.












## Modificaciones en Heroe








- **Descripción del Problema:**








La clase Heroe necesitaba ser más flexible para permitir la creación de diferentes tipos de héroes con diferentes armas y atributos.








- **Solución Del Problema:**




Se modificó el constructor para aceptar parámetros que definen las características del héroe. También se agregó un método setArmas para definir las armas del héroe.




- **Cambios Al Codigo:**




``` java
public class Heroe extends Personaje {




    private boolean defendiendo;
    private int turnosRestantesParaAtacar = 0;
    private Scanner scanner;
    private static final int UMBRAL_DESMAYO = 30;
    private static final int RECUPERACION_ENERGIA = 2;




    public Heroe(int energia, int poder, int ataque, double prob_exito, String nombre) {
        super(energia, poder, ataque, prob_exito, nombre);
        scanner = new Scanner(System.in);
    }




    @Override
    public void atacar(Personaje objetivo) {
        turnosRestantesParaAtacar--;
        if (turnosRestantesParaAtacar == 0) {
            this.setPoder(20);
            System.out.println("El " + this.getNombre() + " ha sobrevivido 3 turnos. Ahora tiene todo su poder de regreso.");
            handleTurnoHeroe(objetivo);
        }
    }




    private void handleTurnoHeroe(Personaje objetivo) {
        System.out.println("Elige un arma para atacar:\n" +
                "1 - " + this.armas[0].getNombre() + " (Ataque: " + this.armas[0].getAtaque() + " | Probabilidad de éxito: " + this.armas[0].getProb() + " %)\n" +
                "2 - " + this.armas[1].getNombre() + " (Ataque: " + this.armas[1].getAtaque() + " | Probabilidad de éxito: " + this.armas[1].getProb() + " %)\n" +
                "3 - " + this.armas[2].getNombre() + " (Ataque: " + this.armas[2].getAtaque() + " | Probabilidad de éxito: " + this.armas[2].getProb() + " %)");




        if (turnosRestantesParaAtacar < 1) {
            System.out.println("4 - Poción (No puedes atacar o defender por 3 turnos)");
        }




        // Código para manejar la elección de arma...




        dejarDeDefender();
    }




    public Arma[] getArmas() {
        return armas;
    }




    public void setArmas(String nombre0, int ataque0, double prob_exito0, String nombre1, int ataque1, double prob_exito1, String nombre2, int ataque2, double prob_exito2) {
        this.armas[0] = new Arma(nombre0, ataque0, prob_exito0);
        this.armas[1] = new Arma(nombre1, ataque1, prob_exito1);
        this.armas[2] = new Arma(nombre2, ataque2, prob_exito2);
    }
}
```








## Modificaciones en Juego








- **Descripción del Problema:**








La clase Juego necesitaba ser más flexible para permitir la creación de diferentes tipos de personajes y villanos.








- **Solución Del Problema:**




Se modificó la clase Juego para permitir la selección de diferentes personajes y la creación de villanos con atributos específicos. También se mejoró la legibilidad del flujo de la batalla.




- **Cambios Al Codigo:**




``` java
public class Juego {




    private Personaje personaje;
    private Villano villano;




    public Juego() {
        personaje = seleccionarPersonaje();
        villano = new Villano(150, 20, 2, 0.5, "Vampiro");
        villano.setArmas("Garra", 3, 0.5, "Colmillo", 5, 0.3, "Bastón", 10, 0.2);
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




                System.out.println("Vida restante del " + villano.getNombre() + ": " + villano.getPoder());
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
            Heroe heroe = new Heroe(150, 20, 2, 0.5, "Bárbaro");
            heroe.setArmas("Puños", 3, 0.5, "Cabezazo", 5, 0.3, "Maza", 10, 0.2);
            return heroe;
        } else if (opcion == 2) {
            Heroe heroe = new Heroe(150, 20, 2, 0.5, "Asesino");
            heroe.setArmas("Dardo", 3, 0.5, "Navaja", 5, 0.3, "Estoque", 10, 0.2);
            return heroe;
        } else if (opcion == 3) {
            Heroe heroe = new Heroe(150, 20, 2, 0.5, "Arquero");
            heroe.setArmas("Flecha", 3, 0.5, "Ballesta", 5, 0.3, "Lanza", 10, 0.2);
            return heroe;
        } else {
            System.out.println("Opción inválida. Seleccionando al Asesino por defecto.");
            Heroe heroe = new Heroe(150, 20, 2, 0.5, "Asesino");
            heroe.setArmas("Dardo", 3, 0.5, "Navaja", 5, 0.3, "Estoque", 10, 0.2);
            return heroe;
        }
    }
}
```








## Modificaciones en Personaje








- **Descripción del Problema:**








La clase Personaje necesitaba ser más flexible para permitir la definición de diferentes tipos de personajes con diferentes armas.




- **Solución Del Problema:**




Se añadieron métodos para obtener y establecer las armas de un personaje. También se agregó lógica para manejar los ataques y la recuperación de energía de los personajes.




- **Cambios Al Codigo:**




``` java
public abstract class Personaje {




    private int energia;
    private int poder;
    private int ataque;
    private double prob_exito;
    private String nombre;
    protected Arma[] armas = new Arma[3];




    public Personaje(int energia, int poder, int ataque, double prob_exito, String nombre) {
        this.energia = energia;
        this.poder = poder;
        this.ataque = ataque;
        this.prob_exito = prob_exito;
        this.nombre = nombre;
    }




    public abstract void atacar(Personaje objetivo);




    public void defender() {
        // Lógica de defensa...
    }




    public void recuperarEnergia() {
        this.energia += RECUPERACION_ENERGIA;
    }




    public boolean estaVivo() {
        return this.poder > 0;
    }




    public boolean estaDesmayado() {
        return this.energia <= UMBRAL_DESMAYO;
    }




    public int getEnergia() {
        return energia;
    }




    public void setEnergia(int energia) {
        this.energia = energia;
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




    public double getProb_exito() {
        return prob_exito;
    }




    public void setProb_exito(double prob_exito) {
        this.prob_exito = prob_exito;
    }




    public String getNombre() {
        return nombre;
    }




    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}




```


## Modificaciones en Villano








- **Descripción del Problema:**








La clase Villano necesitaba ser más flexible para permitir la creación de diferentes tipos de villanos con diferentes armas y atributos.




- **Solución Del Problema:**




Se añadió la capacidad de definir las armas del villano y se mejoró la lógica de ataque del villano.




- **Cambios Al Codigo:**




``` java
public class Villano extends Personaje {




    public Villano(int energia, int poder, int ataque, double prob_exito, String nombre) {
        super(energia, poder, ataque, prob_exito, nombre);
    }




    @Override
    public void atacar(Personaje objetivo) {
        System.out.println("El villano " + this.getNombre() + " ataca al " + objetivo.getNombre());
        if (Math.random() < this.getProb_exito()) {
            objetivo.setPoder(objetivo.getPoder() - this.getAtaque());
            System.out.println("El ataque fue exitoso! El " + objetivo.getNombre() + " ahora tiene " + objetivo.getPoder() + " de poder.");
        } else {
            System.out.println("El ataque falló!");
        }
    }
}








```


## Implementación de Poción








- **Descripción del Problema:**




Se necesitaba una funcionalidad que permitiera a los personajes tomar una poción para recuperarse durante el combate. La poción impide que el personaje ataque o se defienda durante tres turnos.




- **Solución Del Problema:**




Se añadió un método tomarPocion a la clase Heroe y se modificó la lógica de ataque para permitir esta nueva opción. Cuando el jugador elige tomar una poción, el héroe no podrá atacar ni defenderse durante los próximos tres turnos.


- **Cambios Al Codigo:**




``` java
public class Heroe extends Personaje {


    private Arma[] armas;
    private boolean defendiendo;
    private int turnosRestantesParaAtacar = 0;
    private Scanner scanner;
    private static final int UMBRAL_DESMAYO = 30;
    private static final int RECUPERACION_ENERGIA = 2;


    @Override
    public void atacar(Personaje objetivo) {
        if (turnosRestantesParaAtacar == 0) {
            handleTurnoHeroe(objetivo);
        } else {
            turnosRestantesParaAtacar--;
            if (turnosRestantesParaAtacar == 0) {
                this.setPoder(20);
                System.out.println("El Heroe ha sobrevivido 3 turnos. Ahora tiene todo su poder de regreso.");
                handleTurnoHeroe(objetivo);
            }
        }
    }


    private void handleTurnoHeroe(Personaje objetivo) {
        System.out.println("Elige un arma para atacar (1, 2 o 3):");
        if (turnosRestantesParaAtacar < 1) {
            System.out.println("Pulsa 4 para tomar una poción:");
        }
        int eleccion = scanner.nextInt();


        while (eleccion < 1 || eleccion > armas.length + 1) {
            System.out.println("Elección inválida. Por favor elige entre 1, 2, 3, o 4:");
            eleccion = scanner.nextInt();
        }


        if (eleccion < 4) {
            Arma armaElegida = armas[eleccion - 1];
            if (Math.random() < armaElegida.getProb()) {
                objetivo.recibirDano(armaElegida.getAtaque());
                System.out.println("El Guerrero ataca con éxito usando el arma " + eleccion);
            } else {
                System.out.println("El Guerrero falla el ataque.");
            }
        } else if (eleccion == 4) {
            tomarPocion();
            System.out.println("El Guerrero ha tomado una poción. No podrás atacar o defender por 3 turnos");
        }


        dejarDeDefender();
    }


    public void recuperarEnergia() {
        setEnergia(Math.min(getEnergia() + RECUPERACION_ENERGIA, 150));
    }


    public void tomarPocion() {
        turnosRestantesParaAtacar = 3;
    }
}
```




---




### *Conclusión Final*




Este proyecto nos introduce en un apasionante enfrentamiento entre un guerrero y un vampiro, ambientado en un juego por turnos donde cada decisión cuenta. La mecánica de batalla se basa en probabilidades de éxito, lo que añade un interesante elemento de azar y estrategia. La elección entre diferentes armas para el guerrero y varios tipos de ataques para el vampiro permite a los jugadores desarrollar sus propias tácticas y adaptar su estilo de juego a los desafíos que presenta el oponente.
Además, el juego se enriquece con retos adicionales como la defensa y la gestión de recursos, como la energía y las pociones de salud, lo que obliga a los jugadores a pensar críticamente y tomar decisiones bajo presión. Estas características no solo aumentan la complejidad del juego, sino que también hacen cada partida única y emocionante.
Desde el punto de vista técnico, el diseño del software está claramente estructurado, facilitando así su mantenimiento y expansión futura. Las mejoras en el código, como la optimización de nombres de variables y la estructura general, aseguran que el juego no solo funcione bien, sino que también sea accesible para otros desarrolladores que quieran aprender o contribuir al proyecto.
En resumen, este juego no es solo un pasatiempo emocionante, sino también una herramienta educativa valiosa para aquellos interesados en la programación de videojuegos y el diseño de software. Combina de manera efectiva la diversión del juego con una experiencia de aprendizaje enriquecedora, demostrando cómo teorías complejas se pueden aplicar de manera práctica y entretenida.




#### Aspectos Clave del Diseño
Nuestro proyecto es un juego desarrollado en Java que refleja un enfoque sofisticado y bien pensado en su diseño, adoptando una estructura basada en la programación orientada a objetos. Esta metodología no solo facilita la organización del código y mejora su rentabilidad, sino que también contribuye a una escalabilidad eficaz. Cada personaje, arma y elemento del juego está encapsulado en clases con responsabilidades claramente definidas, lo que refleja un diseño modular que permite fácil mantenimiento y expansión.
El juego se caracteriza por su interactividad, permitiendo a los usuarios tomar decisiones estratégicas como la selección de armas y tácticas defensivas. Esto no solo enriquece la experiencia del jugador, sino que también aporta una capa personalizada y estratégica al desarrollo del juego. Además, el sistema de batalla se basa en probabilidades para determinar el éxito de los ataques, inyectando un elemento de azar que hace que cada enfrentamiento sea único y emocionante.
Un aspecto destacado es la gestión de recursos, incluyendo la energía y la salud, que agrega profundidad a la estrategia del juego. Los jugadores deben planificar cuidadosamente su uso de recursos para maximizar sus posibilidades de victoria. La inclusión de mecánicas como la defensa y la habilidad para recuperar energía mediante pociones ofrece tácticas adicionales que los jugadores pueden utilizar para adaptarse a las condiciones cambiantes del combate.
Finalmente, la importancia de un código limpio y bien mantenido es evidente en este proyecto. Se ha hecho un esfuerzo consciente para adherirse a las mejores prácticas de programación, lo que no solo mejora la legibilidad y la gestión del código sino que también facilita la depuración y el desarrollo continuo. Esta atención al detalle garantiza que el juego no solo funcione bien sino que también sea accesible y extensible para otros desarrolladores que deseen aprender de él o contribuir en el futuro.
En conjunto, el diseño de "El guerrero vs el vampiro" combina funcionalidad con una experiencia de usuario envolvente y educativa, demostrando un equilibrio ejemplar entre la diversión del juego y la aplicación práctica de principios de desarrollo de software complejos.




#### Reflexiones y Mejoras Continuas
En el desarrollo de nuestro proyecto, se han considerado una serie de reflexiones y mejoras clave para optimizar tanto la jugabilidad como el mantenimiento del código. Desde el inicio, se adoptó un diseño modular y escalable, donde cada componente, como personajes y armas, está claramente encapsulado. Esto no solo facilita la expansión futura y el mantenimiento del juego, sino que también mejora la coherencia y la organización del código.
Una característica destacada es la interactividad controlada que se ofrece a los usuarios, permitiéndoles tomar decisiones críticas, como la selección de armas y estrategias defensivas. Esta capacidad de elección profundiza la experiencia de juego y aumenta el compromiso del usuario. Además, se implementó un sistema de batalla basado en probabilidades para determinar el éxito de los ataques, inyectando un elemento de azar que garantiza que cada partida sea única y llena de tensión estratégica.
También se ha puesto un énfasis significativo en la gestión de recursos, como la energía y la salud. Los jugadores deben gestionar cuidadosamente estos recursos para sobrevivir y triunfar, añadiendo una capa estratégica esencial al juego. Los mecanismos de defensa y recuperación de energía ofrecen tácticas adicionales que los jugadores pueden utilizar para adaptarse a las condiciones cambiantes del combate, lo que hace que cada encuentro sea dinámico y tácticamente enriquecedor.
Para asegurar que el juego no solo sea funcional sino también accesible y fácil de mejorar o corregir, se ha hecho un esfuerzo consciente para adherirse a las mejores prácticas de programación. Esto incluye la optimización de la estructura del código y el formato, eliminando el código innecesario y actualizando comentarios desactualizados para mejorar la claridad y comprensión del sistema. Además, se ha mejorado la nomenclatura dentro del código, asegurando que los nombres de variables y métodos sean intuitivos y descriptivos, facilitando así la comprensión y el trabajo de otros desarrolladores que puedan interactuar con el código en el futuro.
Estas mejoras subrayan el compromiso del equipo de desarrollo con un diseño de juego que no solo es entretenido y desafiante, sino también bien construido y sostenible a largo plazo. 
También puede haber mejoras como estas que ponemos a continuación:
Optimización del Algoritmo de Batalla: Aunque el sistema basado en probabilidades añade un elemento de incertidumbre y emoción al juego, sería beneficioso revisar y optimizar estos algoritmos para asegurar un balance adecuado entre los personajes, evitando así que alguno tenga una ventaja desproporcionada sobre el otro.
Introducción de Nuevos Personajes y Enemigos: Para mantener el interés y aumentar la rejugabilidad, se podrían introducir nuevos personajes y enemigos con habilidades únicas. Esto no solo aportaría variedad sino que también permitiría a los jugadores explorar nuevas estrategias.
Desarrollo de Una Narrativa Más Profunda: Aunque el juego ya tiene una premisa interesante, profundizar en la historia con misiones secundarias o antecedentes detallados para los personajes podría enriquecer la experiencia del usuario y dar más contexto a las batallas.
Mejoras en la Interfaz de Usuario: Aunque funcional, siempre hay espacio para mejorar la interfaz de usuario para hacerla más intuitiva y atractiva visualmente. Esto podría incluir mejores gráficos, animaciones más fluidas y una presentación más clara de las estadísticas y opciones disponibles durante el juego.
Incorporación de Modos Multijugador: Añadir modos de juego multijugador podría expandir significativamente la audiencia del juego y fomentar una comunidad activa. Los jugadores podrían competir o colaborar en tiempo real, lo que añade una dimensión social al juego.




---




Este proyecto ha representado una valiosa ocasión para poner en práctica nuestros conocimientos en programación y diseño de software. Nos ha revelado la relevancia de crear código que no solo opere correctamente, sino que también sea sencillo de mantener y expandir. A medida que sigamos perfeccionando el sistema, estas metodologías nos facilitarán realizar modificaciones de manera más efectiva y con una menor cantidad de errores.







