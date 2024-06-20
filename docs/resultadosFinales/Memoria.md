
## Historial

### Commits
[Link de commits](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commits/develop/)

### Issues
**[Only print the field of vision instead of hiding the map in the terminal](https://github.com/mmasias/23-24-IdSw2-SDD/issues/48)**
- [Commit de Resolución](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/a74e6e822b16f5d91bfc9ed050b161b8fa8caf49)

**[Remove unused methods](https://github.com/mmasias/23-24-IdSw2-SDD/issues/38)**
- [Commit de Resolución](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/5d910ebd05e64df3744189139716aeefdb835fc6)

**[Update Domain Model Diagrams to reflect the latest project structure and relationships between classes](https://github.com/mmasias/23-24-IdSw2-SDD/issues/39)**
- [Commit de Resolución](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/ffbae44e8baeda12d3352b64c6e29180f53b1719)

**[Change method name from setTimeOfDay to updateImpreciseTime to more accurately describe its functionality](https://github.com/mmasias/23-24-IdSw2-SDD/issues/36)**
- [Commit de Resolución](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/b6a9578109199159168b30568c7eab820230f8a4)

**[Rename getCurrentTime to getPreciseTime to better differentiate it from the imprecise time representation](https://github.com/mmasias/23-24-IdSw2-SDD/issues/37)**
- [Commit de Resolución](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/b6a9578109199159168b30568c7eab820230f8a4)

**[Implement initialization logic to set both preciseTime and impreciseTime correctly when a new Time object is instantiated](https://github.com/mmasias/23-24-IdSw2-SDD/issues/35)**
- [Commit de Resolución](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/b6a9578109199159168b30568c7eab820230f8a4)

**[Refactor the class to improve method naming conventions and better differentiate between precise and imprecise time representations](https://github.com/mmasias/23-24-IdSw2-SDD/issues/34)**
- [Commit de Resolución](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/b6a9578109199159168b30568c7eab820230f8a4)

**[Crear método para devolver un tile random del mapa](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/issues/27)**
- [Commit de Resolución](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/b096f84dca37cdf40690406453d1973627801abf)

**[Implement a better way of reading the map file](https://github.com/mmasias/23-24-IdSw2-SDD/issues/41)**
- [Commit de Resolución](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/690a5d7a091768b9dd17e42bef9f9223d5bd2f58)

**[Design correct Use Cases Diagrams to ensure that all user interactions and system functionalities are accurately represented. (JuanJo)](https://github.com/mmasias/23-24-IdSw2-SDD/issues/40)**
- [Commit de Resolución](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/2afba2d50c9a376d5b7f7c65d191f2f1f35cc387) (primero de numerosos commits que resolvieron el issue el dia 30 de mayo de 2024)

**[Print only the field of vision so that the map doesnt take up space](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/issues/44)**
- [Commit de Resolución](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/26d8731f9f00e7a9f7874455a01134d0e3d95bac)

### Diagramas
[Historial de Diagramas de Aplicación](./DiagramaDeAplicacion(redaccion).md)

## Versión inicial (modelo vista controlador)
Para abordar la solución del proyecto, se optó por utilizar una arquitectura **MVC** (Modelo-Vista-Controlador) con la idea de **desarrollar un código reusable y adaptable en futuras implementaciones**. 

Inicialmente, se creó un controlador para las clases más importantes de la solución, permitiendo tener un conjunto de clases con responsabilidades bien definidas. El diagrama de clases inicialmente propuesto puede encontrarse en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/99a071a70c0c760b78c1e3a2f5536427a5419e9f).

- Se desarrolló la **estructura base** de las clases incluyendo atributos y métodos. Finalmente se estableció una idea inicial de la responsabilidad que tendrá cada clase.
- Un ejemplo de este proceso es la clase controladora del mapa encontrada [aquí](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/cc9a169d12120d72328096d0e9d0b1abecea10ee).

Posteriormente, nos dimos cuenta que utilizar esta estructura de carpetas implicaba:
- Demasiados **problemas de acoplamiento** entre clases. 
- **Extensión innecesaria** del código ya que muchas de estas podían ser aglutinadas, creando una estructura más simple.
- Ciertos parámetros y datos necesarios para ejecutar las funciones de algunos controladores debían **recorrer demasiadas clases** que no los utilizaban, lo que **dificultaba la implementación y el mantenimiento** de ellas.

Este fue un momento crucial en la vida del proyecto, ya que de no habernos dado cuenta de ello, el desarrollo se habría complicado exponencialmente a medida que este evolucionaba.

Esta fase finaliza con la presentación adecuada de los diagramas de la aplicación, encontrados [aquí](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/223607cb4002db26bcf9eafd7ae84e5f22b92be6).

## Versión modular (diseño modular y principios SOLID)
Para la segunda versión del proyecto, se revisó a profundidad el código, tomando en cuenta las recomendaciones proporcionadas en clase. A continuación, podemos examinar la arquitectura de la aplicación y observar algunas clases que cumplen con el patrón SOLID.

### Modulos
La aplicación se repartió en los siguientes archivos para un flujo más claro de la aplicación:

- Controllers
    - **World Controller**: Esta clase maneja la lógica y la interacción entre el modelo World y la vista WorldView.
- Models
    - **Entity**: Es la clase abstracta que representa una entidad en el modelo del mundo. Conoce de la posición de la entidad y el transporte que se está usando.
    - **Character**: Esta clase es una extención de la clase Entity y representa un personaje en el modelo del mundo. Sus responsabilidades incluyen:
        - Definir el tipo de personaje (CharacterType).
        - Mantener una lista de transportes disponibles para el personaje (availableTransports).
    - **Map**: La clase Map es el modelo que representa un mapa en el mundo. Contiene una matriz bidimensional de Tiles (casillas) y tambien contiene los métodos necesarios para poder interactuar con esta matriz.
    - **Point**: En esta clase se representa un punto en el espacio dentro de la matriz del mundo, con coordenadas X e Y. Contiene métodos para obtener y establecer la ubicación.
    - **Tile**: Esta clase representa una baldosa en el mapa del mundo. Cada una tiene un tipo (TileTypes) y también proporciona métodos para obtener y cambiar este tipo, así como para obtener símbolos ASCII asociados con el tipo de baldosa.
    - **Time**: Es la clase que representa el tiempo en el mundo, con métodos para avanzar el tiempo, establecer el momento del día según la hora actual y reiniciar el día. Además, proporciona métodos para obtener el momento del día actual y la hora actual en formato de 24 horas.
    - **Transport**: Representa el transporte en el mundo. Determina la velocidad y el símbolo ASCII asociado.
    - **World**: Representa el mundo, contiene un mapa, entidades y gestiona el tiempo. Permite simular ciclos de juego avanzando el tiempo y añadir nuevas entidades al mundo.
- Views
    - **World View**: Es la clase responsable de la presentación del mundo. Esto incluye la visualizacion del mapa, la limpieza de la pantalla, mostrar la hora actual, el momento del día y las entidades.

- Enums
    - **CharacterType**: Define tipos de personajes, en estos momentos solo tenemos dos tipos de personajes, que son los jugables y los no jugables (NPCs).
    - **TileTypes**: Define los diferentes tipos de tiles (casillas) para el mundo. Cada tipo de tile tiene tres propiedades asociadas:
        - Un número de tile (tileNumber).
        - Un color ASCII (asciiColor).
        - Un símbolo ASCII (asciiSymbol).
    - **TimesOfDay**: Define diferentes momentos del día, los cuales son Mañana, Tarde, Atardecer y noche.
    - **Transport Types**: Define los diferentes tipos de transportes que puede tener un personaje. Cada tipo de transporte tiene tres propiedades asociadas:
        - Velocidad (speed).
        - Símbolo ASCII (asciiSymbol).
        - Lista de tipos de tiles (casillas) por los que puede moverse (tilesItCanMoveThrough)


#### Single Responsibility Principle

Este principio lo podemos observar en las siguientes clases:
- **FileReaderController**: esta clase se encarga exclusivamente de leer archivos CSV desde una ruta de archivo especificada. Lo podemos revisar en el siguiente [enlace](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/blob/ab2cbba4f062d0ee2dccfe25824332cbbdc55d6e/legacy/Controllers/FileReaderController.java).
- **TimeController**: se encarga de gestionar el tiempo, avanzarlo, reiniciarlo y actualizar el período del día (TimesOfDay) en función del tiempo actual. Lo podemos revisar en el siguiente [enlace](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/blob/ab2cbba4f062d0ee2dccfe25824332cbbdc55d6e/legacy/Controllers/TimeController.java).
- **TileFactory**: Esta clase tambien tiene una única responsabilidadm que es crear objetos de tipo Tile. Lo podemos revisar en el siguiente [enlace](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/blob/ab2cbba4f062d0ee2dccfe25824332cbbdc55d6e/legacy/Factories/TileFactory.java).
- **Model/Point**: tiene una responsabilidad clara: representar y gestionar un punto en un espacio bidimensional. No se mezcla con otras responsabilidades.
- **Model/Word**: La clase World se encarga únicamente de representar el estado del mundo y proporcionar métodos para manipular el mapa, las entidades y el tiempo. No realiza funcionalidades adicionales que no correspondan a la gestión del mundo.


#### Open/Closed Principle
Este principio lo podemos observar en las siguientes clases:
- **Model/Entity**: Esta clase desde el inicio fué diseñada para ser extendida a cualquier tipo de entidad que pueda tener la aplicación. Todas aquellas clases que extiendan de Entity pueden agregar nuevas funcionalidades sin modificar la clase principal. Esto permite que la clase esté abierta para la extensión y cerrada para la modificación.

- **Model/Point**: Esta clase tambien está diseñada para ser extendida. Se pueden agregar nuevas funcionalidades en subclases sin modificar la clase Point, hasta este momento no se encuentra ninguna extension, pero existe si se necesitara en un futuro, sería fácil de implementar.

- **Model/Tile**: La clase Tile permite cambiar el tipo de baldosa (changeType) y obtener información sobre el tipo y su representación ASCII (getType, getAsciiSymbol, getAsciiColor). Está diseñada para ser extendida mediante la modificación o adición de nuevos tipos de casillas (TileTypes).
- **Model/Point**: La clase Point está diseñada para ser extendida. Se pueden agregar nuevas funcionalidades en subclases sin modificar la clase Point.
- **Model/Transport** Esta clase permite obtener información sobre el tipo de transporte (getType()), su velocidad (getSpeed()), y su representación ASCII (getAsciiSymbol()). Además, puede extenderse para agregar funcionalidades relacionadas con el transporte sin modificar su comportamiento actual.


#### Liskov Substitution Principle
Este principio lo podemos observar en las siguientes clases:
- **Model/Character**: Esta clase extiende Entity y no corrompe el comportamiento esperado de Entity. Cualquier instancia de Character puede ser utilizada donde se espera una Entity.


#### Interface Segregation Principle
Este principio no lo utilizamos de manera directa en el código, dado que decidimos que sería añadir mayor complejidad a lo necesario en el momento.


#### Dependency Inversion Principle
Este principio lo podemos observar en las siguientes clases:

- **Model/Tiles**: La clase Tile depende de TileTypes, que es una abstracción para los tipos de casillas definidos. Esto permite que Tile utilice las propiedades definidas en TileTypes sin acoplarse directamente a implementaciones concretas.
- **Model/Transport**: Depende de TransportTypes, que es una abstracción para los tipos de transporte definidos. Esto permite que Transport utilice las propiedades definidas en TransportTypes sin acoplarse directamente a implementaciones concretas.
- **Model/Word**: Depende de abstracciones como Map, Entity, y Time a través de sus interfaces públicas (métodos get y set). Esto permite que World use estas abstracciones sin depender directamente de implementaciones concretas, lo que facilita la flexibilidad y extensibilidad del diseño.

---

Teniendo en cuenta toda la arquitectura planteada anteriormente y las presentaciones realizadas en clase, nos pudimos dar cuenta que intentar cumplir al completo todo el principio SOLID y modularizar demasiado la aplicación resultó ser un poco tedioso y no necesario para el alcance actual de la aplicación, por ello se realizaron los siguientes cambios:

- Los modelos que se definieron desde etapa temprana del proyecto se han mantenido muy similares a lo largo del tiempo, suponiendo que se realizó un buen analisis del proyecto.
- Se eliminaron las siguientes clases: *TileFactory* y todas aquellas que se encuentran en la carpeta *Legacy*.
- Se cambió el nombre del Enum *TimesOfDay* por *ImpreciseTime*, esto porque se encontró un nombre más descriptivo y detallado para su funcionamiento.
- Se añadió la carpeta Data, donde se encuentra el mapa en formato *CSV*.

## Versión limpia (aplicación de clean code)
En la revisión del diseño de nuestro software, identificamos varios problemas relacionados con prácticas de 'code smells' que requerían atención. Por ejemplo, analizando el historial del diagrama de la aplicación, se puede apreciar que hubo momentos en que notamos una duplicación considerable de funcionalidades entre varias clases, lo que nos llevó a implementar una jerarquía de herencia más eficiente y a la introducción de interfaces para promover la reutilización del código. 

- Un ejemplo de esto es lo que sucedía en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/495203327decbc61e82819a08117934cd01c774f) donde las clases PlayableCharacter y NonPlayableCharacter heredaban de Character pero **duplicaban código**, cosa que se solucionó en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/76ab2a1b8329cf38bb6606680c1a00e7d22f92ed) donde se convirtieron en un enum que pasó a ser atributo de la clase Character que dejó de ser abstracta. 
Esto elimina la duplicación de código y centraliza la lógica de transporte en una sola clase.
- Algo similar ocurrió entre [esta versión](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/223607cb4002db26bcf9eafd7ae84e5f22b92be6), donde existían múltiples controladores específicos para movimientos y acciones de caracteres que complicaban la arquitectura, y [esta otra](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/5897b65705e7e43850c51e468b46c8c8017aee92), donde se consolidaron varios controladores pequeños en un único controlador que pasó a manejar todos los aspectos del movimiento y las acciones de los personajes.

- Además, se refactorizaron clases con múltiples responsabilidades para adherirse al **principio de responsabilidad única**, lo que simplificó nuestra base de código y mejoró la modularidad del sistema. Un ejemplo de esto es  [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/ab2cbba4f062d0ee2dccfe25824332cbbdc55d6e), donde WorldController tenía dependencias directas con múltiples clases, lo que creaba un alto acoplamiento.
  
- En cierto momento del desarrollo, se planteó [un issue](https://github.com/mmasias/23-24-IdSw2-SDD/issues/38) solicitando la **eliminación de todos los métodos vacíos** o sin funcionalidades que hubiera, y se comenzó a llevar esto a cabo. Por ejemplo, en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/d46320aa31c91c0437ea33cb25471ad768926e56), donde la clase updateTime, que inicialmente había sido útil para poder programar el paso del tiempo pero que llegado cierto punto se modificó y quedó únicamente como una clase que llamaba a otra en vez de ejecutarse esta otra directamente. Eliminando este tipo de smell codes se logró simplificar la estructura del código y mejorar su mantenibilidad.
- Hubo [otro issue](https://github.com/mmasias/23-24-IdSw2-SDD/issues/48) que solicitaba modificar la vista de manera que en ve de mostrarse el mapa completo y ocultar lo que no entraba en rango de visión, se cambiara directamente a que la vista unicamente fuera el rango de visión, y no el mapa completo ocultando la parte no visible. Esto se realió en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/a74e6e822b16f5d91bfc9ed050b161b8fa8caf49) y es más correcto siguiendo la arquitectura del MVC.
- Además, se introdujo una nueva clase de apoyo para la vista, esto con el fin de poder mejorar el diseño gráfico de la aplicación. Esta clase fue diseñada específicamente para gestionar la visualización dinámica del entorno del juego, ajustando la vista basándose en la posición del jugador y variaciones temporales, ya que al contener nuevos métodos de apoyo en la lectura y presentación del mapa se puede permitir que si en un futuro se modifica la vista sea más complicado que aparecan problemas en esta. Estos cambios se llevaron a cabo en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/af2895f2ac6f703562838a055361d55a890ed9d4) y en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/8ef3f0317285e6a6ad08cc3526a3dc7dc4d39a08).
- En relación a este cambio cabe mencionar también la manera en que se resolvió [este issue](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/issues/44), que inicialmente en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/26d8731f9f00e7a9f7874455a01134d0e3d95bac) se había resuelto simplemente en la clase worldView modificando directamente en la vista para que solo se mostrara en pantalla el rango de visión del jugador y el resto quedara oculto y que finalmente se acabó modificando del modo expuesto hace un rato con la clase de apoyo a la vista viewPort para definir el rango de visión y luego renderizar el mapa y las entidades dentro de este rango en la consola, ajustando dinámicamente el contenido mostrado basado en la posición del jugador y otros factores como la hora del día.
-  En esta etapa del desarrollo, también se realiaron cambios enfocados a **facilitar la comprensión del código**, como el [cambio del nombre del método setTimeOfDay a updateImpreciseTime](https://github.com/mmasias/23-24-IdSw2-SDD/issues/36) que se solucionó con [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/b6a9578109199159168b30568c7eab820230f8a4)  para describir mejor su funcionalidad. Lo mismo sucedía con este issue [Rename getCurrentTime to getPreciseTime to better differentiate it from the imprecise time representation](https://github.com/mmasias/23-24-IdSw2-SDD/issues/37) y su [resolución](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/b6a9578109199159168b30568c7eab820230f8a4)

Los problemas relacionados con la aplicación de los principios de clean code vistos en la asignaturas fueron parte fundamental durante todo el desarrollo hasta el final del proyecto que ya teniendo la aplicación casi acabada en [este punto](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/af2895f2ac6f703562838a055361d55a890ed9d4) quedaron todos solucionados y no tuvimos ninguno nuevo. Todos estos cambios fueron fruto del objetivo que tenñiamos de seguir las mejores prácticas de 'clean code', para lograr un software más robusto, mantenible y escalable.

