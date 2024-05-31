# Diagramas de estados

## [Diagrama de Estados del Ascensor](/docs/Modelo_de_Dominio/Diagramas_de_Estados/Ascensor/)
El diagrama muestra las transiciones entre los estados de movimiento y capacidad. En "Movimiento", el ascensor puede estar "Detenido", "Subiendo" o "Bajando", y se detiene después de subir o bajar. En "Capacidad", el ascensor puede estar "Libre", "Parcialmente Lleno" o "Lleno", con transiciones para llenar o vaciar la capacidad. El diagrama ilustra cómo el ascensor cambia de estado en función de las acciones de movimiento (subir, bajar, detener) y de carga (llenar, vaciar).

<div align="center">
  <image src="./Ascensor/Diagrama_de_Estados.svg" align="center">
</div>

## [Diagrama de Estados del Cuadro de Mandos](/docs/Modelo_de_Dominio/Diagramas_de_Estados/Cuadro_de_Mando/)
El diagrama de estados del cuadro de mando muestra las transiciones entre la gestión de solicitudes y ascensores. Inicialmente, el sistema comienza en "Gestionando Solicitudes" con una nueva solicitud. Cuando la solicitud es aceptada, pasa a "Gestionando Ascensores". Después de gestionar los ascensores, el sistema transita a "En Espera". Desde "En Espera", una nueva solicitud lleva de nuevo a "Gestionando Solicitudes". Este diagrama ilustra cómo el cuadro de mando maneja las solicitudes y la gestión de ascensores, alternando entre estos estados en función de las acciones realizadas.
<div align="center">
  <image src= "./Cuadro_de_Mando/Diagrama_de_Estados.svg">
</div>

## [Diagrama de Estados del Usuario](/docs/Modelo_de_Dominio/Diagramas_de_Estados/Usuario/)

El diagrama de estados del usuario muestra las transiciones entre los estados de espera y uso del ascensor. Inicialmente, el usuario está "En Planta". Cuando solicita un ascensor, pasa a "Solicitando Ascensor". Una vez que el ascensor está disponible, el usuario transita a "En Ascensor". Finalmente, cuando el ascensor llega a la planta deseada, el usuario vuelve al estado "En Planta". Este diagrama describe cómo un usuario interactúa con el ascensor, desde solicitarlo hasta llegar a su destino.
<div align="center">
  <image src= "./Usuario/Diagrama_de_Estados.svg">
</div>

