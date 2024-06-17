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

### Smell Codes

#### Cohesión

##### 1.1 Alternative classes with different interfaces

Tras realizar una revisión detallada del código implementado, creemos que no es necesario introducir interfaces. El diseño actual del sistema muestra una clara separación de responsabilidades y una interacción efectiva entre las clases, lo que facilita la extensibilidad y el mantenimiento del código.

##### Clases y Responsabilidades:

- **CashRegister y AttentionCenter**: Estas clases gestionan las operaciones en las cajas registradoras y la asignación de clientes a las cajas, respectivamente. Aunque interactúan estrechamente, cada una tiene responsabilidades bien definidas que no se solapan.
- **Customer y CustomerQueue**: Customer es una entidad de datos que representa al cliente, mientras que CustomerQueue administra operaciones de cola para grupos de clientes. Las responsabilidades de manejo de datos versus operaciones de cola están bien separadas.
- **DataLog**: Se encarga de la recopilación de estadísticas y el registro de eventos operativos, funcionando como un sistema de logging sin interferir o duplicar funcionalidades de otras clases.
- **Main y Time**: Main controla la simulación diaria usando la clase Time para el seguimiento del tiempo. Time sirve exclusivamente para controlar el avance temporal dentro de la simulación.

##### 1.2 Features envy - Envidia de características

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

##### 1.3 Data class - Clase de datos

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

#### Conclusión

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
