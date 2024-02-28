package Controllers;

import java.util.Scanner;

public class InputController {
    public char getUpperCaseChar(){
        Scanner inputDirection = new Scanner(System.in);
        char inputChar = inputDirection.next().charAt(0);
        inputDirection.close();
        return Character.toUpperCase(inputChar);
    }
}