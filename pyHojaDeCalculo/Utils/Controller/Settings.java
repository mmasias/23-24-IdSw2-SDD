package Utils.Controller;

public class Settings {
    public static final int VIEWPORT_HEIGHT = 10;
    public static final int VIEWPORT_WIDTH = 10;
    public static final int INITIAL_CELL_SIZE = 8;
    public static final int MAX_ROWS = 20;
    public static final int MAX_COLUMNS_NUMBER = 20;
    public static final char MAX_COLUMNS_CHAR = getMaxColumns(MAX_COLUMNS_NUMBER);


    private static char getMaxColumns(int maxColumns) {
        if (maxColumns <= 0) {
            throw new IllegalArgumentException("El número de columnas debe ser mayor que cero.");
        }

        int asciiValue = 65 + (maxColumns - 1);
        if (asciiValue > 90) {
            int offset = asciiValue - 90;
            asciiValue = 96 + offset;
        }
        return (char) asciiValue;

    }
}
