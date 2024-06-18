# Sesiones de diseño

Este es el repositorio de las sesiones de diseño de la asignatura de Ingeniería del Software II de UNEATLANTICO.

Se desarrolla, en un caso controlado, la disciplina de diseño, con el objetivo de capacitarnos para la descomposición del trabajo de implementación en piezas manejables, las que serán gestionadas por diferentes equipos de desarrollo, posiblemente al mismo tiempo.

## Proyecto PyMundo


### Contenido del Repositorio:

- [Requisitos del proyecto](https://github.com/puntoReflex/pyMundo/blob/main/enunciado.md)
- [Modelo de dominio](./docs/modeloDominio/README.md)
  - Diagrama de clases
  - Diagrama de Objetos
  - Diagrama de Estados
- [Actores y Casos de Uso](./docs/casosDeUso/README.md) 
  - Diagrama de Casos de Uso 
  - Especificación de Casos de Uso
- [Resultados finales](./docs/resultadosFinales/README.md)
  - Clases prácticas
  - Resultados de las sesiones de diseño

- [Memoria del proyecto](./docs/resultadosFinales/Memoria.md)


## Desarrollo del Proyecto

### Primera Fase (Estructura y decisiones iniciales)
Para abordar la solución del proyecto, se optó por utilizar una arquitectura **MVC** (Modelo-Vista-Controlador) con la idea de desarrollar un código reusable y adaptable a futuras implementaciones. Inicialmente, se creó un controlador para las clases más importantes de la solución, permitiendo tener un conjunto de clases con responsabilidades bien definidas. El diagrama de clases inicialmente propuesto puede encontrarse en [este commit](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/99a071a70c0c760b78c1e3a2f5536427a5419e9f).

Durante esta etapa, se desarrolló también la estructura base de las clases necesarias para llegar a una solución adecuada, así como los métodos más importantes de cada uno de estos elementos. Por ejemplo, la clase controladora del mapa puede ser consultada [aquí](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/cc9a169d12120d72328096d0e9d0b1abecea10ee).

Finalmente, nos dimos cuenta de que utilizar esta estructura de carpetas implicaba demasiados problemas de acoplamiento entre clases. Ciertos parámetros y datos necesarios para ejecutar funciones de algunos controladores debían recorrer demasiadas clases que no los utilizaban, lo que dificultaba la implementación y el mantenimiento de las clases. 

Este fue un momento crucial en la vida del proyecto, ya que de no habernos dado cuenta de ello, el desarrollo se habría complicado exponencialmente a medida que este evolucionaba.

Esta fase finaliza con la presentación adecuada de los diagramas de la aplicación, encontrados [aquí](https://github.com/VeronikaEspa/23-24-IdSw2-SDD/commit/223607cb4002db26bcf9eafd7ae84e5f22b92be6).
