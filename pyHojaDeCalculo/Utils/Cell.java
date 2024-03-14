package Utils;

public class Cell {
    private String cellValue;

    public Cell() {
        this.cellValue = null;
    }

    public Cell(String cellValue) {
        this.cellValue = cellValue;
    }

    public String getCellValue() {
        return cellValue;
    }

    public void setCellValue(String cellValue) {
        this.cellValue = cellValue;
    }
}
