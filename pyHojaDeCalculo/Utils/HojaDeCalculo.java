package Utils;

import java.util.Scanner;

public class HojaDeCalculo {
    private Sheet sheet;
    private Movement movement;
    private Scanner input;
    private int Rows = 10;
    private int Columns = 10;

    public HojaDeCalculo() {
        sheet = new Sheet(Rows, Columns);
        movement = new Movement();
        input = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            Menu.showSheet(sheet, Rows, Columns, movement.getCurrentRow(sheet.getCurrentCell()),
                    movement.getCurrentColumn(sheet.getCurrentCell()));
            Menu.showMovementMenu(sheet.getCurrentCell());
            String command = input.nextLine().toLowerCase();
            if (command.equals("q")) {
                break;
            } else if (command.equals("e")) {
                System.out.println("Ingrese el nuevo valor de la celda " + sheet.getCurrentCell() + ":");
                int row = movement.getCurrentRow(sheet.getCurrentCell());
                int column = movement.getCurrentColumn(sheet.getCurrentCell());
                String Result = MathOperations.evaluateFormula(input.nextLine(), sheet);
                sheet.setCellValue(row, column, Result);
            } else if (command.equals("r")) {
                System.out.println("Ingrese el tamaño que desea: ");
                int newSize = Integer.parseInt(input.nextLine());
                sheet.setCellSize(newSize);
                System.out.println("Tamaño actualizado a: " + sheet.getSpacing());
            }

            else {
                sheet.setCurrentCell(movement.handleCommand(command, sheet.getCurrentCell()));
            }
        }
        input.close();
    }
}
