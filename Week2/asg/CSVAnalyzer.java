import java.util.*;

public class CSVAnalyzer {

    // Parse CSV without split
    public static List<List<String>> parseCSV(String input) {
        List<List<String>> data = new ArrayList<>();
        List<String> row = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        boolean inQuotes = false;

        for (char ch : input.toCharArray()) {
            if (ch == '"') {
                inQuotes = !inQuotes;
            } else if (ch == ',' && !inQuotes) {
                row.add(field.toString().trim());
                field.setLength(0);
            } else if (ch == '\n' && !inQuotes) {
                row.add(field.toString().trim());
                data.add(row);
                row = new ArrayList<>();
                field.setLength(0);
            } else {
                field.append(ch);
            }
        }
        if (field.length() > 0) row.add(field.toString().trim());
        if (!row.isEmpty()) data.add(row);

        return data;
    }

    // Display table
    public static void displayTable(List<List<String>> data) {
        StringBuilder sb = new StringBuilder("\nFormatted Table:\n");
        for (List<String> row : data) {
            for (String cell : row) {
                sb.append(String.format("%-15s", cell));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CSV data (end with 'END'):");
        StringBuilder input = new StringBuilder();
        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("END")) break;
            input.append(line).append("\n");
        }

        List<List<String>> data = parseCSV(input.toString());
        displayTable(data);
    }
}
