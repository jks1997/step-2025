import java.util.*;

public class CaseConversion {

    // Convert to uppercase using ASCII
    public static String toUpperCaseManual(String text) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Convert to lowercase using ASCII
    public static String toLowerCaseManual(String text) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Title case conversion
    public static String toTitleCaseManual(String text) {
        String lower = toLowerCaseManual(text);
        StringBuilder result = new StringBuilder();
        boolean capitalize = true;

        for (char ch : lower.toCharArray()) {
            if (ch == ' ') {
                capitalize = true;
                result.append(ch);
            } else if (capitalize && ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));
                capitalize = false;
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();

        String upperManual = toUpperCaseManual(text);
        String lowerManual = toLowerCaseManual(text);
        String titleManual = toTitleCaseManual(text);

        String upperBuiltIn = text.toUpperCase();
        String lowerBuiltIn = text.toLowerCase();

        System.out.println("Format\t\tManual\t\tBuilt-in");
        System.out.println("Uppercase\t" + upperManual + "\t" + upperBuiltIn);
        System.out.println("Lowercase\t" + lowerManual + "\t" + lowerBuiltIn);
        System.out.println("Title Case\t" + titleManual);
    }
}
