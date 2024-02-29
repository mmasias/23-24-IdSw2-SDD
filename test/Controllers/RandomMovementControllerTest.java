package Controllers;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RandomMovementControllerTest {
    @Test
    public void testGetRandomMovement() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        RandomMovementController randomMovementController = new RandomMovementController();
        char movimientoObtenido = randomMovementController.getRandomMovement();
        String output = outputStream.toString().trim();
        List<String> expectedValues = Arrays.asList("W", "S", "A", "D");

        assertTrue(expectedValues.contains(output));

        System.setOut(System.out);
        System.out.println("Movimiento obtenido: " + movimientoObtenido);
        System.out.println("Salida capturada: " + output);
    }
}
