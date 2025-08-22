import java.util.*;

public class FileOrganizer {

    // Extract filename and extension
    public static String[] splitFile(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1) return new String[]{filename, ""};
        return new String[]{filename.substring(0, dotIndex), filename.substring(dotIndex + 1)};
    }

    // Categorize based on extension
    public static String getCategory(String ext) {
        ext = ext.toLowerCase();
        if (ext.equals("txt") || ext.equals("doc")) return "Document";
        if (ext.equals("jpg") || ext.equals("png")) return "Image";
        if (ext.equals("mp3")) return "Audio";
        return "Unknown";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter filenames (type 'END' to stop):");
        List<String> files = new ArrayList<>();
        while (true) {
            String file = sc.nextLine();
            if (file.equalsIgnoreCase("END")) break;
            files.add(file);
        }

        StringBuilder report = new StringBuilder("\nFile Organization Report:\n");
        Map<String, Integer> categoryCount = new HashMap<>();

        for (String file : files) {
            String[] parts = splitFile(file);
            String category = getCategory(parts[1]);
            categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
            String newName = category + "_" + parts[0] + "_" + System.currentTimeMillis() + "." + parts[1];
            report.append(String.format("Original: %-20s Category: %-10s New: %s\n", file, category, newName));
        }

        report.append("\nCategory Counts:\n");
        for (String cat : categoryCount.keySet()) {
            report.append(cat).append(": ").append(categoryCount.get(cat)).append("\n");
        }

        System.out.println(report);
    }
}
