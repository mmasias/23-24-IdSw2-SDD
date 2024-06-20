# Modelo Vista Controlador (MVC) en una Hoja de Cálculo Simple

Este proyecto implementa un modelo básico de hoja de cálculo utilizando el patrón de diseño Modelo Vista Controlador (MVC). A continuación se detalla la estructura del código y cómo cada componente funciona.

## [Modelo](Utils/Model)

### Sheet (Hoja de Cálculo)

La clase `Sheet` representa la hoja de cálculo y maneja la lógica de datos y la interacción con las celdas.

#### Funcionalidad

- **sheetData**: Almacena los datos de las celdas en una matriz bidimensional de objetos `Cell`.
- **currentCellPosition**: Mantiene el registro de la posición actual en la hoja de cálculo.
- **cellSize**: Define el tamaño visual de las celdas.

#### Métodos Importantes

- `getCellContent(int i, int j)`: Devuelve el contenido formateado de una celda específica para su visualización.
- `setCellValue(int row, int col, String value)`: Establece el valor de una celda específica.
- `setCurrentCellPosition(String newCellPosition)`: Actualiza la posición actual de la celda.

#### Técnicas Utilizadas

- **Relaciones entre Clases**: `Sheet` utiliza y gestiona objetos `Cell`, mostrando una relación de composición.
- **Transmisión**: La clase transmite datos entre la interfaz de usuario y los modelos de datos de manera eficiente.

## [Vista](Utils/View)

### Viewport (Vista del Portapapeles)

La clase `Viewport` se encarga de la representación visual de la hoja de cálculo en la consola.

#### Funcionalidad

- **showSheet()**: Muestra la hoja de cálculo en la consola, limitando la vista a una ventana (viewport) definida por `VIEWPORT_HEIGHT` y `VIEWPORT_WIDTH`.

#### Métodos Importantes

- `printHeaders(int cellSize, int startCol, int endCol)`: Imprime los encabezados de columna en la vista.
- `printIndex(int cellSize, int index)`: Imprime los índices de fila en la vista.
- `printBottom(int cellSize, int startCol, int endCol)`: Imprime la línea inferior de separación en la vista.

#### Técnicas Utilizadas

- **Estrategia de Clasificación**: `Viewport` utiliza diferentes métodos privados para organizar y mostrar datos de manera ordenada en la consola.
- **Clean Code**: Métodos como `printHeaders`, `printIndex` y `printBottom` están diseñados para ser claros y específicos en su funcionalidad.

## [Controlador](Utils/Controller)

### Spreadsheet (Hoja de Cálculo)

La clase `Spreadsheet` actúa como el controlador principal que coordina la interacción entre la vista (`Viewport`) y el modelo (`Sheet`).

#### Funcionalidad

- `run()`: Inicia el bucle principal del programa, gestionando la entrada del usuario y actualizando la hoja de cálculo en consecuencia.

#### Métodos Importantes

- `run()`: Implementa la lógica principal del programa, interpretando comandos del usuario y realizando acciones correspondientes en la hoja de cálculo.

#### Técnicas Utilizadas

- **MVC**: `Spreadsheet` ejemplifica la separación de responsabilidades entre modelo, vista y controlador, facilitando la modularidad y mantenibilidad del código.
- **Clean Code**: El código está estructurado para ser fácil de entender y modificar, siguiendo prácticas de programación clara y eficiente.
