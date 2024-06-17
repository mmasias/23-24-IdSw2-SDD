# Memoria del Sistema de Gestión de Centro Comercial

## Tabla de Contenidos

- [Introducción](#introducción)
- [Diseño](#diseño)
- [Diseño Modular](#diseño-modular)
- [Diseño Orientado a Objetos](#diseño-orientado-a-objetos)
- [Conclusión](#conclusión)

A continuación se presenta el diagrama que ilustra la estructura del proceso de diseño seguido en el desarrollo del sistema. Este diagrama proporciona una visión general y secuencial de las etapas principales del diseño:

![Diagrama de Diseño](../images/plan.svg)

## Introducción

Este documento detalla las mejoras implementadas en el Sistema de Gestión de Centro Comercial, destacando el uso de prácticas de diseño modular, código limpio y diseño orientado a objetos para mejorar la mantenibilidad, legibilidad y escalabilidad del sistema.

## Diseño

### Código Limpio

Implementamos mejoras significativas en la base de código para aumentar la legibilidad y mantenibilidad, siguiendo principios de código limpio:

- **Eliminación de Código Muerto**: Se eliminaron bloques de código no utilizados y se depuraron los comentarios obsoletos para clarificar la funcionalidad del sistema.
- **Nombres Descriptivos**: Se revisaron los nombres de variables y métodos para que sean intuitivos y descriptivos, facilitando la comprensión del código.
- **Estructura y Formato Mejorado**: Se ajustó la estructura del código para seguir un estilo consistente y legible, utilizando adecuadamente la indentación y el espaciado.

```java
//Antes
int a = 6; // Límite de 6 cajas registradoras

//Después
int maxCashRegisters = 6;
```

## Diseño Modular


### 1.Cohesión

#### 1.1 Alternative classes with different interfaces

Tras realizar una revisión detallada del código implementado, creemos que no es necesario introducir interfaces. El diseño actual del sistema muestra una clara separación de responsabilidades y una interacción efectiva entre las clases, lo que facilita la extensibilidad y el mantenimiento del código.

##### Clases y Responsabilidades:

- **CashRegister y AttentionCenter**: Estas clases gestionan las operaciones en las cajas registradoras y la asignación de clientes a las cajas, respectivamente. Aunque interactúan estrechamente, cada una tiene responsabilidades bien definidas que no se solapan.
- **Customer y CustomerQueue**: Customer es una entidad de datos que representa al cliente, mientras que CustomerQueue administra operaciones de cola para grupos de clientes. Las responsabilidades de manejo de datos versus operaciones de cola están bien separadas.
- **DataLog**: Se encarga de la recopilación de estadísticas y el registro de eventos operativos, funcionando como un sistema de logging sin interferir o duplicar funcionalidades de otras clases.
- **Main y Time**: Main controla la simulación diaria usando la clase Time para el seguimiento del tiempo. Time sirve exclusivamente para controlar el avance temporal dentro de la simulación.

#### 1.2 Features envy - Envidia de características

El código gestiona principalmente operaciones del centro comercial mediante clases que representan distintos aspectos de un sistema de gestión (ejemplo: clientes, cajeros, registros de cajas). Las clases tienen bien definidas sus responsabilidades, como:

- `CustomerQueue` gestiona la cola de clientes.
- `CashRegister` maneja las operaciones de las cajas registradoras.
- `AttentionCenter` coordina las acciones entre cajas registradoras y la cola de clientes.

No se evidencia un "Features Envy", ya que cada clase maneja sus propios datos y comportamientos adecuadamente.

Ejemplo:

```java
public void assignCustomersToCashRegisters() {
    …
    for (CashRegister cashRegister : cashRegisters) {
        if (cashRegister.isOpen() && !cashRegister.isOccupied() && customerQueue.getSize() > 0) {
            Customer customer = customerQueue.peekCustomer();
            cashRegister.serveCustomer(customer);
            customerQueue.removeCustomer();
        }
    }
}
```

En este fragmento del codigo, `AttentionCenter` no modifica directamente los datos de `CustomerQueue` o `CashRegister`, sino que invoca sus métodos públicos, lo cual es un indicativo de un diseño limpio y modular. Si se observara que métodos de una clase manipulan excesivamente detalles internos de otra, sería necesario reconsiderar la distribución de responsabilidades, posiblemente moviendo métodos o datos para alinear mejor con el principio de responsabilidad única.

#### 1.3 Data class - Clase de datos

Hemos realizado cambios para mejorar la encapsulación y la cohesión del diseño. Es la clase `Customer` la que controla sus propios datos asegurando de que los cambios en sus atributos se hacen internamente, asegurando la modularidad.

**Metodo antes de los cambios:**

```java
   public void processCustomer(ShoppingCenter shoppingCenter) {
        if (this.isOccupied && this.currentCustomer != null) {
            int remainingItems = this.currentCustomer.getNumberOfItemPacks() - 1;
            this.currentCustomer.setNumberOfItemPacks(remainingItems);
            if (remainingItems <= 0) {
                shoppingCenter.removeCustomer(this.currentCustomer);
                finishServingCustomer();
            }
        }
    }

```

**Metodo despues de los cambios:**

```java
public void processCustomer(ShoppingCenter shoppingCenter) {
        if (this.isOccupied && this.currentCustomer != null) {
            this.currentCustomer.reduceNumberOfItemPacks(this.currentCustomer.getNumberOfItemPacks());
            if (this.currentCustomer.getNumberOfItemPacks()<=0) {
                shoppingCenter.removeCustomer(this.currentCustomer);
                finishServingCustomer();
            }
        }
    }
```

**Método nuevo para asegurar la encapsulación:**

```java
   public int reduceNumberOfItemPacks(int numberOfItemPacks) {
        return this.numberOfItemPacks--;
    }
```

#### 1.4 Divergent Change - Cambios divergentes

El código actual parece respetar bastante bien el Principio de Responsabilidad Única, con clases enfocadas en tareas específicas y relacionadas. Sin embargo, sí que es conveniente cambiar la clase `AttentionCenter`, que, por la naturaleza de sus responsabilidades, podrían expandirse en formas que lleven a cambios divergentes.

Las responsabilidades incluyen manejar la apertura y cierre de la caja, procesar clientes, manejar pausas y cambios de turno, y mantener el estado de ocupación.

Para mejorar la adherencia al Principio de Responsabilidad Única (SRP), podríamos introducir las siguientes modificaciones en el código:

- La gestión de turnos y pausas podría delegarse a una clase separada, que se encargue de administrar los horarios y estados de los cajeros. Esto podría llamarse `CashierManager`.

  - Nueva Clase `CashierManager`:
    - Responsabilidades:
      - Gestionar los turnos de los cajeros.
      - Iniciar y terminar pausas.
      - Coordinar los cambios de turno.
    - Modificación en `CashRegister`:
      - Eliminar toda la lógica de manejo de turnos y pausas.
      - Interactuar con `CashierManager` para consultar o modificar el estado del cajero.

- El procesamiento de clientes podría ser manejado por otra clase que se enfoque exclusivamente en la interacción entre el cliente y la caja registradora, como `TransactionManager`.

  - Nueva Clase `TransactionManager`
    - Responsabilidades:
      - Procesar las compras de los clientes.
      - Gestionar la asignación de clientes a cajas.
      - Finalizar las transacciones y actualizar el estado del cliente.
    - Modificación en `CashRegister`:
      - Delegar todas las operaciones de procesamiento de clientes a `TransactionManager`.
      - Mantener una interfaz simple para iniciar y terminar la ocupación de la caja.

  Estas refactorizaciones ayudarán a que `CashRegister` se enfoque en su responsabilidad principal de mantener el estado de la caja y delegue otras funciones a clases especializadas.

#### 1.5 Shotgun Surgery - Cirugía a escopetazos

##### Introducción

En el proceso de desarrollo y revisión de nuestro sistema de cajas registradoras, hemos identificado un problema conocido como "Shotgun Surgery". Este problema ocurre cuando realizar un cambio pequeño requiere modificaciones en múltiples clases, lo que dificulta el mantenimiento y la escalabilidad del código. En este documento, describimos el problema encontrado y proponemos una solución que se implementará en futuras versiones del proyecto.

##### Descripción del Problema

Actualmente, nuestro sistema incluye las siguientes clases principales:

1. CashRegister.
2. Customer.
3. Cashier.
4. AttentionCenter.
5. ShoppingCenter.

En la implementación actual, la clase `CashRegister` tiene interacciones directas y múltiples dependencias con las clases `Customer`,` Cashier`,` AttentionCenter` y `ShoppingCenter`. Esto significa que cualquier cambio en la lógica de `CashRegister` requiere modificaciones en todas estas clases, generando el problema de Shotgun Surgery.

##### Ejemplo del Problema

Por ejemplo, si necesitamos cambiar la manera en que se gestiona el servicio de un cliente (`Customer`), tendríamos que modificar:

- `CashRegister`: para ajustar cómo se interactúa con el cliente.
- `Customer`: para ajustar los atributos o métodos.
- `AttentionCenter`: para gestionar adecuadamente el cambio de cajeros.
- `ShoppingCenter`: para gestionar la agregación de clientes.

Esto genera una alta dependencia entre las clases y aumenta el riesgo de introducir errores al realizar cambios.

##### Propuesta de Mejora

Para mitigar el problema de Shotgun Surgery y mejorar la mantenibilidad del código, proponemos centralizar las operaciones relacionadas con las entidades principales en clases de servicio dedicadas. Esta estrategia reduce la necesidad de realizar cambios en múltiples lugares y facilita la encapsulación de la lógica relacionada con cada entidad.

##### Propuesta Específica

1. Crear clases de servicio para cada entidad principal:

- `CustomerService`: para manejar las operaciones relacionadas con los clientes.
- `CashierService`: para manejar las operaciones relacionadas con los cajeros.
- `CashRegisterService`: para centralizar las operaciones de las cajas registradoras.

2. Centralizar las operaciones de negocio:

- Las operaciones específicas de `Customer`, `Cashier` y `CashRegister` se moverían a sus respectivas clases de servicio. Esto incluye operaciones como actualizar el número de paquetes de un cliente, cambiar el cajero asignado, y procesar el servicio de un cliente en la caja registradora.

##### Beneficios Esperados

- **Centralización de cambios**: Las operaciones relacionadas estarán centralizadas, lo que significa que cualquier cambio en la lógica solo afectará una clase específica.
- **Reducción de impacto por cambios**: Al minimizar los puntos de modificación dispersos, el código se vuelve más fácil de mantener y más robusto ante futuros cambios.
- **Mejor encapsulación y cohesión**: Cada clase manejará mejor sus propias operaciones, adhiriéndose más firmemente al principio de encapsulación y mejorando la cohesión del sistema.

##### Conclusión

Aunque no disponemos del tiempo necesario para implementar estos cambios en la versión actual del proyecto, hemos identificado claramente la necesidad de refactorizar nuestro sistema para evitar el problema de Shotgun Surgery. La implementación de estas mejoras se planificará para futuras versiones, garantizando un código más mantenible, escalable y robusto.


#### 1.6 Data Clumps - Grupo de datos

En nuestro proyecto, hemos estructurado las clases para minimizar los "Data Clumps", asegurando que cada clase maneja su propia información sin redundancias. Por ejemplo, la clase `CashRegister` encapsula todas las operaciones y estados relevantes de las cajas registradoras, desde manejar a un cliente hasta controlar los estados de apertura y ocupación.

**Ejemplo del Código Existente:**

```java
public class CashRegister {
    private int id;
    private Cashier currentCashier;
    private Customer currentCustomer;
    private boolean isOpen;
    private boolean isOccupied;

    public CashRegister(int id, AttentionCenter attentionCenter) {
        this.id = id;
        this.isOpen = false;
        this.isOccupied = false;
    }

    public void serveCustomer(Customer customer) {
        this.currentCustomer = customer;
        this.isOccupied = true;
    }
}
```

**Sugerencia de Mejora Posible**

Aunque no se detectaron clumps significativos, una sugerencia podría ser encapsular configuraciones repetitivas o agrupaciones de propiedades que se usan a través de múltiples clases, similar al `NetworkConfig` en el ejemplo teórico. Por ejemplo, si las cajas registradoras o el sistema en general tuvieran configuraciones de red o parámetros de conexión que se repiten, estos deberían encapsularse en una clase aparte.

#### 1.7 Primitive Obsession - Obsesión por tipos primitivos

##### Descripción del Problema

En el código actual, se observa una dependencia excesiva en tipos primitivos para representar información que podría beneficiarse de una mayor abstracción. Esta práctica, conocida como "Primitive Obsession", puede llevar a problemas de mantenibilidad y claridad en el sistema.

##### Ejemplos Identificados

Uno de los ejemplos más claros de este problema se encuentra en el manejo de las propiedades de la clase Customer, que actualmente utiliza tipos primitivos para representar la cantidad de paquetes de artículos (`numberOfItemPacks`). Esto simplifica la representación, pero limita las posibilidades de manejo más avanzado de la información, como validaciones específicas o métodos adicionales relacionados con los paquetes.

##### Solución Propuesta: Introducción de la Clase ItemPack

Para solucionar la obsesión por los tipos primitivos y mejorar la estructura del código, proponemos la creación de una nueva clase llamada `ItemPack`. Esta clase encapsulará las operaciones y características de los paquetes de artículos, proporcionando una abstracción más robusta y flexible.

##### Beneficios de la Solución Propuesta:

- **Mejor organización del código:** La introducción de la clase `ItemPack` agrupa todas las operaciones y datos relacionados con los paquetes de artículos en una única entidad, mejorando la cohesión del código.

- **Facilidad de mantenimiento y extensión:** Cualquier cambio o mejora en la lógica relacionada con los paquetes de artículos se puede manejar dentro de la clase `ItemPack`, sin afectar otras partes del código.

- **Reducción de errores:** Al centralizar la lógica de manejo de paquetes de artículos, se reducen las posibilidades de errores y se facilita la implementación de validaciones complejas.

##### Conclusión:
La implementación de la clase `ItemPack` y la refactorización de la clase `Customer` para usar esta nueva abstracción, alinea el proyecto con las mejores prácticas de programación orientada a objetos. Esto no solo mejora la calidad del código y su mantenibilidad, sino que también prepara la base para futuras extensiones y mejoras en el sistema de gestión del centro comercial.


#### 1.8 Lazy Classes - Clases perezosas

##### Descripción del Problema

Revisando el código, identificamos la clase `Time` como una posible Lazy Class. Esta clase solo tiene dos atributos (hour y minute) y unos pocos métodos (`incrementTime`, `getCurrentTime`, `getMinute`). Estas funcionalidades podrían ser manejadas fácilmente por otra clase existente, eliminando la necesidad de mantener una clase adicional.

##### Solución Propuesta

La funcionalidad de la clase `Time` puede ser incorporada directamente en la clase `Main`, donde se utiliza. Esto reduce la cantidad de clases en el sistema, simplifica la estructura del código y reduce la complejidad del mantenimiento.

##### Beneficios de la Solución Propuesta

- Simplificación del código: Se reduce la cantidad de clases en el sistema, lo que simplifica la estructura general del código.
- Reducción de la complejidad: Menos clases significan una menor complejidad para navegar y mantener el sistema.
- Optimización de recursos: Al eliminar clases que no contribuyen significativamente a la funcionalidad del sistema, se optimizan los recursos utilizados para el mantenimiento del código.

##### Conclusión

Hemos identificado la clase `Time` como una Lazy Class en nuestro sistema actual. La funcionalidad mínima que proporciona puede ser integrada directamente en la clase Main, eliminando la necesidad de mantener una clase adicional y simplificando la estructura del código. Esta propuesta de mejora se implementará en futuras versiones del proyecto para garantizar un código más mantenible y eficiente.

### 2. Acoplamiento
#### 2.1 Inappropriate Intimacy - Inapropiada intimidad
##### Mejor Gestión de Estado
**Mejor encapsulación:**
 Cada clase debería gestionar sus propios datos internamente. Las interacciones entre las clases, como CashRegister y Customer, así como AttentionCenter y CustomerQueue, deben realizarse a través de métodos que controlen el acceso y la mutabilidad de sus estados. Por ejemplo, en lugar de que CashRegister acceda directamente a los datos del Customer, debería hacerlo mediante métodos públicos que encapsulen la lógica necesaria.

**Reducción del acoplamiento:** Limitando el acceso directo a los campos internos y utilizando métodos para la comunicación entre objetos, el acoplamiento entre las clases se reduce. Esto hace que el sistema sea más modular y fácil de modificar. Por ejemplo, AttentionCenter podría utilizar interfaces o patrones de diseño que promuevan la separación de responsabilidades, como el Patrón Observador para manejar eventos entre CustomerQueue y CashRegister.

**Facilidad de mantenimiento:** Con un diseño más claro y mejor encapsulado, el mantenimiento se vuelve más sencillo y se minimizan los riesgos de errores inadvertidos en el manejo de las relaciones entre objetos. Esto es crucial para un sistema que maneja múltiples operaciones en tiempo real, como la gestión de una cola de clientes en un centro comercial.

##### Metodos agregados:

```java

Public class Customer:

 public void purchaseItemPack() {
        if (this.numberOfItemPacks > 0) {
            this.numberOfItemPacks--;
        }
    }

    public void returnItemPack() {
        this.numberOfItemPacks++;
    }

public class CashRegister:

public void finishService() {
        this.currentCustomer = null;
        this.isOccupied = false;
    }


Public class CustomerQueue:


 public Customer serveNextCustomer() {
        return customers.poll();
    }
    public int getQueueSize() {
        return customers.size();
    }

    public boolean isEmpty() {
        return customers.isEmpty();
    }

Public class AttentionCenter:

public void processNextCustomer() {
        if (!customerQueue.isEmpty()) {
            Customer customer = customerQueue.serveNextCustomer();
            if (customer != null) {
                System.out.println("Processing customer: " + customer.getId());
            }
        }
    }
    public void manageQueue() {
        while (!customerQueue.isEmpty()) {
            processNextCustomer();
        }
    }

public void manageQueue() {
        while (!customerQueue.isEmpty()) {
            processNextCustomer();
        }
    }


```


##### Metodos modificados:

```java
//Antes

Public class CashRegister:

    public void openRegister() {
        this.isOpen = true;
        this.servedCustomers = 0;
        this.breakCounter = 0;
        System.out.println("Cash register " + this.id + " is now open.");
    }

    public void closeRegister() {
        if (!this.isOccupied) {
            this.isOpen = false;
            System.out.println("Cash register " + this.id + " is now closed.");
            this.servedCustomers = 0;
        }
    }
public void serveCustomer(Customer customer) {
        if (!this.isOccupied && this.currentCashier != null && this.currentCashier.isServing()) {
            this.isOccupied = true;
            this.currentCustomer = customer;
            this.servedCustomers++;
            System.out.println("Serving customer " + customer.getId() + " at cash register " + this.id);
        }
    }

Public class CustomerQueue:

public void addCustomer(Customer customer) {
        customers.add(customer);
        maxQueueLength = Math.max(maxQueueLength, customers.size());
        System.out.println("Customer with ID " + customer.getId() + " added to the queue.");
    }


//Después

Public class CashRegister:

public void openRegister() {
        isOpen = true;
    }

    public void closeRegister() {
        isOpen = false;
    }

 public void serveCustomer(Customer customer) {
        if (isOpen && !isOccupied && customer != null) {
            this.currentCustomer = customer;
            this.isOccupied = true;
            customer.purchaseItemPack();
        }
    }

Public class CustomerQueue;

public void addCustomer(Customer customer) {
        if (customer != null) {
            customers.add(customer);
            System.out.println("Customer added to queue: " + customer.getId());
        }
    }

```

 #### 2.2 Incomplete Library Class - Clase de biblioteca incompleta
Durante el desarrollo de nuestro sistema de gestión de cajas registradoras en un centro comercial, hemos evaluado el uso de bibliotecas externas y nos hemos encontrado con el problema de "Incomplete Library Class". Este problema ocurre cuando una clase de una biblioteca externa no proporciona la funcionalidad necesaria y no puede ser modificada directamente debido a la falta de control sobre su código fuente. Este documento describe el problema identificado y propone una solución para mejorar la funcionalidad y mantenibilidad del sistema.

##### Descripción del Problema
En nuestro sistema, utilizamos la biblioteca Gson para manejar la serialización y deserialización de JSON. Sin embargo, si en el futuro requerimos soporte adicional para algún formato de datos o procesamiento específico que Gson no proporcione directamente, podríamos enfrentar limitaciones. Este es un caso típico de "Incomplete Library Class".

Por ejemplo, al cargar datos de cajeros desde un archivo JSON, podríamos necesitar agregar validaciones adicionales o manejar formatos de datos específicos que Gson no soporta de manera directa. La limitación de no poder modificar directamente la clase de la biblioteca externa nos lleva a buscar una solución alternativa para extender su funcionalidad de manera eficiente.

##### Solución Propuesta
Para abordar el problema de "Incomplete Library Class", proponemos implementar el patrón de diseño Adapter. Este patrón nos permitirá envolver la clase de la biblioteca externa (en este caso, Gson) y agregar la funcionalidad adicional requerida sin modificar el código fuente de la biblioteca.

##### Implementación del Adapter Pattern
1. Definir una interfaz que declare los métodos necesarios:
    - Una interfaz que defina las operaciones necesarias para cargar y procesar datos.
2. Crear una clase adaptadora que implemente la interfaz:
    - La clase adaptadora utilizará la biblioteca externa (Gson) para manejar la serialización y deserialización de JSON, añadiendo cualquier funcionalidad adicional necesaria, como validaciones específicas o soporte para formatos adicionales.
3. Utilizar la clase adaptadora en el sistema:
    - Reemplazar el uso directo de la biblioteca externa con la clase adaptadora en las partes del sistema que manejan la carga y procesamiento de datos.
##### Beneficios de la Solución Propuesta
- Extensibilidad mejorada: Al envolver la clase de la biblioteca externa en una clase adaptadora, podemos añadir la funcionalidad adicional requerida sin modificar el código de la biblioteca. Esto permite extender las capacidades de la biblioteca de manera controlada y modular.
- Mantenimiento simplificado: La clase adaptadora actúa como un punto de control único para las extensiones de funcionalidad, lo que simplifica el mantenimiento y las actualizaciones futuras. Cualquier cambio en los requisitos de procesamiento de datos se puede manejar dentro de la clase adaptadora sin afectar otras partes del sistema.
- Separación de preocupaciones: Al separar la lógica de serialización y deserialización de cualquier procesamiento adicional, mejoramos la claridad del diseño del sistema. Esto facilita la realización de pruebas más específicas y dirigidas, y mejora la capacidad de comprender y mantener el código.
##### Conclusión
Aunque en la versión actual del proyecto no hemos enfrentado limitaciones específicas con la biblioteca Gson, hemos identificado la posibilidad de futuros problemas relacionados con "Incomplete Library Class". Implementar el patrón Adapter nos permitirá manejar eficazmente estas limitaciones, proporcionando una capa de abstracción que puede ser fácilmente modificada para ajustarse a las necesidades del proyecto sin depender de cambios en la biblioteca externa. Esta propuesta de mejora se planificará para futuras versiones del proyecto, garantizando un código más mantenible y extensible.

El diseño modular fue clave en la refactorización del sistema:

- **Refactorización de Métodos**: Por ejemplo; se descompuso el método `main` en funciones más pequeñas como `initializeCashRegisters` y `simulateDay`, cada una con responsabilidades bien definidas.
- **Cohesión y Acoplamiento**: Mejoramos la cohesión funcional y reducimos el acoplamiento entre componentes, permitiendo que cada módulo funcione de manera más independiente.

```java
//Antes

// Manejo de descansos, cambios de turno y asignación de clientes
attentionCenter.checkAndInitiateBreaks(currentTime);
attentionCenter.handleShiftChanges(currentTime);
attentionCenter.assignCustomersToCashRegisters();
attentionCenter.processCustomersInCashRegisters(shoppingCenter);


//Después
processShoppingCenterOperations(...);
```

## Diseño Orientado a Objetos

### Implementación de Principios SOLID

En nuestro diseño, incorporamos los principios SOLID para garantizar un código robusto y mantenible:

- **Principio de Responsabilidad Única**: Cada clase y método se diseñó para tener una sola razón de cambio.
- **Principio de Abierto/Cerrado**: El sistema se diseñó para ser extensible sin necesidad de modificar los componentes existentes.
- **Refactorización para Reducir el Acoplamiento**: Introducimos interfaces y abstracciones donde fue necesario para desacoplar las clases y facilitar la extensibilidad.

## Conclusión

Las mejoras aplicadas al Sistema de Gestión de Centro Comercial han transformado el código y la arquitectura del sistema, haciendo que sea más fácil de entender, modificar y extender. Estas mejoras no solo benefician el mantenimiento actual sino que también preparan el sistema para futuras expansiones y funcionalidades.
