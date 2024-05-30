# pyAscensores

## Sobre el proyecto 🎓

Este proyecto es una simulación de un sistema de ascensores en una universidad. El objetivo es simular el comportamiento de los ascensores y las personas que los utilizan.

```
           Personas                                    Personas
          esperando                                    en la planta

Planta  3    _____     [v4v]    | |     | |     | |     __3__ 
Planta  2    ___2_      | |     | |     | |     | |     __4__
Planta  1    _____      | |     | |    [^2^]    | |     __2__
Planta  B    _____      | |    [^0^]    | |     | |     __4__
Planta -1    _____      | |     | |     | |     | |     __1__
Planta -2    _____      | |     | |     | |    [v1v]    __0__
Planta -3    ___1_      | |     | |     | |     | |     __1__
                       /--------- Ascensores ------/
   
```

## Comportamiento de las personas 👨

En esta simulación, las personas se comportan de la siguiente manera:

- Las personas se crean con tres atributos:
  - Tiempo que va a estar en una planta
  - Planta de destino

Al crease, las personas se colocan en una planta aleatoria. Cuando el tiempo que va a estar en una planta llega a 0, la persona reliza una solicitud de ascensor y se coloca en la cola de espera.

Cuando un ascensor llega a una planta, las personas se comportan de la siguiente manera:

- Si el ascensor está lleno, la persona se queda en la cola de espera y vuelve a realizar una solicitud de ascensor.
- Si el ascensor esta vacío, la persona entra en el ascensot y realiza una solicitud de destino.
- Si en el ascensor hay alguien, le pregunta a que dirección va y si va a la misma dirección, entra en el ascensor.

Cuando la persona llega a su destino, sale del ascensor y se regeneran de forma aleatoria los atributos de la persona.

## Comportamiento de los ascensores 🛗

Los ascensores se comportan de la siguiente manera:

- los ascensores se crean con los siguientes atributos:
  - Planta en la que se encuentra
  - Dirección en la que se mueve
  - Lista de personas que están dentro del ascensor
  - Lista de plantas a las que se tiene que dirigir
  - Capacidad maxima del ascensor (6 personas)

Cuando una persona realiza una solicitud de ascensor, el panel de control procesa la solicitud y añade la planta a la que se tiene que dirigir a la lista de plantas a las que se tiene que dirigir.

Cuando una persona entra en el ascensor, se añade a la lista de personas que están dentro del ascensor, y realiza una solicitud de destino, la cual se le asigna directamente al ascensor en el que se encuentra.

## Modelo de Dominio 📚

Para 