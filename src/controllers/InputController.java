package controllers;

import java.util.Scanner;

public class InputController {
    static Scanner inputDirection = new Scanner(System.in);
    public char getUpperCaseChar(char inputDirection){
        return Character.toUpperCase(inputDirection);
    }
    public static void main(String[] args) {
        InputController inputController = new InputController();
        System.out.println(inputController.getUpperCaseChar(inputDirection.next().charAt(0)));
    }
}