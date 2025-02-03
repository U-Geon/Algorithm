import java.util.*;
import java.io.*;

public class Main {

    static String solution(String str, String bomb) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(c);

            if(sb.length() >= bomb.length() && sb.substring(sb.length() - bomb.length()).equals(bomb)) {
                sb.setLength(sb.length() - bomb.length());
            }
        }

        return !sb.toString().isEmpty() ? sb.toString() : "FRULA";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine().strip();
        String bomb = br.readLine().strip();

        System.out.println(solution(line, bomb));
    }
}