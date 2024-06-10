package Utils.Model;

import Utils.Controller.Settings;

public class Sheet {
    private Cell[][] sheetData;
    private String currentCellPosition;
    private int cellSize = Settings.INITIAL_CELL_SIZE;

    public Sheet(int rows, int columns) {
        sheetData = new Cell[rows][columns];
        currentCellPosition = "A0";
        fillSheetData(rows, columns);
    }

    public void fillSheetData(int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sheetData[i][j] = new Cell(i, j);
            }
        }
    }

    public String getCellContent(int i, int j) {

        if (getCellLetter(i, j).equals(this.currentCellPosition)) {
            if (this.sheetData[i][j].getCellValue() == null) {
                return "[" + (" ").repeat(cellSize - 2) + "]" + "|";
            } else {
                String cellValue = this.sheetData[i][j].getCellValue();

                if (cellValue.length() > cellSize - 2) {
                    cellValue = cellValue.substring(0, cellSize - 2);
                }
                return "[" + cellValue + " ".repeat(cellSize - 2 - cellValue.length()) + "]" + "|";
            }
        } else {
            if (this.sheetData[i][j].getCellValue() == null) {
                return (" ").repeat(cellSize) + "|";
            } else {
                String cellValue = this.sheetData[i][j].getCellValue();

                if (cellValue.length() > cellSize) {
                    cellValue = cellValue.substring(0, cellSize);
                }
                return cellValue + " ".repeat(cellSize - cellValue.length()) + "|";
            }
        }
    }

    public int getCellSize() {
        return cellSize;
    }

    static String getCellLetter(int i, int j) {
        return (char) (j + 65) + String.valueOf(i);
    }

    public String getCurrentCellPosition() {
        return currentCellPosition;
    }

    public void setCurrentCellPosition(String newCellPosition) {
        this.currentCellPosition = newCellPosition;
    }

    public void setCellValue(int row, int col, String value) {
        sheetData[row][col].setCellValue(value);
    }

    public Cell[][] getSheetData() {
        return sheetData;
    }

    public int getRows() {
        return sheetData.length;
    }

    public int getColumns() {
        return sheetData[0].length;
    }

    public void setCellSize(int size) {
        this.cellSize = size;
        if (this.cellSize < 1) {
            this.cellSize = 1;
        }
    }
}