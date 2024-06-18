# Memoria del proyecto El Mundo

## Historial
[link de commits](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commits/develop/)

## Version inicial (modelo vista controlador)
- diagrama de aplicacion inicial
- decisiones de diseño
  - En esta primera entrega se decidió hacer un diseño modular y desacoplado. Se uso el Modelo Vista Controlador desde un inicio con el fin de que el código fuera lo más reusable posible en caso de que el ambiente cambiase. Se decidió aplicar este patrón de arquitectura desde un inicio debido a la experiencia de los integrantes con este. Se desarrollo un controlador por acción con el fin de tener más control sobre los evetos de la aplicación.
- commit final

## Version modular (diseño modular y principios SOLID)
- diagrama de aplicacion mejorado
- cambios y desiciones
    - En esta segunda entreha se decidió remver los controladores más específicos para mantener un solo controlador general, el cual nos permitiría tener una visión más general de la aplicación. Se consolidaron clases y se eliminar códigos repetidos, llevando asi una mayor acoplación pero manteniendo la flexibilidad de la extensión del sistema. Se hizo mejor uso de la clase de apoyo Point y se detectaron códigos inservibles, o muy complejos. No hubieron cambios en el modelo, ya que las bases estaban bien establecidas, lo cual demustra la flexibilidad del patrpon MVC.
- commit final

## Version limpia (aplicación de clean code)
- diagrama de aplicacion mejorado
- cambios y desiciones:
    Se removieron los últimos smell codes, como por ejemplo en este caso la clase updateTime, que inicialmente había sido útil para poder programar el paso del tiempo pero que llegado cierto punto se modificó y quedó únicamente como una clase que llamaba a otra en vez de ejecutarse esta otra directamente, esto se aprecia en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/d46320aa31c91c0437ea33cb25471ad768926e56), con eso se logró simplificar la estructura del código y mejorar su mantenibilidad. Además,  se introdujo una nueva clase de apoyo para la vista, esto con el fin de poder mejorar el diseño gráfico de la aplicación. Esta clase fue diseñada específicamente para gestionar la visualización dinámica del entorno del juego, ajustando la vista basándose en la posición del jugador y variaciones temporales, ya que al contener nuevos métodos de apoyo en la lectura y presentación del mapa se puede permitir que si en un futuro se modifica la vista sea más complicado que aparecan problemas en esta. Estos cambios se llevaron a cabo en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/af2895f2ac6f703562838a055361d55a890ed9d4) y en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/8ef3f0317285e6a6ad08cc3526a3dc7dc4d39a08)
- commit final
