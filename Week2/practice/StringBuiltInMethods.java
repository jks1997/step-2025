public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";

        // 1. Display original string length including spaces
        System.out.println("1. Original String Length (with spaces): " + sampleText.length());

        // 2. Remove leading and trailing spaces, show new length
        String trimmedText = sampleText.trim();
        System.out.println("2. Trimmed String: \"" + trimmedText + "\"");
        System.out.println("   New Length (after trimming): " + trimmedText.length());

        // 3. Find and display the character at index 5
        System.out.println("3. Character at index 5: " + sampleText.charAt(5));

        // 4. Extract substring "Programming" from the text
        String subText = trimmedText.substring(5, 16); // "Programming"
        System.out.println("4. Extracted Substring: " + subText);

        // 5. Find the index of the word "Fun"
        int indexFun = trimmedText.indexOf("Fun");
        System.out.println("5. Index of 'Fun': " + indexFun);

        // 6. Check if the string contains "Java" (case-sensitive)
        System.out.println("6. Contains 'Java': " + trimmedText.contains("Java"));

        // 7. Check if the string starts with "Java" (after trimming)
        System.out.println("7. Starts with 'Java': " + trimmedText.startsWith("Java"));

        // 8. Check if the string ends with an exclamation mark
        System.out.println("8. Ends with '!': " + trimmedText.endsWith("!"));

        // 9. Convert the entire string to uppercase
        System.out.println("9. Uppercase: " + trimmedText.toUpperCase());

        // 10. Convert the entire string to lowercase
        System.out.println("10. Lowercase: " + trimmedText.toLowerCase());

        // Count vowels
        int vowelCount = countVowels(trimmedText);
        System.out.println("11. Number of vowels: " + vowelCount);

        // Find all occurrences of a character
        System.out.print("12. Occurrences of 'a': ");
        findAllOccurrences(trimmedText, 'a');
    }

    // Method to count vowels in a string
    public static int countVowels(String text) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    // Method to find all positions of a character
    public static void findAllOccurrences(String text, char target) {
        boolean found = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("Character not found");
        }
        System.out.println();
    }
}
