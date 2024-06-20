## Clase Navigator

### **_¿Por qué?_**

La clase `Navigator` se creó para gestionar el movimiento en la hoja de cálculo, permitiendo al usuario navegar entre las celdas de manera eficiente. `Navigator` es una clase altamente cohesiva, ya que se centra en un solo propósito: calcular la nueva posición de una celda en función de la dirección de movimiento.

En términos de programación modular, la clase `Navigator` presenta cierto acoplamiento con la clase `Settings`, ya que esta última le inyecta algunas constantes. También muestra una cohesión moderada con los demás módulos. Esto se evidencia en los métodos [getFormattedRow](https://github.com/pablarce/23-24-IdSw2-SDD/blob/9bb3ba620abd97635bd97d2da741642bc47f5f8b/pyHojaDeCalculo/Utils/Controller/Navigator.java#L4) y [getFormattedColumn](https://github.com/pablarce/23-24-IdSw2-SDD/blob/9bb3ba620abd97635bd97d2da741642bc47f5f8b/pyHojaDeCalculo/Utils/Controller/Navigator.java#L8), que se centran en transformar la posición de una celda desde su formato de cadena de índices de fila y columna, otorgándoles una responsabilidad definida y relacionada.

Además, los métodos de movimiento como [moveUp, moveDown, moveLeft y moveRight](https://github.com/pablarce/23-24-IdSw2-SDD/blob/9bb3ba620abd97635bd97d2da741642bc47f5f8b/pyHojaDeCalculo/Utils/Controller/Navigator.java#L28) tienen una alta cohesión, ya que todos se centran en calcular las nuevas posiciones de celdas basándose en la posición actual y una dirección de movimiento específica. En términos de encapsulamiento, la clase es exitosa y muestra una considerable escalabilidad.

Respecto a los principios SOLID, `Navigator` cumple con el S (Single Responsibility Principle) y el I (Interface Segregation Principle), ya que se encarga exclusivamente del movimiento en la hoja de cálculo y no depende de otras interfaces.

### **_Qué cambiamos_**

Originalmente, esta clase se llamaba `Movement` y realizaba funciones iguales a las de `Navigator`. La clase `Movement` se creó para gestionar el movimiento entre las filas y columnas, pero tenía ciertos ajustes inadecuados, como restar 1 al índice. Además, `Movement` no ajustaba correctamente el índice de la fila para el movimiento hacia arriba, como se puede ver en la imagen: ![alt text](../../../images/movement.png).

En la nueva implementación, la clase `Navigator` fue diseñada para obtener directamente la fila desde el índice del string. Cuando se realiza el movimiento hacia arriba, ajusta la fila decrementándola en 1, siempre que la fila sea mayor que 0. `Navigator` ofrece una implementación más flexible, utilizando constantes para definir los límites y manejando el movimiento de manera más lógica y precisa. Esto se puede observar en [Navigator.java](https://github.com/pablarce/23-24-IdSw2-SDD/blob/main/pyHojaDeCalculo/Utils/Controller/Navigator.java).

---

## Clase Settings

### **_¿Por qué?_**

La clase `Settings` se creó para almacenar las configuraciones estáticas del proyecto, adaptando las configuraciones de la hoja de cálculo a las necesidades del usuario.

`Settings` exhibe un bajo acoplamiento al no depender de otras clases y una alta cohesión al concentrarse exclusivamente en almacenar configuraciones estáticas. Es altamente reutilizable para cualquier proyecto que requiera una configuración similar. Cumple en gran medida con el principio S (Single Responsibility Principle) de SOLID, dado que su responsabilidad principal es la gestión de configuraciones estáticas. Sin embargo, incluye la función [getMaxColumns](https://github.com/pablarce/23-24-IdSw2-SDD/blob/721a9f57351b5304017dbe8d2ee7a7e2ea8bf0fd/pyHojaDeCalculo/Utils/Controller/Settings.java#L12), que aunque podría considerarse como una responsabilidad adicional, es crucial para ciertas operaciones del proyecto. Moverla a otra clase podría comprometer este principio al fragmentar innecesariamente el código.

### **_Qué cambiamos_**

Inicialmente, las variables finales que dependían del gusto del usuario estaban dispersas en varias clases del proyecto. Para centralizar estas configuraciones y hacerlas más accesibles, se creó la clase `Settings`. Se desarrollaron métodos para obtener estas configuraciones y se eliminaron las variables finales de las clases que las contenían, como se puede ver en [Settings.java](https://github.com/pablarce/23-24-IdSw2-SDD/blob/main/pyHojaDeCalculo/Utils/Controller/Settings.java).

---
