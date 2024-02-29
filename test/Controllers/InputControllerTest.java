package Controllers;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class InputControllerTest {
    @Test
    public void testGetUpperCaseChar() {
        InputController inputController = new InputController();
        char letraIngresada = 'a';
        char resultadoEsperado = 'A';

        if (!Character.isLetter(letraIngresada)) {
            throw new IllegalArgumentException("Solo se permiten letras como entrada.");
        }

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(String.valueOf(letraIngresada).getBytes());
        System.setIn(in);

        char resultadoObtenido = inputController.getUpperCaseChar(letraIngresada);

        System.setIn(sysInBackup);

        try {
            assertEquals(resultadoEsperado, resultadoObtenido);
            System.out.println("Resultado esperado: " + resultadoEsperado);
            System.out.println("Resultado obtenido: " + resultadoObtenido);
        } catch (AssertionError e) {
            throw new AssertionError("La letra ingresada no se convirtió correctamente a mayúscula. "
                    + "Resultado esperado: " + resultadoEsperado + ", Resultado obtenido: " + resultadoObtenido);
        }
    }
}
