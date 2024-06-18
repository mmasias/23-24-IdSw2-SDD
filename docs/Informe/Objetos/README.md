# Diseño Orientado a Objetos 🎨

## Introducción SOLID 📚

En el desarrollo de software, el diseño modular orientado a objetos se ha convertido en un paradigma esencial para crear sistemas robustos, mantenibles y escalables. Este enfoque se basa en la aplicación de principios sólidos que guían a los desarrolladores en la estructuración de su código de manera eficiente. Entre estos principios destacan los que componen el acrónimo SOLID, cada uno abordando un aspecto crítico del diseño orientado a objetos.

- ## Principio de Responsabilidad Única (SRP) 🎯

    ### Definición 📝

    En ingeniería de software, se establece que cada módulo o clase debe tener la responsabilidad de una única parte de la funcionalidad del software, y esta responsabilidad debe estar completamente encapsulada dentro de la clase.

    ### Ejemplo 🚀

    En PyAscenosres, hemos aplicado este principio con las clases de impresión de la simulación por consola. A continuación, se muestra un fragmeto de la clase `BuildingView`, que se encarga de imprimir la simulación, y otro de `ElevatorView`, una clase que se encarga de generar el string a imprimir los ascensores.(Código extraido del siguiente [commit](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/05f681140a3dd07236a70253ebaba8cd54ddef18))

    ```java

    public class BuildingView {
        // ...

        public BuildingView(Building building, boolean isTesting) {
            // ...
        }

        public void render() {
            ArrayList<String[]> views = this.getViews(building);
            String mergedViews = this.mergeViews(views, building);
            System.out.println(mergedViews);

            DebuggerView debugger = new DebuggerView(building, this.isTesting);
            debugger.render();
        }

        private ArrayList<String[]> getViews(Building building) {
            ArrayList<String[]> views = new ArrayList<String[]>();

            ArrayList<Elevator> elevators = building.getElevators();
            ArrayList<Floor> floors = building.getFloors();

            ElevatorView elevator = new ElevatorView(elevators, floors.size());
            FloorView floor = new FloorView(floors);
            PeopleOnFloorView peopleOnFloor = new PeopleOnFloorView(floors);
            WaitingPeopleView peopleWaiting = new WaitingPeopleView(floors);

            views.add(floor.render());
            views.add(peopleWaiting.render());
            views.add(elevator.render());
            views.add(peopleOnFloor.render());

            return views;
        }

        private String mergeViews(ArrayList<String[]> views, Building building) {
            // ...
        }

        private String spacesBeforeAndAfter(int SpacesBefore, int SpacesAfter, String text) {
        // ...
        }
    }

    ```

    ```java
    public class ElevatorView {

        public ElevatorView(List<Elevator> elevators, int totalFloors) {
            // ...
        }

        public String[] render() {
            ArrayList<String[]> renderedElevators = new ArrayList<String[]>();
            for (Elevator elevator : elevators) {
                String view[] = getElevatorView(elevator).split("\n");
                renderedElevators.add(view);
            }

            String[] view = mergeElevatorsViews(renderedElevators);
            return view;
        }

        private String getElevatorView(Elevator elevator) {
            StringBuilder elevatorView = new StringBuilder();
            int currentFloor = elevator.getCurrentFloor();
            char direction = directionIcons[elevator.getDirection().ordinal()];

            for (int i = totalFloors - 1; i >= 0; i--) {
                if (i == currentFloor) {
                    int peopleInside = elevator.getPeopleInside().size();
                    String elevatorStr = "[" + direction + peopleInside + direction + "] ";
                    elevatorView.append(elevatorStr);
                } else {
                    elevatorView.append(" | |  ");
                }
                elevatorView.append("\n");
            }

            return elevatorView.toString();
        }

        private String[] mergeElevatorsViews(ArrayList<String[]> views) {
            // ...
        }
    }

    ```

- ## Principio Abierto/Cerrado (OCP) 🚪

    ### Definición 📝

    Este principio establece que las clases deben estar abiertas para su extensión, pero cerradas para su modificación. Es decir, una clase debe ser fácilmente extensible sin necesidad de modificar su código fuente.

    ### Ejemplo 🚀

    En nuestro caso, en el desarrollo de las listas que utilizamos para almacenar las instancias de los modelos de la simulación, hemos aplicado este principio. Hemos creado una clase tipo T `modelList` en la que se definen e implementan funciones básicas que estas listas deben de tener. Para no modificar esta clase base y poder añadir funcionalidades, hemos creado una clase lista para cada modelo, que instancian la clase `modelList`. A continuación, se muestra un fragmento de la clase `PeopleList`, que instancia `modelList`, y otro fragmento de la clase `modelList`. (Código extraido del siguiente [commit](https://github.com/jramsgz/23-24-IdSw2-SDD/commit/96ab09382a5a25e2f9d7b1bc3735d2f3c7184926))


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

    ```java
    public class ModelList<T extends IModel> {
        private ArrayList<T> modelList;

        public ModelList() {
            this.modelList = new ArrayList<T>();
        }

        public ArrayList<T> index() {
            return this.modelList;
        }

        public T get(int index) {
            for (T model : this.modelList) {
                if (model.getId() == index) {
                    return model;
                }
            }
            return null;
        }

        public void add(T model) {
            this.modelList.add(model);
        }

        public void update(int id, T updatedModel) {
            int position = this.getListPosition(id);
            this.modelList.set(position, updatedModel);
        }

        public void delete(int id) {
            int position = this.getListPosition(id);
            this.modelList.remove(position);
        }

        private int getListPosition(int id) {
            for (int i = 0; i < this.modelList.size(); i++) {
                if (this.modelList.get(i).getId() == id) {
                    return i;
                }
            }
            return -1;
        }
    }
    ```

- ## Principio de Sustitución de Liskov (LSP) 🧩

    ### Definición 📝

    Este principio establece que los objetos de una clase derivada deben poder sustituir a los objetos de la clase base sin afectar el comportamiento del programa. Es decir, una clase derivada debe ser capaz de reemplazar a su clase base sin que el programa falle.

    ### Ejemplo 🚀

    En nuestro caso, al tener una herencia reducida, no hemos tenido la necesidad de aplicar este principio.