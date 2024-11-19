import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().strip());

        Map<Character, Integer> alphabet = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine().strip();
            int power = 1;

            for (int j = word.length() - 1; j >= 0; j--) {
                char c = word.charAt(j);
                alphabet.put(c, alphabet.getOrDefault(c, 0) + power);
                power *= 10;
            }
        }

        List<Integer> values = new ArrayList<>(alphabet.values());
        values.sort(Collections.reverseOrder());

        int result = 0;
        int multiplier = 9;

        for (int value : values) {
            result += value * multiplier--;
        }

        System.out.println(result);
    }
}
