package Controllers;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class RandomMovementControllerTest {
    @Test
    public void testGetRandomMovement() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        RandomMovementController randomMovementController = new RandomMovementController();
        char movimientoObtenido = randomMovementController.getRandomMovement();
        String output = outputStream.toString().trim();

        try {
            assertEquals("W", output);
        } catch (AssertionError e) {
            try {
                assertEquals("S", output);
            } catch (AssertionError e1) {
                try {
                    assertEquals("A", output);
                } catch (AssertionError e2) {
                    assertEquals("D", output);
                }
            }
        }

        System.setOut(System.out);
        System.out.println("Movimiento obtenido: " + movimientoObtenido);
        System.out.println("Salida capturada: " + output);
    }
}
