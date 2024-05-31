# pyAscensores

```
           Personas                                    Personas
          esperando                                    en la planta

Planta  6    _____     [v4v]    | |     | |     | |     __3__ 
Planta  5    ___2_      | |     | |     | |     | |     __4__
Planta  4    _____      | |     | |    [^2^]    | |     __2__
Planta  3    _____      | |    [^0^]    | |     | |     __4__
Planta  2    _____      | |     | |     | |     | |     __1__
Planta  1    _____      | |     | |     | |    [v1v]    __0__
Planta  0    ___1_      | |     | |     | |     | |     __1__
                       /--------- Ascensores ------/
   
```

## Sobre el proyecto 🎓

Este proyecto es una simulación de un sistema de ascensores en una universidad. El objetivo es simular el comportamiento de los ascensores y las personas que los utilizan.

## Comportamiento de las personas 👨

En esta simulación, las personas se comportan de la siguiente manera:

- Las personas se crean con tres atributos:
  - Tiempo que va a estar en una planta
  - Planta de destino

Al crease, las personas se colocan en una planta aleatoria. Cuando el tiempo que va a estar en una planta llega a 0, la persona reliza una solicitud de ascensor y se coloca en la cola de espera.

Cuando un ascensor llega a una planta, las personas se comportan de la siguiente manera:

- Si el ascensor está lleno, la persona se queda en la cola de espera y espera a que un ascensor disponible la recoja.
- Si el ascensor esta vacío, la persona entra en el ascensor y realiza una solicitud de destino.
- Si en el ascensor hay alguien, le pregunta a que dirección va y si va a la misma dirección, entra en el ascensor.

Cuando la persona llega a su destino, sale del ascensor y se regeneran de forma aleatoria los atributos de la persona de planta a la que ir, el tiempo en planta.

## Comportamiento de los ascensores 🛗

Los ascensores se comportan de la siguiente manera:

- los ascensores se crean con los siguientes atributos:
  - Planta en la que se encuentra
  - Dirección en la que se mueve (UP, DOWN & STOP)
  - Lista de personas que están dentro del ascensor
  - Lista de plantas a las que se tiene que dirigir
  - Capacidad maxima del ascensor (6 personas)

Cuando una persona realiza una solicitud de ascensor, el panel de control procesa la solicitud y añade la planta en la lista del ascensor de las plantas a las que se tiene que dirigir.

Cuando una persona entra en el ascensor, se añade a la lista de personas que están dentro del ascensor, y realiza una solicitud de destino, la cual se le asigna directamente al ascensor en el que se encuentra.

## [Requisitos](/docs/Enunciado)

## Modelo de Dominio 📚

  En este apartado se encuentra la esctructura de este proyecto. Para describirla, se establecen una serie de entidades y como se relacionan entre sí.
  
  Las relaciones y el funcionamiento de estos se encuentran descritos en los siguientes diagramas:

  - [Diagramas de Clases](/docs/Modelo_de_Dominio/Diagramas_de_Clases/)
  - [Diagramas de Estados](/docs/Modelo_de_Dominio/Diagramas_de_Estados/)
  - [Diagaramas de Objetos](/docs/Modelo_de_Dominio/Diagramas_de_Objetos/)

## Arquitectura
Diagramas que describen la estructura del proyecto y como las clases se realacionan entre si
  - [Diagrama_de_Arquitectura](/docs/Diagrama_de_Arquitectura/)