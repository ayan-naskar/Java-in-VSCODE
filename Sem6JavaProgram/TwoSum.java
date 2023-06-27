import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) throws IOException {
        Set<Long> numbers = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader("2sum.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            long num = Long.parseLong(line.trim());
            numbers.add(num);
        }
        reader.close();

        int count = 0;
        for (long t = -10000; t <= 10000; t++) {
            for (long x : numbers) {
                long y = t - x;
                if (x != y && numbers.contains(y)) {
                    count++;
                    System.out.println("Found: " + count);
                    break;
                }
            }
        }
        System.out.println("Final count: " + count);
    }
}
