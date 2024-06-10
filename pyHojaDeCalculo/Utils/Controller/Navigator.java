package Utils.Controller;

public class Navigator {
    public int getFormattedRow(String currentCellPosition) {
        return Integer.parseInt(currentCellPosition.substring(1));
    }

    public int getFormattedColumn(String currentCellPosition) {
        return currentCellPosition.charAt(0) - 'A';
    }

    public String handleCommand(String command, String currentCellPosition) {
        switch (command) {
            case "w":
                return moveUp(currentCellPosition);
            case "a":
                return moveLeft(currentCellPosition);
            case "s":
                return moveDown(currentCellPosition);
            case "d":
                return moveRight(currentCellPosition);
            default:
                System.out.println("Comando no reconocido.");
                return currentCellPosition;
        }
    }

    private String moveUp(String currentCellPosition) {
        int row = getFormattedRow(currentCellPosition);
        return row > 0 
            ? String.format("%c%d", currentCellPosition.charAt(0), row - 1) 
            : currentCellPosition;
    }

    private String moveDown(String currentCellPosition) {
        int row = getFormattedRow(currentCellPosition);
        return row < Settings.MAX_ROWS - 1 
            ? String.format("%c%d", currentCellPosition.charAt(0), row + 1) 
            : currentCellPosition;
    }

    private String moveLeft(String currentCellPosition) {
        char column = currentCellPosition.charAt(0);
        return column > 'A' 
            ? String.format("%c%d", (char) (column - 1), getFormattedRow(currentCellPosition)) 
            : currentCellPosition;
    }

    private String moveRight(String currentCellPosition) {
        char column = currentCellPosition.charAt(0);
        return column < Settings.MAX_COLUMNS_CHAR
            ? String.format("%c%d", (char) (column + 1), getFormattedRow(currentCellPosition))
            : currentCellPosition;
    }
}