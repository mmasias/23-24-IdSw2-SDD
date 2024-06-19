# Diseño 📏
El diseño de software es el proceso de definir la arquitectura, componentes, interfaces y otros atributos de un sistema o componente. Este documento abarca estrategias de clasificación, relaciones entre clases y prácticas de "clean code" para asegurar la calidad y mantenibilidad del software.

## Estrategias de Clasificación
#### **Técnicas Utilizadas**:
Las estrategias de clasificación en diseño de software incluyen varias técnicas que ayudan a organizar y estructurar el código de manera efectiva. Algunas de las principales técnicas son:

- ***Descripción informal***: Método simple para identificar objetos y operaciones a partir de la descripción del problema. Consiste en escribir una descripción del problema y subrayar sustantivos y verbos. Los sustantivos representan objetos candidatos y los verbos representan operaciones candidatas.
    - **Ejemplo de Aplicación en el Proyecto** 🚀: \
    Este proyecto simula un sistema de **ascensores** en una universidad ([``BuildingController``](/src/Controllers/BuildingController.java)), con el objetivo de emular el comportamiento tanto de los ascensores como de las **personas** que los utilizan . Los ascensores están operativos todo el rato, subiendo, bajando, o quedándose en la misma **planta**. ([``ElevatorController``](/src/Controllers/ElevatorController.java))\
    Las **personas** ([``Person``](/src/Models/Person.java)) se sitúan en distintas plantas y tienen en mente cuánto tiempo van a estar en cada planta y, una vez ese tiempo llegue a 0 ([``Time``](/src/Controllers/Time.java)), a qué planta quieren ir, poniéndolas en la lista de espera (de la planta en la que se encuentren) para subir al ascensor. ([``FloorController``](/src/Controllers/FloorController.java)) \
    El **ascensor** tiene una capacidad máxima, y si está lleno no deja entrar a más personas. Si el ascensor está vacío, la persona que se encuentre en la misma **planta** que el ascensor, entra en este último y va a la planta donde quiera ir la única persona que hay en ese momento en el ascensor, y si en el ascensor tiene gente dentro, le pregunta a qué dirección va y si va a la misma dirección, la persona entra en el ascensor. ([``ElevatorController``](/src/Controllers/ElevatorController.java))\
    (Actor externo: Persona)

- ***Análisis clásico y del dominio***: 
    - **Clasico**: Identifica objetos físicos, conceptos, personas, organizaciones, lugares, dispositivos, otros sistemas, y eventos que son relevantes para el dominio del problema.
    - **Dominio**: Involucra a expertos del dominio para identificar objetos, operaciones y relaciones importantes.
    - **Ejemplo de Aplicación en el Proyecto** 🚀: [Modelo de dominio](/docs/Modelo_de_Dominio/)

- ***Análisis del comportamiento***: Se centra en el comportamiento dinámico como fuente primaria de clases y objetos.
    - **Ejemplo de Aplicación en el Proyecto** 🚀: 
        - **Time**: Clase que se encarga de actualizar todo el contenido del [``Building``](/src/Models/Building.java) entre una iteración y otra.
        - **Building**: Clase que agrupa [``Floor``](/src/Models/Floor.java), [``Elevator``](/src/Models/Elevator.java), [``Person``](/src/Models/Person.java), [``ElevatorRequest``](/src/Models/ElevatorRequest.java), [``FloorRequest``](/src/Models/FloorRequest.java) y [``ControlPanel``](/src/Models/ControlPanel.java).
        - **Floor**: Clase que contiene a las [``Person``](/src/Models/Person.java) que esperan a un [``Elevator``](/src/Models/Elevator.java) como a las que no. Cuenta con un ID de la Floor.
        - **Elevator**: Se compone de los siguientes elementos:
            - ID de [``Elevator``](/src/Models/Elevator.java)
            - [``Floor``](/src/Models/Floor.java) en la que se encuentra
            - Dirección en la que se mueve (UP, DOWN & STOP)
            - Lista de [``Person``](/src/Models/Person.java) que están dentro del [``Elevator``](/src/Models/Elevator.java)
            - Lista de [``Floor``](/src/Models/Floor.java) a las que se tiene que dirigir
            - Capacidad máxima del [``Elevator``](/src/Models/Elevator.java) (6 [``Person``](/src/Models/Person.java))
        - **Person**: Se compone de tres atributos:
            - ID
            - Tiempo que va a estar en una Floor
            - Floor de destino
        - **ElevatorRequest**: Clase que controla desde donde se llama un [``Elevator``](/src/Models/Elevator.java) y con qué intención.
        - **FloorRequest**: Clase que controla hacia qué Floor va un [``Elevator``](/src/Models/Elevator.java) seleccionado (por su ID).
        - **ControlPanel**: Clase que controla las Solicitudes de Parada y de Destino (Con los datos enviados desde [``ElevatorRequest``](/src/Models/ElevatorRequest.java) y [``FloorRequest``](/src/Models/FloorRequest.java)).
        
        **Commit de creación de los modelos:** [Commit](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/4de21e124a7b60523a4efe4f8ea67d02d0659c10)

## Relaciones entre Clases
### Colaboración
#### **Técnicas Utilizadas**:
Las relaciones por colaboración se definen por la forma en que los objetos interactúan entre sí para cumplir con sus responsabilidades. Las principales técnicas son:

- **Composición / Agregación** : En la composición los componentes constituyen obligatoriamente una parte del objeto compuesto, al destruir el objeto compuesto ambos desaparecen a diferencia de la agregación que la constitución es opcional y pueden existir sin él.
    - *Un ejemplo* de agregación son las listas empleadas en este proyecto, como la lista de personas de un ascensor (peopleInside, que en este caso es un [``PersonList``](/src/Lists/PersonList.java)), sin el ascensor las personas siguen existiendo.
    ```java
    public class PersonList {
        private ModelList<Person> people;

        public PersonList() {
            this.people = new ModelList<Person>();
        }

        public ArrayList<Person> index() {
            return this.people.index();
        }

        public Person get(int index) {
            return this.people.get(index);
        }

        public void create(int id, int timeOnFloor, int destination) {
            this.people.add(new Person(id, timeOnFloor, destination));
        }

        public void update(int id, Person updatedPerson) {
            this.people.update(id, updatedPerson);
        }

        public void delete(int id) {
            this.people.delete(id);
        }

        public void add(Person person) {
            this.people.add(person);
        }
    }

    ```
    - *Un ejemplo* de composición es la relación entre [``Building``](/src/Models/Building.java) y [``ControlPanel``](/src/Models/ControlPanel.java), sin edificio no puede existir ``ControlPanel``.
    ``` java
    public class Building {
        private FloorList floors;
        private ElevatorList elevators;
        private ControlPanel controlPanel;
        private Counters counters;

        public Building() {
            // ...
            this.controlPanel = new ControlPanel();
        }

        // ...

        public ControlPanel getControlPanel() {
            return this.controlPanel;
        }

        public void updateControlPanel(ControlPanel controlPanel) {
            this.controlPanel = controlPanel;
        }

        // ...

    }
    ```
- **Asociación**: La asociación se refiere a una relación en la que dos objetos pueden existir independientemente uno del otro, pero interactúan para realizar ciertas operaciones.
    - *Por ejemplo*: [``BuildingController``](/src/Controllers/BuildingController.java) y [``Building``](/src/Models/Building.java): En el ``BuildingController``, hay una relación de asociación con ``Building``. La clase ``BuildingController`` tiene un atributo de tipo ``Building`` y llama a sus métodos para actualizar la información del edificio.
    ```java
    import src.Models.Building;

    public class BuildingController {
        private Building building;
        // ...

        public BuildingController(Building building) {
            this.building = building;
            // ...
        }

        public Building update() {
            // ...
            return this.building;
        }
    }
    ```

- **Dependencia (Uso)**: Es la relación que se establece momentáneamente entre una clase A y una clase B.
    - *Ejemplo*: En este proyecto la relación entre una persona y un ascensor es de uso. 
    Un *ejemplo de codigo* se puede apreciar en elevator controller donde se utiliza la clase ``Elevator``
    ```java
    private void updateElevatorPeople(Elevator elevator) {
        int currentFloorId = elevator.getCurrentFloor();
        Floor currentFloor = this.building.getFloors().get(currentFloorId);

        this.processPeopleInside(elevator, currentFloor);
        this.processWaitingPeople(elevator, currentFloor);

        this.building.updateElevator(elevator);
    }
    ```

En el [Diagrama de Clases](/docs/Modelo_de_Dominio/Diagramas_de_Clases/) se puede ver los tipos de relaciones entre las diferentes clases
\
En el siguiente [Commit](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/c4280d7fc28d873d8b2a8bff1b058ab5a97a09d0) se aprecia la implementacion de las anteriores tecnicas en una version anterior del *Diagrama de clases*, [aquí el cambio del SVG](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/1feb5b31885cd6b4b10342c61d90d352ffa316f7).


### Transmisión
#### **Técnicas Utilizadas**:
Las relaciones por transmisión se refieren a la forma en que las clases heredan atributos y métodos de otras clases. Las principales técnicas son:
 - **Herencia por extensión**: Técnica donde una clase derivada extiende la funcionalidad de una clase base.
    - *ejemplo*: ``ModelList`` es un claro ejemplo de transmisión por extensión, ya que a traves de la restriccion `<T extends IModel>` permite cualquier clase que implemente `IModel` pueda ser utilizada como tipo genérico ``T``, asegurando que estas clases transmitan las propiedades y métodos de IModel a ModelList.
    ```java
    public class ModelList<T extends IModel> {
        // ...
    }
    ```
    ```java
    public interface IModel {

    public int getId();

    }
    ```
- **Herencia por implementación**:Técnica donde una clase derivada transforma el concepto de la clase base
    - *ejemplo*: Las clases ``Elevator``, ``Floor`` y ``Person`` implementan la interfaz ``IModel``, las clases deben implementar todos los métodos definidos en la interfaz, en este caso ``getID()``

    ```java
    public class Person implements IModel {
    private int id;
    // ...

    public Person(int id, int timeOnFloor, int destination) {
        this id = id;
        // ...
    }

    public int getId() {
        return this.id;
    }

    // ...
    
    }
    ```


## Clean Code: Legibilidad
#### **Técnicas Utilizadas**:
Para asegurar la legibilidad y mantenibilidad del código, se utilizan diversas técnicas de "clean code" como:



 1. **Nombres significativos**: Utilizar nombres descriptivos para variables, funciones y clases.
    - **Ejemplo de aplicación en el proyecto**🚀:
Cambio del nombre de someoneStopped a a isSomeoneAvaliable para comprobar si un ascensor está disponible para ser llamado. [Commit](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/5aad8933969adaab39d1574bce21dc13e0063a04) 

 2. **Funciones pequeñas**: Dividir funciones grandes en funciones más pequeñas y específicas.
    - **Ejemplo de aplicación en el proyecto**🚀: Refactorización del método ``render()`` en varios métodos que se encargan de renderizar cada una de las partes: [Commit](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/1248239af394faaa8c709dad52fbeab1666a0e4a) 

 3. **Eliminación de comentarios innecesarios**:Reducir comentarios y dejar que el código claro hable por sí mismo.
    - **Ejemplo de aplicación en el proyecto🚀**: No hemos podido aplicarlo ya que todas las explicaciones sobre el funcionamiento del código se encuentran en documentos aparte. 
 4. **Consistencia en el estilo de código**: Mantener una uniformidad de código en todo el proyecto que facilita su lectura pero, sobre todo, su modificación.
    - **Ejemplo de aplicación en el proyecto🚀**: Se ha logrado cambiando un valor fijo a uno dinamico [Commit](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/1ca59af256ab6fdf7fbe3b512ee9bf0293fca2e4). También hemos cambiado ``DebuggerView`` para que sea más fácil de leer y esté mejor estructurado. [Commit](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/ca1303e1481e95052e5d1f41634e30b4e5f4dccd?diff=unified&w=0) 

5. **Código Muerto**:Fragmentos de código injustificables, inexplicables u obsoletos en el sistema: interfaces, clases, funciones o segmentos de código complejo con aspecto importante pero que no están relacionados con el sistema.
    - **Ejemplo de aplicación en el proyecto🚀**: Eliminación de método en desuso innecesario (En ``ElevatorRequestList``). [Commit](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/f25ab037c1f816f2440dcb4c4e39852fde4f8654) 
