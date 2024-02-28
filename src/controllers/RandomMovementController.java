package controllers;

import Utils.Movement;

import java.util.Random;

public class RandomMovementController {
    Random random = new Random();
    int randomNumber = random.nextInt(4);

    public void getRandomMovement() {
        switch (randomNumber) {
            case 0:
                System.out.println(Movement.UP.getKey());
                break;
            case 1:
                System.out.println(Movement.DOWN.getKey());
                break;
            case 2:
                System.out.println(Movement.LEFT.getKey());
                break;
            case 3:
                System.out.println(Movement.RIGHT.getKey());
                break;
        }
    }

    public static void main(String[] args) {
        new RandomMovementController().getRandomMovement();
    }
}