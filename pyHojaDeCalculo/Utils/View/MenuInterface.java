package Utils.View;

public class MenuInterface {

    public static void showMovementMenu(String currentCell) {
        System.out.println("Celda actual: " + currentCell);
        System.out.println("Utilice las teclas W, A, S y D para moverse.");
        System.out.println("Presione E para editar la celda actual.");
        System.out.println("Presione R para cambiar el tamaño de las celdas.");
        System.out.println("Presione Q para salir.");
    }
}
