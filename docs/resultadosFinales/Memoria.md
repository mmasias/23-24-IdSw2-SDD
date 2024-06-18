# Memoria del proyecto El Mundo

## Historial
(link de commits)

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
- cambios y desiciones
    Se removieron los últimos smell codes, y se introdujo una nueva clase de apoyo para la vista, esto con el fin de poder mejorar el diseño gráfico de la aplicación. se introdujeron nuevos métodos de apoyo en la lectura y presentación del mapa.
- commit final
