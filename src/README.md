# Implementación de principios SOLID - Versión 4
Nuestro juego se compone del funcionamiento de una aspiradora donde se aplican principios SOLID, asegurando que el diseño del software sea modular, flexible y fácil de mantener. A continuación, se explica cómo cada uno de los principios SOLID se aplica a esta simulación:

## Principio de Responsabilidad Única (SRP)

**Antes de su implementación:**

Las clases se encargaban de realizar distintas acciones que podian llegar a confundir. La clase aspiradora realizaba más de su propia función, al igual que las demás.

**Después de su implementación:**

Al aplicarle el principio de responsabilidad, cada clase que se mencionará tiene un comportamiento único:
- La clase "ControladorAspiradora" se encarga unicamente del funcionamiento de la aspiradora.
- La clase "ControladorGato" se encarga unicamente del comportamiento del gato.
- La clase "ControladorHabitación" se encarga unicamente de la compocisión de la habitación.

## Principio de Inversión de Dependencias (DIP)

**Antes de su implementación:**

Las clases "ControladorGato" y "ControladorHabitacion" eran más extendidas, donde su metodo "mover" era más complejo y contenia la lógica de movimiento.

**Después de su implementación:**

- Se agregó una clase abstracta llamada "Movible" en los controladores que tendría los metodos respectivos de movimientos.
- Se pone el metodo "Mover(Habitacion habitacion)" en la clase abstracta "Movible".
- Las clases "ControladorGato" y "ControladorAspiradora" extienden a "Movible" en su propia implementación del método mover.

## Principio Abierto/Cerrado (OCP)

**Antes de su implementación:**

La generación de la superficie y los muebles estaba embebida dentro de la clase "Habitacion", lo que requeriría modificar la clase si se cambiaba la manera de generar estos elementos.

**Después de su implementación:**

Ahora la clase habitación depende de la clase "FabricarElementos" que contiene los metodos "GenerarSuperficie" y "GenerarMuebles" permitiendo extender la funcionalidad de generación sin modificar la clase Habitacion.

## Documentación

### Diagrama de Clases

|Diagrama|Código|
|-|:-:|
|![Diagrama de Clases](/img/DiagramaDeClases.svg)|[Código UML](/modelosUML/DiagramaDeClases.puml)|

### Diagrama de Estado - Aspiradora

|Diagrama|Código|
|-|:-:|
|![Diagrama de Estado](/img/DiagramaEstado.svg)|[Código UML](/modelosUML/DiagramaDeEstado.puml)|

### Diagrama de Estado - Azulejo

|Diagrama|Código|
|-|:-:|
|![Diagrama de Estado](/img/DiagramaEstado2.svg)|[Código UML](/modelosUML/DiagramaDeEstadopt2.puml)|

### Diagrama de Objetos

|Diagrama|Código|
|-|:-:|
|![Diagrama de Objetos](/img/ModeloDeObjetos.svg)|[Código UML](/modelosUML/DiagramaDeObjetos.puml)|

[Regresar a la pantalla principal](/README.md)
