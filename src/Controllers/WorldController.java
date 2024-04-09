package Controllers;

import java.util.Random;
import java.util.Scanner;

public class WorldController {

    private void InitializeWorldMap(){

    }

    private void getRandomCharacterMovement(){
        Random random = new Random();
        char[] movements = {'W', 'A', 'S', 'D'};
        processUserInput(movements[random.nextInt(movements.length)]);
    }

    private void getUserInput(){
        Scanner scanner = new Scanner(System.in);
        char direction = Character.toUpperCase(scanner.nextLine().charAt(0));
        scanner.close();
        processUserInput(direction);
    }

    private void processUserInput(char input){
        if( input == ('W' | 'A' | 'S' | 'D')){
            // Move character
        }
    }

}
