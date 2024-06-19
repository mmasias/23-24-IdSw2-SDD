# Implementación de principios SOLID - Versión 4
Nuestro juego se compone del funcionamiento de una aspiradora donde se aplican principios SOLID, asegurando que el diseño del software sea modular, flexible y fácil de mantener. A continuación, se explica cómo cada uno de los principios SOLID se aplica a esta simulación:

## Principio de Responsabilidad Única (SRP)
Se ha implementado este principio para mantener claro el funcionamiento de cada parte de la simulación, a continuacion se detallara donde se ha aplicado:

-La clase "ControladorAspiradora" se encarga unicamente del funcionamiento de la aspiradora.
-La clase "ControladorGato" se encarga unicamente del comportamiento del gato.
-La clase "ControladorHabitación" se encarga unicamente de la compocisión de la habitación.

## Principio de Inversión de Dependencias (DIP)

Las clases "ControladorGato" y "ControlAspiradora" dependen de la abstracción "Movible" que puede ser modificada sin afectar dichas clases.

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


## Explicación del código

El proyecto se mueve por 3 diferentes carpetas las cuales tenemos **Modelo**, **Vista**, **Controlador** lo cual esto nos sirve tener como mayor manejo de funcionalidades al momento de repartir responsabilidades y atributos para cada clase

### Carpeta Controlador 📂

### Carpeta Modelo 📂

Las clases de los modelos se han creado acorde de mantener el estado y las propiedades del juego que se va cambiando de estado o moviendo dependiendo de las circunstancias del programa y con una única responsabilidad definida.

Las clases están diseñadas para ser extendidas mediante la adición de nuevos métodos o funcionalidades, lo cuál son la base para derivar otras clases sin problemas, siempre y cuando las subclases mantengan las propiedades de la clase base.

### Carpeta Vista 📂

En las clases que contiene esta carpeta su mayor funcionalidad y única es mostrar mensajes relacionados al juego que en este caso son los siguientes:

- Consola: Esta se encarga de la interacción con el usuario a través de la consola, lo que incluye recibir entradas y mostrar mensajes
- Utils: Clase encarga de definir y manejar un enum con valores asociados a ellos.
- VistaAspiradora: Encarga de mostrar mensajes relacionados con el estado y las acciones de la aspiradora.
- VistaGato: Clase que mostra mensajes relacionados con la acción del gato de ensuciar una casilla.
- VistaHbitacion: Responsable de representar visualmente el estado de la habitación.

[Regresar a la pantalla principal](/README.md)
