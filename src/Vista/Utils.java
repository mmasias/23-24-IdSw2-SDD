package Vista;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Utils {
    public static int obtenerEnteroValido(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                if (valor > 5) {
                    return valor;
                } else {
                    System.out.println("Cantidad no permitida, ingrese otra cantidad arriba de 5");
                }
            } else {
                System.out.println("No has introducido un número entero válido.");
                scanner.next();
            }
        }
    }

    public enum Elementos {
        ZONA_LIMPIA(" . ", 0),
        ZONA_SUCIA("...", 1),
        ZONA_MAS_SUCIA("ooo", 2),
        ZONA_MUY_SUCIA("OOO", 3),
        ZONA_SUCISIMA("***", 4),
        ASPIRADORA(")_(", -1),
        GATO("^-^", -2),
        SOFA("[#]", -3);

        private final String simbolo;
        private final int valor;
        private static final Map<Integer, Elementos> map = new HashMap<>();

        static {
            for (Elementos zona : Elementos.values()) {
                map.put(zona.obtenerValor(), zona);
            }
        }

        Elementos(String simbolo, int valor) {
            this.simbolo = simbolo;
            this.valor = valor;
        }

        public String obtenerSimbolo() {
            return simbolo;
        }

        public int obtenerValor() {
            return valor;
        }

        public static String obtenerSimboloPorValor(int valor) {
            if (map.containsKey(valor)) {
                return map.get(valor).obtenerSimbolo();
            }
            return null;
        }
    }
}
