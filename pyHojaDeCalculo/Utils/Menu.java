package Utils;

class Menu {

    private static final int ViewportHeight = 10;
    private static final int ViewportWith = 5;
    public static void showSheet(Sheet sheet, int rows, int columns, int cursorRow, int cursorCol) {
        System.out.println("Hoja de Cálculo:");

        int startRow = Math.max(0, cursorRow - ViewportHeight / 2);
        int startCol = Math.max(0, cursorCol - ViewportWith / 2);

        for (int i = startRow; i < Math.min(rows,cursorRow + ViewportHeight); i++) {
            for (int j = startCol; j < Math.min(columns, cursorCol + ViewportWith); j++) {
                    System.out.print(sheet.getCellContent(i, j));
            }
            System.out.println();
        }
    }

    public static void showMovementMenu(String currentCell) {
        System.out.println("Celda actual: " + currentCell);
        System.out.println("Utilice las teclas W, A, S y D para moverse.");
        System.out.println("Presione E para editar la celda actual.");
        System.out.println("Presione R para cambiar el tamaño de las celdas.");
        System.out.println("Presione Q para salir.");
    }
}
