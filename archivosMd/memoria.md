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
