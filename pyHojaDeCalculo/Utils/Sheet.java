package Utils;

class Sheet {
    private Cell[][] sheetData;
    private String currentCell;
    private final int spacing = 8;

    public Sheet(int rows, int columns) {
        sheetData = new Cell[rows][columns];
        currentCell = "A1";
        fillSheetData(rows, columns);
    }

    public void fillSheetData(int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sheetData[i][j] = new Cell();
            }
        }
    }

    public String getCellContent(int i, int j) {
        if (i == 0 && j == 0) { // Arriba a la izquierda
            return (" ").repeat(spacing);
        } else if (i == 0) {
            return " " + (char) (j + 64) + (" ").repeat(spacing - 1);

        } else if (i == 1) { // Primera fila (letras)
            if (j == 0) {
                return "+" + ("-").repeat(spacing - 1);
            } else if (j == this.sheetData[i].length - 1) {
                return "+" + ("-").repeat(spacing) + "+";
            } else {
                return "+" + ("-").repeat(spacing);
            }

        } else if (i == this.sheetData.length - 1) { // Última fila
            return ("-").repeat(spacing) + "+";

        } else if (j == 0) { // Primera columna (numeros)
            int nSpace = 0;
            if (i < 11) {
                nSpace = spacing - 1;
            } else {
                nSpace = spacing - 2;
            }
            return i - 1 + (" ").repeat(nSpace) + "|";

        } else if (getCellName(i - 1, j).equals(this.currentCell)) { // Celda actual
            if (this.sheetData[i][j].getCellValue() == null) {
                return "[" + (" ").repeat(spacing - 2) + "]" + "|";
            } else {
                String cellValue = this.sheetData[i][j].getCellValue();
                if (cellValue.length() > spacing - 2) {
                    cellValue = cellValue.substring(0, spacing - 2);
                }
                return "[" + cellValue + "]" + "|";
            }
        } else { // Celdas normales (no son la actual)
            if (this.sheetData[i][j].getCellValue() == null) {
                return (" ").repeat(spacing) + "|";
            } else {
                return this.sheetData[i][j].getCellValue() + "|";
            }
        }
    }

    static String getCellName(int i, int j) {
        return (char) (j + 64) + String.valueOf(i);
    }

    public String getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(String currentCell) {
        this.currentCell = currentCell;
    }

    public void setCellValue(int row, int col, String value) {
        if (value.length() > spacing) {
            value = value.substring(0, spacing);
        } else if (value.length() < spacing) {
            int spacesToAdd = spacing - value.length();
            value = value + " ".repeat(spacesToAdd);
        }
        sheetData[row + 2][col + 1].setCellValue(value);
    }

    public Cell[][] getSheetData() {
        return sheetData;
    }
}