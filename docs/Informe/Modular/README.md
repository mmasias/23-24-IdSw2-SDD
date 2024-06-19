# Diseño Modular 🧩

En el diseño modular orientado a objetos, la creación de sistemas se basa en dividir la funcionalidad en módulos manejables y cohesivos. Cada módulo debe cumplir con ciertas propiedades como cohesión, acoplamiento, y granularidad, para asegurar la mantenibilidad y escalabilidad del software. Además, identificar y evitar \"smell codes\" ayuda a mantener un código limpio y eficiente.

## Cohesión 📦

### Definición 📝
La cohesión se refiere al grado en que los elementos de un módulo pertenecen juntos. Un módulo altamente cohesivo realiza una única tarea o un conjunto de tareas estrechamente relacionadas, facilitando su comprensión y mantenimiento.

### Ejemplo 🚀
En nuestro proyecto, cada clase tiene responsabilidades claramente definidas y encapsuladas. Por ejemplo, la clase `Elevator` solo maneja la lógica relacionada con el comportamiento del ascensor, mientras que la clase `Person` se encarga de la información y el comportamiento de las personas.

```java
public class Elevator {
    private int id;
    private int capacity;
    private PersonList peopleInside;
    private int currentFloor;
    private Direction currentDirection;
    private FloorsToGoList floorsToGoList;
    
    // Métodos relacionados con el movimiento del ascensor
}
```

Se crearon listas de modelos para gestionar delegar la responsabilidad de manejar las listas de modelos a una clase específica y evitar dicha lógica en las clases de modelo.

[Commit de Ejemplo](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/590e5ff5c5ac3467b324918066cfe8d06288971c)

## Acoplamiento 🔗

### Definición 📝
El acoplamiento se refiere al grado de interdependencia entre los módulos. Un bajo acoplamiento significa que los módulos pueden funcionar de manera independiente, facilitando la modificación y reutilización del código.

### Ejemplo 🚀
En nuestro proyecto, hemos utilizado interfaces para reducir el acoplamiento entre las clases. Por ejemplo, la interfaz `IModel` permite que las clases `Building`, `ControlPanel`, `Person`, `Elevator`, y `Floor` sean tratadas de manera uniforme en `ModelList`.

```java
public interface IModel {
    int getId();
}

public class ModelList<T extends IModel> {
    private List<T> modelList;
    
    // Métodos para manejar la lista de modelos
}
```
[Commit de Ejemplo](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/96ab09382a5a25e2f9d7b1bc3735d2f3c7184926)

## Granularidad 🌾

### Definición 📝
La granularidad se refiere al tamaño y alcance de un módulo. Los módulos deben ser lo suficientemente pequeños para ser comprensibles y manejables, pero lo suficientemente grandes para encapsular una funcionalidad significativa.

### Ejemplo 🚀
Hemos dividido el código en clases pequeñas y específicas. Por ejemplo, la clase `BuildingView` se encarga solo de la visualización del edificio y delega la visualización de componentes específicos a otras clases.

```java
public class BuildingView {
    private Building building;
    private boolean isTesting;
    
    public BuildingView(Building building, boolean isTesting) {
        this.building = building;
        this.isTesting = isTesting;
    }

    // Lógica para renderizar el edificio
    public void render() {
        // ...

        ArrayList<String[]> views = new ArrayList<String[]>();

        views.add(floorView.render());
        views.add(peopleOnFloorView.render());
        views.add(elevatorView.render());

        // ...
    }
}
```
[Commit de Ejemplo](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/ccc7f4fd11fcef8822c3229737a376a9f209c519)

## Smell Codes 🚨 #TODO

### Definición 📝
Los "smell codes" son indicativos de posibles problemas en el código que pueden afectar su mantenibilidad y escalabilidad. Identificar y eliminar estos "olores" ayuda a mantener un código limpio.

### Ejemplos 🚀

#### Relacionados con la Cohesión

- **Alternative Classes with Different Interfaces**: Clases que realizan tareas similares pero tienen interfaces diferentes. 
    - *Ejemplo*: En nuestro proyecto, todas las clases que requieren un ID implementan la interfaz `IModel`, asegurando consistencia.

    ```java
    public interface IModel {
        int getId();
    }
    ```

### Patrón Modelo-Vista-Controlador (MVC) 🖼️

### Definición 📝
El patrón Modelo-Vista-Controlador (MVC) es una arquitectura que separa la aplicación en tres componentes principales:
- **Modelo**: Maneja la lógica de datos y la representación del negocio.
- **Vista**: Representa la interfaz de usuario.
- **Controlador**: Maneja la entrada del usuario y la interacción entre el Modelo y la Vista.

### Ejemplo 🚀
En nuestro proyecto, implementamos el patrón MVC para separar las responsabilidades de renderizado y lógica de negocio.

```java
// Modelo
public class Person {
    private int id;
    private int timeOnFloor;
    private int destination;
    
    // Métodos relacionados los datos de la persona
}

// Vista
public class BuildingView {
    private Building building;
    
    public void render() {
        // Lógica para renderizar el edificio
    }
}

// Controlador
public class BuildingController {
    private Building building;
    private ElevatorController elevatorController;
    private FloorController floorController;
    private ControlPanelController controlPanelController;
    
    public BuildingController(Building building) {
        // Constructor para inicializar el controlador
    }
    
    public Building update() {
        // Lógica para actualizar el estado del edificio
    }
}
```
[Commit de Ejemplo](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/3e25dcb72eb13c9dd82c8e32f15a5a712b19e124)
