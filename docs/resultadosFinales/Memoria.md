# Memoria del proyecto El Mundo

## Historial
[link de commits](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commits/develop/)

## Version inicial (modelo vista controlador)
Para abordar la solución del proyecto, se optó por utilizar una arquitectura **MVC** (Modelo-Vista-Controlador) con la idea de **desarrollar un código reusable y adaptable a futuras implementaciones**. 

Inicialmente, se creó un controlador para las clases más importantes de la solución, permitiendo tener un conjunto de clases con responsabilidades bien definidas. El diagrama de clases inicialmente propuesto puede encontrarse en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/99a071a70c0c760b78c1e3a2f5536427a5419e9f).

- Se desarrolló la **estructura base** de las clases incluyendo atributos, métodos y finalmente se estableció una idea inicial de la responsabilidad que tendrá cada clase
- Un ejemplo de este proceso es la clase controladora del mapa encontrada [aquí](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/cc9a169d12120d72328096d0e9d0b1abecea10ee).

Finalmente, nos dimos cuenta de que utilizar esta estructura de carpetas implicaba:
- Demasiados **problemas de acoplamiento** entre clases. 
- **Extensión innecesaria** del código ya que muchas de estas podían ser agrupadas y crear una estructura más simple.
- Ciertos parámetros y datos necesarios para ejecutar las funciones de algunos controladores debían **recorrer demasiadas clases** que no los utilizaban, lo que **dificultaba la implementación y el mantenimiento** de ellas.

Este fue un momento crucial en la vida del proyecto, ya que de no habernos dado cuenta de ello, el desarrollo se habría complicado exponencialmente a medida que este evolucionaba.

Esta fase finaliza con la presentación adecuada de los diagramas de la aplicación, encontrados [aquí](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/223607cb4002db26bcf9eafd7ae84e5f22b92be6).

## Version modular (diseño modular y principios SOLID)
- diagrama de aplicacion mejorado
- cambios y desiciones
    - En esta segunda entreha se decidió remver los controladores más específicos para mantener un solo controlador general, el cual nos permitiría tener una visión más general de la aplicación. Se consolidaron clases y se eliminar códigos repetidos, llevando asi una mayor acoplación pero manteniendo la flexibilidad de la extensión del sistema. Se hizo mejor uso de la clase de apoyo Point y se detectaron códigos inservibles, o muy complejos. No hubieron cambios en el modelo, ya que las bases estaban bien establecidas, lo cual demustra la flexibilidad del patrpon MVC.
- commit final

## Version limpia (aplicación de clean code)
En la revisión del diseño de nuestro software, identificamos varios problemas relacionados con prácticas de 'code smells' que requerían atención. Por ejemplo, analizando el historial del diagrama de la aplicación, se puede apreciar que hubo momentos en que notamos una duplicación considerable de funcionalidades entre varias clases, lo que nos llevó a implementar una jerarquía de herencia más eficiente y a la introducción de interfaces para promover la reutilización del código. 

Un ejemplo de esto es lo que sucedía en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/495203327decbc61e82819a08117934cd01c774f) donde las clases PlayableCharacter y NonPlayableCharacter heredaban de Character pero duplicaban código relacionado con la gestión de transporte, cosa que se solucionó en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/76ab2a1b8329cf38bb6606680c1a00e7d22f92ed) donde se introdujo una clase abstracta CharacterBase que encapsulaba todas las funcionalidades comunes de gestión de transporte, de la cual PlayableCharacter y NonPlayableCharacter ahora heredan. 

Esto elimina la duplicación de código y centraliza la lógica de transporte en una sola clase. Algo similar ocurrió entre [esta versión](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/223607cb4002db26bcf9eafd7ae84e5f22b92be6), donde existían múltiples controladores específicos para movimientos y acciones de caracteres que complicaban la arquitectura, y [esta otra](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/5897b65705e7e43850c51e468b46c8c8017aee92), donde se consolidaron varios controladores pequeños en un único controlador que pasó a manejar todos los aspectos del movimiento y las acciones de los personajes.

Además, se refactorizaron clases con múltiples responsabilidades para adherirse al principio de responsabilidad única, lo que simplificó nuestra base de código y mejoró la modularidad del sistema. Un ejemplo de esto es  [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/ab2cbba4f062d0ee2dccfe25824332cbbdc55d6e), donde WorldController tenía dependencias directas con múltiples clases, lo que creaba un alto acoplamiento. 

En la [siguiente versión](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/e744913734a4f1ddeca6300161345f1554028e77), se llevó a cabo la introducción de interfaces como IWorldManager y IEntityManagement, que WorldController ahora utiliza, permitiendo una mayor flexibilidad y la posibilidad de cambiar las implementaciones subyacentes sin afectar WorldController. También se abordaron las dependencias circulares entre paquetes, introduciendo patrones de diseño que mejoraron el desacoplamiento. 

Cada uno de estos cambios se alineó con nuestro compromiso de seguir las mejores prácticas de 'clean code', resultando en un software más robusto, mantenible y escalable.

Finalmente, se removieron los últimos smell codes, como por ejemplo en este caso la clase updateTime, que inicialmente había sido útil para poder programar el paso del tiempo pero que llegado cierto punto se modificó y quedó únicamente como una clase que llamaba a otra en vez de ejecutarse esta otra directamente. 

En cierto momento del desarrollo, se planteó [un issue](https://github.com/mmasias/23-24-IdSw2-SDD/issues/38) solicitando la eliminación de todos los métodos vacíos o sin funcionalidades que hubiera, y se comenzó a llevar esto a cabo. Por ejemplo, en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/d46320aa31c91c0437ea33cb25471ad768926e56), con eso se logró simplificar la estructura del código y mejorar su mantenibilidad. 

Además, se introdujo una nueva clase de apoyo para la vista, esto con el fin de poder mejorar el diseño gráfico de la aplicación. Esta clase fue diseñada específicamente para gestionar la visualización dinámica del entorno del juego, ajustando la vista basándose en la posición del jugador y variaciones temporales, ya que al contener nuevos métodos de apoyo en la lectura y presentación del mapa se puede permitir que si en un futuro se modifica la vista sea más complicado que aparecan problemas en esta. Estos cambios se llevaron a cabo en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/af2895f2ac6f703562838a055361d55a890ed9d4) y en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/8ef3f0317285e6a6ad08cc3526a3dc7dc4d39a08). 

En relación a este cambio cabe mencionar también la manera en que se resolvió [este issue](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/issues/44), que inicialmente en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/26d8731f9f00e7a9f7874455a01134d0e3d95bac) se había resuelto simplemente en la clase worldView modificando directamente en la vista para que solo se mostrara en pantalla el rango de visión del jugador y el resto quedara oculto y que finalmente ase acabó modificando del modo expuesto hace un rato con la clase de apoyo a la vista viewPort para definir el rango de visión y luego renderizar el mapa y las entidades dentro de este rango en la consola, ajustando dinámicamente el contenido mostrado basado en la posición del jugador y otros factores como la hora del día.

De esta manera se solucionó inicialmente el issue y posteriormente con los conocimientos adquirdos en la materia se mejoró la implementación inicial mediante el uso de la clase Viewport en que se definen los límites de este rango de visión.

Los problemas relacionados con la aplicación de los principios de clean code vistos en la asignaturas fueron parte fundamental durante todo el desarrollo hasta el final del proyecto que ya teniendo la aplicación casi acabada en [este punto](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/af2895f2ac6f703562838a055361d55a890ed9d4) quedaron todos solucionados y no tuvimos ninguno nuevo.
