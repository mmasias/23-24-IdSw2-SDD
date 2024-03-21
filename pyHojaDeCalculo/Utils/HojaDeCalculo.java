package Utils;

import java.util.Scanner;

public class HojaDeCalculo {
    private Sheet sheet;
    private Movement movement;
    private Scanner input;

    public HojaDeCalculo() {
        sheet = new Sheet(18, 11);
        movement = new Movement();
        input = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            Menu.showSheet(sheet);
            Menu.showMovementMenu(sheet.getCurrentCell());
            String command = input.nextLine().toLowerCase();
            if (command.equals("q")) {
                break;
            } else if (command.equals("e")) {
                System.out.println("Ingrese el nuevo valor de la celda " + sheet.getCurrentCell() + ":");
                String Result = OperacionesMatematicas.evaluarFormula(input.nextLine(), sheet);
                sheet.setCellValue(movement.getCurrentRow(sheet.getCurrentCell()), movement.getCurrentColumn(sheet.getCurrentCell()),Result);
            } else if(command.equals("r")){
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