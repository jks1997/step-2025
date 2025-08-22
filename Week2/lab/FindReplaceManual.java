import java.util.*;

public class FindReplaceManual {

    // Method to find all occurrences of substring
    public static List<Integer> findOccurrences(String text, String findStr) {
        List<Integer> positions = new ArrayList<>();
        int index = text.indexOf(findStr);
        while (index != -1) {
            positions.add(index);
            index = text.indexOf(findStr, index + findStr.length());
        }
        return positions;
    }

    // Method to manually replace substring
    public static String manualReplace(String text, String findStr, String replaceStr) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i <= text.length() - findStr.length() && text.substring(i, i + findStr.length()).equals(findStr)) {
                result.append(replaceStr);
                i += findStr.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    // Method to compare with built-in replace
    public static boolean compareResults(String manualResult, String builtInResult) {
        return manualResult.equals(builtInResult);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the main text:");
        String text = sc.nextLine();

        System.out.println("Enter substring to find:");
        String findStr = sc.nextLine();

        System.out.println("Enter substring to replace:");
        String replaceStr = sc.nextLine();

        // Finding occurrences
        List<Integer> occurrences = findOccurrences(text, findStr);
        System.out.println("Occurrences found at: " + occurrences);

        // Manual replace
        String manualResult = manualReplace(text, findStr, replaceStr);
        String builtInResult = text.replace(findStr, replaceStr);

        // Compare
        boolean isSame = compareResults(manualResult, builtInResult);

        System.out.println("Manual Replace Result: " + manualResult);
        System.out.println("Built-in Replace Result: " + builtInResult);
        System.out.println("Both results are same: " + isSame);
    }
}
