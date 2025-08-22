import java.util.*;

public class TextCalculator {

    // Validate expression format
    public static boolean validateExpression(String expr) {
        int parenthesesCount = 0;
        for (char ch : expr.toCharArray()) {
            if (!(Character.isDigit(ch) || "+-*/() ".indexOf(ch) >= 0)) {
                return false; // Invalid character
            }
            if (ch == '(') parenthesesCount++;
            if (ch == ')') parenthesesCount--;
            if (parenthesesCount < 0) return false; // Misplaced closing bracket
        }
        return parenthesesCount == 0;
    }

    // Evaluate expression without parentheses
    public static double evaluateSimpleExpression(String expr, StringBuilder steps) {
        // Tokenize numbers and operators manually
        List<Double> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        StringBuilder num = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (Character.isDigit(ch)) {
                num.append(ch);
            } else if ("+-*/".indexOf(ch) >= 0) {
                numbers.add(Double.parseDouble(num.toString()));
                num.setLength(0);
                operators.add(ch);
            }
        }
        if (num.length() > 0) numbers.add(Double.parseDouble(num.toString()));

        // Handle * and /
        for (int i = 0; i < operators.size(); ) {
            if (operators.get(i) == '*' || operators.get(i) == '/') {
                double result = (operators.get(i) == '*') ? 
                    numbers.get(i) * numbers.get(i + 1) : 
                    numbers.get(i) / numbers.get(i + 1);
                steps.append("Step: ").append(numbers.get(i)).append(" ")
                     .append(operators.get(i)).append(" ")
                     .append(numbers.get(i + 1)).append(" = ").append(result).append("\n");
                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
            } else {
                i++;
            }
        }

        // Handle + and -
        for (int i = 0; i < operators.size(); ) {
            double result = (operators.get(i) == '+') ? 
                numbers.get(i) + numbers.get(i + 1) : 
                numbers.get(i) - numbers.get(i + 1);
            steps.append("Step: ").append(numbers.get(i)).append(" ")
                 .append(operators.get(i)).append(" ")
                 .append(numbers.get(i + 1)).append(" = ").append(result).append("\n");
            numbers.set(i, result);
            numbers.remove(i + 1);
            operators.remove(i);
        }

        return numbers.get(0);
    }

    // Handle parentheses
    public static double evaluateExpression(String expr, StringBuilder steps) {
        while (expr.contains("(")) {
            int close = expr.indexOf(")");
            int open = expr.lastIndexOf("(", close);
            String inner = expr.substring(open + 1, close);
            double innerResult = evaluateSimpleExpression(inner, steps);
            expr = expr.substring(0, open) + innerResult + expr.substring(close + 1);
            steps.append("Replaced parentheses: ").append(expr).append("\n");
        }
        return evaluateSimpleExpression(expr, steps);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter expression (or type 'exit'):");
            String expr = sc.nextLine();
            if (expr.equalsIgnoreCase("exit")) break;

            if (!validateExpression(expr)) {
                System.out.println("Invalid expression format.");
                continue;
            }

            StringBuilder steps = new StringBuilder("Original: " + expr + "\n");
            double result = evaluateExpression(expr.replaceAll(" ", ""), steps);
            steps.append("Final Result: ").append(result);
            System.out.println(steps);
        }
    }
}
