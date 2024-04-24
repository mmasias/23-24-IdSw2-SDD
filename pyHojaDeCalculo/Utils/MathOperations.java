package Utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class MathOperations {

    public static String evaluateFormula(String formula, Sheet sheet) {
        if (formula.startsWith("=")) {
            String expression = formula.substring(1);
            try {
                double result = evaluateExpression(expression, sheet);
                return Double.toString(result);
            } catch (Exception e) {
                return "Error en la expresión matemática: " + e.getMessage();
            }
        } else {
            return formula;
        }
    }

    private static double evaluateExpression(String expression, Sheet sheet) {
        Deque<Double> numbers = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();

        char[] characters = expression.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];

            if (Character.isLetter(character)) {
                StringBuilder cellReference = new StringBuilder();

                while (i < characters.length && Character.isLetterOrDigit(characters[i])) {
                    cellReference.append(characters[i]);
                    i++;
                }
                i--;

                double cellValue = getCellValue(cellReference.toString(), sheet);
                numbers.push(cellValue);
            } else if (Character.isDigit(character) || character == '.') {
                StringBuilder currentNumber = new StringBuilder();

                while (i < characters.length && (Character.isDigit(characters[i]) || characters[i] == '.')) {
                    currentNumber.append(characters[i]);
                    i++;
                }
                i--;

                numbers.push(Double.parseDouble(currentNumber.toString()));
            } else if (character == '(') {
                operators.push(character);
            } else if (character == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    applyOperation(numbers, operators.pop());
                }
                operators.pop();
            } else if (isOperator(character)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(character)) {
                    applyOperation(numbers, operators.pop());
                }
                operators.push(character);
            }
        }

        while (!operators.isEmpty()) {
            applyOperation(numbers, operators.pop());
        }

        return numbers.pop();
    }

    private static double getCellValue(String cellReference, Sheet sheet) {
        int column = cellReference.charAt(0) - 'A' + 1;
        int row = Integer.parseInt(cellReference.substring(1)) - 1;
        String cellValue = sheet.getSheetData()[row + 2][column].getCellValue().trim();
        try {
            return Double.parseDouble(cellValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Referencia de celda no válida o celda vacía.");
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private static void applyOperation(Deque<Double> numbers, char operator) {
        double num2 = numbers.pop();
        double num1 = numbers.pop();

        switch (operator) {
            case '+':
                numbers.push(num1 + num2);
                break;
            case '-':
                numbers.push(num1 - num2);
                break;
            case '*':
                numbers.push(num1 * num2);
                break;
            case '/':
                if (num2 != 0) {
                    numbers.push(num1 / num2);
                } else {
                    throw new ArithmeticException("División por cero.");
                }
                break;
            default:
                throw new IllegalArgumentException("Operador no reconocido.");
        }
    }
}
