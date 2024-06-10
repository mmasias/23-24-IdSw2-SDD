package Utils.Model;

import Utils.View.MenuInterface;
import Utils.Controller.Navigator;
import Utils.Controller.Settings;
import Utils.View.Viewport;

import java.util.Scanner;

public class Spreadsheet {
    private Sheet sheet;
    private Navigator navigator;
    private Scanner input;
    private int rows = Settings.MAX_ROWS;
    private int columns = Settings.MAX_COLUMNS_NUMBER;

    public Spreadsheet() {
        sheet = new Sheet(rows, columns);
        navigator = new Navigator();
        input = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            String currentCellPosition = sheet.getCurrentCellPosition();
            int currentRow = navigator.getFormattedRow(currentCellPosition);
            int currentColumn = navigator.getFormattedColumn(currentCellPosition);

            Viewport.showSheet(sheet, currentRow, currentColumn, sheet.getCellSize());
            MenuInterface.showMovementMenu(currentCellPosition);
            
            String command = input.nextLine().toLowerCase();

            if (command.equals("q")) {
                running = false;
            } else if (command.equals("e")) {
                System.out.println("Ingrese el nuevo valor de la celda " + currentCellPosition + ":");
                String result = MathOperations.evaluateFormula(input.nextLine(), sheet);
                sheet.setCellValue(currentRow, currentColumn, result);
            } else if (command.equals("r")) {
                System.out.println("Ingrese el tamaño que desea: ");
                int newSize = Integer.parseInt(input.nextLine());
                sheet.setCellSize(newSize);
                System.out.println("Tamaño actualizado a: " + sheet.getCellSize());
            } else {
                sheet.setCurrentCellPosition(navigator.handleCommand(command, currentCellPosition));
            }
        }
        input.close();
    }
}
