import java.util.*;

public class StringPerformanceTest {

    public static long stringConcat(int iterations) {
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "abc";
        }
        long end = System.currentTimeMillis();
        System.out.println("String length: " + str.length());
        return end - start;
    }

    public static long stringBuilderConcat(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("abc");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder length: " + sb.length());
        return end - start;
    }

    public static long stringBufferConcat(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append("abc");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer length: " + sbf.length());
        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of iterations (e.g., 1000, 10000, 100000):");
        int iterations = sc.nextInt();

        long timeString = stringConcat(iterations);
        long timeSB = stringBuilderConcat(iterations);
        long timeSBF = stringBufferConcat(iterations);

        System.out.println("\nPerformance Comparison:");
        System.out.println("Method\t\tTime (ms)");
        System.out.println("String\t\t" + timeString);
        System.out.println("StringBuilder\t" + timeSB);
        System.out.println("StringBuffer\t" + timeSBF);
    }
}
