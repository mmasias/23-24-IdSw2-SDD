package Utils;

class Sheet {
    private Cell[][] sheetData;
    private String currentCell;
    private int spacing = 8;
    public Sheet(int rows, int columns) {
        sheetData = new Cell[rows][columns];
        currentCell = "A1";
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
        if (i == 0 && j == 0) { 
            return (" ").repeat(spacing);
        } else if (i == 0) {
            return " " + (char) (j + 64) + (" ").repeat(spacing - 1);

        } else if (i == 1) {
            if (j == 0) {
                return "+" + ("-").repeat(spacing - 1);
            } else if (j == this.sheetData[i].length - 1) {
                return "+" + ("-").repeat(spacing) + "+";
            } else {
                return "+" + ("-").repeat(spacing);
            }

        } else if (i == this.sheetData.length - 1) { 
            return ("-").repeat(spacing) + "+";

        } else if (j == 0) {
            int nSpace = 0;
            if (i < 11) {
                nSpace = spacing - 1;
            } else {
                nSpace = spacing - 2;
            }
            return i - 1 + (" ").repeat(nSpace) + "|";

        } else if (getCellName(i - 1, j).equals(this.currentCell)) {
            if (this.sheetData[i][j].getCellValue() == null) {
                return "[" + (" ").repeat(spacing - 2) + "]" + "|";
            } else {
                String cellValue = this.sheetData[i][j].getCellValue();

                if (cellValue.length() > spacing - 2) {
                    cellValue = cellValue.substring(0, spacing - 2);
                }
                return "[" + cellValue + " ".repeat(spacing -2 - cellValue.length()) + "]" + "|";
            }
        } else { 
            if (this.sheetData[i][j].getCellValue() == null) {
                return (" ").repeat(spacing) + "|";
            } else {
                String cellValue = this.sheetData[i][j].getCellValue();

                if (cellValue.length() > spacing) {
                    cellValue = cellValue.substring(0, spacing);
                }
                return cellValue + " ".repeat(spacing - cellValue.length()) + "|";
            }
        }
    }
    public int getSpacing(){return spacing;}
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
        sheetData[row + 2][col + 1].setCellValue(value);
    }

    public Cell[][] getSheetData(){
        return sheetData;
    }

    public void setCellSize(int size) {
        this.spacing = size;
        if (this.spacing < 1) {
            this.spacing = 1;
        }
    }
}